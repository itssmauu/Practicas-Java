package problema5;

public class Cliente {
    String nombreCliente;
    String sexoCliente;
    String nacimiento;
    int edadCliente;
    String signoZodiacal;

    public Cliente(String nombreCliente, String sexoCliente, String nacimiento){
        this.nombreCliente = nombreCliente;
        this.sexoCliente = sexoCliente;
        this.nacimiento = nacimiento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    public String getSexoCliente() {
        return sexoCliente;
    }
    public String getNacimiento() {
        return nacimiento;
    }


}
