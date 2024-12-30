public class Fil  extends Thread {
    
    private String nombre;


    public Fil(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(nombre + " " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("El hilo fue interrumpido: " + e.getMessage());
            }
        }
        System.out.println("Termina el hilo " + nombre);
    }
}