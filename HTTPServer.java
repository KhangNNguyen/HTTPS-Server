import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
public class HTTPServer{
    public static void main(String[] args) throws IOException {
        int port = 8080;
        final ServerSocket server = new ServerSocket(port);
        System.out.println("Listening for connection on port " + port + " ....");
        while (true){
            try (Socket socket = server.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n " + today;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}