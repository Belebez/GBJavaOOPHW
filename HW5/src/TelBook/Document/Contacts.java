package TelBook.Document;

public class Contacts {

    StringBuilder sb;
    public Contacts() {
        sb = new StringBuilder();
    }

    public Contacts(String data) {
        this();
        addAllText(data);
    }

    public void addAllText(String text) {
        sb.append(text);
    }

    public String getData() {
        return sb.toString();
    }
}
