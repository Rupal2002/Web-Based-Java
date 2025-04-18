package com.museum.Service;

public class ResourceAreadyExistException extends RuntimeException 
{
	public ResourceAreadyExistException(String message)
	{
		super(message);
	}

}
