package D_11_02_25;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
class TaskSchedule {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null;
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task t = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = t;
            t.next = head;
        } else {
            t.next = head;
            head = t;
            tail.next = head;
        }
    }
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task t = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = t;
            t.next = head;
        } else {
            tail.next = t;
            tail = t;
            tail.next = head;
        }
    }
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task t = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        for (int i = 0; i < position - 1; i++) {
            if (temp.next == head) {
                System.out.println("Position out of range");
                return;
            }
            temp = temp.next;
        }
        t.next = temp.next;
        temp.next = t;
        if (temp == tail) {
            tail = t;
        }
    }
    public void removeTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }
        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Task not found.");
    }
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        if (currentTask == null) {
            currentTask = head;
        }
        System.out.println("Current Task: " + currentTask.taskId + " - " + currentTask.taskName +
                " (Priority: " + currentTask.priority + ", Due: " + currentTask.dueDate + ")");
    }
    public void moveToNextTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        if (currentTask == null) {
            currentTask = head;
        } else {
            currentTask = currentTask.next;
        }
        viewCurrentTask();
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }
}
public class TaskScheduler {
    public static void main(String[] args) {
        TaskSchedule schedule = new TaskSchedule();
        schedule.addTaskAtEnd(1, "Complete Report", 2, "2025-02-15");
        schedule.addTaskAtEnd(2, "Prepare Presentation", 1, "2025-02-18");
        schedule.addTaskAtBeginning(3, "Schedule Meeting", 3, "2025-02-14");
        schedule.addTaskAtPosition(4, "Submit Proposal", 2, "2025-02-16", 2);
        System.out.println("All Tasks:");
        schedule.displayAllTasks();
        System.out.println("Viewing Current Task:");
        schedule.viewCurrentTask();
        System.out.println("Moving to Next Task:");
        schedule.moveToNextTask();
        System.out.println("Searching for Tasks with Priority 2:");
        schedule.searchTaskByPriority(2);
        System.out.println("Removing Task ID 3:");
        schedule.removeTask(3);
        schedule.displayAllTasks();
    }
}
