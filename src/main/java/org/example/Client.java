package org.example;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private static final int PORT = 7828;

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", PORT);
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())))
        {

            System.out.println(in.readLine());
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            out.println(s);
            System.out.println(in.readLine());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
