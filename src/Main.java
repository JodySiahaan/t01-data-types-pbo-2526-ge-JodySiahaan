import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

interface Solver {
    void solve(Scanner scanner);
}

class Soal1Solver implements Solver {
    @Override
    public void solve(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            if (scanner.hasNextInt()) {
                int b = scanner.nextInt();
                int sum = a + b;
                boolean overflow = false;

                // Deteksi overflow int
                if (a > 0 && b > 0 && sum < 0) overflow = true;
                if (a < 0 && b < 0 && sum >= 0) overflow = true;

                if (overflow) System.out.println("OVERFLOW");
                else System.out.println(sum);
            }
        }
    }
}

class Soal2Solver implements Solver {
    @Override
    public void solve(Scanner scanner) {
        if (scanner.hasNext()) {
            String inputX = scanner.next();
            String inputY = scanner.next();

            float xF = Float.parseFloat(inputX);
            float yF = Float.parseFloat(inputY);
            float sumF = xF + yF;

            double xD = Double.parseDouble(inputX);
            double yD = Double.parseDouble(inputY);
            double sumD = xD + yD;

            double diff = Math.abs(sumF - sumD);
            System.out.printf("%.6f%n", diff);
        }
    }
}

class Soal3Solver implements Solver {
    @Override
    public void solve(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            Integer a = n;
            Integer b = a;
            a = a + 1;

            // sengaja pakai == untuk pembelajaran reference
            System.out.println("==: " + (a == b));
            System.out.println("equals: " + a.equals(b));
        }
    }
}

class Soal4Solver implements Solver {
    @Override
    public void solve(Scanner scanner) {
        if (scanner.hasNext()) {
            String s = scanner.next();
            String a = s;
            String b = s; // hilangkan new String biar tidak warning
            a = a + "X";

            System.out.println("==: " + (a == b));
            System.out.println("equals: " + a.equals(b));
        }
    }
}

class Soal5Solver implements Solver {
    @Override
    public void solve(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (scanner.hasNextDouble()) {
                double dbl = scanner.nextDouble();
                if (scanner.hasNextBoolean()) {
                    boolean bool = scanner.nextBoolean();

                    double result = num * dbl;
                    if (!bool) result *= -1;

                    System.out.printf("%.2f%n", result);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        Map<String, Solver> solvers = new HashMap<>();
        solvers.put("Soal1", new Soal1Solver());
        solvers.put("Soal2", new Soal2Solver());
        solvers.put("Soal3", new Soal3Solver());
        solvers.put("Soal4", new Soal4Solver());
        solvers.put("Soal5", new Soal5Solver());

        if (scanner.hasNext()) {
            String command = scanner.next();
            Solver solver = solvers.get(command);

            if (solver != null) solver.solve(scanner);
            else System.out.println("Soal tidak ditemukan!");
        }

        scanner.close();
    }
}