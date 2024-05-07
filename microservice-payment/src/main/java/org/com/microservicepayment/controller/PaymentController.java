package org.com.microservicepayment.controller;

import lombok.AllArgsConstructor;
import org.com.microservicepayment.entities.Payment;
import org.com.microservicepayment.entities.PaymentStatus;
import org.com.microservicepayment.entities.PaymentType;
import org.com.microservicepayment.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;

    @GetMapping("/payments")
    public List<Payment> findAllPayments(){
        return paymentService.findAllPayments();
    }

    @GetMapping("/payments/{id}")
    public Payment findPaymentById(@PathVariable("id") Integer id){
        return paymentService.findPaymentById(id);
    }

    @PostMapping("/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public Payment savePayment(@RequestParam Integer commandId, @RequestHeader PaymentType type){
        return paymentService.savePayment(commandId,type);
    }

    @PutMapping("/payments/{paymentId}/updateStatus")
    public Payment updatePaymentStatus(@PathVariable("paymentId") Integer id,
                                       @RequestHeader PaymentStatus status){
        return paymentService.updatePaymentStatus(id,status);
    }

}
