import java.util.Random;

class Treballador extends Thread {
    private final float nouAnualBrut;
    private final int edatIniciTreball;
    private final int edatFiTreball;
    private int edatActual;
    private float cobrat;

    public Treballador(String nom, float nouAnualBrut, int edatIniciTreball, int edatFiTreball) {
        super(nom);
        this.nouAnualBrut = nouAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 0;
        this.cobrat = 0.0f;
    }

    public synchronized void cobra() {
        float salariMensual = nouAnualBrut / 12.0f;
        float impostos = salariMensual * 0.24f;
        cobrat += (salariMensual - impostos);
    }

    @Override
    public void run() {
        for (edatActual = edatIniciTreball; edatActual <= edatFiTreball; edatActual++) {
            cobra();
            try {
                Thread.sleep(10); // Simula el pas del temps
            } catch (InterruptedException e) {
                System.err.println("Fil interromput: " + getName());
            }
        }
    }

    public synchronized float getCobrat() {
        return cobrat;
    }

    public synchronized int getEdat() {
        return edatActual;
    }
}

class Administracio {
    private static final int NUM_POBLACIO_ACTIVA = 50;
    private final Treballador[] poblacioActiva;

    public Administracio() {
        poblacioActiva = new Treballador[NUM_POBLACIO_ACTIVA];
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            poblacioActiva[i] = new Treballador(
                "Ciutadà-" + i, 25000.0f, 20, 65
            );
        }
    }

    public void iniciaSimulacio() {
        for (Treballador treballador : poblacioActiva) {
            treballador.start();
        }
        for (Treballador treballador : poblacioActiva) {
            try {
                treballador.join(); // Espera que el fil acabi
            } catch (InterruptedException e) {
                System.err.println("Error esperant fil: " + treballador.getName());
            }
        }
    }

    public void mostraEstadistiques() {
        for (Treballador treballador : poblacioActiva) {
            System.out.printf("%s -> edat: %d / total: %.2f%n",
                treballador.getName(), treballador.getEdat() - 1, treballador.getCobrat());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.iniciaSimulacio();
        administracio.mostraEstadistiques();
    }
}
