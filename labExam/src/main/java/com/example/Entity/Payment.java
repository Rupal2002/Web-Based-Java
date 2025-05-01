package com.example.Entity;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Payment 
{ 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 30)
    private String paymentMode;
	
	@Enumerated(EnumType.STRING)
    private Status status;
	
	
    private LocalDate paymentDate;
   
    private Double amount;
    
	public Payment() 
	{
		
	}

	public Payment(Integer id, String paymentMode, Status status, LocalDate paymentDate, Double amount) {
		super();
		this.id = id;
		this.paymentMode = paymentMode;
		this.status = status;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getPaymentMode() 
	{
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) 
	{
		this.paymentMode = paymentMode;
	}

	public Status getStatus() 
	{
		return status;
	}

	public void setStatus(Status status) 
	{
		this.status = status;
	}

	public LocalDate getPaymentDate() 
	{
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) 
	{
		this.paymentDate = paymentDate;
	}

	public Double getAmount() 
	{
		return amount;
	}

	public void setAmount(Double amount) 
	{
		this.amount = amount;
	}

	@Override
	public String toString() 
	{
		return "Payment [id=" + id + ", paymentMode=" + paymentMode + ", status=" + status + ", paymentDate="
				+ paymentDate + ", amount=" + amount + "]";
	}
   
}
