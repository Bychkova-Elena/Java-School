package school.javacore.streamapi.project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiFinalProject {
    public static void main(String[] args) {
        Set<Product> products = Set.of(
                new Product(1L, "Приключения Гуливера", "Books", new BigDecimal("80")),
                new Product(2L, "Приключения Дэвида", "Books", new BigDecimal("250")),
                new Product(3L, "Молоко", "Children's products", new BigDecimal("60")),
                new Product(4L, "Памперсы", "Children's products", new BigDecimal("320")),
                new Product(5L, "Заяц", "Toys", new BigDecimal("2000")),
                new Product(6L, "Мишка", "Toys", new BigDecimal("1200")),
                new Product(7L, "Лягушка", "Toys", new BigDecimal("1800")),
                new Product(8L, "Приключения Герберта", "Books", new BigDecimal("550")),
                new Product(9L, "Шоколад детский", "Children's products", new BigDecimal("99")),
                new Product(10L, "Леденец", "Children's products", new BigDecimal("70")),
                new Product(11L, "Приключения Муравья", "Books", new BigDecimal("870"))

        );

        Set<Order> orders = Set.of(
                new Order(
                        1L,
                        LocalDate.of(2021,2,10),
                        LocalDate.of(2021,3,14),
                        "DONE",
                        new HashSet<>(products.stream().skip(7L).collect(Collectors.toSet()))),
                new Order(
                        2L,
                        LocalDate.of(2023,11,10),
                        LocalDate.of(2023,11,24),
                        "DONE",
                        new HashSet<>(products.stream().skip(8L).collect(Collectors.toSet()))),
                new Order(
                        3L,
                        LocalDate.of(2025,10,31),
                        null,
                        "IN PROGRESS",
                        new HashSet<>(products.stream().skip(9L).collect(Collectors.toSet()))),
                new Order(
                        4L,
                        LocalDate.of(2025,10,30),
                        null,
                        "IN PROGRESS",
                        new HashSet<>(products.stream().skip(6L).collect(Collectors.toSet()))),
                new Order(
                        5L,
                        LocalDate.of(2025,11,2),
                        null,
                        "NEW",
                        new HashSet<>(products.stream().skip(10L).collect(Collectors.toSet()))),
                new Order(
                        6L,
                        LocalDate.of(2023,8,8),
                        LocalDate.of(2023,8,20),
                        "DONE",
                        new HashSet<>(products.stream().skip(7L).collect(Collectors.toSet()))),
                new Order(
                        7L,
                        LocalDate.of(2023,11,10),
                        LocalDate.of(2023,11,24),
                        "DONE",
                        new HashSet<>(products.stream().skip(8L).collect(Collectors.toSet()))),
                new Order(
                        8L,
                        LocalDate.of(2024,10,31),
                        LocalDate.of(2024,11,24),
                        "DONE",
                        new HashSet<>(products.stream().skip(9L).collect(Collectors.toSet()))),
                new Order(
                        9L,
                        LocalDate.of(2025,10,30),
                        null,
                        "IN PROGRESS",
                        new HashSet<>(products.stream().skip(6L).collect(Collectors.toSet()))),
                new Order(
                        10L,
                        LocalDate.of(2025,11,2),
                        null,
                        "NEW",
                        new HashSet<>(products.stream().skip(10L).collect(Collectors.toSet()))),
                new Order(
                        11L,
                        LocalDate.of(2021,3,2),
                        LocalDate.of(2021,3,14),
                        "DONE",
                        new HashSet<>(products.stream().skip(7L).collect(Collectors.toSet()))),
                new Order(
                        12L,
                        LocalDate.of(2023,10,10),
                        LocalDate.of(2023,10,24),
                        "DONE",
                        new HashSet<>(products.stream().skip(8L).collect(Collectors.toSet()))),
                new Order(
                        13L,
                        LocalDate.of(2024,7,7),
                        LocalDate.of(2024,8,8),
                        "DONE",
                        new HashSet<>(products.stream().skip(9L).collect(Collectors.toSet()))),
                new Order(
                        14L,
                        LocalDate.of(2025,10,30),
                        null,
                        "IN PROGRESS",
                        new HashSet<>(products.stream().skip(6L).collect(Collectors.toSet()))),
                new Order(
                        15L,
                        LocalDate.of(2025,11,2),
                        null,
                        "NEW",
                        new HashSet<>(products.stream().skip(10L).collect(Collectors.toSet()))),
                new Order(
                        16L,
                        LocalDate.of(2010,10,20),
                        LocalDate.of(2010,10,30),
                        "DONE",
                        new HashSet<>(products.stream().skip(7L).collect(Collectors.toSet()))),
                new Order(
                        17L,
                        LocalDate.of(2012,11,10),
                        LocalDate.of(2012,11,24),
                        "DONE",
                        new HashSet<>(products.stream().skip(8L).collect(Collectors.toSet()))),
                new Order(
                        18L,
                        LocalDate.of(2014,10,31),
                        LocalDate.of(2014,10,31),
                        "DONE",
                        new HashSet<>(products.stream().skip(9L).collect(Collectors.toSet()))),
                new Order(
                        19L,
                        LocalDate.of(2024,10,30),
                        LocalDate.of(2024,10,30),
                        "DONE",
                        new HashSet<>(products.stream().skip(6L).collect(Collectors.toSet()))),
                new Order(
                        20L,
                        LocalDate.of(2025,11,1),
                        null,
                        "NEW",
                        new HashSet<>(products.stream().skip(10L).collect(Collectors.toSet()))),
                new Order(
                        21L,
                        LocalDate.of(2017,2,10),
                        LocalDate.of(2017,2,21),
                        "DONE",
                        new HashSet<>(products.stream().skip(7L).collect(Collectors.toSet()))),
                new Order(
                        22L,
                        LocalDate.of(2018,5,6),
                        LocalDate.of(2018,5,24),
                        "DONE",
                        new HashSet<>(products.stream().skip(8L).collect(Collectors.toSet()))),
                new Order(
                        23L,
                        LocalDate.of(2019,7,10),
                        LocalDate.of(2019,7,17),
                        "DONE",
                        new HashSet<>(products.stream().skip(9L).collect(Collectors.toSet()))),
                new Order(
                        24L,
                        LocalDate.of(2021,3,15),
                        null,
                        "IN PROGRESS",
                        new HashSet<>(products.stream().skip(6L).collect(Collectors.toSet()))),
                new Order(
                        25L,
                        LocalDate.of(2021,3,15),
                        null,
                        "NEW",
                        new HashSet<>(products.stream().skip(10L).collect(Collectors.toSet())))
        );

        List<Customer> customers = Arrays.asList(
                new Customer(
                        1L,
                        "Lena",
                        3L,
                        orders.stream().limit(5L).collect(Collectors.toSet())
                ),
                new Customer(
                        2L,
                        "Misha",
                        3L,
                        orders.stream().skip(5L).limit(5L).collect(Collectors.toSet())
                ),
                new Customer(
                        3L,
                        "Dima",
                        2L,
                        orders.stream().skip(10L).limit(5L).collect(Collectors.toSet())
                ),
                new Customer(
                        4L,
                        "Ira",
                        1L,
                        orders.stream().skip(15L).limit(5L).collect(Collectors.toSet())
                ),
                new Customer(
                        5L,
                        "Kira",
                        2L,
                        orders.stream().skip(20L).limit(5L).collect(Collectors.toSet())
                )
        );

        // Задание 1
        List<Product> productsListWithPriceUp100AndBookCategory = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(p -> p.getCategory().equals("Books") && p.getPrice().intValue() > 100)
                .distinct()
                .collect(Collectors.toList());

        // Задание 2
        List<Order> orderListWithProductsFromChildrenProductsCategory = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getProducts().stream()
                                .anyMatch(product -> product.getCategory().equals("Children's products")))
                .collect(Collectors.toList());

        // Задание 3
        BigDecimal sumProductWithToysCategoryAndDiscount = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Toys"))
                .map(product -> product.getPrice().multiply(new BigDecimal("0.9")))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Задание 4
        Set<Product> productsSetFromClientLevelTwoAndSpecialOrderDate = customers.stream()
                .filter(customer -> customer.getLevel() == 2L)
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().getYear() == 2021
                        && ((order.getOrderDate().getMonth() == Month.FEBRUARY
                        && order.getOrderDate().getDayOfMonth() != 1)
                        || order.getOrderDate().getMonth() == Month.MARCH))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toSet());

        // Задание 5
        List<Product> cheapProductsWithBooksCategoryTop = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Books"))
                .distinct()
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(2)
                .collect(Collectors.toList());

        // Задание 6
        Order[] lastOrdersCreated = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .toArray(Order[]::new);

        // Задание 7
        Set<Product> productListFromOrdersCreatedAtOfMarch = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021, 3, 15)))
                .peek(order -> System.out.print(order.getId() + " "))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toSet());

        // Задание 8
        BigDecimal countOrdersDeliveryInFebruary21 = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().getMonth() == Month.FEBRUARY
                        && order.getOrderDate().getYear() == 2021)
                .map(order -> order.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Задание 9
        var averagePriceOfMarchOrders = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021, 3, 14)))
                .map(order -> order.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .collect(Collectors.averagingDouble(BigDecimal::doubleValue));

        // Задание 10
        var summaryStatisticProductWithCategoryBook = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals("Books"))
                .distinct()
                .collect(Collectors.summarizingInt(product -> product.getPrice().intValue()));

        // Задание 11
        Map<Long, Integer> orderMap = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toMap(Order::getId, order -> order.getProducts().size()));

        // Задание 12
        Map<Customer, List<Order>> customerMap = customers.stream()
                .collect(Collectors.toMap(customer -> customer, customer -> new ArrayList<>(customer.getOrders())));

        // Задание 13
        Map<Order, Double> ordersPriceMap = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toMap(order -> order, order -> order.getProducts().stream()
                        .mapToDouble(product -> product.getPrice().doubleValue()).sum()));

        // Задание 14
        Map<String, List<String>> productByCategoryMap = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.groupingBy(
                        Product::getCategory, Collectors.mapping(Product::getName, Collectors.toList()))
                );

        // Задание 15
        Map<String, Product> expensiveProductByCategory = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toMap(
                        Product::getCategory,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Product::getPrice))
                ));
    }
}
