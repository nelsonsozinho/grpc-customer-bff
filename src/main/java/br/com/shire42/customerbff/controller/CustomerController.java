package br.com.shire42.customerbff.controller;

import br.com.shire42.customerbff.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/customer", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public ResponseEntity<?> findCustomerByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(customerService.findCustomerByEmail(email));
    }

    @GetMapping("/{customerId}/wallet")
    public ResponseEntity<?> findCustomerWithWallet(@PathVariable("customerId") String customerId) {
        return ResponseEntity.ok(customerService.findWalletsByCustomerId(customerId));
    }

}
