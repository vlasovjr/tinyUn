package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "classroom_info", schema = "kampus_old", catalog = "")
public class ClassroomInfoEntity {
    private int id;
    private String address;
    private String number;
    private int size;
    private Collection<CourseTimetableTmpChangesEntity> courseTimetableTmpChangesById;
    private Collection<ClassroomContentEntity> classroomContentsById;
    private Collection<CourseTimetableSlotEntity> courseTimetableSlotsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 45)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "size", nullable = false)
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomInfoEntity that = (ClassroomInfoEntity) o;
        return id == that.id &&
                size == that.size &&
                Objects.equals(address, that.address) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, address, number, size);
    }

    @OneToMany(mappedBy = "classroomInfoByClassroomId")
    public Collection<CourseTimetableTmpChangesEntity> getCourseTimetableTmpChangesById() {
        return courseTimetableTmpChangesById;
    }

    public void setCourseTimetableTmpChangesById(Collection<CourseTimetableTmpChangesEntity> courseTimetableTmpChangesById) {
        this.courseTimetableTmpChangesById = courseTimetableTmpChangesById;
    }

    @OneToMany(mappedBy = "classroomInfoByClassroomId")
    public Collection<ClassroomContentEntity> getClassroomContentsById() {
        return classroomContentsById;
    }

    public void setClassroomContentsById(Collection<ClassroomContentEntity> classroomContentsById) {
        this.classroomContentsById = classroomContentsById;
    }

    @OneToMany(mappedBy = "classroomInfoByClassroomId")
    public Collection<CourseTimetableSlotEntity> getCourseTimetableSlotsById() {
        return courseTimetableSlotsById;
    }

    public void setCourseTimetableSlotsById(Collection<CourseTimetableSlotEntity> courseTimetableSlotsById) {
        this.courseTimetableSlotsById = courseTimetableSlotsById;
    }
}
