package com.papas.service.telegramBot.user.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by Pavel on 19.04.2016.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class IdAuditedEntity extends IdEntity implements Auditable {
    @CreatedDate
    @JsonIgnore
    private Date created;

    @LastModifiedDate
    @JsonIgnore
    private Date modified;

    public IdAuditedEntity() {
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
