package com.mueseum;

import java.sql.SQLException;
import java.time.LocalDate;

import java.util.Scanner;

import com.mueseum.entity.Category;
import com.museum.Service.ArticleService;

public class ArticleMain 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		ArticleService service = null;
		try
		{
			 service = new ArticleService();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		boolean exit = true;
		while(exit)
		{
			System.out.println("------------------Menu---------------------"
					+ "\n1. Add Article. "
					+ "\n2. DisplayAll Articles."
					+ "\n3. Display Details of Article."
					+ "\n4. Update Articles."
					+ "\n5. Delete Articles."
					+ "\n0. Exit");
			int ch = sc.nextInt();
			switch(ch)
		{
			case 1:
			{
				try
				{
					System.out.println("Enter article name,category(PAINTING, SCULPTURE, ARTIFACT),created date, creator name, ");
					String name =  sc.next();
					Category category = Category.valueOf(sc.next());
					LocalDate date = LocalDate.parse(sc.next());
					
					String creatorName = sc.next();
					service.addArticle(name, category, date, creatorName);
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				break;
			}
			
			case 2:
			{
				try
				{
					service.getAllArticle();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				break;
			}
			
			case 3:
			{
				try
				{
					System.out.println("Enter article id :");
					service.displayArticleDetails(sc.nextInt());
				}
				catch(SQLException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			}
			
			case 4:
			{
				try
				{
					System.out.println("Enter article id,article name,category(PAINTING, SCULPTURE, ARTIFACT),created date, creator name");
					service.updateArticle(sc.nextInt(),sc.next(),Category.valueOf(sc.next()),LocalDate.parse(sc.next()),sc.next());
				}
				catch(SQLException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			}
			case 5:
			{
				try
				{
					System.out.println("Enter article id you want to delete:");
					service.deleteArticle(sc.nextInt());
				}
				catch(SQLException e)
				{
					System.err.println(e.getMessage());
				}
				break;
			}
			case 0:
			{
				exit = false;
				System.out.println("Thank you");
				break;
			}
			default:
				System.out.println("Invalid choice!!! try Again ");
		}
		}

	}

}
