import java.util.Random;

public class Ejercicio4_HPF {
    private String[] arrayNombres;
    private int[] arrayPuntuacion;

    public Ejercicio4_HPF(String[] nombresRecibidos) {
        this.arrayNombres = nombresRecibidos;
        this.arrayPuntuacion = new int[20];
        Random aleatorio = new Random();

        for (int i = 0; i < 20; i++) {
            this.arrayPuntuacion[i] = aleatorio.nextInt(101 - 35) + 35;
        }
    }

    public void mostrarEstadisticas() {
        int maxPuntos = arrayPuntuacion[0];
        int minPuntos = arrayPuntuacion[0];
        int indiceGanador = 0;
        int indiceUltimo = 0;
        double sumaPuntos = 0;

        for (int i = 0; i < 20; i++) {
            if (arrayPuntuacion[i] > maxPuntos) {
                maxPuntos = arrayPuntuacion[i];
                indiceGanador = i;
            }
            if (arrayPuntuacion[i] < minPuntos) {
                minPuntos = arrayPuntuacion[i];
                indiceUltimo = i;
            }
            sumaPuntos += arrayPuntuacion[i];
        }

        double media = sumaPuntos / 20;

        System.out.println("Equipo Ganador: " + arrayNombres[indiceGanador] + " (" + maxPuntos + " pts)");
        System.out.println("Último Clasificado: " + arrayNombres[indiceUltimo] + " (" + minPuntos + " pts)");
        System.out.println("Puntuación Media: " + String.format("%.2f", media));
    }

    public static void main(String[] args) {
        String[] ligaES = {
                "Real Madrid", "Barcelona", "Atleti", "Real Sociedad", "Villarreal",
                "Betis", "Sevilla", "Osasuna", "Athletic", "Mallorca",
                "Girona", "Rayo", "Celta", "Cadiz", "Getafe",
                "Valencia", "Almeria", "Valladolid", "Espanyol", "Elche"
        };
        System.out.println("Liga Española");
        Ejercicio4_HPF caso1 = new Ejercicio4_HPF(ligaES);
        caso1.mostrarEstadisticas();
        System.out.println("_--------------------------------------");


        String[] ligaUK = {
                "Man City", "Arsenal", "Man United", "Newcastle", "Liverpool",
                "Brighton", "Aston Villa", "Tottenham", "Brentford", "Fulham",
                "Crystal Palace", "Chelsea", "Wolves", "West Ham", "Bournemouth",
                "Forest", "Everton", "Leicester", "Leeds", "Southampton"
        };
        System.out.println("Resultados Liga Generica");
        Ejercicio4_HPF caso2 = new Ejercicio4_HPF(ligaUK);
        caso2.mostrarEstadisticas();
        System.out.println("_--------------------------------------");

        String[] ligaGen = new String[20];
        for(int i = 0; i < 20; i++) {
            ligaGen[i] = "Equipo_" + (i + 1);
        }
        System.out.println("Resultados Liga Generica");
        Ejercicio4_HPF caso3 = new Ejercicio4_HPF(ligaGen);
        caso3.mostrarEstadisticas();
        System.out.println("_--------------------------------------");
    }
}