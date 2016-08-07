package com.lcc.blog.model;

import com.lcc.blog.model.support.ArticleStatus;
import com.lcc.blog.model.support.ArticleType;

import javax.persistence.*;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@Entity
public class Article extends BaseModel {
    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String title;

    private String author;

    private String originUrl;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ArticleStatus articleStatus = ArticleStatus.PUBLISHED;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ArticleType articleType = ArticleType.ARTICLE;

    @ManyToOne
    private Category category;

}
