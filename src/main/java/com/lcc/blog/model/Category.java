package com.lcc.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcc_luffy on 2016/8/7.
 */
@Entity
public class Category extends BaseModel {
    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Column(nullable = false)

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Article> articles = new ArrayList<Article>();
}
