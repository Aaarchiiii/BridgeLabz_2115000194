package D_28_01_25.Level3;

public class NumberChecker {
    public static int countDigits(int number) {
        int count=0;
        while (number!=0) {
            count++;
            number/=10;
        }
        return count;
    }
    public static int[] getDigitsArray(int number) {
        int count=countDigits(number);
        int[] digits=new int[count];
        for(int i=count-1;i>=0;i--) {
            digits[i]=number%10;
            number/=10;
        }
        return digits;
    }
    public static boolean isDuckNumber(int[] digits) {
        for(int i=1;i<digits.length;i++) {
            if(digits[i]==0) return true;
        }
        return false;
    }
    public static boolean isArmstrongNumber(int number) {
        int[] digits=getDigitsArray(number);
        int power=digits.length;
        int sum=0;
        for (int digit:digits) {
        sum+=Math.pow(digit, power);
        }
        return sum==number;
    }
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for(int digit:digits) {
        if(digit>largest) {
            secondLargest=largest;
            largest=digit;
        }
        else if(digit>secondLargest && digit!=largest){
            secondLargest = digit;
        }
    }
    return new int[]{largest,secondLargest};
    }
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;
        for(int digit:digits){
            if(digit<smallest){
                secondSmallest=smallest;
                smallest=digit;
            }
            else if(digit<secondSmallest && digit!=smallest){
                secondSmallest = digit;
            }
        }
        return new int[]{smallest,secondSmallest};
    }
    public static void main(String[] args){
        int number=153;
        int count=countDigits(number);
        int[] digits=getDigitsArray(number);
        boolean isDuck=isDuckNumber(digits);
        boolean isArmstrong=isArmstrongNumber(number);
        int[] largestAndSecondLargest=findLargestAndSecondLargest(digits);
        int[] smallestAndSecondSmallest=findSmallestAndSecondSmallest(digits);
        System.out.println("Number: "+number);
        System.out.println("Count of digits: "+count);
        System.out.println("Digits array: "+java.util.Arrays.toString(digits));
        System.out.println("Is Duck Number: "+isDuck);
        System.out.println("Is Armstrong Number: "+isArmstrong);
        System.out.println("Largest: "+largestAndSecondLargest[0]+", Second Largest: "+largestAndSecondLargest[1]);
        System.out.println("Smallest: "+smallestAndSecondSmallest[0]+", Second Smallest: "+smallestAndSecondSmallest[1]);
    }
}
