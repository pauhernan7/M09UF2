public class Fil extends Thread {
<<<<<<< HEAD
    private final String nom;
    private static boolean modeAlterna;
    private static volatile String tornActual = "Juan";

    public Fil(String nom, boolean modeAlterna) {
        this.nom = nom;
        Fil.modeAlterna = modeAlterna;
=======
    private String nom;
    private static boolean turnos; // Controla si se usan turnos o no
    private static volatile String turno = "Juan"; // Controla el turno actual

    public Fil(String nom, boolean turnos) {
        this.nom = nom;
        this.turnos = turnos;
>>>>>>> 3e1f20d (completat codi)
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
<<<<<<< HEAD
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

=======
            while (turnos && !turno.equals(nom)) {
                Thread.yield(); // Cede el control si no es el turno del hilo
            }

            // Imprime el número actual
            if(i<10){
                System.out.println(nom + " " + i);
            } else {
                System.out.println("Termina el fil " + nom);
            }

            if (turnos) {
                turno = (nom.equals("Juan")) ? "Pepe" : "Juan"; // Cambia el turno
            }
        }

    }
}
>>>>>>> 3e1f20d (completat codi)
