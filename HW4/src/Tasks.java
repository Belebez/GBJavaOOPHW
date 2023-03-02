public class Tasks {

    protected final int id;
    private static int count;
    protected String nameTask;
    protected String priority;
    protected String creator;

    public Tasks(String nameTask, String priority, String creator) {
        count++;
        this.id = getCount();
        this.nameTask = nameTask;
        this.priority = priority;
        this.creator = creator;
    }

    public int getCount() {
        return count;
    }
}
