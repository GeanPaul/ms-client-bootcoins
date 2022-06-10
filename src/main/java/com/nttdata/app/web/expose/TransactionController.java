package com.nttdata.app.web.expose;

import com.nttdata.app.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TransactionController {
    @Autowired
    private KafkaProducer kafkaproducer;

    @PostMapping("/customer/transaction")
    public ResponseEntity<String> requestTransaction(@RequestBody String transaction)
    {
        kafkaproducer.publishEvent(transaction);
        return  ResponseEntity.ok(transaction);
    }
}
