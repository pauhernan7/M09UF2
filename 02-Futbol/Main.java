public class Main {
    public static void main(String[] args) throws InterruptedException {
        Futbolista [] jugadors = new Futbolista[Futbolista.numJugadors];
        String [] nomsFutbolistes = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};

        for (int i = 0; i < Futbolista.numJugadors; i++) {
            jugadors[i] = new Futbolista(nomsFutbolistes[i]);
            jugadors[i].start();
        }

        for (Futbolista futbolista : jugadors) {
            futbolista.join();
        }

        System.out.println("--- Estadísticas ---");
        for (Futbolista futbolista : jugadors) {
            System.out.println(futbolista.getName() + " -> " + futbolista.getNgols() + " gols");
        }
    }
}
