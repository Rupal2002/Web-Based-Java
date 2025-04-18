package com.museum.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import com.mueseum.Dao.ArticleDao;
import com.mueseum.entity.Article;
import com.mueseum.entity.Category;

public class ArticleService {
	private ArticleDao articleDao;

	public ArticleService() throws SQLException {
		articleDao = new ArticleDao();
	}

	public void addArticle(String name, Category category, LocalDate createdDate, String creatorName)
			throws SQLException {
		Optional<Article> existingArticle = articleDao.findAll().stream()

				.filter(article -> article.getName().equalsIgnoreCase(name)).findFirst();
		if (existingArticle.isEmpty()) {
			Article newArticle = new Article(null, name, category, createdDate, creatorName);
			boolean status = articleDao.save(newArticle);
			if (status) {
				System.out.println("Article added Successfully!!");
			} else {
				System.out.println("Article failed to add!!!");
			}
		} else {
			throw new ResourceAreadyExistException("Article already exist with same name : " + name);
		}

	}

	public void getAllArticle() throws SQLException {
		articleDao.findAll().stream().forEach(article -> System.out.println(article));
	}

	public void displayArticleDetails(Integer id) throws SQLException {
		Article foundArticle = articleDao.findById(id);
		if (foundArticle != null) {
			System.out.println(foundArticle);
		} else {
			throw new ResourceNotFoundArticle("Article not found of id : " + id);
		}
	}

	public void updateArticle(Integer id, String name, Category category, LocalDate createdDate, String creatorName)
			throws SQLException {
		Article foundArticle = articleDao.findById(id);
		if (foundArticle != null) {
			Article article = new Article(id, name, category, createdDate, creatorName);
			articleDao.update(article);
		} else
			throw new ResourceNotFoundArticle("Article not found of id : " + id);
	}

	public void deleteArticle(Integer id) throws SQLException {
		Article foundArticle = articleDao.findById(id);
		if (foundArticle != null) {
			articleDao.delete(id);
		} else
			throw new ResourceNotFoundArticle("Article not found of id : " + id);
	}
}
