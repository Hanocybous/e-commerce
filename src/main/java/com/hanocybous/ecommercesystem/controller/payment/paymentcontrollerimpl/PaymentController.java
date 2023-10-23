package com.hanocybous.ecommercesystem.controller.payment.paymentcontrollerimpl;

import com.hanocybous.ecommercesystem.controller.payment.IPaymentController;
import com.hanocybous.ecommercesystem.dto.payment.PaymentDto;
import com.hanocybous.ecommercesystem.entity.payment.Payment;
import com.hanocybous.ecommercesystem.entity.payment.PaymentMethod;
import com.hanocybous.ecommercesystem.service.payment.paymentimpl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/v1/payment")
public class PaymentController implements IPaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment/total")
    @ResponseBody
    public Double getTotalAmountOfPayments(@RequestBody(required = false) String paymentMethod,
                                           @RequestBody(required = false) String paymentStatus) {
        return paymentService.getTotalAmountOfPayments();
    }

    @GetMapping("/payment/{paymentStatus}")
    @ResponseBody
    public Double getTotalAmountOfPaymentsByPaymentStatus(
            @RequestBody
            @PathVariable String paymentStatus) {
        if (paymentStatus == null) {
            return paymentService.getTotalAmountOfPayments();
        }
        return paymentService.getTotalAmountOfPaymentsByPaymentStatus(paymentStatus);
    }

    @GetMapping("/payment/{paymentMethod}/{paymentStatus}")
    @ResponseBody
    public Double getTotalAmountOfPaymentsByPaymentMethodAndPaymentStatus(
            @RequestBody
            @PathVariable String paymentMethod,
            @RequestBody
            @PathVariable String paymentStatus) {
        if (paymentMethod == null && paymentStatus == null) {
            return paymentService.getTotalAmountOfPayments();
        }
        if (paymentMethod == null) {
            return paymentService.getTotalAmountOfPaymentsByPaymentStatus(paymentStatus);
        }
        if (paymentStatus == null) {
            return paymentService.getTotalAmountOfPaymentsByPaymentMethod(paymentMethod);
        }
        return paymentService.getTotalAmountOfPaymentsByPaymentMethodAndPaymentStatus(
                paymentMethod,
                paymentStatus);
    }

    @PostMapping("/payment/create")
    @ResponseBody
    public Double createPayment(@RequestBody String paymentMethod,
                                @RequestBody Double amount,
                                @RequestBody Long orderId) {
        return paymentService.createPayment(
                PaymentMethod.valueOf(paymentMethod),
                amount,
                orderId).getAmount();
    }

    @PostMapping("/payment/create/{paymentMethod}/{amount}/{paymentStatus}")
    public Payment createPayment(
                                 @RequestBody
                                 @PathVariable PaymentMethod paymentMethod,
                                 @RequestBody
                                 @PathVariable Double amount,
                                 @RequestBody
                                 @PathVariable String paymentStatus) {
        return paymentService.createPayment(
                paymentMethod,
                amount,
                paymentStatus);
    }

    @GetMapping("/payment/{paymentId}")
    @ResponseBody
    public List<PaymentDto> getPaymentById(
            @RequestBody
            @PathVariable Long paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @GetMapping("/payment/{paymentMethod}")
    @ResponseBody
    public List<PaymentDto> getPaymentByPaymentMethod(
            @RequestBody
            @PathVariable String paymentMethod) {
        return paymentService.getPaymentByPaymentMethod(paymentMethod);
    }

    @DeleteMapping("/payment/{paymentId}")
    @ResponseBody
    public void deletePaymentById(
            @RequestBody
            @PathVariable Long paymentId) {
        paymentService.deletePaymentById(paymentId);
    }

    @DeleteMapping("/payment/{paymentMethod}")
    @ResponseBody
    public void deletePaymentByPaymentMethod(
            @RequestBody
            @PathVariable String paymentMethod) {
        paymentService.deletePaymentByPaymentMethod(PaymentMethod.valueOf(paymentMethod));
    }

    @DeleteMapping("/payment/{paymentStatus}")
    @ResponseBody
    public void deletePaymentByPaymentStatus(
            @RequestBody
            @PathVariable String paymentStatus) {
        paymentService.deletePaymentByPaymentStatus(paymentStatus);
    }

    @GetMapping("/payment/all")
    @ResponseBody
    public List<PaymentDto> getAllPayments() {
        return paymentService.findAllPayments();
    }

}
