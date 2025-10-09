package school.javacore.oop;

/*
Задача: Создать класс GameScore, который будет хранить общий счёт (количество очков)
для всей игры и позволять увеличивать этот счёт. При этом у каждого игрока может быть своё имя, и в конструкторе
класса Player мы будем «прибавлять» очки к общему счёту.

Создайте класс GameScore со статическим полем totalScore (изначально 0).
В классе GameScore сделайте статический метод addPoints(int points), который увеличивает totalScore на переданное число.
Создайте класс Player с полями String name и int personalScore.
В конструкторе Player(String name, int points) прибавляйте очки к статическому GameScore и также сохраняйте их в
personalScore.
В методе main (отдельный класс, например Main) создайте несколько Player, чтобы проверить, что общий счёт игры
(GameScore.totalScore) действительно отражает сумму очков всех игроков.
Выведите информацию о каждом игроке (имя, личный счёт) и общий счёт, чтобы убедиться, что логика работает верно.

На что обратить внимание:
Убедитесь, что при создании нового игрока счёт действительно прибавляется к GameScore.totalScore.
Попробуйте поэкспериментировать: создайте нескольких игроков и проверьте, правильно ли всё суммируется.
*/

public class StaticLesson {
    public static void main(String[] args) {
        Player player1 = new Player("Ivan", 20);
        Player player2 = new Player("Lena", 30);
        Player player3 = new Player("Dasha", 10);

        System.out.println(player1.toString());
        System.out.println(player2.toString());
        System.out.println(player3.toString());

        Player player4 = new Player("Kolya", 100);
        System.out.println(player4.toString());
    }
}

class GameScore {
    static int totalScore = 0;

    static void addPoints (int points) {
        totalScore += points;
    }
}

class Player {
    String name;
    int personalScore;

    Player (String name, int points) {
        this.name = name;
        this.personalScore = points;
        GameScore.addPoints(points);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", personalScore=" + personalScore +
                ", totalScore=" + GameScore.totalScore +
                '}';
    }
}
