import java.util.*;

public class Estanc extends Thread {

    private static final Random rnd = new Random();

    private List<Tabac> tabacs;
    private List<Paper> papers;
    private List<Llumi> llumins;
    private boolean obert;

    public Estanc() {
        tabacs = new ArrayList<>();
        papers = new ArrayList<>();
        llumins = new ArrayList<>();
        obert = true;
    }

    @Override
    public void run() {
        System.out.println("Estanc obert");

        while (obert) {
            generarSubministrament();
            try {
                // Reemplazamos TimeUnit con Thread.sleep
                Thread.sleep(rnd.nextInt(1000) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Estanc tancat");
    }

    private synchronized void generarSubministrament() {
        int opcio = rnd.nextInt(3);
        switch (opcio) {
            case 0:
                afegirTabac();
                break;
            case 1:
                afegirPaper();
                break;
            case 2:
                afegirLlumi();
                break;
        }
        notifyAll();
    }

    private void afegirTabac() {
        tabacs.add(new Tabac());
        System.out.println("Afegint Tabac");
    }

    private void afegirPaper() {
        papers.add(new Paper());
        System.out.println("Afegint Paper");
    }

    private void afegirLlumi() {
        llumins.add(new Llumi());
        System.out.println("Afegint Llumi");
    }

    public synchronized Tabac obtenirTabac() {
        while (tabacs.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return tabacs.isEmpty() ? null : tabacs.remove(tabacs.size() - 1);
    }

    public synchronized Paper obtenirPaper() {
        while (papers.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return papers.isEmpty() ? null : papers.remove(papers.size() - 1);
    }

    public synchronized Llumi obtenirLlumi() {
        while (llumins.isEmpty() && obert) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return llumins.isEmpty() ? null : llumins.remove(llumins.size() - 1);
    }

    public void tancarEstanc() {
        obert = false;
        synchronized (this) {
            notifyAll();
        }
    }
}