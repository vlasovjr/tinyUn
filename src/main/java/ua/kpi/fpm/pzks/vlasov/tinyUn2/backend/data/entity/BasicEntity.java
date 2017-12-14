package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;

@MappedSuperclass
public abstract class BasicEntity implements Serializable {
    @Transient
    public abstract int getEntityId();
    @Transient
    public abstract void setFatherId(int id);
}
