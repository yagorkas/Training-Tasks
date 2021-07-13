package trainingTask1;


public class QuadricEquationsImpl{
    public static void main(String[] args){
        QuadricEquations.solveEquation(2,5,1);

        QuadricEquations.solveEquation(1,2,1);

        QuadricEquations.solveEquation(1,4,7);
    }
}

class QuadricEquations{
    //вложенный класс для рассчета дискриминанта
    private static class Discriminant{
        static double calculate(double a,double b,double c){
            return b*b-4*a*c;
        }
    }

    //статический метод для решения квадратных уравнений с действительными коэффициентами
    public static void solveEquation(double a,double b,double c){
        double d = Discriminant.calculate(a,b,c);
        if (d > 0) {
            System.out.println("Уравнение имеет 2 действительных корня: х1 = "+((-b+Math.sqrt(d))/2*a)+"; x2 = "+((-b-Math.sqrt(d))/2*a));
        }else if (d == 0){
            System.out.println("Уравнение имеет 1 действительный корень: х = "+(-b/2*a));
        }else {
            d *= -1;
            String b2 = ""+(-b/(2*a));
            String d2 = ""+Math.sqrt(d)/(2*a)+"i";
            System.out.println("Уравнение имеет 2 решения с комплексными корнями: х1 = "+b2+" + "+d2+"; x2 = "+b2+" - "+d2);
        }
    }
}
