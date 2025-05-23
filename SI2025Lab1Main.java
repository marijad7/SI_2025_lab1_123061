import java.util.*;

enum Priority {
    LOW, MEDIUM, HIGH
}

class Task {
    private String name;
    private boolean isCompleted;
    private Priority priority;
    private String category;

    public Task(String name, Priority priority, String category) {
        this.name = name;
        this.priority = priority;
        this.category = category;
        this.isCompleted = false;
    }

    public void complete() {
        this.isCompleted = true;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " [" + category + "] - Priority: " + priority + (isCompleted ? " [Completed]" : " [Pending]");
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String name, Priority priority, String category) {
        tasks.add(new Task(name, priority, category));
    }

    public void printTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // MISSING FEATURES:

    // 1. Remove a task by name
    public void removeTask(String name) {
        // TODO: Implement removal logic
    }

    // 2. Find all completed tasks
    public List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    // 3. List tasks sorted by name
    public void sortTasksByName() {
        // TODO: Implement sorting logic
    }

    // 4. Sort tasks by priority
    public void sortTasksByPriority() {
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                // HIGH has highest priority (0), MEDIUM (1), LOW (2)
                return t1.getPriority().ordinal() - t2.getPriority().ordinal();
            }
        });
    }

    // 5. Filter tasks by category
    public List<Task> filterByCategory(String category) {
        // TODO: Implement filtering logic
        return new ArrayList<>();
    }

    // 6. Find the highest-priority unfinished task
    public List<Task> getMostUrgentTasks() {
        List<Task> urgentTasks = new ArrayList<>();
        Priority highestPriority = Priority.LOW; // Start with lowest priority
        
        // First, find the highest priority among unfinished tasks
        for (Task task : tasks) {
            if (!task.isCompleted() && task.getPriority().ordinal() < highestPriority.ordinal()) {
                highestPriority = task.getPriority();
            }
        }
        
        // Then, collect all unfinished tasks with that priority
        for (Task task : tasks) {
            if (!task.isCompleted() && task.getPriority() == highestPriority) {
                urgentTasks.add(task);
            }
        }
        
        return urgentTasks;
    }

    // 7. Count tasks per category
    public Map<String, Integer> countTasksPerCategory() {
        // TODO: Implement counting logic
        return new HashMap<>();
    }

    // 8. Mark a task as completed by name
    public void markTaskCompleted(String name) {
        // TODO: Implement marking task as completed
    }

    // 9. Mark all tasks in a category as completed
    public void markCategoryCompleted(String category) {
        // TODO: Implement marking all tasks in category as completed
    }
}

public class SI2025Lab1Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        
        // Add some sample tasks
        manager.addTask("Complete lab assignment", Priority.HIGH, "School");
        manager.addTask("Buy groceries", Priority.MEDIUM, "Shopping");
        manager.addTask("Call mom", Priority.LOW, "Personal");
        
        // Print all tasks before sorting
        System.out.println("All tasks before sorting:");
        manager.printTasks();
        
        // Sort tasks by priority
        manager.sortTasksByPriority();
        
        // Print tasks after sorting
        System.out.println("\nTasks sorted by priority:");
        manager.printTasks();
        
        // Find and print most urgent tasks
        System.out.println("\nMost urgent tasks:");
        List<Task> urgentTasks = manager.getMostUrgentTasks();
        for (Task task : urgentTasks) {
            System.out.println(task);
        }
        
        // Mark some tasks as completed
        manager.markTaskCompleted("Buy groceries");
        
        // Print completed tasks
        System.out.println("\nCompleted tasks:");
        List<Task> completedTasks = manager.getCompletedTasks();
        for (Task task : completedTasks) {
            System.out.println(task);
        }
    }
} 