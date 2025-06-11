package problema1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GestionarContrasena {
    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ValidadorDeContrasena validadorDeContrasena = new ValidadorDeContrasena();
        
        try {
            while (true) {
                System.out.println("Ingrese una contraseña");
                String contrasena = bufferedReader.readLine();
                boolean validador = true;

                if (contrasena.length() < 8) {
                    System.err.println("La contraseña debe tener mínimo 8 carácteres.");
                    validador = false;
                }

                if (!validadorDeContrasena.contieneNumero(contrasena)) {
                    System.err.println("La contraseña debe contener al menos un número.");
                    validador = false;
                }

                if (!validadorDeContrasena.contieneMayuscula(contrasena)) {
                    System.err.println("La contraseña debe contener una letra mayuscula.");
                    validador = false;
                }

                if(validador){
                    System.out.println("Contraseña ingresada correctamente.");
                    break;
                }
                else {
                    System.err.println("Ingrese la contraseña correctamente.");
                }
            }

        }
        catch (IOException e){
            System.err.println("Error de entrada: " + e.getMessage());
        }
    }
}
