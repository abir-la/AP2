package org.example.blocking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadBlockingServer extends Thread {
    static int clientsCount;

    public static void main(String[] args) {
        new MultiThreadBlockingServer().start();
    }

    public void run() {
        System.out.println("The server has started using port 1234");
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while ((true)) {
                Socket socket = serverSocket.accept();
                ++clientsCount;

                new Conversation(socket, clientsCount).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    class Conversation extends Thread {
        private Socket socket;
        private int clientId;

        public Conversation(Socket socket, int clientId) {
            this.socket = socket;
            this.clientId = clientId;
        }

        public void run() {


            try {
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);
                String ip = socket.getRemoteSocketAddress().toString();
                System.out.println("New client conneciton" + clientId + " IP=" + ip);
                pw.println("Welcome, your ID is" + clientId);
                String request;
                while ((request=br.readLine())!=null) {
                    //String request = br.readLine();
                    System.out.println("New request =>ip =" + ip + " Request:" + request);
                    String response = "Size :" + request.length();
                    pw.println(response);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

