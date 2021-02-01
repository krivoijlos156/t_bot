package com.papas.service.telegramBot.user.common;

import java.util.Date;

public interface Auditable {
    Date getCreated();

    void setCreated(Date created);

    Date getModified();

    void setModified(Date modified);
}
