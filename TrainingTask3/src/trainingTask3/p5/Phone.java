package trainingTask3.p5;

public class Phone {
    public static void main(String[] args){
        String phone1 ="+79175655655";
        String phone2 ="+104289652211";
        String phone3 ="89175655655";
        System.out.println(Phone.formatPhone(phone1));
        System.out.println(Phone.formatPhone(phone2));
        System.out.println(Phone.formatPhone(phone3));
    }

    static String formatPhone(String str){
        String newPhone = new String();
        if (str.charAt(0)=='+'){
            newPhone = str.substring(0,str.length()-7)+"-"+str.substring(str.length()-7,str.length()-4)+"-"+str.substring(str.length()-4);
        } else {
            newPhone = "+7"+str.substring(1,str.length()-7)+"-"+str.substring(str.length()-7,str.length()-4)+"-"+str.substring(str.length()-4);
        }
        return newPhone;
    }
}
