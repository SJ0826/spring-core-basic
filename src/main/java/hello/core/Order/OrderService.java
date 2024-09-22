package hello.core.Order;

public interface OrderService {
    Order createOrder(Long member, String itemName, int itemPrice);
}
