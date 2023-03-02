import java.util.Date;

public class Reminder extends Tasks {
    Date date = new Date();

    private String dateReminder;
    private String timeCreatReminder;

    /**
     *
     * @param nameTask Название напоминания
     * @param priority Приоритет напоминания
     * @param dateReminder Дата напоминания
     * @param creator Кто создаёт запись
     */
    public Reminder(String nameTask, String priority, String dateReminder, String creator) {
        super(nameTask, priority, creator);
        this.dateReminder = dateReminder;
        this.timeCreatReminder = String.valueOf(date);
    }

    @Override
    public String toString() {
        return "Напоминание:" + "\n" +
                "1. Название - " + super.nameTask + "\n" +
                "2. Приоритет - " + super.priority + "\n" +
                "3. Дата напоминаия - " + dateReminder + "\n" +
                "4. Создатель - " + super.creator + "\n" +
                "5. ID напоминания - " + super.id + "\n" +
                "6. Дата создания напоминания - " + timeCreatReminder + "\n";
    }
}
