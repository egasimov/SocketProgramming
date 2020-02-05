package org.qasimovey;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds=new DatagramSocket(9999);
        DatagramPacket dp ;
        byte[] send_b=new byte[65535];
        byte[] receive_b=new byte[65535];
        System.out.println("SERVER IS UP");
        while (true){
            dp=new DatagramPacket(receive_b,receive_b.length);
            ds.receive(dp);
            System.out.println("Client message "+data(receive_b));
            if(data(receive_b).contains("/quit")){
                break;
            }
            int i=Integer.parseInt(data(receive_b));
            i=i*i;
            send_b=String.valueOf(i).getBytes();
            dp=new DatagramPacket(send_b,send_b.length,dp.getAddress(),dp.getPort());
            ds.send(dp);


        }
        System.out.println("SERVER STOPPED");
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
