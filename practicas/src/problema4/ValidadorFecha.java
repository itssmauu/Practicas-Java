package problema4;

public class ValidadorFecha {
    public static void  validar(String fecha) throws FechaInvalidaException{
        if (fecha==null || fecha.length() !=10 || fecha.charAt(2) != '/' || fecha.charAt(5) != '/') {
            throw new FechaInvalidaException("Formato incorrecto. Use el formato dd/mm/AAAA");
        }

        int dia, mes, anio;

        try {
            dia = Integer.parseInt(fecha.substring(0,2));
            mes = Integer.parseInt(fecha.substring(3,5));
            anio = Integer.parseInt(fecha.substring(6,10));
        }
        catch (NumberFormatException e){
            throw new FechaInvalidaException("Los valores deben ser númericos");
        }

        if (mes<1 || mes>12){
            throw new FechaInvalidaException("Mes fuera de rango(1-12)");
        }
        if (dia<1 || dia>diasDelmes(mes, anio)){
            throw new FechaInvalidaException("Día fuera de rango para el mes ingresado.");
        }
        if (anio<1900 || anio>2025){
            throw new FechaInvalidaException("Año fuera de rango válido (1900-2025)");
        }
        if (anio==2025 && mes>6){
            throw new FechaInvalidaException("la fecha no puede estar en el futuro");
        }
    }

    private static int diasDelmes(int mes, int anio){
        switch (mes){
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(anio) ? 29: 28;
            default:
                return 31;
        }
    }

    private static boolean esBisiesto(int anio){
        return (anio % 4 == 0 && anio % 100 !=0)||(anio %400 == 0);
    }
}
