import java.util.Random;

public class Motor extends Thread {
    private int potenciaInicial = 0;
    private int potenciaObjectiu = 0;
    private boolean enFuncionamiento = true; 

    public void setPotenciaObjectiu(int potenciaObjectiu) {
        this.potenciaObjectiu = potenciaObjectiu;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (enFuncionamiento) {
            if (potenciaInicial == potenciaObjectiu) {
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    System.out.println(getName() + ": Interrumpido. Finalizando.");
                    enFuncionamiento = false;
                }
                continue;
            }

            if (potenciaObjectiu == 0 && potenciaInicial == 0) {
                System.out.println(getName() + ": Motor apagat");
                enFuncionamiento = false;
                break;
            }

            if (potenciaInicial < potenciaObjectiu) {
                potenciaInicial++;
                System.out.println(getName() + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaInicial);
            } else if (potenciaInicial > potenciaObjectiu) {
                potenciaInicial--;
                System.out.println(getName() + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaInicial);
            }

            try {
                Thread.sleep(1000 + random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(getName() + ": Interrumpido durante el ajuste. Finalizando.");
                enFuncionamiento = false;
            }
        }
    }
}
