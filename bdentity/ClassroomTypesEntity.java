package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "classroom_types", schema = "kampus_old", catalog = "")
public class ClassroomTypesEntity {
    private int id;
    private String type;
    private Collection<ClassroomContentEntity> classroomContentsById;
    private Collection<CourseSemesterRequiredEntity> courseSemesterRequiredsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomTypesEntity that = (ClassroomTypesEntity) o;
        return id == that.id &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type);
    }

    @OneToMany(mappedBy = "classroomTypesByTypeId")
    public Collection<ClassroomContentEntity> getClassroomContentsById() {
        return classroomContentsById;
    }

    public void setClassroomContentsById(Collection<ClassroomContentEntity> classroomContentsById) {
        this.classroomContentsById = classroomContentsById;
    }

    @OneToMany(mappedBy = "classroomTypesByClassroomTypeId")
    public Collection<CourseSemesterRequiredEntity> getCourseSemesterRequiredsById() {
        return courseSemesterRequiredsById;
    }

    public void setCourseSemesterRequiredsById(Collection<CourseSemesterRequiredEntity> courseSemesterRequiredsById) {
        this.courseSemesterRequiredsById = courseSemesterRequiredsById;
    }
}
