class Compte {
    private static Compte instance;
    private float saldo;

    private Compte() {
        this.saldo = 0;
    }

    public static synchronized Compte getInstance() {
        if (instance == null) {
            instance = new Compte();
        }
        return instance;
    }

    public synchronized float getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}