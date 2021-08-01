package trainingTask4.p2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class StringDateCalendar {
    /**
     * Формирует объект Date по вводимой строке.
     * @param stringDate строка, содержащая данные <Год><Месяц><Число><Часы><минуты>
     * @return объект Date или null, если строка не в заданном формате.
     */
    public static Date makeDate(String stringDate) throws ParseException {
        return new SimpleDateFormat("dd.MM.yyyy H:m").parse(stringDate);
    }

    /**
     * Формирует объект Calendar по вводимой строке.
     * @param stringDate строка, содержащая данные <Год><Месяц><Число><Часы><минуты>
     * @return объект Calendar или null, если строка не в заданном формате.
     */
    public static Calendar makeCalendar(String stringDate) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("dd.MM.yyyy H:m").parse(stringDate));
        return calendar;
    }
}

public class Test {
    public static void main(String[] args){
        String str = "2000.02.29 12:00";
        Date date = null;
        try {
            date = StringDateCalendar.makeDate(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = null;
        try {
            calendar = StringDateCalendar.makeCalendar(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date.toString());
        System.out.println(calendar.getTime());
    }
}
