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

    public boolean startClient() {
        return connectToServer();
    }

    private boolean connectToServer() {
        try {
            // Connect to the server
            socket = new Socket(serverIpAddress, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateIP(String serverIpAddress) {
        this.serverIpAddress = serverIpAddress;
    }

    public void sendPacket(final String message) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Check if the client is connected before sending the message
                    if (out != null && socket != null && socket.isConnected()) {
                        // Send message to server
                        out.println(message);

                        // Receive response from server
                        String response = in.readLine();
                        System.out.println("Response from server: " + response);
                    } else {
                        System.out.println("Client is not connected to the server.");
                        startClient();
                        sendPacket(message);
                    }
                } catch (IOException e) {
                    // Handle SocketException - Connection reset
                    if (e instanceof SocketException && e.getMessage().contains("Connection reset")) {
                        System.out.println(e.getMessage());
                        if (!startClient()) {
                            return;
                        }
                        sendPacket(message);
                    } else {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    public void stopClient() {
        try {
            // Close resources
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (socket != null) {
                socket.close();
            }
            // Set resources to null
            out = null;
            in = null;
            socket = null;
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}