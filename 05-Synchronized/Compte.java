public class Compte {
    private float saldo;
    private static Compte instancia;


    private Compte() {
        saldo = 0.0f;
    }

    public static Compte getInstancia() {
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
