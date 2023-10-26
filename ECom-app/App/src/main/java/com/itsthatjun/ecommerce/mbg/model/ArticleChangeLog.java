package com.itsthatjun.ecommerce.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ArticleChangeLog implements Serializable {
    private Integer id;

    private Integer articleId;

    private String updateAction;

    private String changeOperator;

    private Date createdAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(String updateAction) {
        this.updateAction = updateAction;
    }

    public String getChangeOperator() {
        return changeOperator;
    }

    public void setChangeOperator(String changeOperator) {
        this.changeOperator = changeOperator;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}