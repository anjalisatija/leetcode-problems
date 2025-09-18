import java.util.*;
class TaskManager {
    // Use a Task class for custom sorting of priority and taskId later in the PriorityQueue
    class Task {
        int userId;
        int priority;
        int taskId;
        public Task(int userId, int taskId, int priority){
            this.userId = userId;
            this.priority = priority;
            this.taskId = taskId;
        } 
        // Debugging method to print current Task info
        public String toString(){
            return "userId:" + this.userId + " - priority:" + this.priority + " - taskId:"+ this.taskId;
        } 
    }   
    // Custom comparator to compare each task's priority first, then taskId
    class ComparePriority implements Comparator<Task> {
        public int compare(Task a, Task b) {
            if(b.priority==a.priority){
                return b.taskId - a.taskId;
            }
            return b.priority - a.priority;
        }
    }   
    // Use a PriorityQueue to store tasks as a maxHeap and have highet priority task as the head
    PriorityQueue<Task> pq;
    // Use a HashMap to store a task's validity(existed or not)
    HashMap<Integer,Task> map;

    public TaskManager(List<List<Integer>> tasks) {
        this.pq = new PriorityQueue<>(new ComparePriority());
        this.map = new HashMap<>();
        // Initialize the system
        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }
    // Add new task into pq and map
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId,taskId,priority);
        this.pq.add(task);
        this.map.put(taskId,task);
    }
    // Add edited task as a new task into pq
    // Look up the taskId in the map and update the edited task
    // Old task will no longer have the validaty in the map
    public void edit(int taskId, int newPriority) {
        Task oldTask = this.map.get(taskId);
        Task newTask = new Task(oldTask.userId,oldTask.taskId,newPriority);
        this.pq.add(newTask);
        this.map.put(taskId,newTask);
    }
    // Retain the task in pq if it is not the head, else remove it from pq
    // Then remove its validity in the map
    public void rmv(int taskId) {
        Task task = map.get(taskId);
        if(task==pq.peek()){
            pq.poll();
        }
        this.map.remove(taskId);
    }
    public int execTop() {
        // Print current pq
        System.out.println(pq);
        // Loop the queue until the end or when the highest priority task is found
        while(this.pq.size()>0){
            // Continuously remove the top element from pq
            Task highest = this.pq.poll();
            // Take the highest priority task's id
            int highestTaskId = highest.taskId;
            // Check the task's validity and if that task in the map has the same priority as the task found in the head of pq 
            if(this.map.containsKey(highestTaskId) && this.map.get(highestTaskId).priority== highest.priority){
                // Delete the task's validity
                this.map.remove(highestTaskId);
                // Return the userId of that task
                return highest.userId;
            }
        }
        // If no task is found, then return -1
        return -1;
    }
    public static void main (String[] args){
        List<Integer> task1 = new ArrayList<>();
        task1.add(1);
        task1.add(101);
        task1.add(8);
        List<Integer> task2 = new ArrayList<>();
        task2.add(2);
        task2.add(102);
        task2.add(20);
        List<Integer> task3 = new ArrayList<>();
        task3.add(3);
        task3.add(103);
        task3.add(5);
        List<List<Integer>> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        TaskManager obj = new TaskManager(tasks);
        System.out.println("null");
        obj.add(4,104,5);
        System.out.println("null");
        obj.edit(102,9);
        System.out.println("null");
        int exec1 = obj.execTop();
        System.out.println(exec1);
        obj.rmv(101);
        System.out.println("null");
        obj.add(50,101,8);
        System.out.println("null");
        int exec2 = obj.execTop();
        System.out.println(exec2);
        System.out.println(" ");
    }
}