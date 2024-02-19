package com.example.rpcs3_skylandersremote;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class TCPClient {
    private String serverIpAddress;
    private int port;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public TCPClient(String serverIpAddress, int port) {
        this.serverIpAddress = serverIpAddress;
        this.port = port;
    }

    public void startClient() {
        try {
            // Connect to the server
            socket = new Socket(serverIpAddress, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connected to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPacket(final String message) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Check if the PrintWriter out is initialized
                    if (out == null) {
                        startClient();
                    }

                    // Send message to server
                    out.println(message);

                    // Receive response from server
                    String response = in.readLine();
                    System.out.println("Response from server: " + response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stopClient() {
        try {
            // Close resources
            out.close();
            in.close();
            socket.close();
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}