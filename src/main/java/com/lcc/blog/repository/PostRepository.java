package com.lcc.blog.repository;

import com.lcc.blog.model.Post;
import com.lcc.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lcc_luffy on 2016/7/23.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);
}
