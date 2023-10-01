package br.com.shire42.customerbff.grpc.client;

import br.com.shire42.customer.CustomerRequest;
import br.com.shire42.customer.CustomerServiceGrpc;
import br.com.shire42.customerbff.model.Customer;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CustomerGrpcClient {

    @GrpcClient("customer-service")
    private CustomerServiceGrpc.CustomerServiceBlockingStub customerStub;


    public Optional<Customer> findCustomerService(final String email) {
        final CustomerRequest request = CustomerRequest.newBuilder()
                .setEmail(email)
                .build();

        final List<Customer> customers = this.customerStub.findCustomer(request)
                .getCustomersList()
                .stream()
                .map(c -> new Customer(UUID.fromString(c.getId()), c.getName(), c.getLastName(), c.getEmail(), null))
                .toList();

        return customers.stream().findFirst();
    }

}
