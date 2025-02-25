import java.util.Random;

public class Filosof implements Runnable {
    private int num;
    private Forquilla forquillaEsquerra;
    private Forquilla forquillaDreta;
    private int iniciGana;
    private int fiGana;
    private int gana;
    private Random random;

    public Filosof(int num, Forquilla esquerra, Forquilla dreta) {
        this.num = num;
        this.forquillaEsquerra = esquerra;
        this.forquillaDreta = dreta;
        this.random = new Random();
    }

    public int getNum() {
        return num;
    }

    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Fil" + num + " pensant");
        iniciGana = (int) System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000) + 1000); 
    }

    private void agafarForquilles() throws InterruptedException {
        while (true) {
            if (forquillaEsquerra.intentarAgafar()) {
                if (forquillaDreta.intentarAgafar()) {
                    System.out.println("Fil" + num + " té forquilles esq(" + forquillaEsquerra.getNum() + ") dreta(" + forquillaDreta.getNum() + ")");
                    return;
                } else {
                    forquillaEsquerra.deixar();
                }
            }
            Thread.sleep(random.nextInt(500) + 500);
        }
    }

    private void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.println("Fil" + num + " deixa les forquilles");
    }

    private void menjar() throws InterruptedException {
        fiGana = (int) System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000; 
        System.out.println("Fil" + num + " menja amb gana " + gana);
        Thread.sleep(random.nextInt(1000) + 1000); 
        System.out.println("Fil" + num + " ha acabat de menjar");
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                agafarForquilles();
                menjar();
                deixarForquilles();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}