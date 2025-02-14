package D_14_02_25;
import java.util.*;
public class InsertionSort {
    public static void Sort(int[] id){
        int n = id.length;
        for(int i=1; i<n; i++){
            int key = id[i];
            int j = i-1;
            while(j>=0 && id[j]>key){
                id[j+1] = id[j];
                j--;
            }
            id[j+1] = key;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of employees");
        int n = sc.nextInt();
        int[] id = new int[n];
        System.out.println("Enter id's of employees");
        for(int i=0; i<n; i++){
            id[i] = sc.nextInt();
        }
        System.out.println("Before Sorting");
        for(int i=0; i<n; i++){
            System.out.print(id[i]+" ");
        }
        System.out.println();
        Sort(id);
        System.out.println("After Sorting");
        for(int i=0; i<n; i++){
            System.out.print(id[i]+" ");
        }
    }
}
