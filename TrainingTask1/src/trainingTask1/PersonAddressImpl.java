package trainingTask1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

public class PersonAddressImpl {
    //поиск позиции человека в массиве по по фамилии (первое вхождение) (если нет, то вернет null)
    public static int searchSurname(Person[] persons, String surname){
        int man = -1;
        for (int i = 0; i<persons.length; i++){
            if (persons[i].getSurname().equals(surname)) {
                man = i;
                break;
            }
        }
        return man;
    }

    //поиск позиции человека в массиве по фамилии (вхождение под номером 'pos') (если нет, то вернет -1)
    public static int searchSurname(Person[] persons, String surname, int pos){
        int man = -1;
        int cnt = 0;
        for (int i = 0; i<persons.length; i++){
            if (persons[i].getSurname().equals(surname)) {
                cnt++;
                if (cnt == pos) {
                    man = i;
                    break;
                }
            }
        }
        return man;
    }

    //поиск позиции человека в массиве по адресу(первое вхождение) (если такого нет, то вернет -1)
    public static int searchAddress(Person[] persons, String address){
        int man = -1;
        for (int i = 0; i<persons.length; i++){
            if (persons[i].getAddress().equals(address)) {
                man = i;
                break;
            }
        }
        return man;
    }

    //поиск позиции человека в массиве по адресу (вхождение под номером 'pos') (если нет, то вернет -1)
    public static int searchAddress(Person[] persons, String address, int pos){
        int man = -1;
        int cnt = 0;
        for (int i = 0; i<persons.length; i++){
            if (persons[i].getAddress().equals(address)) {
                cnt++;
                if (cnt == pos) {
                    man = i;
                    break;
                }
            }
        }
        return man;
    }

    //вывод людей, родившихся между определенными датами, (если таких нет, то null)
    public static void searchDates(Person[] persons, Calendar d1, Calendar d2){
        for (int i = 0; i<persons.length; i++){
            if (persons[i].getBirthdate().compareTo(d1)>0 && persons[i].getBirthdate().compareTo(d2)<0){
                System.out.println(persons[i].toString());
            }
        }
    }

    //поиск позиции самого молодого человека в массиве (первое вхождение)
    public static int findYoung(Person[] persons){
        Calendar young = persons[0].getBirthdate();
        int index = 0;
        for (int i = 0; i<persons.length; i++){
            if (persons[i].getBirthdate().compareTo(young)>0) {
                index = i;
                young = persons[i].getBirthdate();
                break;
            }
        }
        return index;
    }

    //поиск позиции самого старого человека в массиве (первое вхождение)
    public static int findOld(Person[] persons){
        Calendar old = persons[0].getBirthdate();
        int index = 0;
        for (int i = 0; i<persons.length; i++){
            if (persons[i].getBirthdate().compareTo(old)<0) {
                index = i;
                old = persons[i].getBirthdate();
                break;
            }
        }
        return index;
    }

    //вывод людей, проживающих на одной улице,и их индексов в массиве
    public static void sameAddress(Person[] persons){
        HashSet<String> strSet = new HashSet<>();
        for (int i = 0; i<persons.length; i++){
            strSet.add(persons[i].getAddress());
        }
        for (String addr : strSet) {
            System.out.print(addr+": ");
            for (int i = 0; i<persons.length; i++){
                if (persons[i].getAddress().equals(addr)) {
                    System.out.print(persons[i].getFullName()+"; ");
                }
            }
            System.out.println();
        }

    }
    public static void main(String[] args){
        Person[] persons = new Person[4];

        persons[0] = new Person("Иван","Иванов");
        persons[0].setBirthdate(11,12,1980);
        persons[0].setAddress("Ул. Арбат");

        persons[1] = new Person("Евгений","Петров");
        persons[1].setBirthdate(11,12,1978);
        persons[1].setAddress("Ул. Смоленская");

        persons[2] = new Person("Сергей","Иванов");
        persons[2].setBirthdate(1,12,1988);
        persons[2].setAddress("Ул. Арбат");

        persons[3] = new Person("Алексей","Семенченко");
        persons[3].setBirthdate(10,7,1985);
        persons[3].setAddress("Ул. Смоленская");

        System.out.println("проверка подпункта 1");
        System.out.println(PersonAddressImpl.searchSurname(persons,"Петров"));
        System.out.println(PersonAddressImpl.searchSurname(persons,"Иванов",2)+"\n");

        System.out.println("проверка подпункта 2");
        System.out.println(PersonAddressImpl.searchAddress(persons,"Ул. Смоленская"));
        System.out.println(PersonAddressImpl.searchAddress(persons,"Ул. Смоленская",2)+"\n");

        System.out.println("проверка подпункта 3");
        Calendar d1 = new GregorianCalendar(1983,1,1);
        Calendar d2 = new GregorianCalendar(2000,1,1);
        PersonAddressImpl.searchDates(persons,d1,d2);
        System.out.println();

        System.out.println("проверка подпункта 4");
        System.out.println(PersonAddressImpl.findYoung(persons));
        System.out.println(PersonAddressImpl.findOld(persons)+"\n");


        System.out.println("проверка подпункта 5");
        PersonAddressImpl.sameAddress(persons);
        System.out.println();
    }
}

//кдасс для сущности человека
class Person{
    private String name;
    private String surname;
    private Calendar birthdate;
    private Address address;

    public Person(){}
    public Person(String name){
        this.name = name;
    }
    public Person(String name,String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName() {
        return name+" "+surname;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int day,int month, int year) {
        Calendar birthdate = new GregorianCalendar(year,month,day);
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address.getName();
    }

    public void setAddress(String address) {
        this.address = new Address();
        this.address.setName(address);
    }

    @Override
    public String toString() {
        return name + ", " + surname + ", " +
                birthdate.get(Calendar.DATE)+"."+(birthdate.get(Calendar.MONTH)+1)+"."+birthdate.get(Calendar.YEAR)+
                ", " + address.getName()+ ";";
    }
}

//класс для сущности адреса
class Address{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}