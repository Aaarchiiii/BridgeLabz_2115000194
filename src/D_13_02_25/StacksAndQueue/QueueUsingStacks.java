package D_13_02_25.StacksAndQueue;
import java.util.*;
public class QueueUsingStacks {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public QueueUsingStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public void enqueue(int data){
        s1.push(data);
    }
    public int dequeue(){
        if(s2.isEmpty()){
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
            }
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public static void main(String[] args){
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
