import java.util.Scanner;

public class ToDoList {
    static String[] tasks = new String[10]; // Array of 10 tasks
    static int size = 0; // Number of tasks currently in the list
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- TO-DO LIST MENU ---");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1: addTask(); break;
                case 2: updateTask(); break;
                case 3: deleteTask(); break;
                case 4: viewTasks(); break;
                case 5: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    // Insert into array
    static void addTask() {
        if (size == tasks.length) {
            System.out.println("Task list is full!");
            return;
        }
        System.out.print("Enter task: ");
        String task = sc.nextLine();
        tasks[size] = task;
        size++;
        System.out.println("Task added!");
    }

    // Update array element
    static void updateTask() {
        if (size == 0) {
            System.out.println("No tasks to update!");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to update: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= size) {
            System.out.println("Invalid task number!");
            return;
        }

        System.out.print("Enter new task text: ");
        tasks[index] = sc.nextLine();
        System.out.println("Task updated!");
    }

    // Delete + shift array elements
    static void deleteTask() {
        if (size == 0) {
            System.out.println("No tasks to delete!");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index < 0 || index >= size) {
            System.out.println("Invalid task number!");
            return;
        }

        // Shift all elements to the left
        for (int i = index; i < size - 1; i++) {
            tasks[i] = tasks[i + 1];
        }

        tasks[size - 1] = null; // Clear last
        size--;
        System.out.println("Task deleted!");
    }

    // Traverse array
    static void viewTasks() {
        if (size == 0) {
            System.out.println("No tasks added yet!");
            return;
        }
        System.out.println("\n--- Your To-Do List ---");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }
}
