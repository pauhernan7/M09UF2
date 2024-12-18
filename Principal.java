// Principal.java
public class Principal {
    public static void main(String[] args) {
        System.out.println("Comportament 1:");
        executarIntercalada();

        System.out.println("\nComportament 2:");
        executarPrimerPepeDespresJuan();

        System.out.println("\nComportament 3:");
        executarAlternaEstricta();
    }

    private static void executarIntercalada() {
        Thread juan = new Fil("Juan", false);
        Thread pepe = new Fil("Pepe", false);

        System.out.println("Main thread finalitzat.");

        juan.start();
        pepe.start();

        esperarFinalizacion(juan, pepe);
    }

    private static void executarPrimerPepeDespresJuan() {
        Thread pepe = new Fil("Pepe", false);
        Thread juan = new Fil("Juan", false);

        System.out.println("Main thread finalitzat.");

        pepe.setPriority(Thread.MAX_PRIORITY);
        juan.setPriority(Thread.MIN_PRIORITY);

        pepe.start();
        juan.start();

        esperarFinalizacion(pepe, juan);
    }

    private static void executarAlternaEstricta() {
        Thread juan = new Fil("Juan", true);
        Thread pepe = new Fil("Pepe", true);

        System.out.println("Main thread finalitzat.");

        juan.start();
        pepe.start();

        esperarFinalizacion(juan, pepe);
    }

    private static void esperarFinalizacion(Thread... threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println("Error esperant el fil: " + thread.getName());
            }
        }
    }
}
