package PhoneBook.Guide;

public class Contact {

    private String firstName;
    private String lastName;
    private int phoneNumber;



    public Contact(String firstName, String lastName, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String[] string) {
        this.firstName = string[0];
        this.lastName = string[1];
        this.phoneNumber = Integer.parseInt(string[2]);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "\nКонтакт:\n" +
                "1. Имя = " + firstName + "\n" +
                "2. Фамилия = " + lastName + "\n" +
                "3. Номер телефона = " + phoneNumber + "\n";
    }
}
