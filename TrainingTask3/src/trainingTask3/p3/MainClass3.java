package trainingTask3.p3;

import java.util.StringTokenizer;

public class MainClass3 {
    public static void main(String[] args){
        Address adr1 = new Address();
        adr1.setPartsComma("СтранаX, регион-, городA, улица 1, строение.7, корпус 44;  ,квартира 12");
        System.out.println(adr1.toString());

        Address adr2 = new Address();
        adr2.setPartsAny("Страна2, регион+, город B, улица 2, строение7, корпус 12, квартира 45");
        System.out.println(adr2.toString());

        Address adr3 = new Address();
        adr3.setPartsAny("Страна#. регион*. город C; улица3, строение 7. корпус 3    ;  квартира 23");
        System.out.println(adr3.toString());

        Address adr4 = new Address();
        adr4.setPartsAny("Страна sdf; регион/, город D, улица 5, строение.7, корпус4;   -12");
        System.out.println(adr4.toString());
    }
}

class Address{
    private String name;
    private String country;
    private String region;
    private String city;
    private String street;
    private String building;
    private String block;
    private String room;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartsComma(String str){
        String[] words = str.split(",");
        country = words[0].trim();
        region = words[1].trim();
        city = words[2].trim();
        street = words[3].trim();
        building = words[4].trim();
        block = words[5].trim();
        room = words[6].trim();
    }

    public void setPartsAny(String str){
        StringTokenizer words = new StringTokenizer(str,",.;");
        this.country = words.nextToken().trim();
        this.region = words.nextToken().trim();
        this.city = words.nextToken().trim();
        this.street = words.nextToken().trim();
        this.building = words.nextToken().trim();
        this.block = words.nextToken().trim();
        this.room = words.nextToken().trim();
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", block='" + block + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}