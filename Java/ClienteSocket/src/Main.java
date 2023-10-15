import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int puerto = 8000;
        String host = "localhost";
        Socket miSocket = null;
        BufferedReader lectorSocket;
        PrintWriter escritorSocket;
        String mensajeRespuesta, mensajeTransmitido;
        try{
            System.out.println("Conectado al servidor");

            miSocket = new Socket(host,puerto);     // Incluye el metodo Connect

            System.out.println("Me conecte al servidor exitosamente");

            lectorSocket = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
            escritorSocket = new PrintWriter(miSocket.getOutputStream(),true);

            mensajeTransmitido = "Hola soy el cliente de irving";

            System.out.println("Mensjae a transmitir: " + mensajeTransmitido);

            escritorSocket.println(mensajeTransmitido);

            System.out.println("Esperando respuesta");

            mensajeRespuesta = lectorSocket.readLine();

            System.out.println("Mensaje recibido del servidor: " + mensajeRespuesta);




        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}