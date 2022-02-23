package demo.repository;
import org.springframework.data.repository.CrudRepository;

import demo.entity.CustomerAccount;


public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Long> {

	CustomerAccount findByUsername(String username);
  
}