import java.util.Random;

public class Fumador extends Thread {
    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;
    private int numFumades;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
        this.numFumades = 0;
    }

    public void fuma() {
        try {
            System.out.println("Fumador " + id + " fumant");
            Thread.sleep(500 + new Random().nextInt(500));
            numFumades++;
            System.out.println("Fumador " + id + " ha fumat " + numFumades + " vegades");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void compraTabac() {
        tabac = estanc.venTabac();
        if (tabac != null) {
            System.out.println("Fumador " + id + " comprant Tabac");
        }
    }

    public void compraPaper() {
        paper = estanc.venPaper();
        if (paper != null) {
            System.out.println("Fumador " + id + " comprant Paper");
        }
    }

    public void compraLlumi() {
        llumi = estanc.venLlumi();
        if (llumi != null) {
            System.out.println("Fumador " + id + " comprant Llumí");
        }
    }

    @Override
    public void run() {
        while (numFumades < 3) {
            compraTabac();
            compraPaper();
            compraLlumi();
            if (tabac != null && paper != null && llumi != null) {
                fuma();
                tabac = null;
                paper = null;
                llumi = null;
            }
        }
    }
}