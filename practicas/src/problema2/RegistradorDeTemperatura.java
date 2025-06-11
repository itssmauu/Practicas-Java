package problema2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RegistradorDeTemperatura {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("Ingrese la cantidad de dias a registrar: ");
            int cantidadDias = Integer.parseInt(bufferedReader.readLine());
            if (cantidadDias>=1)
            {
                double temperaturaMax = -50;
                double temperaturaMin = 60;
                double sumaTemperatura=0;
                double temperaturaProm;

                for (int i=1; i<=cantidadDias; i++){
                    System.out.println("Ingrese la temperatura para el dia " + i);
                    double temperaturaDia = Double.parseDouble(bufferedReader.readLine());

                    if (temperaturaDia>=-50 && temperaturaDia<=60){

                        sumaTemperatura=sumaTemperatura + temperaturaDia;

                        if (temperaturaDia>temperaturaMax){
                            temperaturaMax = temperaturaDia;
                        }

                        if(temperaturaDia<temperaturaMin)
                        {
                            temperaturaMin = temperaturaDia;
                        }
                    }
                    else {
                        System.err.println("Ingrese una temperatura entre -50°C y 60°C");
                        i--;
                    }
                }
                System.out.println("La temperatura máxima es: " + temperaturaMax + "°C");
                System.out.println("La temperatura minima es: " + temperaturaMin + "°C");
                System.out.println("La temperatura promedio es: " + (sumaTemperatura/cantidadDias) + "°C");
            } else {
                System.err.println("Error: La cantidad de dias debe ser mayor a cero.");
            }
        }





        catch (NumberFormatException e){
            System.err.println("Error: ingrese un número valido " + e.getMessage());
        }
        catch (IOException e){
            System.err.println("Error de entrada:" + e.getMessage());
        }


    }
}
