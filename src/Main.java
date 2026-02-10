import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String soal = sc.next();

        switch (soal) {

            case "Soal1": {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if ((b > 0 && a > Integer.MAX_VALUE - b) ||
                    (b < 0 && a < Integer.MIN_VALUE - b)) {
                    System.out.println("OVERFLOW");
                } else {
                    System.out.println(a + b);
                }
                break;
            }

            case "Soal2": {
                double x = sc.nextDouble();
                double y = sc.nextDouble();

                float fsum = (float)x + (float)y;
                double dsum = x + y;

                double diff = Math.abs(fsum - dsum);
                System.out.printf("%.6f\n", diff);
                break;
            }

            case "Soal3": {
                int N = sc.nextInt();

                Integer a = N;
                Integer b = a;

                a = a + 1;

                System.out.println("==: " + (a == b));
                System.out.println("equals: " + a.equals(b));
                break;
            }

            case "Soal4": {
                String S = sc.next();

                String a = S;
                String b = new String(S);

                a = a + "X";

                System.out.println("==: " + (a == b));
                System.out.println("equals: " + a.equals(b));
                break;
            }

            case "Soal5": {
                int i = Integer.parseInt(sc.next());
                double d = Double.parseDouble(sc.next());
                boolean bool = Boolean.parseBoolean(sc.next());

                double hasil = i * d;

                if (!bool) {
                    hasil *= -1;
                }

                System.out.printf("%.2f\n", hasil);
                break;
            }
        }

        sc.close();
    }
}
