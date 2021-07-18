package trainingTask2.p2;

public interface Game {
    //метод инициализации начала игры
    void initNewGame(int N,int K);
    //метод проверки активности игры
    boolean isActive();
    //метод проведения следующего раунда игры
    void nextRound();
    //метод вывода таблицы игроков
    void checkTable();
}
