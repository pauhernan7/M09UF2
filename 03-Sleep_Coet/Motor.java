import java.util.Random;

public class Motor extends Thread {
    private int potenciaInicial = 0;
    private int potenciaObjectiu = 0;

    public synchronized void setPotenciaObjectiu(int potenciaObjectiu) {
        this.potenciaObjectiu = potenciaObjectiu;
        notify();
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    while (potenciaInicial == potenciaObjectiu) {
                        wait();
                    }
                }

                // Si potenciaInicial es igual a potenciaObjectiu, el motor no hace nada
                if (potenciaObjectiu == 0 && potenciaInicial == 0) {
                    System.out.println("Motor apagat");
                    break;
                }

                // Comprobamos las tres condiciones y mostramos el mensaje correspondiente
                if (potenciaInicial < potenciaObjectiu) {
                    potenciaInicial++;  // Incrementamos la potencia
                    System.out.println(getName() + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaInicial);
                } else if (potenciaInicial > potenciaObjectiu) {
                    potenciaInicial--;  // Decrementamos la potencia
                    System.out.println(getName() + ": Decre. Objetiu: " + potenciaObjectiu + " Actual: " + potenciaInicial);
                } else {
                    System.out.println(getName() + ": FerRes. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaInicial);
                }

                // Simulamos el ajuste con un retraso aleatorio
                Random random = new Random();
                Thread.sleep(1000 + random.nextInt(1000));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
