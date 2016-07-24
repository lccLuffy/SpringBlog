package com.lcc.blog.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Date updatedAt;

    @PrePersist
    public void prePersist()
    {
        createdAt = updatedAt = new Date();
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = new Date();
    }

}
