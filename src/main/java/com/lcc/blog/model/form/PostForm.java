package com.lcc.blog.model.form;

import com.lcc.blog.model.support.ArticleStatus;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by lcc_luffy on 2016/7/27.
 */
public class PostForm {
    @NotNull
    @Min(1)
    private String title;

    @NotNull
    @Min(1)
    private String content;

    private String htmlContent;

    private ArticleStatus postStatus = ArticleStatus.PUBLISHED;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public ArticleStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(ArticleStatus postStatus) {
        this.postStatus = postStatus;
    }
}
