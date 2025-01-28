package D_28_01_25.Level2;

import java.util.Arrays;
public class RandomNumbers {
    public int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = 1000 + (int) (Math.random() * 9000);
        }
        return randomNumbers;
    }
    public double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double average = (double) sum / numbers.length;
        return new double[] { average, min, max };
    }
    public static void main(String[] args) {
        RandomNumbers randomNumbers = new RandomNumbers();
        int[] numbers = randomNumbers.generate4DigitRandomArray(5);
        double[] results = randomNumbers.findAverageMinMax(numbers);
        System.out.println("Generated Numbers: " + Arrays.toString(numbers));
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + results[1]);
        System.out.println("Maximum: " + results[2]);
    }
}
