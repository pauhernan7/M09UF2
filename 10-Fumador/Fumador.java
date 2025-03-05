import java.util.*;

public class Fumador extends Thread {

    private static final Random rnd = new Random();

    private Estanc estanc;
    private final int id;
    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;
    private int fumades;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
        this.fumades = 0;
    }

    @Override
    public void run() {
        while (fumades < 3) {
            try {
                comprarTabac();
                comprarPaper();
                comprarLlumi();

                if (tabac != null && paper != null && llumi != null) {
                    fumar();
                    tabac = null;
                    paper = null;
                    llumi = null;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void fumar() throws InterruptedException {
        System.out.printf("Fumador %d fumant%n", id);
        // Reemplazamos TimeUnit con Thread.sleep
        Thread.sleep(rnd.nextInt(500) + 500);
        fumades++;
        System.out.printf("Fumador %d ha fumat %d vegades%n", id, fumades);
    }

    private void comprarTabac() throws InterruptedException {
        synchronized (estanc) {
            while ((tabac = estanc.obtenirTabac()) == null) {
                estanc.wait();
            }
        }
        System.out.printf("Fumador %d comprant Tabac%n", id);
    }

    private void comprarPaper() throws InterruptedException {
        synchronized (estanc) {
            while ((paper = estanc.obtenirPaper()) == null) {
                estanc.wait();
            }
        }
        System.out.printf("Fumador %d comprant Paper%n", id);
    }

    private void comprarLlumi() throws InterruptedException {
        synchronized (estanc) {
            while ((llumi = estanc.obtenirLlumi()) == null) {
                estanc.wait();
            }
        }
        System.out.printf("Fumador %d comprant Llumi%n", id);
    }
}