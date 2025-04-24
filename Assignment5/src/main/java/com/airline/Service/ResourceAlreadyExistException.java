package com.airline.Service;

public class ResourceAlreadyExistException extends RuntimeException 
{
   public ResourceAlreadyExistException(String message)
   {
	   super(message);
   }
}
