package school.javacore.oop;

/*
Задача: Реализовать класс Car с полями brand, model, year.

Сделайте поля private String brand, private String model, private int year.

Реализуйте геттеры и сеттеры для каждого поля:
getBrand(), setBrand(String brand)
getModel(), setModel(String model)
getYear(), setYear(int year) (проверка: не меньше 1886 — считается, что первая машина была создана тогда).

В методе main (в отдельном классе Main) создайте пару объектов Car, присвойте значения, попробуйте ввести
некорректный год. Убедитесь, что ваш код работает правильно (не устанавливает неправильные значения).

        (Опционально) Добавьте метод toString() для удобного вывода информации об объекте.
*/

public class Еncapsulation {
    public static void main(String[] args) {
        Car car1 = new Car("Brand1", "Model1");
        Car car2 = new Car("Brand2", "Model2");

        car1.setYear(1900);
        car2.setYear(700);

        System.out.println(car1);
        System.out.println(car2);
    }
}

class Car {
    private String brand;
    private String model;
    private int year;

    Car (String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        if (year < 1886) {
            System.out.println("Год не может быть меньше 1886");
            return;
        }

        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
