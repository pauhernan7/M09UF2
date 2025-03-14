class Filosofo extends Thread {
    private final int id;
    private final Forquilla esquerra;
    private final Forquilla dreta;
    private int gana;

    public Filosofo(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
        this.gana = 0;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof: fil" + id + " pensant");
        Thread.sleep((long) (1000 + Math.random() * 1000));
    }

    private void menjar() throws InterruptedException {
        System.out.println("Filòsof: fil" + id + " menja");
        Thread.sleep((long) (1000 + Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                while (!esquerra.agafar()) {
                    System.out.println("Filòsof: fil" + id + " espera forquilla esquerra " + esquerra.getId());
                    Thread.sleep((long) (500 + Math.random() * 500));
                }
                System.out.println("Filòsof: fil" + id + " agafa la forquilla esquerra " + esquerra.getId());
                while (!dreta.agafar()) {
                    System.out.println("Filòsof: fil" + id + " deixa l'esquerra (" + esquerra.getId() + ") i espera (dreta ocupada)");
                    esquerra.deixar();
                    gana++;
                    System.out.println("Filòsof: fil" + id + " gana=" + gana);
                    Thread.sleep((long) (500 + Math.random() * 500));
                    while (!esquerra.agafar()) {
                        System.out.println("Filòsof: fil" + id + " espera forquilla esquerra " + esquerra.getId());
                        Thread.sleep((long) (500 + Math.random() * 500));
                    }
                }
                System.out.println("Filòsof: fil" + id + " agafa la forquilla dreta " + dreta.getId());
                menjar();
                dreta.deixar();
                esquerra.deixar();
                System.out.println("Filòsof: fil" + id + " ha acabat de menjar");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}