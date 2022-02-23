package demo.repository;

import org.springframework.data.repository.CrudRepository;
import demo.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

	  
}
