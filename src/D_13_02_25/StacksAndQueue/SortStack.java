package D_13_02_25.StacksAndQueue;
import java.util.*;
public class SortStack {
    public static void sorting(Stack<Integer> s1){
        if(!s1.isEmpty()){
            int top = s1.pop();
            sorting(s1);
            insertion(s1, top);
        }
    }
    public static void insertion(Stack<Integer> s1, int data){
        if(s1.isEmpty() || s1.peek()<=data){
            s1.push(data);
        }
        else{
            int top = s1.pop();
            insertion(s1, data);
            s1.push(top);
        }
    }
    public static void main(String[] args){
        Stack<Integer> s1 = new Stack<>();
        s1.push(5);
        s1.push(2);
        s1.push(30);
        s1.push(14);
        s1.push(16);
        System.out.println("Stack: "+s1);
        sorting(s1);
        System.out.println("Stack after sorting: "+s1);
    }
}
