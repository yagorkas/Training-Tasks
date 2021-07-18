package trainingTask2.p4;

public class MainClass{
    public static void main(String[] args){
        TheNumbersImpl tni = new TheNumbersImpl();
        tni.setX();
        tni.setY();
        tni.getDifference();
    }
}

class TheNumbersImpl implements TwoNumbers{
    private double x;
    private double y;
    final double limit = 1000000;

    //должен устанавливать значение поля x
    @Override
    public void setX() {
        x = limit*(Math.random()*2 - 1);
    }
    //должен устанавливать значение поля y
    @Override
    public void setY() {
        y = limit*(Math.random()*2 - 1);
    }
    //печатает на экран абсолютное значение разности x и y
    @Override
    public void getDifference() {
        System.out.println(Math.abs(x-y));
    }
}
