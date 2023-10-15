import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Main {
    public static void main(String[] args) {
        int puerto = 8000;
        BufferedReader lectorSocket;
        PrintWriter escritorSocket;
        String mensajeRecibido, mensajeRespuesta, lineaRecibida;

        try {
            ServerSocket miServidor = new ServerSocket(puerto);
            Socket miCliente;

            while (true){

                System.out.println("Esperando conexion");

                miCliente = miServidor.accept();
                System.out.println("Conexion aceptada");

                lectorSocket = new BufferedReader(new InputStreamReader(miCliente.getInputStream()));
                escritorSocket = new PrintWriter(miCliente.getOutputStream(), true);

                System.out.println("Esperando mensaje");
                mensajeRecibido = "";

                do {
                    lineaRecibida = lectorSocket.readLine();
                    mensajeRecibido+=lineaRecibida + "\n";
                }while(lineaRecibida.length()==0);

                System.out.println("El request es:");
                System.out.println(mensajeRecibido + "\n");

                String contenido = "<html><body><h1>Hola soy el servidor de Irving</h1></body></html>";
                mensajeRespuesta = "HTTP/1.1 200 OK\n";
                mensajeRespuesta += "Content-Type: text/html\n";
                mensajeRespuesta += "Content-Length: "+contenido.length()+"\n\n";
                mensajeRespuesta += contenido;

                escritorSocket.println(mensajeRespuesta);
                System.out.println(mensajeRespuesta);

            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}