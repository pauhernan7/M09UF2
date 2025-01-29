import java.util.Random;

class Soci extends Thread {
    private Compte compte;
    private final float aportacio = 10f;
    private final int esperaMax = 100;
    private final int maxAnys = 10;
    private Random random;
    
    public Soci() {
        this.compte = Compte.getInstance();
        this.random = new Random();
    }

    public void run() {
        for (int any = 0; any < maxAnys; any++) {
            for (int mes = 0; mes < 12; mes++) {
                try {
                    Thread.sleep(random.nextInt(esperaMax));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (compte) {
                    float saldoActual = compte.getSaldo();
                    if (mes % 2 == 0) {
                        compte.setSaldo(saldoActual + aportacio);
                    } else {
                        compte.setSaldo(saldoActual - aportacio);
                    }
                }
            }
        }
    }
}