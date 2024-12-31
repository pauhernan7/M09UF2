public class Futbolista extends Thread {
    static final int numJugadors = 11;
    static final int numTirades = 20;
    static final double probabilitat = 0.5;
    private int ngols;
    private int ntirades;



    public Futbolista (String nombre) {
        super(nombre);
        this.ngols = 0;
        this.ntirades = 0;
    }

    @Override
    public void run() {
        for (int i = 1; i <= numTirades; i++) {
            ntirades++;
            if (Math.random() < probabilitat) {
                ngols++;
            }
        }
        
    }

    public static int getNumjugadors() {
        return numJugadors;
    }

    public static int getNumtirades() {
        return numTirades;
    }

    public static double getProbabilitat() {
        return probabilitat;
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

}
