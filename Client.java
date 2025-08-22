import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int porta = 12345;

        try (Socket socket = new Socket(host, porta);
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Conectado ao servidor!");

            String mensagem;
            while (true) {
                System.out.print("Digite uma mensagem: ");
                mensagem = teclado.readLine();
                if (mensagem.equalsIgnoreCase("sair")) break;

                saida.println(mensagem);
                System.out.println("Servidor respondeu: " + entrada.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
