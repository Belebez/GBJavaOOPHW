import java.util.ArrayList;
import java.util.List;

public class Calendar<T extends Tasks> {
    private List<T> tasks = new ArrayList<>();

    public Calendar(List<T> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<T> getTasksList() {
        return (ArrayList<T>) tasks;
    }

    public void addTasks(T someTasks) {
        tasks.add(someTasks);
    }

    public void removeTasks(T someTasks) {
        tasks.remove(someTasks);
    }



}
