package com.demos;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.OutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", (exchange) -> {
            MathOperation op = new FactorialOp();
            long result = op.calculate(5);
            String response = "<h1>Factorial result: " + result + "</h1>";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });
        server.start();
        System.out.println("Server started on 8080");
    }
}