package D_14_02_25;
import java.util.*;
public class BubbleSort {
    public static void Sort(int[] marks){
        int n = marks.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(marks[j]>marks[j+1]){
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of student");
        int n = sc.nextInt();
        int[] marks = new int[n];
        System.out.println("Enter marks of students");
        for(int i=0; i<n; i++){
            marks[i] = sc.nextInt();
        }
        System.out.println("Before Sorting:");
        for(int i=0; i<n; i++){
            System.out.println(marks[i]+" ");
        }
        Sort(marks);
        System.out.println("After Sorting:");
        for(int i=0; i<n; i++){
            System.out.println(marks[i]+" ");
        }
    }
}
