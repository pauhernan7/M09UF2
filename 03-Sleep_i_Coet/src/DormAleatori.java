import java.util.Random;

public class DormAleatori extends Thread {
    private long tempsCreacio;


    public DormAleatori (String nombre) {
        super(nombre);
        this.tempsCreacio = System.currentTimeMillis();
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            int intervalAleatori = 100 + random.nextInt(900);
            long tempsTotal = System.currentTimeMillis() - this.tempsCreacio;
            System.out.println(getName() + "(" + i + ") a dormir " + intervalAleatori + " ms total " + tempsTotal + "ms" );
            try {
                Thread.sleep(intervalAleatori);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();



        System.out.println("-- Fi del main ---------");
    }

}
