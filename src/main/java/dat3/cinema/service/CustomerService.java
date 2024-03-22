package dat3.cinema.service;

import dat3.cinema.entity.Customer;
import dat3.cinema.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by id
    public ResponseEntity<Customer> getOneCustomer(int id) {
        return ResponseEntity.of(customerRepository.findById(id));
    }

    // Create a new customer
    public Customer createCustomer(Customer request) {
        Customer customer = new Customer();
        updateCustomer(customer, request);
        return customerRepository.save(customer);
    }

    // Update a customer by id and return the updated customer object or throw a 404 error if the customer is not found
    public Customer updateCustomer(Customer request, int id) {
        Customer customerToEdit = customerRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found, can't update"));
        customerToEdit.setFirstName(request.getFirstName());
        customerToEdit.setLastName(request.getLastName());
        customerToEdit.setPhoneNumber(request.getPhoneNumber());
        customerToEdit.setEmail(request.getEmail());
        return customerRepository.save(customerToEdit);
    }

    // Update the customer object with the given request object
    private void updateCustomer(Customer customer, Customer request) {
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setEmail(request.getEmail());
    }

    // Delete a customer by id and return the deleted customer object or throw a 404 error if the customer is not found
    public ResponseEntity<Customer> deleteOneCustomer(int id) {
        Optional<Customer> customerToDelete = Optional.ofNullable(customerRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found, can't delete")));
        customerRepository.deleteById(id);
        return ResponseEntity.of(customerToDelete);
    }













}
