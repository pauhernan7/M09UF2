import java.util.ArrayList;
import java.util.List;

public class Taula {
    private List<Filosof> filosofs;
    private List<Forquilla> forquilles;

    public Taula(int numFilosofs) {
        filosofs = new ArrayList<>();
        forquilles = new ArrayList<>();

        for (int i = 0; i < numFilosofs; i++) {
            forquilles.add(new Forquilla(i));
        }

        for (int i = 0; i < numFilosofs; i++) {
            Forquilla esquerra = forquilles.get(i);
            Forquilla dreta = forquilles.get((i + 1) % numFilosofs);
            filosofs.add(new Filosof(i, esquerra, dreta));
        }
    }

    public void showTaula() {
        for (Filosof filosof : filosofs) {
            System.out.println("Comensal:Fil" + filosof.getNum() + " esq:" + filosof.getForquillaEsquerra().getNum() + " dret:" + filosof.getForquillaDreta().getNum());
        }
        System.out.println("----------------------------------");
    }

    public void cridarATaula() {
        for (Filosof filosof : filosofs) {
            new Thread(filosof).start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }
}