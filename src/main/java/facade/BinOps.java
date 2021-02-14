package facade;

public class BinOps {
    public String sum(String a, String b) {
    /*Переведите числа из двоичной записи в
      строках в int, сложите и переведите
      обратно в двоичную запись*/
        int intA = Integer.parseInt(a, 2);
        System.out.println("IntA is: " + intA);
        int intB = Integer.parseInt(b, 2);
        System.out.println("IntB is: " + intB);
        int sum = intA + intB;
        return Integer.toBinaryString(sum);
    }

    public String mult(String a, String b) {
    /*Переведите числа из двоичной записи в
      строках в int, перемножьте и переведите
      обратно в двоичную запись*/
        int intA = Integer.parseInt(a, 2);
        System.out.println("IntA is: " + intA);
        int intB = Integer.parseInt(b, 2);
        System.out.println("IntB is: " + intB);
        int mult = intA * intB;
        return Integer.toBinaryString(mult);
    }
}
