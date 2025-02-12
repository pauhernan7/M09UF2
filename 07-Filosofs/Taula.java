class Taula {
    private Filosof[] filosofs;
    private Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofs = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofs; i++) {
            Forquilla esquerra = forquilles[i];
            Forquilla dreta = forquilles[(i + 1) % numFilosofs];
            filosofs[i] = new Filosof("fil" + i, esquerra, dreta);
        }
    }

    public void showTaula() {
        for (Filosof filosof : filosofs) {
            System.out.println("Comensal: " + filosof.getNom() + 
                               " esq: " + filosof.getForquillaEsquerra().getNumero() + 
                               " dret: " + filosof.getForquillaDreta().getNumero());
        }
    }

    public void cridarATaula() {
        for (Filosof filosof : filosofs) {
            filosof.start(); // Iniciar el fil de cada filòsof
        }
    }
}