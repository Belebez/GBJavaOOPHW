import java.util.Date;

public class Event extends Tasks {
    Date date = new Date();

    private int durationEvent;
    private String dateStartEvent;
    private String timeCreatEvent;

    /**
     *
     * @param nameTask Название мероприятия
     * @param priority Приоритет мероприятия
     * @param dateStartEvent Дата начала мероприятия
     * @param durationEvent Продолжительность мероприятия
     * @param creator Кто создаёт запись
     */
    public Event(String nameTask, String priority, String dateStartEvent, int durationEvent, String creator) {
        super(nameTask, priority, creator);
        this.dateStartEvent = dateStartEvent;
        this.durationEvent = durationEvent;
        this.timeCreatEvent = String.valueOf(date);
    }

    @Override
    public String toString() {
        return "Мероприятие:" + "\n" +
                "1. Название - " + super.nameTask + "\n" +
                "2. Приоритет - " + super.priority + "\n" +
                "3. Начало мероприятия - " + dateStartEvent + "\n" +
                "4. Длительность мероприятия - " + durationEvent + " д." + "\n" +
                "5. Создатель - " + super.creator + "\n" +
                "6. ID мероприятия - " + super.id + "\n" +
                "7. Дата создания мероприятия - " + timeCreatEvent + "\n";
    }

}
