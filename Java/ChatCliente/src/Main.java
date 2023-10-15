import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int puerto = 8000;
        String host = "localhost";
        Socket miSocket = null;
        BufferedReader lectorSocket;
        PrintWriter escritorSocket;
        String mensajeRespuesta, mensajeTransmitido;
        Scanner leer = new Scanner(System.in);  // Scanner Objet para leer entradas de usuario

        try{
            while (true) {
                System.out.println("Conectado al servidor");
                miSocket = new Socket(host,puerto);     // Incluye el metodo Connect
                //System.out.println("Me conecte al servidor exitosamente");
                lectorSocket = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
                escritorSocket = new PrintWriter(miSocket.getOutputStream(), true);
                System.out.println("Ingrese Mensaje");
                mensajeTransmitido = leer.nextLine();  // Leer input
                //System.out.println("Mensjae a transmitir: " + mensajeTransmitido);
                escritorSocket.println(mensajeTransmitido);
                //System.out.println("Esperando respuesta");
                mensajeRespuesta = lectorSocket.readLine();
                System.out.println("Mensaje recibido del servidor: " + mensajeRespuesta);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}