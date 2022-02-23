package demo.repository;
import org.springframework.data.repository.CrudRepository;

import demo.entity.CustomerOrder;


public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {

  
}
