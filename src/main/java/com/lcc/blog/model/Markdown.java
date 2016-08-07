package com.lcc.blog.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by lcc_luffy on 2016/8/7.
 */
@Entity
public class Markdown extends BaseModel {
    @Column(nullable = false)
    private String title;

    @Type(type = "text")
    private String content;
}
