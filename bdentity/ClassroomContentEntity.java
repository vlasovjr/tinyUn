package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "classroom_content", schema = "kampus_old", catalog = "")
public class ClassroomContentEntity {
    private int id;
    private int classroomId;
    private int typeId;
    private ClassroomInfoEntity classroomInfoByClassroomId;
    private ClassroomTypesEntity classroomTypesByTypeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "classroom_id", nullable = false)
    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    @Basic
    @Column(name = "type_id", nullable = false)
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomContentEntity that = (ClassroomContentEntity) o;
        return id == that.id &&
                classroomId == that.classroomId &&
                typeId == that.typeId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, classroomId, typeId);
    }

    @ManyToOne
    @JoinColumn(name = "classroom_id", referencedColumnName = "id", nullable = false)
    public ClassroomInfoEntity getClassroomInfoByClassroomId() {
        return classroomInfoByClassroomId;
    }

    public void setClassroomInfoByClassroomId(ClassroomInfoEntity classroomInfoByClassroomId) {
        this.classroomInfoByClassroomId = classroomInfoByClassroomId;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    public ClassroomTypesEntity getClassroomTypesByTypeId() {
        return classroomTypesByTypeId;
    }

    public void setClassroomTypesByTypeId(ClassroomTypesEntity classroomTypesByTypeId) {
        this.classroomTypesByTypeId = classroomTypesByTypeId;
    }
}
