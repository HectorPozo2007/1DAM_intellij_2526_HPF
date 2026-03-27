public class Ejercicio1_HPF {
    private double salarioJefe;
    private double salarioEncargado;
    private double salarioOficinistas;
    private int numeroOficinistas;
    private boolean proyectosTerminados;
    private double presupuestoEmpresa;

    // voy a crear un constructor de la clase para probar que funcione bien
    public Ejercicio1_HPF(double salarioJefe, double salarioEncargado, double salarioOficinistas,
                          int numeroOficinistas, boolean proyectosTerminados, double presupuestoEmpresa) {
        this.salarioJefe = salarioJefe;
        this.salarioEncargado = salarioEncargado;
        this.salarioOficinistas = salarioOficinistas;
        this.numeroOficinistas = numeroOficinistas;
        this.proyectosTerminados = proyectosTerminados;
        this.presupuestoEmpresa = presupuestoEmpresa;
    }

    public static void main(String[] args) {

        // CASO 1: Pasa la auditoría
        Ejercicio1_HPF empresaOK = new Ejercicio1_HPF(3000, 2000, 1000, 5, true, 50000);
        System.out.print("Empresa 1 -> ");
        empresaOK.auditoriaEmpresa();


        // CASO 2: Falla por Proyectos No Terminados
        Ejercicio1_HPF empresaPendiente = new Ejercicio1_HPF(3000, 2000, 1000, 5, false, 50000);
        System.out.print("Empresa 2 -> ");
        empresaPendiente.auditoriaEmpresa();


        // CASO 3: Falla por Gasto en Personal (> 20.000€)
        Ejercicio1_HPF empresaCara = new Ejercicio1_HPF(8000, 5000, 2000, 5, true, 50000);
        System.out.print("Empresa 3 -> ");
        empresaCara.auditoriaEmpresa();


        // CASO 4: Falla por Presupuesto (> 100.000€)
        Ejercicio1_HPF empresaRica = new Ejercicio1_HPF(3000, 2000, 1000, 5, true, 150000);
        System.out.print("Empresa 4 -> ");
        empresaRica.auditoriaEmpresa();
    }

    public boolean auditoriaEmpresa(){
        double gastosGlobales;

        //el proyecto no esta terminado, termina el proceso aqui, el resto si no entra significa que si lo estan
        if (!proyectosTerminados){
            System.out.println("No ha pasado la auditoria y aque no ha terminado los proyectos acordados.");
            return false;
        }

        gastosGlobales = salarioEncargado+salarioJefe+(salarioOficinistas*numeroOficinistas);
        if (gastosGlobales>20000){
            System.out.println("No ha pasado la auditoria ya que el gasto en personal es de " + gastosGlobales + " y excede el limite mensual de 20.000 euros.");
            return false;
        }

        if (presupuestoEmpresa>100000){
            System.out.println("No ha pasado la auditoria ya que el presupuesto asignado de " + presupuestoEmpresa + " excede el limite establecido en 100.000 euros.");
            return false;
        }

        System.out.println("Enorabuena!! Ha pasado la auditoria, nos vemos el anyo que viene");
        return true;
    }


}
