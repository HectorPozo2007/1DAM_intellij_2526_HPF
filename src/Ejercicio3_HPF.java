public class Ejercicio3_HPF {
    private String nombre;
    private int edad;
    private double peso, altura;
    private String sexo;
    private double velInicial, distInicial, calInicial;

    public Ejercicio3_HPF(String nombre, int edad, double peso, double altura, String sexo,
                          double velInicial, double distInicial, double calInicial) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.velInicial = velInicial;
        this.distInicial = distInicial;
        this.calInicial = calInicial;
    }

    public void generarFicha(double[] vels, double[] dists, double[] cals) {
        double sumaV = 0, sumaD = 0, sumaC = 0;
        double maxDist = 0, maxCal = 0;

        double imc = peso / (altura * altura);

        for (int i = 0; i < 10; i++) {
            sumaV += vels[i];
            sumaD += dists[i];
            sumaC += cals[i];

            if (dists[i] > maxDist) maxDist = dists[i];
            if (cals[i] > maxCal) maxCal = cals[i];
        }

        double medV = sumaV / 10;
        double medD = sumaD / 10;
        double medC = sumaC / 10;
        System.out.println("\n=============================================");
        System.out.println("Hola " + nombre + ", ficha de seguimiento:");
        System.out.println("Edad: " + edad + " | Peso: " + peso + "kg | Altura: " + altura + "m");
        System.out.println("Sexo: " + sexo + " | IMC: " + String.format("%.2f", imc));
        System.out.println("PROMEDIOS DE 10 SESIONES:");
        System.out.println("Velocidad media: " + medV + " km/h");
        System.out.println("Distancia media: " + medD + " km");
        System.out.println("Calorías medias: " + medC + " kcal");
        System.out.println("Máxima distancia: " + maxDist + " km");
        System.out.println("Máximas calorías: " + maxCal + " kcal");

        boolean mejora = false;
        if (medV > velInicial) {
            System.out.println("Enhorabuena! Has superado tu VELOCIDAD inicial.");
            mejora = true;
        }
        if (medD > distInicial) {
            System.out.println("Enhorabuena! Has superado tu DISTANCIA inicial.");
            mejora = true;
        }
        if (medC > calInicial) {
            System.out.println("Enhorabuena! Has superado tus CALORÍAS iniciales.");
            mejora = true;
        }

        if (!mejora) System.out.println("Sigue entrenando, no has superado tus marcas de referencia.");
    }
    public static void main(String[] args) {
        double[] vels = {10, 12, 11, 13, 10, 12, 14, 11, 10, 12};
        double[] dists = {5, 6, 7, 5, 8, 6, 7, 5, 6, 10};
        double[] cals = {400, 500, 450, 600, 420, 510, 650, 400, 430, 700};

        Ejercicio3_HPF corredorPro = new Ejercicio3_HPF("Carlos", 28, 75.5, 1.80, "H", 8.0, 4.0, 300);
        corredorPro.generarFicha(vels, dists, cals);

        Ejercicio3_HPF corredorElite = new Ejercicio3_HPF("Marta", 32, 58.0, 1.65, "M", 15.0, 12.0, 1000);
        corredorElite.generarFicha(vels, dists, cals);

        Ejercicio3_HPF corredorFiel = new Ejercicio3_HPF("Juan", 45, 90.0, 1.75, "H", 13.0, 2.0, 800);
        corredorFiel.generarFicha(vels, dists, cals);
    }
}