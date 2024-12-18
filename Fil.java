public class Fil extends Thread {
    private final String nom;
    private static boolean modeAlterna;
    private static volatile String tornActual = "Juan";

    public Fil(String nom, boolean modeAlterna) {
        this.nom = nom;
        Fil.modeAlterna = modeAlterna;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (modeAlterna) {
                while (!tornActual.equals(nom)) {
                    Thread.yield();
                }
            }

            mostrarProgres(i);

            if (modeAlterna) {
                cambiarTorn();
            }
        }
    }

    private void mostrarProgres(int iteracio) {
        if (iteracio < 10) {
            System.out.println(nom + " " + iteracio);
        } else {
            System.out.println("Fil finalitzat: " + nom);
        }
    }

    private synchronized void cambiarTorn() {
        tornActual = tornActual.equals("Juan") ? "Pepe" : "Juan";
    }
}

