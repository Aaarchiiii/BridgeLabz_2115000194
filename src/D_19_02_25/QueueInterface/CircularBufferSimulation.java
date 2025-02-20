package D_19_02_25.QueueInterface;
import java.util.*;
public class CircularBufferSimulation{
    private int[] buffer;
    private int head, tail, size, capacity;
    public CircularBufferSimulation(int capacity){
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }
    public void insert(int value){
        buffer[tail] = value;
        tail = (tail+1)%capacity;
        if(size<capacity){
            size++;
        }
        else{
            head = (head+1) % capacity;
        }
    }
    public int[] getContents(){
        int[] result = new int[size];
        for(int i=0; i<size; i++){
            result[i] = buffer[(head+i)%capacity];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBufferSimulation b = new CircularBufferSimulation(3);
        b.insert(1);
        b.insert(2);
        b.insert(3);
        System.out.println("Buffer: "+Arrays.toString(b.getContents()));
        b.insert(4);
        System.out.println("Buffer: "+Arrays.toString(b.getContents()));
        b.insert(5);
        System.out.println("Buffer: "+Arrays.toString(b.getContents()));
    }
}