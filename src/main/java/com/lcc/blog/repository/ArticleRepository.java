package com.lcc.blog.repository;

import com.lcc.blog.model.Article;
import com.lcc.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByUser(User user);
}
