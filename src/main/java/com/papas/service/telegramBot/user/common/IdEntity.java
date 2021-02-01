package com.papas.service.telegramBot.user.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.proxy.HibernateProxyHelper;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Pavel on 19.04.2016.
 */
@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class IdEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    protected Long id;

    public IdEntity(Long id) {
        this.id = id;
    }

    public IdEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() && getClass() != HibernateProxyHelper.getClassWithoutInitializingProxy(o))
            return false;

        IdEntity that = (IdEntity) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
