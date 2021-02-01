package com.papas.service.telegramBot.hashtag;

import com.papas.service.telegramBot.content.Model;
import com.papas.service.telegramBot.user.common.NamedEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class HashTag extends NamedEntity {

    @ManyToMany(mappedBy = "hashTags", fetch = FetchType.LAZY)
    private Set<Model> models = new HashSet<>();

    public HashTag() {
    }

    public HashTag(String name) {
        this.name = name;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }
}
