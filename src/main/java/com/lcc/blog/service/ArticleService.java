package com.lcc.blog.service;

import com.lcc.blog.model.Article;
import com.lcc.blog.model.form.PostForm;
import com.lcc.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lcc_luffy on 2016/7/24.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Page<Article> getAllPosts(Pageable pageable) {
        PageRequest pageRequest = new PageRequest(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.Direction.DESC,
                "updatedAt"
        );
        return articleRepository.findAll(pageRequest);
    }

    public Article getPost(Long id) {
        return articleRepository.findOne(id);
    }

    public void createPost(PostForm postForm) {

    }

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public void deleteOne(Long id) {
        articleRepository.delete(id);
    }

    public void save(Article post) {
        articleRepository.save(post);
    }
}
