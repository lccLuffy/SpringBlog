package com.lcc.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by lcc_luffy on 2016/8/7.
 */
@Entity
public class Folder extends BaseModel {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Category category;
}
