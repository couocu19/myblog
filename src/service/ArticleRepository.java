package service;


import bean.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

public abstract class ArticleRepository implements PagingAndSortingRepository<Article,Integer> {

    }

