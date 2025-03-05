import java.io.*;

public class Barri {

    private Estanc estanc;
    private Fumador[] fumadors;

    public Barri() {
        estanc = new Estanc();
        fumadors = new Fumador[3];

        for (int i = 0; i < 3; i++) {
            fumadors[i] = new Fumador(estanc, i);
        }
    }

    public static void main(String[] args) {
        Barri barri = new Barri();

        for (Fumador fumador : barri.fumadors) {
            fumador.start();
        }

        barri.estanc.start();

        for (Fumador fumador : barri.fumadors) {
            try {
                fumador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        barri.estanc.tancarEstanc();
    }
}