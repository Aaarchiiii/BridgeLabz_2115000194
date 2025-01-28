package D_28_01_25.Level3;

public class NumberChecker2{
    public static int countDigits(int number){
        int count=0;
        while(number!=0){
            count++;
            number/=10;
        }
        return count;
    }
    public static int[] getDigitsArray(int number){
        int count=countDigits(number);
        int[] digits=new int[count];
        for(int i=count-1;i>=0;i--){
            digits[i]=number%10;
            number/=10;
        }
        return digits;
    }
    public static int sumOfDigits(int[] digits){
        int sum=0;
        for(int digit:digits){
            sum+=digit;
        }
        return sum;
    }
    public static int sumOfSquaresOfDigits(int[] digits){
        int sum=0;
        for(int digit:digits){
            sum+=Math.pow(digit,2);
        }
        return sum;
    }
    public static boolean isHarshadNumber(int number){
        int[] digits=getDigitsArray(number);
        int sum=sumOfDigits(digits);
        return number%sum==0;
    }
    public static int[][] digitFrequency(int number){
        int[] digits=getDigitsArray(number);
        int[][] frequency=new int[10][2];
        for(int i=0;i<10;i++){
            frequency[i][0]=i;
            frequency[i][1]=0;
        }
        for(int digit:digits){
            frequency[digit][1]++;
        }
        return frequency;
    }
    public static void main(String[] args){
        int number=1729;
        int count=countDigits(number);
        int[] digits=getDigitsArray(number);
        int sum=sumOfDigits(digits);
        int sumSquares=sumOfSquaresOfDigits(digits);
        boolean isHarshad=isHarshadNumber(number);
        int[][] freq=digitFrequency(number);
        System.out.println("Number:"+number);
        System.out.println("Count of digits:"+count);
        System.out.println("Digits array:"+java.util.Arrays.toString(digits));
        System.out.println("Sum of digits:"+sum);
        System.out.println("Sum of squares of digits:"+sumSquares);
        System.out.println("Is Harshad Number:"+isHarshad);
        System.out.print("Digit Frequencies:");
        for(int[] pair:freq){
            if(pair[1]>0){
                System.out.print("("+pair[0]+":"+pair[1]+") ");
            }
        }
    }
}
