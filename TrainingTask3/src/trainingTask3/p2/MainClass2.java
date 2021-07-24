package trainingTask3.p2;

public class MainClass2{
    public static void main(String[] args){
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();

        p1.setFirst_name("Иван");
        p1.setLast_name("Иванов");
        p1.setTrird_name("Иванович");

        p2.setLast_name("Иванов");
        p2.setTrird_name("Алексеевич");

        p3.setFirst_name("Петр");
        p3.setLast_name("Иванов");

        p4.setLast_name("Иванов");

        System.out.println(p1.getFIO());
        System.out.println(p2.getFIO());
        System.out.println(p3.getFIO());
        System.out.println(p4.getFIO());
    }
}

class Person{
    private String first_name;
    private String last_name;
    private String third_name;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTrird_name() {
        return third_name;
    }

    public void setTrird_name(String third_name) {
        this.third_name = third_name;
    }

    String getFIO(){
        String fio = last_name;
        if (first_name == null && third_name == null) return fio;
        else fio += " ";
        if (first_name != null) fio += last_name.charAt(0)+".";
        if (third_name != null) fio += third_name.charAt(0)+".";
        return fio;
    }

}

