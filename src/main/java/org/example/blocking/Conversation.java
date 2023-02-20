package org.example.blocking;

import java.net.Socket;

public class Conversation extends Thread{
    private Socket socket;
    public Conversation(Socket socket, int clientsCount){
        this.socket=socket;
    }
    public void run(){

    }
}
