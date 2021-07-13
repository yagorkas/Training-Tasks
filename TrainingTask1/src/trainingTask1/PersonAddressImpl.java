package trainingTask1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

public class PersonAddressImpl {
    //поиск позиции человека в массиве по по фамилии (первое вхождение) (если нет, то вернет null)
    public static int searchSurname(Person[] persons, String surname){
        int man = -1;
        for (int i = 0; i<persons.length; i++){
            if (persons[i].getName().equals(surname)) {
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
            if (persons[i].getName().equals(surname)) {
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
            if (persons[i].getName().equals(address)) {
                cnt++;
                if (cnt == pos) {
                    man = i;
                    break;
                }
            }
        }
        return man;
    }

    //подсчет количества людей, родившихся между заданными датами
    public static int countDates(Person[] persons, Calendar d1, Calendar d2){
        int cnt =0;
        for (int i = 0; i<persons.length; i++){
            if (persons[i].getBirthdate().compareTo(d1)>0 && persons[i].getBirthdate().compareTo(d2)<0){
                cnt++;
            }
        }
        return cnt;
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
        this.address.setName(address);
    }

    @Override
    public String toString() {
        return name + ", " + surname + ", " +
                birthdate.get(Calendar.DATE)+"."+(birthdate.get(Calendar.MONTH)+1)+"."+birthdate.get(Calendar.YEAR)+
                ", " + address+ ";";
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