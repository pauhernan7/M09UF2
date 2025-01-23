import java.util.Random;

public class Soci extends Thread {
    private static final Compte instancia;
    private float aportacio;
    private int esperaMax;
    private Random random;
    private int maxAnys;


    public int getMaxAnys() {
        return maxAnys;
    }



    public Soci() {
        this.aportacio = 10f;
        this.esperaMax = 100;
        this.random = random;
        this.maxAnys = 10;
    }



    public static Compte getInstancia() {
        return instancia;
    }


    @Override
    public void run() {
        for (int any = 0; i < maxAnys; any++) {
            for (int mes = 0; j < 12; mes++) {
                float saldoActual = compte.getSaldo();

                if (mes % 2 == 0) {
                    cuenta.setSaldo(saldoActual + aportacio);
                } else {
                    cuenta.setSaldo(saldoActual - aportacio);
                }

                try {
                    Thread.sleep(random.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();;
                }
            }
        }
    }
}
