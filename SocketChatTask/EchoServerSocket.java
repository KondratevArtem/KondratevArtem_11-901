package my.itis;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EchoServerSocket {

    private List<Socket> clients;


    public static void readAndWrite(Socket clientFirst, Socket clientSecond) {
        try {
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientFirst.getInputStream()));
            PrintWriter toClient = new PrintWriter(clientSecond.getOutputStream(), true);
            while (true) {
                String messageFromClient = null;
                try {
                    messageFromClient = fromClient.readLine();
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
                if (messageFromClient != null) {
                    toClient.println(messageFromClient);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }


    public void start(int port) {
        ServerSocket server;
        clients = new ArrayList<>();

        try {
            server = new ServerSocket(port);
            while (clients.size() < 2) {
                Socket client = server.accept();
                clients.add(client);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        Thread firstClient = new Thread(new Runnable( ) {
            @Override
            public void run() {
                readAndWrite(clients.get(0), clients.get(1));
            }
        });
        Thread secondClient = new Thread(new Runnable( ) {
            @Override
            public void run() {
                readAndWrite(clients.get(1), clients.get(0));
            }
        });

        firstClient.start();
        secondClient.start();
    }
}
