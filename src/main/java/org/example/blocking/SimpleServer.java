package org.example.blocking;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(1234);
        System.out.println("Im waiting on a new connection");
        Socket socket=ss.accept();
        InputStream is=socket.getInputStream();
        OutputStream os=socket.getOutputStream();
        System.out.println("I'm waiting on data");
        int nb=is.read();
        System.out.println("I'm sending response");
        int res=nb*23;
        os.write(res);
        socket.close();

    }
}
