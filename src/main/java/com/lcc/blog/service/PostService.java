package com.lcc.blog.service;

import com.lcc.blog.model.Post;
import com.lcc.blog.model.form.PostForm;
import com.lcc.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by lcc_luffy on 2016/7/24.
 */
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Page<Post> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Post getPost(Long id) {
        return postRepository.findOne(id);
    }

    public void createPost(PostForm postForm) {
        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setContent(postForm.getContent());
        post.setHtmlContent(postForm.getHtmlContent());
        post.setPostStatus(postForm.getPostStatus());
        postRepository.save(post);
    }
}
