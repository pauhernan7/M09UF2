class Taula {
    private final Filosofo[] filosofs;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofs = new Filosofo[numFilosofs];
        forquilles = new Forquilla[numFilosofs];
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }
        for (int i = 0; i < numFilosofs; i++) {
            filosofs[i] = new Filosofo(i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
        }
    }

    public void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.println("Comensal: fil" + i + " esq:" + i + " dret:" + ((i + 1) % filosofs.length));
        }
    }

    public void cridarATaula() {
        for (Filosofo f : filosofs) {
            f.start();
        }
    }
}