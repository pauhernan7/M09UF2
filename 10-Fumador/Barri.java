public class Barri {
    public static void main(String[] args) {
        Estanc estanc = new Estanc();
        Fumador[] fumadors = new Fumador[3];

        for (int i = 0; i < 3; i++) {
            fumadors[i] = new Fumador(estanc, i);
            fumadors[i].start();
        }

        estanc.start();

        for (Fumador fumador : fumadors) {
            try {
                fumador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        estanc.tancarEstanc();

        try {
            estanc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}