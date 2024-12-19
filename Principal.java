<<<<<<< HEAD
// Principal.java
public class Principal {
    public static void main(String[] args) {
        System.out.println("Comportament 1:");
        executarIntercalada();

        System.out.println("\nComportament 2:");
        executarPrimerPepeDespresJuan();

=======
public class Principal {
    public static void main(String[] args) {
        // Comportament 1: Execució intercalada
        System.out.println("Comportament 1:");
        executarIntercalada();

        // Comportament 2: Primer Pepe, després Juan
        System.out.println("\nComportament 2:");
        executarPrimerPepeDespresJuan();

        // Comportament 3: Execució alterna estricta
>>>>>>> 3e1f20d (completat codi)
        System.out.println("\nComportament 3:");
        executarAlternaEstricta();
    }

<<<<<<< HEAD
    private static void executarIntercalada() {
        Thread juan = new Fil("Juan", false);
        Thread pepe = new Fil("Pepe", false);

        System.out.println("Main thread finalitzat.");
=======
    public static void executarIntercalada() {
        Fil juan = new Fil("Juan", false);
        Fil pepe = new Fil("Pepe", false);

        System.out.println("Termina thread main");
>>>>>>> 3e1f20d (completat codi)

        juan.start();
        pepe.start();

<<<<<<< HEAD
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
=======
        try {
            juan.join();
            pepe.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void executarPrimerPepeDespresJuan() {
        Fil pepe = new Fil("Pepe", false);
        Fil juan = new Fil("Juan", false);

        System.out.println("Termina thread main");

        // Donem prioritat a Pepe
        pepe.setPriority(10);
        juan.setPriority(1);

        pepe.start();
        juan.start();
        
        try {
            pepe.join();
            juan.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void executarAlternaEstricta() {
        System.out.println("Termina thread main");

        // Crear instancias de los hilos
        Fil juan = new Fil("Juan", true);
        Fil pepe = new Fil("Pepe",  true);

        // Iniciar los hilos
        juan.start();
        pepe.start();

        // Esperar a que ambos hilos terminen
        try {
            juan.join();
            pepe.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> 3e1f20d (completat codi)
