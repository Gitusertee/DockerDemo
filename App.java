import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080),0);

        server.createContext("/", exchange -> {

            String response =
                "Hello from Treasure Docker Java Application";

            exchange.sendResponseHeaders(
                    200,
                    response.length());

            OutputStream os =
                exchange.getResponseBody();

            os.write(response.getBytes());
            os.close();
        });

        server.start();

        System.out.println("Server started on 8080");
    }
}

//first docker assignment