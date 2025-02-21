package D_20_02_25;

import java.io.*;
public class PipedStream {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis;
        try {
            pis = new PipedInputStream(pos);
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));
            writerThread.start();
            readerThread.start();
            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Writer implements Runnable {
    private PipedOutputStream pos;
    public Writer(PipedOutputStream pos) {
        this.pos = pos;
    }
    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes());
            pos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Reader implements Runnable {
    private PipedInputStream pis;
    public Reader(PipedInputStream pis) {
        this.pis = pis;
    }
    @Override
    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            pis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
