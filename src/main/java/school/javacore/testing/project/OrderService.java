package school.javacore.testing.project;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String processOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        try {
            orderRepository.saveOrder(order);
            return "Order processed successfully";
        } catch (Exception e) {
            return "Order processing failed";
        }
    }

    public double calculateTotal(int id) {
        Order order = orderRepository.getOrderById(id).orElseThrow();

        return order.getTotalPrice();
    }
}
