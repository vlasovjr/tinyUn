package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course_timetable_slot", schema = "kampus_old", catalog = "")
public class CourseTimetableSlotEntity {
    private int id;
    private int courseReaderId;
    private int day;
    private int number;
    private int week;
    private Integer classroomId;
    private Collection<CourseTimetableTmpChangesEntity> courseTimetableTmpChangesById;
    private CourseSemesterUnitReaderEntity courseSemesterUnitReaderByCourseReaderId;
    private ClassroomInfoEntity classroomInfoByClassroomId;
    private Collection<LessonCalendarEntity> lessonCalendarsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "course_reader_id", nullable = false)
    public int getCourseReaderId() {
        return courseReaderId;
    }

    public void setCourseReaderId(int courseReaderId) {
        this.courseReaderId = courseReaderId;
    }

    @Basic
    @Column(name = "day", nullable = false)
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "week", nullable = false)
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Basic
    @Column(name = "classroom_id", nullable = true)
    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTimetableSlotEntity that = (CourseTimetableSlotEntity) o;
        return id == that.id &&
                courseReaderId == that.courseReaderId &&
                day == that.day &&
                number == that.number &&
                week == that.week &&
                Objects.equals(classroomId, that.classroomId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, courseReaderId, day, number, week, classroomId);
    }

    @OneToMany(mappedBy = "courseTimetableSlotByTimeslotId")
    public Collection<CourseTimetableTmpChangesEntity> getCourseTimetableTmpChangesById() {
        return courseTimetableTmpChangesById;
    }

    public void setCourseTimetableTmpChangesById(Collection<CourseTimetableTmpChangesEntity> courseTimetableTmpChangesById) {
        this.courseTimetableTmpChangesById = courseTimetableTmpChangesById;
    }

    @ManyToOne
    @JoinColumn(name = "course_reader_id", referencedColumnName = "id", nullable = false)
    public CourseSemesterUnitReaderEntity getCourseSemesterUnitReaderByCourseReaderId() {
        return courseSemesterUnitReaderByCourseReaderId;
    }

    public void setCourseSemesterUnitReaderByCourseReaderId(CourseSemesterUnitReaderEntity courseSemesterUnitReaderByCourseReaderId) {
        this.courseSemesterUnitReaderByCourseReaderId = courseSemesterUnitReaderByCourseReaderId;
    }

    @ManyToOne
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    public ClassroomInfoEntity getClassroomInfoByClassroomId() {
        return classroomInfoByClassroomId;
    }

    public void setClassroomInfoByClassroomId(ClassroomInfoEntity classroomInfoByClassroomId) {
        this.classroomInfoByClassroomId = classroomInfoByClassroomId;
    }

    @OneToMany(mappedBy = "courseTimetableSlotByCourseTimetableSlotId")
    public Collection<LessonCalendarEntity> getLessonCalendarsById() {
        return lessonCalendarsById;
    }

    public void setLessonCalendarsById(Collection<LessonCalendarEntity> lessonCalendarsById) {
        this.lessonCalendarsById = lessonCalendarsById;
    }
}
