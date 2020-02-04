package org.qasimovey;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        try {
            Scanner sc=new Scanner(System.in);
            Socket s = new Socket("127.0.0.1", 9999);
            System.out.println("Client connected");
            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());

            while(true){
                String msg=sc.nextLine();
                dos.writeUTF(msg);
                if(msg.contains("/quit"))break;
                msg=dis.readUTF();
                System.out.println("S: "+msg);
            }
            dis.close();
            dos.close();
            sc.close();
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }
}
