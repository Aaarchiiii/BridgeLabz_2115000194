package D_28_01_25.Level3;

import java.util.*;
public class EmployeeBonus {
    public static int[][] generateSalariesAndService(){
        int[][] data=new int[10][2];
        Random random=new Random();
        for(int i=0;i<10;i++){
            data[i][0]=random.nextInt(40001)+10000;
            data[i][1]=random.nextInt(11);
        }
        return data;
    }
    public static double[][] calculateBonusAndNewSalary(int[][] data){
        double[][] result=new double[10][3];
        for(int i=0;i<10;i++){
            int salary=data[i][0];
            int years=data[i][1];
            double bonus=(years>5)?0.05*salary:0.02*salary;
            result[i][0]=salary;
            result[i][1]=bonus;
            result[i][2]=salary+bonus;
        }
        return result;
    }
    public static void displaySummary(double[][] data){
        double totalOldSalary=0,totalNewSalary=0,totalBonus=0;
        System.out.printf("%-10s%-10s%-10s%-10s\n","OldSalary","Bonus","NewSalary","Years");
        for(int i=0;i<10;i++){
            totalOldSalary+=data[i][0];
            totalBonus+=data[i][1];
            totalNewSalary+=data[i][2];
            System.out.printf("%-10.2f%-10.2f%-10.2f%-10d\n",data[i][0],data[i][1],data[i][2],(int)data[i][0]);
        }
        System.out.println("Total Old Salary:"+totalOldSalary);
        System.out.println("Total Bonus:"+totalBonus);
        System.out.println("Total New Salary:"+totalNewSalary);
    }
    public static void main(String[] args){
        int[][] salariesAndService=generateSalariesAndService();
        double[][] bonusAndNewSalary=calculateBonusAndNewSalary(salariesAndService);
        displaySummary(bonusAndNewSalary);
    }
}
