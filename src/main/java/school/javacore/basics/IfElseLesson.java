package school.javacore.basics;

/*
Написать программу, которая помогает пользователю выбрать жанр фильма для просмотра. Пусть программа:
Предлагает ввести число от 1 до 5 (1 — комедия, 2 — драма, 3 — фантастика, 4 — боевик, 5 — аниме).
В зависимости от введённого числа предлагает несколько известных фильмов этого жанра
(можно ограничиться 1–2 названиями).
Если число не входит в диапазон 1–5, выводит сообщение: «Такого жанра не знаю».
*/

import java.util.Scanner;

public class IfElseLesson {
    public static  void main(String[] args) {
        System.out.print("Выберите жанр фильма (чмсло от 1 до 5): ");
        String moviesGenre = new Scanner(System.in).nextLine();

        switch (moviesGenre) {
            case "1":
                System.out.println("Фмльмы жанра комедия: ... ");
                break;

            case "2":
                System.out.println("Фмльмы жанра драма: ... ");
                break;

            case "3":
                System.out.println("Фмльмы жанра фантастика: ... ");
                break;

            case "4":
                System.out.println("Фмльмы жанра боевик: ... ");
                break;

            case "5":
                System.out.println("Фмльмы жанра аниме: ... ");
                break;

            default:
                System.out.println("Такого жанра не знаю");
                break;
        }
    }
}
