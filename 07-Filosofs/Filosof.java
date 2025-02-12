import java.util.Random;

class Filosof extends Thread {  // Herència de Thread en lloc d'implementar Runnable
    private String nom;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int gana;
    private Random random;

    public Filosof(String nom, Forquilla esquerra, Forquilla dreta) {
        this.nom = nom;
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
        this.gana = 0;
        this.random = new Random();
    }

    public String getNom() {
        return nom;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof: " + nom + " pensant");
        Thread.sleep(random.nextInt(1000) + 1000); // Pensar entre 1s i 2s
    }

    private void menjar() throws InterruptedException {
        System.out.println("Filòsof: " + nom + " menja");
        Thread.sleep(random.nextInt(1000) + 1000); // Menjar entre 1s i 2s
        gana = 0; // Resetegem la gana després de menjar
        System.out.println("Filòsof: " + nom + " ha acabat de menjar. Gana: " + gana);
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();

                // Intentar agafar les forquilles
                while (true) {
                    if (!forquillaEsquerra.isEnUs()) {
                        forquillaEsquerra.setEnUs(true);
                        System.out.println("Filòsof: " + nom + " agafa la forquilla esquerra " + forquillaEsquerra.getNumero());

                        if (!forquillaDreta.isEnUs()) {
                            forquillaDreta.setEnUs(true);
                            System.out.println("Filòsof: " + nom + " agafa la forquilla dreta " + forquillaDreta.getNumero());
                            menjar();
                            forquillaDreta.setEnUs(false);
                            System.out.println("Filòsof: " + nom + " deixa la forquilla dreta " + forquillaDreta.getNumero());
                            forquillaEsquerra.setEnUs(false);
                            System.out.println("Filòsof: " + nom + " deixa la forquilla esquerra " + forquillaEsquerra.getNumero());
                            break; // Sortir del bucle després de menjar
                        } else {
                            forquillaEsquerra.setEnUs(false);
                            System.out.println("Filòsof: " + nom + " deixa l'esquerra (" + forquillaEsquerra.getNumero() + ") i espera (dreta ocupada)");
                            gana++;
                            System.out.println("Filòsof: " + nom + " gana=" + gana);
                        }
                    }
                    Thread.sleep(random.nextInt(500) + 500); // Esperar entre 0.5s i 1s
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}