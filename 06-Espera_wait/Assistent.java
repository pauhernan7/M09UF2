import java.util.Random;

public class Assistent extends Thread {
    private final Esdeveniment esdeveniment;
    private final Random random = new Random();
    private final String nom;

    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (random.nextBoolean()) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
                Thread.sleep(random.nextInt(1000)); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
