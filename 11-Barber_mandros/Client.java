public class Client {
    private int id;
    private String name;

    public Client(int id) {
        this.id = id;
        this.name = "Client-" + id;
    }

    public String getName() {
        return name;
    }

    public void tallarseElCabell() {
        System.out.println(name + " tallant-se el cabell");
    }
}