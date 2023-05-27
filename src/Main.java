import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println(Calc.calc(inputString));
    }
}