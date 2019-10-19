package service;

import bean.Article;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    /**
     * 保存文章信息
     * @param article
     * @return
     */
//    @Transactional
    public Article saveOrUpdateArticle(Article article) {
        return articleRepository.save(article);
    }
}
