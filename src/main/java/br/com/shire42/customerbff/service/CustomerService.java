package br.com.shire42.customerbff.service;

import br.com.shire42.customerbff.grpc.client.CustomerGrpcClient;
import br.com.shire42.customerbff.grpc.client.WalletGrpcClient;
import br.com.shire42.customerbff.model.Customer;
import br.com.shire42.customerbff.model.Wallet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerGrpcClient customerService;

    private final WalletGrpcClient walletService;

    public Customer findCustomerByEmail(final String email) {
        return customerService.findCustomerService(email).orElseThrow();
    }

    public List<Wallet> findWalletsByCustomerId(final String customerId) {
        return walletService.findWalletsCustomer(customerId);
    }

}
