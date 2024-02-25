import java.util.Scanner;

public class FibDemo {
    public long fibIter(int n) {
       int num1 = 0;
       int num2 = 1;

       for (int i = 0; i < n; i++) {
           int temp = num1;
           num1 = num2;

           num2 = temp + num2;
       }
       return num1;
    }

    public long fibRecur(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibRecur(n-1) + fibRecur(n-2);

    }

    public static void main(String[] args)
    {
        int n;
        long t0, t1, f1, f2, d1, d2;
        FibDemo fd = new FibDemo();

        System.out.print("Enter and interfere greater than 0: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        t0 = System.nanoTime();
        f1 = fd.fibIter(n);
        t1 = System.nanoTime();
        d1 = t1 - t0;

        System.out.println("fibIter(" + n + ") = " + f1 + ". Elapsed time is " + d1 + "ns.");
        System.out.println();

        t0 = System.nanoTime();
        f2 = fd.fibRecur(n);
        t1 = System.nanoTime();
        d2 = t1 - t0;

        System.out.println("fibIter(" + n + ") = " + f2 + ". Elapsed time is " + d2 + "ns.");
        System.out.println();

        if (f2 != f1) {
            System.out.println("Test Failed!");
        } else {
            System.out.println("With the given n, recursive version is " + (d2 / d1) + "times slower!");
        }
        System.out.println();
    }
}
