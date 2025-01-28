package D_28_01_25.Level3;

public class NumberChecker3{
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
    public static int[] reverseArray(int[] digits){
        int[] reversed=new int[digits.length];
        for(int i=0;i<digits.length;i++){
            reversed[i]=digits[digits.length-1-i];
        }
        return reversed;
    }
    public static boolean arraysAreEqual(int[] arr1,int[] arr2){
        if(arr1.length!=arr2.length)return false;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i])return false;
        }
        return true;
    }
    public static boolean isPalindrome(int number){
        int[] digits=getDigitsArray(number);
        int[] reversed=reverseArray(digits);
        return arraysAreEqual(digits,reversed);
    }
    public static boolean isDuckNumber(int[] digits){
        for(int i=1;i<digits.length;i++){
            if(digits[i]==0)return true;
        }
        return false;
    }
    public static void main(String[] args){
        int number=12321;
        int count=countDigits(number);
        int[] digits=getDigitsArray(number);
        int[] reversed=reverseArray(digits);
        boolean isPalindromeNumber=isPalindrome(number);
        boolean isDuck=isDuckNumber(digits);
        System.out.println("Number:"+number);
        System.out.println("Count of digits:"+count);
        System.out.println("Digits array:"+java.util.Arrays.toString(digits));
        System.out.println("Reversed array:"+java.util.Arrays.toString(reversed));
        System.out.println("Is Palindrome:"+isPalindromeNumber);
        System.out.println("Is Duck Number:"+isDuck);
    }
}
