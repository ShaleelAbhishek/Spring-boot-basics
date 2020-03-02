import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashMap;

public class Server {

    public static HashMap<String, String> userList = new HashMap<>();

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        HttpContext context = server.createContext("/register");
        context.setHandler(exchange -> register(exchange));


        HttpContext context1 = server.createContext("/list");
        context1.setHandler(exchange -> listUsers(exchange));


        HttpContext context3 = server.createContext("/send");
        context1.setHandler(exchange -> sendMsg(exchange));

        server.start();
    }

    private static void sendMsg(HttpExchange exchange) throws IOException {
        String response = "Users list : " + userList;

        exchange.sendResponseHeaders(200, response.getBytes().length);//response code and length
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private static void register(HttpExchange exchange) throws IOException {

        URI requestedUri = exchange.getRequestURI();
        String query = requestedUri.getRawQuery();

        String clientName = query.substring(query.indexOf("=") + 1, query.length());
        System.out.println(clientName);

        String response = "user registerd!";
        if (userList.keySet().contains(clientName)) {
            response = "already exist !";
        }

        userList.put(clientName, "empty Message");

        exchange.sendResponseHeaders(200, response.getBytes().length);//response code and length
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private static void listUsers(HttpExchange exchange) throws IOException {
        String response = "Users list : " + userList;

        exchange.sendResponseHeaders(200, response.getBytes().length);//response code and length
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
