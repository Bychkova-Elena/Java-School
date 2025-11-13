package school.javacore.testing.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    private OrderRepository orderRepositoryMock;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderRepositoryMock = mock(OrderRepository.class);
        orderService = new OrderService(orderRepositoryMock);
    }

    @Test
    void shouldReturnSuccessfulMessageWhenProcessOrder() {
        // given
        Order order = createOrder();
        when(orderRepositoryMock.saveOrder(order)).thenReturn(1);

        // when
        String ms = orderService.processOrder(order);

        // then
        assertEquals("Order processed successfully", ms);
        verify(orderRepositoryMock, times(1)).saveOrder(order);
    }

    @Test
    void shouldReturnFailedMessageWhenProcessOrder() {
        // given
        Order order = createOrder();
        when(orderRepositoryMock.saveOrder(order)).thenThrow(RuntimeException.class);

        // when
        String ms = orderService.processOrder(order);

        // then
        assertEquals("Order processing failed", ms);
        verify(orderRepositoryMock, times(1)).saveOrder(order);
    }

    @Test
    void shouldTrowExceptionWhenOrderIsNull() {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> orderService.processOrder(null));
    }

    @Test
    void shouldReturnRightTotalPrice() {
        // given
        int id = 3;
        Order order = createOrder(3, 100.0);

        when(orderRepositoryMock.getOrderById(id)).thenReturn(Optional.of(order));

        // when
        double totalPrice = orderService.calculateTotal(id);

        // then
        assertEquals(300.0, totalPrice);
        verify(orderRepositoryMock, times(1)).getOrderById(id);
    }

    @Test
    void shouldTrowExceptionWhenOrderNotFound() {
        // given
        int id = 3;

        when(orderRepositoryMock.getOrderById(id)).thenReturn(Optional.empty());

        // when & then
        assertThrows(NoSuchElementException.class, () -> orderService.calculateTotal(id));
        verify(orderRepositoryMock, times(1)).getOrderById(id);
    }

    @Test
    void shouldReturnZeroTotalPriceWhenQuantityIsZero() {
        // given
        int id = 3;
        Order order = createOrder(0, 120.0);

        when(orderRepositoryMock.getOrderById(id)).thenReturn(Optional.of(order));

        // when
        double totalPrice = orderService.calculateTotal(id);

        // then
        assertEquals(0.0, totalPrice);
        verify(orderRepositoryMock, times(1)).getOrderById(id);
    }

    private Order createOrder() {
        return new Order("Milk", 10, 100.0);
    }

    private Order createOrder(int quantity, double price) {
        return new Order("Milk", quantity, price);
    }
}
