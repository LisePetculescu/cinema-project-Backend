package dat3.cinema.api;

import dat3.cinema.entity.Customer;
import dat3.cinema.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // Create a new customer path
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer request) {
        return customerService.createCustomer(request);
    }

    // Update a customer path
    @PutMapping(path = "/{id}")
    public Customer updateCustomer(@RequestBody Customer request, @PathVariable int id) {
        return customerService.updateCustomer(request, id);
    }

    // Delete a customer path
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Customer> deleteOneCustomer(@PathVariable int id) {
        return customerService.deleteOneCustomer(id);
    }
}
