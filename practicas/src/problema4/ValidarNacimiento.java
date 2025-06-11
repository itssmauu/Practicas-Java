package problema4;
import java.io.BufferedReader;
import  java.io.InputStreamReader;
import java.io.IOException;

public class ValidarNacimiento {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Ingrese su fecha de nacimiento(dd/mm/AAAA): ");
            String fecha = bufferedReader.readLine().trim();

            ValidadorFecha.validar(fecha);
            System.out.println("La fecha es válida");

        }catch(IOException e){
            System.err.println("Error al leer la entrada");
        }
        catch (FechaInvalidaException e){
            System.err.println("Fecha inválida: " + e.getMessage());
        }

    }
}
