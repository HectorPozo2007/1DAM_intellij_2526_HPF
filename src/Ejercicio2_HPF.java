public class Ejercicio2_HPF {


    public static void main(String[] args) {
        Ejercicio2_HPF ej2 = new Ejercicio2_HPF();
        ej2.procesoSeleccion(45, "Juan", 28000, new double[]{0}); // Caso: Edad > 40
        ej2.procesoSeleccion(30, "Ana", 35000, new double[]{0});  // Caso: Sueldo > 30k
        ej2.procesoSeleccion(25, "Luis", 22000, new double[]{1000, 2000, 1500, 3000, 2500}); // Caso: OK
    }

    public boolean procesoSeleccion(int edad, String nombre, double sueldoAnterior, double[] nominas) {
        System.out.println("Evaluando a: " + nombre + ".");

        if (edad > 40) {
            System.out.println("Candidato descartado por edad.");
            return false;
        }

        if (sueldoAnterior > 30000) {
            System.out.println("Candidato descartado por sueldo anterior.");
            return false;
        }

        System.out.println("Contratado!");
        double suma = 0;
        for (double n : nominas) suma += n;

        System.out.println("Suma total: " + suma + "€");

        double media = suma / 5;
        double sueldoFinal = (media > 2500) ? media * 1.05 : media * 1.10;

        System.out.println("Sueldo final tras incremento: " + sueldoFinal + "€\n");
        return true;
    }
}
