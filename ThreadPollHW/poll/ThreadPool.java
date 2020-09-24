package ThreadPollHW.poll;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    // очередь задач
    private Deque<Runnable> tasks;

    // пул потоков
    private PoolWorker threads[];

    public ThreadPool(int threadsCount) {
        this.tasks = new ConcurrentLinkedDeque<>();
        this.threads = new PoolWorker[threadsCount];

        for (int i = 0; i < this.threads.length; i++) {
            this.threads[i] = new PoolWorker();
            this.threads[i].start();
        }
    }

    public void submit(Runnable task) {
        synchronized (tasks) {
            tasks.addFirst(task);
            tasks.notify();
        }
    }

    // класс - рабочий поток
    private class PoolWorker extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                    tasks.pollLast().run();
                }
            }
        }
    }
}