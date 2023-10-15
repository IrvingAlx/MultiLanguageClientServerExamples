import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int puerto = 8000;
        String host = "localhost";
        Socket miSocket = null;
        BufferedReader lectorSocket;
        PrintWriter escritorSocket;
        String mensajeTransmitido, mensajeRespuesta ,lineaRecibida;

        try {

            System.out.println("Conectado al servidor");
            miSocket = new Socket(host,puerto);     // Incluye el metodo Connect

            lectorSocket = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
            escritorSocket = new PrintWriter(miSocket.getOutputStream(), true);

            mensajeTransmitido = "GET / HTTP/1.1";
            System.out.println("Mensjae a transmitir: \n" + mensajeTransmitido);
            System.out.println("Host: localhost:8000 \n");
            escritorSocket.println(mensajeTransmitido);
            escritorSocket.println("Host: localhost:8000");
            escritorSocket.println();
            escritorSocket.flush();
            System.out.println("Esperando respuesta");
            System.out.println("\nMensaje recibido del servidor: ");
            while ((lineaRecibida = lectorSocket.readLine()) != null){
                System.out.println(lineaRecibida);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}