import java.io.*;
import java.util.*;

public class Main {
	
	private static final String TASKS_FILE = "C:/Users/ahmet/eclipse-workspace/test272/src/Tasks.txt";
    private static final String WISHES_FILE = "C:/Users/ahmet/eclipse-workspace/test272/src/Wishes.txt";
    private static final String COMMANDS_FILE = "C:/Users/ahmet/eclipse-workspace/test272/src/Commands.txt";
	
    private static List<Task> tasks = new ArrayList<>();
    private static List<Wish> wishes = new ArrayList<>();
    private static int totalPoints = 0;
    private static int level = 1;

    public static void main(String[] args) {
        loadTasksFromFile();
        loadWishesFromFile();
        processCommands();
    }

    private static void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TASKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                tasks.add(new Task(
                    parts[0].trim(),  // id
                    parts[1].trim(),  // title
                    parts[2].trim(),  // description
                    parts[3].trim(),  // deadline (artık String olarak)
                    Integer.parseInt(parts[4].trim())  // points
                ));
            }
        } catch (IOException e) {
            System.out.println("Görevler dosyası okunamadı: " + e.getMessage());
        }
    }

    private static void loadWishesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(WISHES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                wishes.add(new Wish(
                    parts[0].trim(),  // id
                    parts[1].trim(),  // title
                    parts[2].trim(),  // description
                    parts.length > 3 ? parts[3].trim() : null  // datetime (optional)
                ));
            }
        } catch (IOException e) {
            System.out.println("Dilekler dosyası okunamadı: " + e.getMessage());
        }
    }

    private static void processCommands() {
        try (BufferedReader reader = new BufferedReader(new FileReader(COMMANDS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                executeCommand(line);
            }
        } catch (IOException e) {
            System.out.println("Komut dosyası okunamadı: " + e.getMessage());
        }
    }

    private static void executeCommand(String command) {
        String[] parts = command.split(" ");
        switch (parts[0]) {
            case "ADD_TASK1":
                addTask(parts);
                break;
            case "LIST_ALL_TASKS":
                listTasks(parts.length > 1 ? parts[1] : null);
                break;
            case "TASK_DONE":
                markTaskDone(parts[1]);
                break;
            case "TASK_CHECKED":
                checkTask(parts[1], Integer.parseInt(parts[2]));
                break;
            case "PRINT_BUDGET":
                System.out.println("Toplam Puan: " + totalPoints);
                break;
            case "PRINT_STATUS":
                System.out.println("Seviye: " + level);
                break;
            default:
                System.out.println("Geçersiz komut: " + command);
        }
    }

    private static void addTask(String[] parts) {
        // ADD_TASK1 komut işleme mantığı
        // Bu metodu ihtiyaca göre implement edin
    }

    private static void listTasks(String filter) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void markTaskDone(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                System.out.println(taskId + " numaralı görev tamamlandı olarak işaretlendi.");
                return;
            }
        }
        System.out.println(taskId + " numaralı görev bulunamadı.");
    }

    private static void checkTask(String taskId, int rating) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId) && task.isCompleted()) {
                task.setApproved(true);
                task.setRating(rating);
                totalPoints += task.getPoints();
                updateLevel();
                System.out.println(taskId + " numaralı görev onaylandı ve " + 
                    task.getPoints() + " puan eklendi.");
                return;
            }
        }
        System.out.println(taskId + " numaralı görev bulunamadı veya tamamlanmamış.");
    }

    private static void updateLevel() {
        if (totalPoints < 40) level = 1;
        else if (totalPoints < 60) level = 2;
        else if (totalPoints < 80) level = 3;
        else level = 4;
    }
}
