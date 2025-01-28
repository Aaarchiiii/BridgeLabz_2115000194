package D_28_01_25.Level3;

public class NumberChecker5{
    public static int[] findFactors(int number){
        int count=0;
        for(int i=1;i<=number;i++){
            if(number%i==0)count++;
        }
        int[] factors=new int[count];
        int index=0;
        for(int i=1;i<=number;i++){
            if(number%i==0)factors[index++]=i;
        }
        return factors;
    }
    public static int findGreatestFactor(int[] factors){
        int greatest=factors[0];
        for(int factor:factors){
            if(factor>greatest)greatest=factor;
        }
        return greatest;
    }
    public static int findSumOfFactors(int[] factors){
        int sum=0;
        for(int factor:factors){
            sum+=factor;
        }
        return sum;
    }
    public static int findProductOfFactors(int[] factors){
        int product=1;
        for(int factor:factors){
            product*=factor;
        }
        return product;
    }
    public static int findProductOfCubeOfFactors(int[] factors){
        int product=1;
        for(int factor:factors){
            product*=Math.pow(factor,3);
        }
        return product;
    }
    public static boolean isPerfectNumber(int number){
        int[] factors=findFactors(number);
        int sum=findSumOfFactors(factors)-number;
            return sum==number;
    }
    public static boolean isAbundantNumber(int number){
        int[] factors=findFactors(number);
        int sum=findSumOfFactors(factors)-number;
        return sum>number;
    }
    public static boolean isDeficientNumber(int number){
        int[] factors=findFactors(number);
        int sum=findSumOfFactors(factors)-number;
        return sum<number;
    }
    public static boolean isStrongNumber(int number){
        int sum=0,temp=number;
        while(temp!=0){
            sum+=factorial(temp%10);
            temp/=10;
        }
        return sum==number;
    }
    public static int factorial(int num){
        int fact=1;
        for(int i=1;i<=num;i++){
            fact*=i;
        }
        return fact;
    }
    public static void main(String[] args){
        int number=28;
        int[] factors=findFactors(number);
        int greatestFactor=findGreatestFactor(factors);
        int sumOfFactors=findSumOfFactors(factors);
        int productOfFactors=findProductOfFactors(factors);
        int productOfCubeOfFactors=findProductOfCubeOfFactors(factors);
        boolean isPerfect=isPerfectNumber(number);
        boolean isAbundant=isAbundantNumber(number);
        boolean isDeficient=isDeficientNumber(number);
        boolean isStrong=isStrongNumber(number);
        System.out.println("Number:"+number);
        System.out.println("Factors:"+java.util.Arrays.toString(factors));
        System.out.println("Greatest Factor:"+greatestFactor);
        System.out.println("Sum of Factors:"+sumOfFactors);
        System.out.println("Product of Factors:"+productOfFactors);
        System.out.println("Product of Cube of Factors:"+productOfCubeOfFactors);
        System.out.println("Is Perfect Number:"+isPerfect);
        System.out.println("Is Abundant Number:"+isAbundant);
        System.out.println("Is Deficient Number:"+isDeficient);
        System.out.println("Is Strong Number:"+isStrong);
    }
}
