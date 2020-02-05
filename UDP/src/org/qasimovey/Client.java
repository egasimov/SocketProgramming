package org.qasimovey;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds=new DatagramSocket();
        DatagramPacket dp ;
        InetAddress address=InetAddress.getByName("127.0.0.1");
        int port=9999;
        Scanner sc=new Scanner(System.in);
        byte[] send_b=new byte[65535];
        byte[] receive_b=new byte[65535];
        System.out.println("To quit enter: /quit");
        while(true){
            String input=sc.nextLine();
            if(input==null || input.isEmpty())continue;
            send_b=input.getBytes();

            dp=new DatagramPacket(send_b,send_b.length,address,port);
            ds.send(dp);
            if(input.contains("/quit"))break;
            dp=new DatagramPacket(receive_b,receive_b.length);
            ds.receive(dp);
            receive_b=dp.getData();
            System.out.println("Server response : "+data(dp.getData()));
            String response=String.valueOf(receive_b);


        }

        System.out.println("Client disconnected");

    }
    public static String data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while ( i<a.length && a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret.toString();
    }

}
