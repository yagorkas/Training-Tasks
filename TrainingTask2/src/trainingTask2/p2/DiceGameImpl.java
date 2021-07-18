package trainingTask2.p2;

public class DiceGameImpl {
    public static void main(String[] args){
        int rnd = 1;
        int N = 4;
        int K = 3;
        DiceGame game = new DiceGame();
        game.initNewGame(N,K);
        while (game.isActive()){
            System.out.println("Round "+rnd);
            game.nextRound();
            rnd++;
            System.out.println();
        }
        game.checkTable();
    }
}

class DiceGame implements Game{
    private int dicesNumber;
    private Player[] players;
    private boolean activeness = false;

    //метод для инициализации начала игры
    @Override
    public void initNewGame(int N,int K){
        this.dicesNumber = K;
        players = new Player[N];
        players[0] = new Player("You");
        for (int i=1; i < N-1; i++){
            players[i] = new Player("Player "+i);
        }
        players[N-1] = new Player("Comp");
        activeness = true;
    }

    @Override
    public boolean isActive(){
        return this.activeness;
    }

    //метод поиска победителей
    private static int findWinner(int[] cnt){
        int index = 0;
        int max = 0;
        for (int i=0; i<cnt.length; i++){
            if (max < cnt[i]){
                max = cnt[i];
                index = i;
            }
        }
        return index;
    }

    //метод проверка единственности победителя
    private static boolean isOneWinner(int[] cnt){
        int max = 0;
        int counts = 0;
        for (int i=0; i<cnt.length; i++){
            if (max < cnt[i]){max = cnt[i];}
        }
        for (int i=0; i<cnt.length; i++){
            if (max == cnt[i]){counts++;}
        }
        if (counts==1) {return true;}
        else {return false;}
    }

    //метод - проведение раунда
    @Override
    public void nextRound(){
        if (!this.isActive()){
            System.out.println("Игра не активна. Начните новую.");
            return;
        }
        int[] cnt= new int[players.length];
        int winner;
        System.out.println("Суммы очков игроков:");
        for (int j=0; j < players.length;j++){
            for (int i=0; i < dicesNumber; i++){
                cnt[j] += players[j].rollDices();
            }
            System.out.print(players[j].getName()+": "+cnt[j]+"; ");
        }
        System.out.println();
        winner = DiceGame.findWinner(cnt);
        if (!DiceGame.isOneWinner(cnt)) {
            System.out.println("В этом раунде несколько игроков набрали одинаковое количество очков.");
        }else {
            System.out.println("В этом раунде победил игрок: " + players[winner].getName());
            players[winner].addWin();
            Player tmp = players[winner];
            players[winner] = players[0];
            players[0] = tmp;

            if (players[0].getWins() == 7){
                System.out.println("Игрок '" + players[0].getName()+"' набрал 7 побед. На этом игра закончилась.");
                activeness = false;
            }
        }
    }
    @Override
    public void checkTable(){
        System.out.println("Текущая ситуация по игре");
        System.out.println("Игрок|Количество побед");
        for (int i = 0; i<players.length; i++){
            System.out.println(players[i].getName()+" | "+players[i].getWins());
        }
    }

}

class Player{
    private int wins;
    private String name;

    public Player(){}

    public Player(String name){
        this.name = name;
    }

    public int getWins(){
        return wins;
    }

    public void addWin(){
        this.wins++;
    }

    public String getName(){
        return this.name;
    }

    //имитация бросания кости
    public int rollDices(){
        return (int) (Math.random() * 6) + 1;
    }
}