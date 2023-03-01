public class Tasks {

    private final int id;
    private int count;
    private int duration;
    private int deadLine;
    private String nameTask;
    private String priority;

    public Tasks(int id, int duration, int deadLine, String nameTask, String priority) {
        count++;
        this.id = getCount();
        this.duration = duration;
        this.deadLine = deadLine;
        this.nameTask = nameTask;
        this.priority = priority;
    }

    public int getCount() {
        return count;
    }
}
