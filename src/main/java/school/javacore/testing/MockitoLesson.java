package school.javacore.testing;

/*
Расширьте пример с UserService следующим образом:
Добавьте в UserRepository новый метод, например, saveUser(User user), который сохраняет пользователя.
В классе UserService добавьте метод, который вызывает saveUser и возвращает статус сохранения.
Напишите тестовый класс, в котором:
Создайте мок для UserRepository.
Настройте поведение мока для метода saveUser (например, вернуть true или сохранить объект в локальной переменной).
Проверьте, что метод saveUser вызывается нужное количество раз с правильными аргументами.
*/

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
interface UserRepository {
    User findUserById(int id);
    boolean saveUser(User user);
}
class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(int id) {
        User user = userRepository.findUserById(id);
        return user != null ? user.getName() : "Unknown";
    }

    public boolean saveUser(User user) {
        return userRepository.saveUser(user);
    }
}