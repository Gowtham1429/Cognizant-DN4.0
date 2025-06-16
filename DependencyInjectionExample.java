interface CustomerRepository {
    String findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        // Mocked data for testing
        return "Customer ID: " + id + ", Name: Gowtham, Location: Chennai";
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomer(String id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println(customer);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        service.displayCustomer("CUST123");
    }
}
