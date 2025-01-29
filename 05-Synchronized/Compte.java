import java.util.Random;

class Compte {
    private static Compte instancia;
    private float saldo;

    private Compte() {
        this.saldo = 0;
    }

    public static Compte getInstance() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}