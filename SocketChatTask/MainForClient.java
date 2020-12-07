package my.itis;

import java.util.Scanner;

public class MainForClient {
    public static void main(String[] args) {
        SocketClient client = new SocketClient("localhost", 7777);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            client.sendMessage(scanner.nextLine());
        }
    }
}

