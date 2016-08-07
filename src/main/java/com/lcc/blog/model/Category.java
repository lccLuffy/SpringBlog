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


    @OneToMany(mappedBy = "category")
    private List<Article> articles = new ArrayList<Article>();
}
