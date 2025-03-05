import java.util.ArrayList;
import java.util.Random;

public class Estanc extends Thread {
    private ArrayList<Tabac> tabacs;
    private ArrayList<Paper> papers;
    private ArrayList<Llumi> llumins;
    private boolean obert;

    public Estanc() {
        tabacs = new ArrayList<>();
        papers = new ArrayList<>();
        llumins = new ArrayList<>();
        obert = true;
    }

    @Override
    public void run() {
        while (obert) {
            nouSubministrament();
            try {
                Thread.sleep(500 + new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Estanc tancat");
    }

    public synchronized void nouSubministrament() {
        Random rand = new Random();
        int opcio = rand.nextInt(3);
        switch (opcio) {
            case 0:
                addTabac();
                break;
            case 1:
                addPaper();
                break;
            case 2:
                addLlumi();
                break;
        }
    }

    public synchronized void addTabac() {
        tabacs.add(new Tabac());
        System.out.println("Afegint tabac");
        notifyAll();
    }

    public synchronized void addPaper() {
        papers.add(new Paper());
        System.out.println("Afegint Paper");
        notifyAll();
    }

    public synchronized void addLlumi() {
        llumins.add(new Llumi());
        System.out.println("Afegint Llumí");
        notifyAll();
    }

    public synchronized Tabac venTabac() {
        while (tabacs.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!tabacs.isEmpty()) {
            return tabacs.remove(0);
        }
        return null;
    }

    public synchronized Paper venPaper() {
        while (papers.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!papers.isEmpty()) {
            return papers.remove(0);
        }
        return null;
    }

    public synchronized Llumi venLlumi() {
        while (llumins.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!llumins.isEmpty()) {
            return llumins.remove(0);
        }
        return null;
    }

    public synchronized void tancarEstanc() {
        obert = false;
        notifyAll();
    }
}