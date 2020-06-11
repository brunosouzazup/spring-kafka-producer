package br.com.zup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.model.Customer;

@RestController
@RequestMapping("/kafka")
public class CustomerController {
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																													
    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    private static final String TOPIC = "CUSTOMER_DATA";

    @GetMapping("/publish/{name}")
    public String publishName(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new Customer(name, "199999-9999", "customer@zup.com.br", "Av.Paulista - São Paulo - SP"));

        return "Published successfully";
    }
    
	@PostMapping("/publish/")
	public ResponseEntity<Customer> publishCustomer(@RequestBody Customer customer) {
		kafkaTemplate.send(TOPIC, customer);
		
		return ResponseEntity.created(null).body(customer);
	}
}