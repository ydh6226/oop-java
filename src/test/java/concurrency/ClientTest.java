package concurrency;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Socket;

public class ClientTest {

    private static final int PORT = 8079;
    private static final int TIMEOUT = 2000;

    static Server server;
    static Thread serverThread;

    @BeforeAll
    static void createSever() throws Exception {
        try {
            server = new Server(PORT, TIMEOUT);
            serverThread = new Thread(server);
            serverThread.start();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @AfterAll
    static void shutDownServer() throws InterruptedException {
        if (server != null) {
            server.stopProcessing();
            serverThread.join();
        }
    }

    static class TrivialClient implements Runnable {
        int clientNumber;

        public TrivialClient(int clientNumber) throws InterruptedException {
            Thread.sleep(1);
            this.clientNumber = clientNumber;
        }

        @Override
        public void run() {
            try {
                connectSendReceive(clientNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void shouldRunInUnder10Seconds() throws Exception {
        int threadCount = 10;
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new TrivialClient(i));

            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }
    }

    private static void connectSendReceive(int clientNumber) throws IOException {
        System.out.println("Client connecting: " + clientNumber);
        Socket socket = new Socket("localhost", PORT);
        System.out.println("Client : sending message :" + clientNumber);
        MessageUtils.sendMessage(socket, String.valueOf(clientNumber));
        System.out.println("Client : getting reply :" + clientNumber);
        MessageUtils.getMessage(socket);
        System.out.println("Client : finished :" + clientNumber);
        socket.close();
    }
}
