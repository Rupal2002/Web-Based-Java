package com.museum.Service;

public class ResourceNotFoundArticle extends RuntimeException 
{
   public  ResourceNotFoundArticle(String message)
   {
	   super(message);
   }
}
