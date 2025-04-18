package com.mueseum.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import com.mueseum.entity.Article;
import com.mueseum.entity.Category;

import Utils.jdbcUtils;

public class ArticleDao implements jdbcDao<Article , Integer>
{
    private Connection con;
    private String query;
    private PreparedStatement pstm;
    private Statement stm;
    
    
    public ArticleDao() throws SQLException
    {
    	con = jdbcUtils.getDbConnection();
    }
    
	@Override
	public Boolean save(Article article) throws SQLException 
	{
		query = "insert into article values(?,?,?,?,?)";
		pstm = con.prepareStatement(query);
		pstm.setInt(1,0);
		pstm.setString(2,article.getName());
		pstm.setString(3,article.getCategory().toString());
		pstm.setDate(4,Date.valueOf(article.getCreatedDate()));
		pstm.setString(5,article.getCreatorName());
		int count = pstm.executeUpdate();
		if(count> 0)
		{
			System.out.println(count + " row inserted");
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Collection<Article> findAll() throws SQLException 
	{
		List<Article> articles = new ArrayList<Article>();
		query = "Select * from article";
		stm= con.createStatement();
		ResultSet rs = stm.executeQuery(query);
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			Category category = Category.valueOf(rs.getString("category"));
			LocalDate date = rs.getDate("date_created").toLocalDate();
			String creatorName = rs.getString("creator_name");
			Article article = new Article(id, name, category, date, creatorName);
					
			articles.add(article);
					
		}
		return articles;
	}

	@Override
	public Article findById(Integer key) throws SQLException 
	{
		Article foundArticle = null;
		query = "Select * from article where id = ?";
		pstm = con.prepareStatement(query);
		pstm.setInt(1,key);
		ResultSet rs = pstm.executeQuery();
		while(rs.next())
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			Category category = Category.valueOf(rs.getString("category"));
			LocalDate date = rs.getDate("date_created").toLocalDate();
			String creatorName = rs.getString("creator_name");
			foundArticle = new Article(id, name, category, date, creatorName);
		}
		return foundArticle;
	}

	@Override
	public void update(Article modifiedArticle) throws SQLException 
	{
		String sqlQuery = "update article set name = ?, category = ?, Date_created = ?, creator_Name = ?,  where id = ?";
		pstm = con.prepareStatement(sqlQuery); 
		int id = modifiedArticle.getId();
		String name = modifiedArticle.getName();
		Category category = modifiedArticle.getCategory();
	    LocalDate date = modifiedArticle.getCreatedDate();
	    String creatorName = modifiedArticle.getCreatorName();
	    pstm.setString(1, name);
	    pstm.setString(2, category.toString());
	    pstm.setDate(3, Date.valueOf(date));
	    pstm.setString(4, creatorName);
	    pstm.setInt(5, id);

		int updateCount = pstm.executeUpdate();
		System.out.println(updateCount + " record Updated ");	
	}

	@Override
	public void delete(Integer key) throws SQLException
	{
		String sqlQuery = " delete  from article where id = ?";
		pstm = con.prepareStatement(sqlQuery);
		pstm.setInt(1, key);

	    int deleteCount = pstm.executeUpdate();
	    if (deleteCount > 0)
	    {
	        System.out.println(deleteCount + " record(s) deleted.");
	    } else
	    {
	        System.out.println("No record found with ID: " + key);
	    }
	}
		
	
   
}
