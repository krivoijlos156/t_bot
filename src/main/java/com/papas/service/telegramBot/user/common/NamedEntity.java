package com.papas.service.telegramBot.user.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by Pavel on 19.04.2016.
 */
@MappedSuperclass
public abstract class NamedEntity extends IdEntity {
    @Column(nullable = false)
    protected String name;

    public NamedEntity() {
    }

    protected NamedEntity(Long id, String name) {
        super(id);
        this.name = name;
    }

    public NamedEntity(Long id) {
        super(id);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                super.toString() +
                "name='" + name + '\'' +
                "}";
    }
}
