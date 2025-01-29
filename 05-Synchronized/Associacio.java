class Associacio {
    private final int numSocis = 1000;
    private Soci[] socis;

    public Associacio() {
        socis = new Soci[numSocis];
        for (int i = 0; i < numSocis; i++) {
            socis[i] = new Soci();
        }
    }

    public void iniciaCompteTempsSocis() {
        for (Soci soci : socis) {
            soci.start();
        }
        for (Soci soci : socis) {
            try {
                soci.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mostraBalancComptes() {
        System.out.printf("Saldo: %.2f\n", Compte.getInstance().getSaldo());
    }
}