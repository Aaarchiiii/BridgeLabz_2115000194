package D_22_01_25.Level1;

public class Distribution {
    public static void main(String[] args){
        int pens = 14;
        int students = 3;
        int getPens = pens/students;
        int remainingPens = pens%students;
        System.out.println("The Pen Per Student is "+getPens+" and the remaining pen not distributed is "+remainingPens);
    }
}
