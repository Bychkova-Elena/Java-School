package school.javacore.basics;

public class VariablesLesson {
    public static void main(String[] args) {
        byte numberOfHands = 2;
        short boilingTemperature = 100;
        int money = 2000;
        long numbersOfSubscribers = 100000000000L;
        float pi = 3.14f;
        double doublePI = 3.14;
        char a = 'A';
        boolean isWinter = false;

        System.out.println("Количество рук: " + numberOfHands);
        System.out.println("Температура кипения воды: " + boilingTemperature);
        System.out.println("Сдача: " + money);
        System.out.println("Количество подписчиков: " + numbersOfSubscribers);
        System.out.println("Число PI: " + pi);
        System.out.println("Число PI типа double: " + doublePI);
        System.out.println("Первая буква алфавита: " + a);
        System.out.println("Is Winter? - " + isWinter);

        int intLong = (int) numbersOfSubscribers;
        System.out.println("Значение long: " + numbersOfSubscribers);
        System.out.println("Значение intLong: " + intLong);

        int nextInt = a + 1;
        for (int i = 0; i < 100; i++) {
            System.out.print((char) nextInt + " ");
            nextInt++;
        }
    }
}
