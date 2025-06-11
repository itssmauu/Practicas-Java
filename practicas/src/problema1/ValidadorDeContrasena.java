package problema1;

public class ValidadorDeContrasena {

    public boolean contieneNumero(String contrasena){
        return contrasena.matches(".*\\d.*");
    }

    public boolean contieneMayuscula(String contrasena){
        return contrasena.matches(".*[A-Z].*");
    }

}
