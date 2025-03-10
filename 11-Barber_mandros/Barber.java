import java.util.Random;

public class Barber implements Runnable {
    private String name;
    private Barberia barberia;

    public Barber(String name, Barberia barberia) {
        this.name = name;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            Client client = barberia.seguentClient();
            if (client != null) {
                System.out.println("Li toca al client " + client.getName());
                tallarCabell(client);
            } else {
                System.out.println("Ningú en espera");
                System.out.println("Barber " + name + " dormint");
                synchronized (barberia.getCondBarber()) {
                    try {
                        barberia.getCondBarber().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void tallarCabell(Client client) {
        Random rand = new Random();
        int temps = 900 + rand.nextInt(100); // 0.9s + random 0.1s
        try {
            Thread.sleep(temps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tallant cabell a " + client.getName());
    }
}