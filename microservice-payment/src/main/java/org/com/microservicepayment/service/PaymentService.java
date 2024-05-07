package org.com.microservicepayment.service;

import lombok.AllArgsConstructor;
import org.com.microservicepayment.beans.CommandBean;
import org.com.microservicepayment.beans.ProductBean;
import org.com.microservicepayment.entities.Payment;
import org.com.microservicepayment.entities.PaymentStatus;
import org.com.microservicepayment.entities.PaymentType;
import org.com.microservicepayment.exceptions.ExistingPaymentException;
import org.com.microservicepayment.exceptions.PaymentNotFoundException;
import org.com.microservicepayment.proxies.MicroserviceCommandProxy;
import org.com.microservicepayment.proxies.MicroserviceProductProxy;
import org.com.microservicepayment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentService {
    private PaymentRepository paymentRepository;
    private MicroserviceCommandProxy commandProxy;
    private MicroserviceProductProxy productProxy;

    public List<Payment> findAllPayments(){
        List<Payment> payments=paymentRepository.findAll();
        if (payments.isEmpty()) throw new PaymentNotFoundException();
        return payments;
    }

    public Payment findPaymentById(Integer id){
        return paymentRepository.findById(id).orElseThrow(PaymentNotFoundException::new);
    }

    public Payment savePayment(Integer commandId, PaymentType type){
        Optional<Payment> existingPayment=paymentRepository.findByCommandId(commandId);
        if(existingPayment.isPresent()) throw new ExistingPaymentException("This command is already paid");

        CommandBean command=commandProxy.findByCommandId(commandId);
        command.setPaidCommand(true);
        commandProxy.updateCommand(command.getId(), command.isPaidCommand());

        ProductBean product=productProxy.findProductById(command.getProductId());

        double amountProduct= product.getPrice();
        double totalAmount=command.getQuantity()*amountProduct;

        return paymentRepository.save(Payment.builder()
                        .commandId(commandId)
                        .amount(totalAmount)
                        .type(type)
                        .status(PaymentStatus.CREATED)
                        .build());
    }

    public Payment updatePaymentStatus(Integer paymentId, PaymentStatus status){
        Payment payment=findPaymentById(paymentId);
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }
}
