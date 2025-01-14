package com.itsthatjun.ecommerce.model.entity;

import com.itsthatjun.ecommerce.enums.type.UpdateActionType;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("article_change_log")
public class ArticleChangeLog {
    @Id
    private Integer id;

    private Integer articleId;

    private UpdateActionType updateAction;

    private String description;

    private String operator;

    private LocalDateTime createdAt;
}