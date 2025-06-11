package problema3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RegistradorNumeros {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int numeroUsuario;
            int numerosPares = 0;
            int numerosImpares = 0;

            System.out.print("Ingrese un numero positivo (Si desea salir digite un numero negativo): ");
            while (true){
                numeroUsuario = Integer.parseInt(bufferedReader.readLine());

                if (numeroUsuario>=0)
                {
                    if ((numeroUsuario % 2 == 0)){
                        numerosPares++;
                    }
                    else{
                        numerosImpares++;
                    }
                }
                else{
                    break;
                };
                System.out.print("Ingrese otro numero positvo (Si desea salir  digite un numero negativo): ");
            }

            System.out.println("Numeros Pares: " + numerosPares);
            System.out.println("Numeros Impares: " + numerosImpares);
        }
        catch (NumberFormatException e){
            System.err.println("Error: el tipo de dato debe ser entero" + e.getMessage());
        }
        catch (IOException e){
            System.err.println("Error de entrada: " + e.getMessage());
        }
    }
}
