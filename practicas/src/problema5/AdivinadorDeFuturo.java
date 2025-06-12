package problema5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AdivinadorDeFuturo {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int a=1;
            do{
                System.out.println("---ADIVINADOR DE FUTURO---");
                System.out.print("Ingrese su nombre: ");
                String nombreCliente = bufferedReader.readLine();

                System.out.print("Ingreso su sexo: ");
                String sexoCliente = bufferedReader.readLine();

                System.out.print("Ingrese su fecha de nacimiento(dd/mm/AAAA): ");
                String nacimiento = bufferedReader.readLine();

                Cliente cliente = new Cliente(nombreCliente, sexoCliente, nacimiento);






                System.out.print("Desea añadir otro cliente(Si/No): ");

            }while (a!=1);




        }catch (IOException e){
            System.err.println("Error de entrada");
        }
    }
}
