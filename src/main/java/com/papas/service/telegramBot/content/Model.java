package com.papas.service.telegramBot.content;

import com.papas.service.telegramBot.hashtag.HashTag;
import com.papas.service.telegramBot.user.common.NamedAuditedEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "model")
public class Model extends NamedAuditedEntity {
    private Integer breastSize;
    private Integer age;
    private Integer height;
    @Column(nullable = false, unique = true)
    private String contentPath;

    @ManyToMany
    @JoinTable(
            name = "model_hashtag", indexes = @Index(columnList = "hashtag_id"),
            joinColumns = {@JoinColumn(name = "model_id")},
            inverseJoinColumns = {@JoinColumn(name = "hashtag_id")}
    )
    private Set<HashTag> hashTags = new HashSet<>();


    public Integer getBreastSize() {
        return breastSize;
    }

    public void setBreastSize(Integer breastSize) {
        this.breastSize = breastSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getContentPath() {
        return contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }
}
