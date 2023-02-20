package org.example.blocking;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyTelnetClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",1234);
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        new Thread(() ->{
            String request;
            try{
            while((request=br.readLine())!=null){

                    String response= null;
                    response = br.readLine();
                    System.out.println(response);
                } }catch (IOException e) {
                    throw new RuntimeException(e);

            }
        }).start();
        Scanner scanner=new Scanner(System.in);
        //String request;
        while (true){
            String request=scanner.nextLine();
            pw.println(request);

        }

    }
}
