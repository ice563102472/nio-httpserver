package com.butterfly.nioserver.test;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by yangzhuo02 on 2016/1/7.
 */
public class Main {
    public static void main(String[] args) {
Main main = new Main();
        main.testRead();
    }

    private void testWrite() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getByName("172.20.196.16"), 8088));
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
            printWriter.println(123123123);
            printWriter.flush();
            printWriter.close();
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void testRead() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getByName("172.20.196.16"), 8088));
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }

            bufferedReader.close();
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
