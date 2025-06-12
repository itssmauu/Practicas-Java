package problema6;

public class Validadores {
    public static void validarCampoVacio(String campo, String nombreCampo) throws CampoVacioException {
        if (campo == null || campo.trim().isEmpty()) {
            throw new CampoVacioException("El " + nombreCampo + " no puede estar vacío o con espacios");
        }
    }

    public static void validarSoloLetras(String campo, String nombreCampo) throws SoloLetrasExcpetion {
        if (!campo.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            throw new SoloLetrasExcpetion("El " + nombreCampo + " no debe contener números o cáracteres especiales.");
        }
        if (campo.matches(".*(^|\\s)[a-zA-ZáéíóúÁÉÍÓÚñÑ]{1}(\\s|$).*")) {
            throw new SoloLetrasExcpetion("Cada palabra en el " + nombreCampo + " debe tener al menos 2 letras");
        }
    }

    public static String capitalizarNombre(String nombre) {
        nombre = nombre.trim().toLowerCase();

        int espacio = nombre.indexOf(" ");

        if (espacio == -1) {
            return nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
        } else {
            String primeraPalabra = nombre.substring(0, 1).toUpperCase() + nombre.substring(1, espacio);
            String segundaPalabra = nombre.substring(espacio + 1, espacio + 2).toUpperCase() + nombre.substring(espacio + 2);
            return primeraPalabra + " " + segundaPalabra;
        }
    }

    public static void validarCedula(String cedula) throws IllegalArgumentException {
        // Eliminar espacios en blanco y saltos de línea
        cedula = cedula.trim().replaceAll("\\s+", "");

        // Verificar que la cédula no contenga saltos de línea ni espacios intermedios
        if (cedula.contains("\n") || cedula.contains(" ")) {
            throw new IllegalArgumentException("La cédula no puede contener espacios en blanco ni saltos de línea.");
        }

        // Validar los formatos de cédula para panameños nacidos en el país
        String regexPanamenos = "^(10|[1-9])-\\d{2,4}-\\d{2,4}$";  // Formatos como XX-XXX-XXX o XX-XXXX-XXXX
        // Validar cédulas de panameños nacidos en el extranjero (PE)
        String regexExtranjero = "^PE-\\d-\\d{3}$";  // Formato PE-X-XXX
        // Validar cédulas de panameños naturalizados (N)
        String regexNaturalizado = "^N-\\d{2}-\\d{3}$";  // Formato N-XX-XXX
        // Validar cédulas de extranjeros residentes legales (E)
        String regexExtranjeroResidente = "^E-(1[0-9]|10)-\\d{5,6}$";  // Formato E-X-XXXXX o E-X-XXXXXX

        // Verificar si la cédula coincide con alguno de los formatos válidos
        if (cedula.matches(regexPanamenos) || cedula.matches(regexExtranjero) || cedula.matches(regexNaturalizado) || cedula.matches(regexExtranjeroResidente)) {
            return; // La cédula es válida
        } else {
            throw new IllegalArgumentException("La cédula no tiene un formato válido.");
        }
    }

    public static void  validarFecha(String fecha) throws FechaInvalidaException {
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
        if (anio<1925 || anio>2025){
            throw new FechaInvalidaException("Año fuera de rango válido (1900-2025)");
        }
        if (anio==2025 && mes>6){
            throw new FechaInvalidaException("la fecha no puede estar en el futuro");
        }

        int limiteAnio = 2007;
        int limiteMes = 6;
        int limiteDia = 12;

        // Verificamos si la fecha ingresada es posterior a la fecha límite (persona menor de 18 años)
        if (anio > limiteAnio || (anio == limiteAnio && mes > limiteMes) || (anio == limiteAnio && mes == limiteMes && dia > limiteDia)) {
            throw new FechaInvalidaException("La persona debe ser mayor de  Edad.");
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
