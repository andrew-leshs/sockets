package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 7828;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            int count = 0;
            String last = "";
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    if (count < 1) {
                        out.println("???");
                        String s = in.readLine();
                        last = s;
                        out.println("OK");
                        count++;
                    } else {
                        out.println("Последний введенный город: " + last);
                        String s = in.readLine();
                        if (s.toLowerCase().charAt(0) == last.toLowerCase().charAt(last.length() - 1)) {
                            last = s;
                            out.println("OK");
                        } else {
                            out.println("NOT OK");
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
