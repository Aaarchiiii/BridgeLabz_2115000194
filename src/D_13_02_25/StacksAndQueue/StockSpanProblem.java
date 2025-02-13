package D_13_02_25.StacksAndQueue;
import java.util.*;
public class StockSpanProblem {
    public static int[] Span(int[] prices){
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && prices[s.peek()]<=prices[i]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                span[i] = i-s.peek();
            }
            s.push(i);
        }
        return span;
    }
    public static void main(String[] args){
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = Span(prices);
        System.out.println("Span: ");
        for(int s1:span){
            System.out.println(s1+" ");
        }
    }
}
