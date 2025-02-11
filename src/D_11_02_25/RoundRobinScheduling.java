package D_11_02_25;

import java.util.*;
class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;
    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;
    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }
    public void addProcess(int processId, int burstTime, int priority) {
        Process process = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = process;
            tail.next = head;
        } else {
            tail.next = process;
            tail = process;
            tail.next = head;
        }
    }
    public void removeProcess(int processId) {
        if (head == null) return;
        Process current = head, prev = tail;
        do {
            if (current.processId == processId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    if (current == head) {
                        head = head.next;
                        tail.next = head;
                    } else if (current == tail) {
                        tail = prev;
                        tail.next = head;
                    } else {
                        prev.next = current.next;
                    }
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }
    public void executeRoundRobin() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        int totalTime = 0;
        int processCount = 0;
        Queue<Integer> waitingTimes = new LinkedList<>();
        Queue<Integer> turnaroundTimes = new LinkedList<>();
        Process current = head;
        while (true) {
            boolean allCompleted = true;
            Process start = current;
            do {
                if (current.remainingTime > 0) {
                    allCompleted = false;
                    int executionTime = Math.min(current.remainingTime, timeQuantum);
                    current.remainingTime -= executionTime;
                    totalTime += executionTime;
                    System.out.println("Executing Process ID: " + current.processId +
                            " Remaining Time: " + current.remainingTime);
                    if (current.remainingTime == 0) {
                        int turnaroundTime = totalTime;
                        int waitingTime = turnaroundTime - current.burstTime;
                        waitingTimes.add(waitingTime);
                        turnaroundTimes.add(turnaroundTime);
                        processCount++;
                        removeProcess(current.processId);
                    }
                }
                current = current.next;
            } while (current != start);

            if (allCompleted) break;
        }
        calculateAverageTimes(waitingTimes, turnaroundTimes, processCount);
    }
    private void calculateAverageTimes(Queue<Integer> waitingTimes, Queue<Integer> turnaroundTimes, int processCount) {
        int totalWaitingTime = 0, totalTurnaroundTime = 0;
        while (!waitingTimes.isEmpty()) {
            totalWaitingTime += waitingTimes.poll();
            totalTurnaroundTime += turnaroundTimes.poll();
        }
        double avgWaitingTime = (double) totalWaitingTime / processCount;
        double avgTurnaroundTime = (double) totalTurnaroundTime / processCount;
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        System.out.println("\nCurrent Process Queue:");
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId +
                    " Burst Time: " + temp.burstTime +
                    " Remaining Time: " + temp.remainingTime +
                    " Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}
public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 6, 3);
        scheduler.displayProcesses();
        scheduler.executeRoundRobin();
    }
}
