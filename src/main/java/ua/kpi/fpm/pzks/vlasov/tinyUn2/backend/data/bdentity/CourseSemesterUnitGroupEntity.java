package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_semester_unit_group", schema = "kampus_old", catalog = "")
public class CourseSemesterUnitGroupEntity {
    private int id;
    private int studentGroupInfoId;
    private int courseSemesterUnitReaderId;
    private StudentGroupInfoEntity studentGroupInfoByStudentGroupInfoId;
    private CourseSemesterUnitReaderEntity courseSemesterUnitReaderByCourseSemesterUnitReaderId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_group_info_id", nullable = false)
    public int getStudentGroupInfoId() {
        return studentGroupInfoId;
    }

    public void setStudentGroupInfoId(int studentGroupInfoId) {
        this.studentGroupInfoId = studentGroupInfoId;
    }

    @Basic
    @Column(name = "course_semester_unit_reader_id", nullable = false)
    public int getCourseSemesterUnitReaderId() {
        return courseSemesterUnitReaderId;
    }

    public void setCourseSemesterUnitReaderId(int courseSemesterUnitReaderId) {
        this.courseSemesterUnitReaderId = courseSemesterUnitReaderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSemesterUnitGroupEntity that = (CourseSemesterUnitGroupEntity) o;
        return id == that.id &&
                studentGroupInfoId == that.studentGroupInfoId &&
                courseSemesterUnitReaderId == that.courseSemesterUnitReaderId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, studentGroupInfoId, courseSemesterUnitReaderId);
    }

    @ManyToOne
    @JoinColumn(name = "student_group_info_id", referencedColumnName = "id", nullable = false)
    public StudentGroupInfoEntity getStudentGroupInfoByStudentGroupInfoId() {
        return studentGroupInfoByStudentGroupInfoId;
    }

    public void setStudentGroupInfoByStudentGroupInfoId(StudentGroupInfoEntity studentGroupInfoByStudentGroupInfoId) {
        this.studentGroupInfoByStudentGroupInfoId = studentGroupInfoByStudentGroupInfoId;
    }

    @ManyToOne
    @JoinColumn(name = "course_semester_unit_reader_id", referencedColumnName = "id", nullable = false)
    public CourseSemesterUnitReaderEntity getCourseSemesterUnitReaderByCourseSemesterUnitReaderId() {
        return courseSemesterUnitReaderByCourseSemesterUnitReaderId;
    }

    public void setCourseSemesterUnitReaderByCourseSemesterUnitReaderId(CourseSemesterUnitReaderEntity courseSemesterUnitReaderByCourseSemesterUnitReaderId) {
        this.courseSemesterUnitReaderByCourseSemesterUnitReaderId = courseSemesterUnitReaderByCourseSemesterUnitReaderId;
    }
}
