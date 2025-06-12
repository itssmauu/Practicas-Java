package problema6;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GestionDePlanilla {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int cantidadEmpleado;
        try {
            System.out.print("Ingrese la cantidad de empleados: ");
            while (true){
                try {
                    cantidadEmpleado = Integer.parseInt(bufferedReader.readLine());
                    if (cantidadEmpleado>0)
                    {
                        break;
                    }
                    else {
                        System.err.println("Ingrese un número mayor a cero. Intente nuevamente");
                    }
                }
                catch (NumberFormatException e){
                    System.err.println("Ingrese un número entero valido. Intente nuevamente");
                }
            }


            for (int i = 1; i <= cantidadEmpleado; i++) {
                System.out.println("Ingrese los datos para el empleado #" + i);

                String nombreEmpleado;
                System.out.print("Nombre completo: ");
                while (true){
                    try{
                        nombreEmpleado = bufferedReader.readLine();
                        Validadores.validarCampoVacio(nombreEmpleado,"Nombre del empleado");
                        Validadores.validarSoloLetras(nombreEmpleado, "Nombre del empleado");
                        nombreEmpleado = Validadores.capitalizarNombre(nombreEmpleado);
                        break;
                    }catch (CampoVacioException | SoloLetrasExcpetion e){
                        System.err.println("Error." + e.getMessage() + ". Intente nuevamente");
                    }

                }

                String cedulaEmpleado;
                System.out.print("Cédula: ");
                while (true){
                    try{
                        cedulaEmpleado = bufferedReader.readLine();
                        Validadores.validarCampoVacio(cedulaEmpleado, "Cédula");
                        Validadores.validarCedula(cedulaEmpleado);
                        break;
                    }catch (CampoVacioException|IllegalArgumentException e){
                        System.err.println("Error." + e.getMessage() + ". Intente nuevamente");
                    }
                }


                String fecha;
                System.out.print("Fecha de nacimiento(dd/mm/AAAA): ");
                while (true){
                    try{
                        fecha = bufferedReader.readLine().trim();
                        Validadores.validarCampoVacio(fecha,"Fecha de nacimiento");
                        Validadores.validarFecha(fecha);
                        break;
                    }catch (CampoVacioException|FechaInvalidaException e){
                        System.err.println("Error." + e.getMessage() + ". Intente nuevamente");
                    }
                }

                int cargoEmpleado;
                System.out.println("Seleccione el tipo de cargo");
                System.out.println("1.Empacador");
                System.out.println("2.Maquinista");
                System.out.println("3.Supervisor");
                while (true) {
                    try{
                        cargoEmpleado = Integer.parseInt(bufferedReader.readLine());

                        if (cargoEmpleado >= 1 && cargoEmpleado <= 3) {
                            break;
                        } else {
                            System.err.println("Error. Ingrese un número válido (1-3).Intente nuevamente");
                        }
                    }catch (NumberFormatException e){
                        System.err.println("Error. Ingrese un número entero. Intente nuevamente");
                    }
                }

                int turnoEmpleado;
                System.out.println("Seleccione el tipo de turno");
                System.out.println("1.Primero turno (7:00 a.m. - 2:59 p.m.)");
                System.out.println("2.Segundo turno (3:00 p.m. - 10:59 p.m.) ");
                System.out.println("3.tercer turno (11:00 p.m. - 6:59 a.m.)");
                while (true) {
                    try{
                        turnoEmpleado = Integer.parseInt(bufferedReader.readLine());
                        if (turnoEmpleado >= 1 && turnoEmpleado <= 3) {
                            break;
                        } else {
                            System.err.println("Error. Ingrese un número válido (1-3).Intente nuevamente");
                        }
                    }catch (NumberFormatException e){
                        System.err.println("Error. Ingrese un número entero. Intente nuevamente");
                    }
                }

                Empleado empleado = new Empleado(nombreEmpleado, cedulaEmpleado, fecha, cargoEmpleado, turnoEmpleado);

                System.out.println("---------------------------------------------------");
                empleado.MostrarDatos();
            }
            System.out.println("---------------------------------------------------");
            System.out.println("Gracias por usar el Programa.");

        }catch (IOException e){
            System.err.println("Error de entrada.");
        }
    }
}
