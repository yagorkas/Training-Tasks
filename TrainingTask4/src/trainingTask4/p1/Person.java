package trainingTask4.p1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private String firstName;
    private String lastName;
    private String secondName;
    private Calendar birthDate;

    public Person(String firstName, String lastName, String secondName, int year, int month, int day) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.setBirthDate(year, month, day);
    }

    public Person(String firstName, String lastName, String secondName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Calendar getBirthdate() {
        return birthDate;
    }

    public void setBirthDate(int year, int month, int day) {
        Calendar date = new GregorianCalendar(year,month,day);
        this.birthDate = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    enum Format {
        shortDate,
        mediumDate,
        longDate
    }

    /**
     * Возвращает строку с датой в заданном формате
     * @param format формат даты.
     * @return Строковое представление даты в заданном формате.
     */
    public String getDifferentFormatDate(Format format) {
        String result;
        switch (format){
            case longDate:
                result = new SimpleDateFormat("dd MMMM y года, EEEE").format(birthDate.getTime());
                break;
            case mediumDate:
                result = new SimpleDateFormat("dd MMM y").format(birthDate.getTime());
                break;
            default:
                result = new SimpleDateFormat("dd.MM.yy").format(birthDate.getTime());
                break;
        }
        return result;
    }

    @Override
    public String toString() {
        return lastName+" "+firstName+" "+secondName+ ", "+getDifferentFormatDate(Format.shortDate);
    }

    public static void main(String[] args){
        Person p1 = new Person("Иванов","Иван","Иванович",2000,1,29);
        System.out.println(p1.getDifferentFormatDate(Format.shortDate));
        System.out.println(p1.getDifferentFormatDate(Format.mediumDate));
        System.out.println(p1.getDifferentFormatDate(Format.longDate));
    }
}
