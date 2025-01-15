import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Coet {
    private Motor[] motors;

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor();
            motors[i].setName("Motor " + i);
        }
    }

    public void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public void passaAPotencia(int potencia) {
        if (potencia < 0 || potencia > 10) {
            System.out.println("Error: Potència fora de rang (0-10).");
            return;
        }
        System.out.println("Passant a potencia: " + potencia);
        for (Motor motor : motors) {
            motor.setPotenciaObjectiu(potencia);
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int potencia = -1;

        System.out.println("Introdueix una potencia objectiu (0 per sortir):");

        while (potencia != 0) {
            try {
                String input = reader.readLine();  // Lee una línea como String
                potencia = Integer.parseInt(input);  // Convierte el String a entero

                if (potencia != 0) {
                    coet.passaAPotencia(potencia);
                }
            } catch (IOException e) {
                System.out.println("Error al llegir l'entrada: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Entrada incorrecta. Introdueïx un enter vàlid");
            }
        }

        System.out.println("Apagant motors...");
        coet.passaAPotencia(0);
    }
}
