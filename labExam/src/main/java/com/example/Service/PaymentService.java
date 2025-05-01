package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.PaymentRepository;
import com.example.Entity.Payment;
import com.example.Exception.ResourceNotFoundException;

@Service
public class PaymentService 
{
   @Autowired PaymentRepository paymentRepo;
   
   public void addPayment(Payment newPayment)
   {
	   paymentRepo.save(newPayment);
	   System.out.println("Payment created successfully");
   }
   
   public List<Payment> allPayments()
   {
	   return paymentRepo.findAll();
   }
   
   public Payment getPayment(Integer id)
   {
	   Payment existingPayment =paymentRepo.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Payment not found by id:" + id));
	   return existingPayment;
   }
   public String updatePayment(Integer id, Payment updatedPayment)
   {
	   Payment existingAmount =paymentRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Payment not found by id:" + id));
	   Double updatedAmount = updatedPayment.getAmount();
	   
	   existingAmount.setAmount(updatedAmount);
	   paymentRepo.save(existingAmount);
	   return "Payment updated Successfully";
   }
   
   public String deletePayment(Integer id)
   {

	   Payment foundPayment =paymentRepo.findById(id)
	   .orElseThrow(()-> new ResourceNotFoundException("Payment not found by id:" + id));
	   paymentRepo.delete(foundPayment);
	   return "Payment deleted Succesfully";
   }
}
