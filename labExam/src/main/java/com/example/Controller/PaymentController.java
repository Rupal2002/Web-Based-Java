package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Payment;
import com.example.Service.PaymentService;

@RestController
public class PaymentController 
{
	@Autowired
    private PaymentService paymentService;
	
	 @PostMapping("/add")
	    public void addPayment(@RequestBody Payment newPayment) 
	 {
	        paymentService.addPayment(newPayment);
	    }
	
	@GetMapping("/payments")
	public List<Payment> getAllPayments()
	{
		return paymentService.allPayments();
	}
	
	@GetMapping("/payments/{id}")
	public Payment getPaymentById(@PathVariable Integer id)
	{
		Payment foundPayment = null;
		try
		{
			foundPayment = paymentService.getPayment(id);
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
		return foundPayment;
	}
	
	@PutMapping("/update/{id}")
	 public String updatePayment(@PathVariable Integer id, @RequestBody Payment updatedPayment)
	 {
		 try
		 {
			 return paymentService.updatePayment(id, updatedPayment);
		 }
		 catch(Exception ex)
		 {
			 return ex.getMessage();
		 }
	 }
	
	@DeleteMapping("/delete/{id}")
	public String deleteMobileById(@PathVariable Integer id)
	{
		try
		{
			return paymentService.deletePayment(id);
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
	}
}
