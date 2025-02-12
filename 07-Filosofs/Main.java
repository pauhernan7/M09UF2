public class Main {
    public static void main(String[] args) {
        Taula taula = new Taula(4); // Crear una taula amb 4 filòsofs
        taula.showTaula(); // Mostrar l'estat inicial de la taula
        taula.cridarATaula(); // Iniciar el sopar (els filòsofs comencen a pensar i menjar)
    }
}