package org.qasimovey;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class ClientHandler extends Thread{
    private DataInputStream in=null;
    private  DataOutputStream out=null;
    private Socket socket =null;

    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh:mm:ss");

    private String specialMessage="Enter 'Date' or 'Time' to get info about day";
    public ClientHandler(Socket socket, DataInputStream in , DataOutputStream out){
        this.socket=socket;
        this.in=in;
        this.out=out;
    }
    @Override
    public void run() {

       // super.run();
       try {
           String clientANS=null;
           String response=null;
           while (true){
               clientANS=in.readUTF();
               if(clientANS.contains("/quit"))break;
               if(clientANS==null ||clientANS.isEmpty())continue;
               Date d=new Date();
               switch (clientANS){
                   case "Date":
                       response=fordate.format(d);
                        break;
                   case "Time":
                       response=fortime.format(d);
                       break;
                   default:
                       response="Invalid input \n"+specialMessage;


               }

           out.writeUTF(response);
           out.flush();
               System.out.println(this.socket + "  Handled");
           }

           System.out.println(this.socket+" Client is disconnected");
       }
       catch (Exception e){
           System.out.println(e.getLocalizedMessage()+"Error occured, terminated");
       }

    }
}

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9999);

        while(true){
            Socket s=serverSocket.accept();
            System.out.println("New Client is connected +"+s);
            DataInputStream inputStream = new DataInputStream(s.getInputStream());
            DataOutputStream outputStream=new DataOutputStream(s.getOutputStream());

            Thread t=new ClientHandler(s,inputStream,outputStream);
            t.start();
        }


    }
}
