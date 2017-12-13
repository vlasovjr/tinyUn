package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_semester_required", schema = "kampus_old", catalog = "")
public class CourseSemesterRequiredEntity {
    private int id;
    private int courseSemesterInfoId;
    private int classroomTypeId;
    private CourseSemesterInfoEntity courseSemesterInfoByCourseSemesterInfoId;
    private ClassroomTypesEntity classroomTypesByClassroomTypeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "course_semester_info_id", nullable = false)
    public int getCourseSemesterInfoId() {
        return courseSemesterInfoId;
    }

    public void setCourseSemesterInfoId(int courseSemesterInfoId) {
        this.courseSemesterInfoId = courseSemesterInfoId;
    }

    @Basic
    @Column(name = "classroom_type_id", nullable = false)
    public int getClassroomTypeId() {
        return classroomTypeId;
    }

    public void setClassroomTypeId(int classroomTypeId) {
        this.classroomTypeId = classroomTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSemesterRequiredEntity that = (CourseSemesterRequiredEntity) o;
        return id == that.id &&
                courseSemesterInfoId == that.courseSemesterInfoId &&
                classroomTypeId == that.classroomTypeId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, courseSemesterInfoId, classroomTypeId);
    }

    @ManyToOne
    @JoinColumn(name = "course_semester_info_id", referencedColumnName = "id", nullable = false)
    public CourseSemesterInfoEntity getCourseSemesterInfoByCourseSemesterInfoId() {
        return courseSemesterInfoByCourseSemesterInfoId;
    }

    public void setCourseSemesterInfoByCourseSemesterInfoId(CourseSemesterInfoEntity courseSemesterInfoByCourseSemesterInfoId) {
        this.courseSemesterInfoByCourseSemesterInfoId = courseSemesterInfoByCourseSemesterInfoId;
    }

    @ManyToOne
    @JoinColumn(name = "classroom_type_id", referencedColumnName = "id", nullable = false)
    public ClassroomTypesEntity getClassroomTypesByClassroomTypeId() {
        return classroomTypesByClassroomTypeId;
    }

    public void setClassroomTypesByClassroomTypeId(ClassroomTypesEntity classroomTypesByClassroomTypeId) {
        this.classroomTypesByClassroomTypeId = classroomTypesByClassroomTypeId;
    }
}
