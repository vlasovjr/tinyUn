package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course_semester_unit_reader", schema = "kampus_old", catalog = "")
public class CourseSemesterUnitReaderEntity {
    private int id;
    private int teacherId;
    private int courseSemesterInfoId;
    private Integer lessonType;
    private int year;
    private Byte firstHalfyear;
    private Collection<CourseSemesterUnitGroupEntity> courseSemesterUnitGroupsById;
    private TeacherEntity teacherByTeacherId;
    private CourseSemesterInfoEntity courseSemesterInfoByCourseSemesterInfoId;
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
    @Column(name = "teacher_id", nullable = false)
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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
    @Column(name = "lesson_type", nullable = true)
    public Integer getLessonType() {
        return lessonType;
    }

    public void setLessonType(Integer lessonType) {
        this.lessonType = lessonType;
    }

    @Basic
    @Column(name = "year", nullable = true)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "first_halfyear", nullable = true)
    public Byte getFirstHalfyear() {
        return firstHalfyear;
    }

    public void setFirstHalfyear(Byte firstHalfyear) {
        this.firstHalfyear = firstHalfyear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSemesterUnitReaderEntity that = (CourseSemesterUnitReaderEntity) o;
        return id == that.id &&
                teacherId == that.teacherId &&
                courseSemesterInfoId == that.courseSemesterInfoId &&
                year == that.year &&
                Objects.equals(lessonType, that.lessonType) &&
                Objects.equals(firstHalfyear, that.firstHalfyear);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, teacherId, courseSemesterInfoId, lessonType, year, firstHalfyear);
    }

    @OneToMany(mappedBy = "courseSemesterUnitReaderByCourseSemesterUnitReaderId")
    public Collection<CourseSemesterUnitGroupEntity> getCourseSemesterUnitGroupsById() {
        return courseSemesterUnitGroupsById;
    }

    public void setCourseSemesterUnitGroupsById(Collection<CourseSemesterUnitGroupEntity> courseSemesterUnitGroupsById) {
        this.courseSemesterUnitGroupsById = courseSemesterUnitGroupsById;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    public TeacherEntity getTeacherByTeacherId() {
        return teacherByTeacherId;
    }

    public void setTeacherByTeacherId(TeacherEntity teacherByTeacherId) {
        this.teacherByTeacherId = teacherByTeacherId;
    }

    @ManyToOne
    @JoinColumn(name = "course_semester_info_id", referencedColumnName = "id", nullable = false)
    public CourseSemesterInfoEntity getCourseSemesterInfoByCourseSemesterInfoId() {
        return courseSemesterInfoByCourseSemesterInfoId;
    }

    public void setCourseSemesterInfoByCourseSemesterInfoId(CourseSemesterInfoEntity courseSemesterInfoByCourseSemesterInfoId) {
        this.courseSemesterInfoByCourseSemesterInfoId = courseSemesterInfoByCourseSemesterInfoId;
    }

    @OneToMany(mappedBy = "courseSemesterUnitReaderByCourseReaderId")
    public Collection<CourseTimetableSlotEntity> getCourseTimetableSlotsById() {
        return courseTimetableSlotsById;
    }

    public void setCourseTimetableSlotsById(Collection<CourseTimetableSlotEntity> courseTimetableSlotsById) {
        this.courseTimetableSlotsById = courseTimetableSlotsById;
    }
}
