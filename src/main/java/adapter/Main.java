package adapter;

public class Main {
    public static void main(String[] args) {
        Ints calc = new IntsCalculator();
        //демонстрация
        int res1 = calc.sum(4, 13);
        System.out.println("ResSum is: " + res1);
        int res2 = calc.pow(7, 9);
        System.out.println("ResPow is: " + res2);
        int res3 = calc.mult(5, 12);
        System.out.println("ResMult is: " + res3);
    }
}
