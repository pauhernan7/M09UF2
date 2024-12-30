public class Principal {
    public static void main(String[] args) {
        System.out.println("Termina thread main");

        Fil hiloJuan = new Fil("Juan");
        Fil hiloPepe = new Fil("Pepe");

        hiloJuan.setPriority(Thread.MIN_PRIORITY);
        hiloPepe.setPriority(Thread.MAX_PRIORITY);

        
        hiloPepe.start();

        try {
            hiloPepe.join();
        } catch (InterruptedException e) {
            System.out.println("Main fua interrumpido " + e.getMessage());
        }

        hiloJuan.start();

        try {
            hiloJuan.join();
        } catch (InterruptedException e) {
            System.out.println("Main fua interrumpido " + e.getMessage());
        }
        System.out.println("Termina thread Main");
    }
}
