package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "teacher", schema = "kampus_old", catalog = "")
public class TeacherEntity {
    private int id;
    private int userId;
    private int departmentId;
    private Collection<CourseSemesterUnitReaderEntity> courseSemesterUnitReadersById;
    private Collection<StudentTranscriptFieldEntity> studentTranscriptFieldsById;
    private UserAccountOldEntity userAccountOldByUserId;
    //private DepartmentEntity departmentByDepartmentId;
    private Collection<TeacherAcademicTitlesEntity> teacherAcademicTitlesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "department_id", nullable = false)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        return id == that.id &&
                userId == that.userId &&
                departmentId == that.departmentId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, departmentId);
    }

    @OneToMany(mappedBy = "teacherByTeacherId")
    public Collection<CourseSemesterUnitReaderEntity> getCourseSemesterUnitReadersById() {
        return courseSemesterUnitReadersById;
    }

    public void setCourseSemesterUnitReadersById(Collection<CourseSemesterUnitReaderEntity> courseSemesterUnitReadersById) {
        this.courseSemesterUnitReadersById = courseSemesterUnitReadersById;
    }

    @OneToMany(mappedBy = "teacherByTeacherId")
    public Collection<StudentTranscriptFieldEntity> getStudentTranscriptFieldsById() {
        return studentTranscriptFieldsById;
    }

    public void setStudentTranscriptFieldsById(Collection<StudentTranscriptFieldEntity> studentTranscriptFieldsById) {
        this.studentTranscriptFieldsById = studentTranscriptFieldsById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserAccountOldEntity getUserAccountOldByUserId() {
        return userAccountOldByUserId;
    }

    public void setUserAccountOldByUserId(UserAccountOldEntity userAccountOldByUserId) {
        this.userAccountOldByUserId = userAccountOldByUserId;
    }
/*
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    public DepartmentEntity getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(DepartmentEntity departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }
//*/
    @OneToMany(mappedBy = "teacherByTeacherId")
    public Collection<TeacherAcademicTitlesEntity> getTeacherAcademicTitlesById() {
        return teacherAcademicTitlesById;
    }

    public void setTeacherAcademicTitlesById(Collection<TeacherAcademicTitlesEntity> teacherAcademicTitlesById) {
        this.teacherAcademicTitlesById = teacherAcademicTitlesById;
    }
}
