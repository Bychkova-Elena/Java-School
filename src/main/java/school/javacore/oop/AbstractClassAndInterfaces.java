package school.javacore.oop;

/*
Задача: Попробуйте на практике совместить абстрактные классы и интерфейсы.

Создайте абстрактный класс Account (например, банковский счёт) с полем balance и методами:
Конструктор, устанавливающий balance.
Метод deposit(double amount), который увеличивает баланс.
Абстрактный метод withdraw(double amount).

Создайте интерфейс Printable, в котором объявите метод printInfo().

Создайте конкретные классы:
SavingAccount (сберегательный счёт), который наследует Account и реализует withdraw (например, не даёт уйти в минус).
CreditAccount (кредитный счёт), тоже наследующий Account — в методе withdraw, возможно, допускает уход в минус
до определённого лимита.
Оба класса реализуют Printable, переопределяя метод printInfo() для вывода информации о типе счёта и балансе.

Напишите класс Main с main(), где создайте несколько аккаунтов: SavingAccount, CreditAccount, добавьте им денег,
попробуйте снять, выведите информацию через printInfo() (полиморфно, через переменную типа Printable).

Что проверить:
Убедитесь, что из Account нельзя сделать new Account().
Класс SavingAccount и CreditAccount переопределяют withdraw() и обязательно предоставляют логику.
Метод printInfo() вызывается через интерфейсную ссылку: Printable p = new SavingAccount(...); p.printInfo();
*/

public class AbstractClassAndInterfaces {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount(20.0);
        CreditAccount creditAccount = new CreditAccount(50.0);
        Printable[] arr = {savingAccount, creditAccount};


        savingAccount.deposit(5.0);
        creditAccount.deposit(10.0);

        for (Printable p : arr) {
            p.printInfo();
        }

        savingAccount.withdraw(10.0);
        creditAccount.withdraw(100.0);

        for (Printable p : arr) {
            p.printInfo();
        }
    }
}

abstract class Account {
    double balance;

    Account (double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance = balance + amount;
    }

    abstract void withdraw(double amount);
}

interface Printable {
    void printInfo();
}

class SavingAccount extends Account implements Printable {

    SavingAccount(double balance) {
        super(balance);
    }

    @Override
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Недостаточно средств");
        }
        else {
            balance = balance - amount;
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Баланс сберегательного счёта: " + balance);
    }
}

class CreditAccount extends Account implements Printable {

    CreditAccount(double balance) {
        super(balance);
    }

    @Override
    void withdraw(double amount) {
        double newBalance = balance - amount;

        if (newBalance < -10000) {
            System.out.println("Слишком большой минус");
        } else {
            balance = newBalance;
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Баланс кредитного счёта: " + balance);
    }
}
