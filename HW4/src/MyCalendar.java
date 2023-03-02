import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCalendar{
    private static List<String> tasks = new ArrayList<>();

    public static void addTasks(Tasks someTasks) {
        tasks.add(someTasks.toString());
    }

    public static void fileWriter(){
        try (FileWriter writer = new FileWriter("MyCalendarTasks.txt",false)){
            for (int i = 0; i < tasks.size(); i++) {
                writer.write(tasks.get(i)+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
