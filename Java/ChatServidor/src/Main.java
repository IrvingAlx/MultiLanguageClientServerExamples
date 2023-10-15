import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int puerto = 8000;
        ServerSocket miServidor;
        Socket miCliente;
        BufferedReader lectorSocket;
        PrintWriter escritorSocket;
        String mensajeRecibido, mensajeEnviado;
        Scanner leer = new Scanner(System.in);  // Scanner Objet para leer entradas de usuario

        try{
            miServidor =  new ServerSocket(puerto);     // Incluye meto|do bind y listen

            while (true){

                //System.out.println("Escuchando conexion");
                miCliente = miServidor.accept();
                System.out.println("Conexion aceptada");

                lectorSocket = new BufferedReader(new InputStreamReader(miCliente.getInputStream()));
                escritorSocket = new PrintWriter(miCliente.getOutputStream(),true);

                //System.out.println("Esperando mensaje");
                mensajeRecibido = lectorSocket.readLine();

                System.out.println("Mensaje recibido: " + mensajeRecibido);
                System.out.println("Ingrese Mensaje");
                mensajeEnviado = leer.nextLine();  // Leer input
                escritorSocket.println(mensajeEnviado);

                System.out.println("Enviando mensaje: " + mensajeEnviado);

            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}