package D_23_01_25.Level1;

import java.util.Scanner;

public class CountDownWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = scanner.nextInt();
        while (counter >= 1){
            System.out.println(counter);
            counter--;
        }
    }
}
