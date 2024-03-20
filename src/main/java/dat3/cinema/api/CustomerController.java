package dat3.cinema.api;

import dat3.cinema.entity.Customer;
import dat3.cinema.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Get all customers path
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get one customer path
    @GetMapping(path = "/{id}")
    public ResponseEntity<Customer> getOneCustomer(@PathVariable int id) {
        return customerService.getOneCustomer(id);
    }






}
