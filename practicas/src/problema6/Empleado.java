package problema6;

public class Empleado {
    private String nombreEmpleado;
    private String cedulaEmpleado;
    private String fecha;
    private int edadEmpleado;
    private int cargoEmpleado;
    private int turnoEmpleado;
    private double salarioBrutoEmpleado;
    private double seguroSocial;
    private double seguroEducativo;
    private double salarioNeto;


    public Empleado(String nombreEmpleado, String cedulaEmpleado, String fecha, int cargoEmpleado, int turnoEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.cedulaEmpleado = cedulaEmpleado;
        this.fecha = fecha;
        this.cargoEmpleado = cargoEmpleado;
        this.turnoEmpleado = turnoEmpleado;
    }

    public String getNombreEmpleado() {return nombreEmpleado;}
    public String getCedulaEmpleado() {return cedulaEmpleado;}
    public String getFecha() {return fecha;}
    public int getCargoEmpleado() {return cargoEmpleado;}
    public int getTurnoempleado() {return turnoEmpleado;}

    public double salarioTipoDeCargo(){
        switch (getCargoEmpleado()){
            case 1:{
                return  500.00;
            }
            case 2:{
                return  600.00;
            }
            case 3:{
                return 700.00;
            }
            default:{
                System.err.println("Error.Ingrese un número permitido en el rango (1-3)");
                return 0.00;
            }
        }
    }

    public void escogerTipoDeCargo(){
        switch (getCargoEmpleado()){
            case 1:{
                System.out.println("Cargo: Empacador");
                break;
            }
            case 2:{
                System.out.println("Cargo: Maquinista");
                break;
            }
            case 3:{
                System.out.println("Cargo: Supervisor");
                break;
            }
        }
    }

    public void escogerTipoTurno(){
        switch (getTurnoempleado()){
            case 1:{
                System.out.println("Turno: 7:00 a.m. a 2:59 p.m.");
                break;
            }
            case 2:{
                System.out.println("Turno: 3:00 p.m. a 10:59 p.m. ");
                break;
            }
            case 3:{
                System.out.println("Turno: 11:00 p.m. a 6:59 a.m.");
                break;
            }
        }
    }

    public void calcularSalario(){
        salarioBrutoEmpleado = salarioTipoDeCargo();

        if(getTurnoempleado()==3){
            salarioBrutoEmpleado = (salarioBrutoEmpleado*0.05)+salarioBrutoEmpleado;
        }

        seguroSocial = salarioBrutoEmpleado*0.0975;
        seguroEducativo = salarioBrutoEmpleado *0.0125;

        salarioNeto = salarioBrutoEmpleado - (seguroSocial+seguroEducativo);

        System.out.printf("Salario Bruto: $%.2f%n", salarioBrutoEmpleado);
        System.out.printf("Seguro Social: $%.2f%n", seguroSocial);
        System.out.printf("Seguro Educativo: $%.2f%n", seguroEducativo);
        System.out.printf("Salario Neto: $%.2f%n", salarioNeto);
    }

    public void calcularEdad(){
        int diaActual = 12;
        int mesActual = 6;
        int anioActual = 2025;

        int diaNacimiento = Integer.parseInt(fecha.substring(0,2));
        int mesNacimiento = Integer.parseInt(fecha.substring(3,5));
        int anioNacimiento = Integer.parseInt(fecha.substring(6,10));

        int edad = anioActual - anioNacimiento;

        if (mesActual < mesNacimiento || (mesActual == mesNacimiento && diaActual < diaNacimiento)) {
            edad--;
        }

        this.edadEmpleado = edad;

        System.out.println("Edad: " + edad + " años");
    }

    public void MostrarDatos(){
        System.out.println("Nombre del Empleado: " + getNombreEmpleado());
        System.out.println("Cédula: " + getCedulaEmpleado());
        calcularEdad();//metodo para calcular la edad e imprimirla
        escogerTipoDeCargo(); //Metodo que imprime el tipo de cargo
        escogerTipoTurno(); //Metodo que imprime el tipo de turno
        calcularSalario(); //metodo que calcula e imprime el salario y lso descuentos
    }


}
