package com.demos;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.OutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        // This creates a web server listening on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        server.createContext("/", (exchange) -> {
            int input = 5;
            int factorial = 120; // Your logic here
            String response = "<h1>Factorial of " + input + " is: " + factorial + "</h1>" +
                              "<p>Harshavardhan D. - App is responding via Kubernetes!</p>";
            
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        System.out.println("Web Server started on port 8080...");
        server.start();
    }
}