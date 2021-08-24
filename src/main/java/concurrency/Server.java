package concurrency;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server implements Runnable  {

    ServerSocket serverSocket;
    volatile  boolean keepProcessing;

    public Server(int port, int millisecondsTimeout) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(millisecondsTimeout);
    }

    @Override
    public void run() {

        System.out.println("server starting");

        while (keepProcessing) {
            try {
                System.out.println("accepting client");
                Socket socket = serverSocket.accept();
                System.out.println("got client");
                process(socket);
            } catch (Exception e) {
                handle(e);
            }
        }

    }

    private void handle(Exception e) {
        if (!(e instanceof SocketException)) {
            e.printStackTrace();
        }
    }

    private void process(Socket socket) {
        if (socket == null) {
            return;
        }

        try {
            System.out.println("Server: getting message");
            String message = MessageUtils.getMessage(socket);
            System.out.println("Server: got message: " + message);
            Thread.sleep(1000);
            System.out.println("Server: sending reply: " + message);
            MessageUtils.sendMessage(socket, "Processed: " + message);
            System.out.println("Server: sent");
            closeIgnoringException(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeIgnoringException(Socket socket) {
        if (socket == null) {
            return;
        }
        try {
            socket.close();
        } catch (IOException ignore) {
        }
    }

    public void stopProcessing() {
        keepProcessing = false;
        closeIgnoringException(serverSocket);
    }

    private void closeIgnoringException(ServerSocket serverSocket) {
        if (serverSocket == null) {
            return;
        }
        try {
            serverSocket.close();
        } catch (IOException ignore) {
        }
    }
}
