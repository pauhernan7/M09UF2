import java.util.LinkedList;
import java.util.Queue;

public class Barberia implements Runnable {
    private Queue<Client> salaEspera;
    private int maxCadires;
    private Object condBarber;
    private static Barberia instance;

    private Barberia(int maxCadires) {
        this.salaEspera = new LinkedList<>();
        this.maxCadires = maxCadires;
        this.condBarber = new Object();
    }

    public static Barberia getInstance(int maxCadires) {
        if (instance == null) {
            instance = new Barberia(maxCadires);
        }
        return instance;
    }

    public Object getCondBarber() {
        return condBarber;
    }

    public synchronized Client seguentClient() {
        return salaEspera.poll();
    }

    public synchronized void entrarClient(Client client) {
        if (salaEspera.size() < maxCadires) {
            salaEspera.add(client);
            System.out.println(client.getName() + " en espera");
            synchronized (condBarber) {
                condBarber.notify();
            }
        } else {
            System.out.println("No queden cadires, client " + client.getName() + " se'n va");
        }
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            entrarClient(new Client(i));
            try {
                Thread.sleep(500); // 0.5 segons
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(10000); // 10 segons
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 11; i <= 20; i++) {
            entrarClient(new Client(i));
            try {
                Thread.sleep(500); // 0.5 segons
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Barberia barberia = Barberia.getInstance(3);
        Barber barber = new Barber("Pepe", barberia);
        Thread barberThread = new Thread(barber);
        Thread barberiaThread = new Thread(barberia);

        barberThread.start();
        barberiaThread.start();
    }
}