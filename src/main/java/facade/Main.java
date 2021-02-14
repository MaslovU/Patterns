package facade;

public class Main {
    public static void main(String[] args) {
        BinOps bins = new BinOps();
        //демонстрация
        String sum = bins.sum("0111", "0101");
        System.out.println(sum);
        String mult = bins.mult("0010", "0011");
        System.out.println(mult);
    }
}
