package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "__course_timetable_tmp_changes", schema = "kampus_old", catalog = "")
public class CourseTimetableTmpChangesEntity {
    private int id;
    private Integer timeslotId;
    private String status;
    private Date date;
    private int number;
    private int week;
    private Integer classroomId;
    private Integer lessonId;
    private CourseTimetableSlotEntity courseTimetableSlotByTimeslotId;
    private ClassroomInfoEntity classroomInfoByClassroomId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "timeslot_id", nullable = true)
    public Integer getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(Integer timeslotId) {
        this.timeslotId = timeslotId;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 12)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Basic
    @Column(name = "lesson_id", nullable = true)
    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTimetableTmpChangesEntity that = (CourseTimetableTmpChangesEntity) o;
        return id == that.id &&
                number == that.number &&
                week == that.week &&
                Objects.equals(timeslotId, that.timeslotId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(date, that.date) &&
                Objects.equals(classroomId, that.classroomId) &&
                Objects.equals(lessonId, that.lessonId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, timeslotId, status, date, number, week, classroomId, lessonId);
    }

    @ManyToOne
    @JoinColumn(name = "timeslot_id", referencedColumnName = "id")
    public CourseTimetableSlotEntity getCourseTimetableSlotByTimeslotId() {
        return courseTimetableSlotByTimeslotId;
    }

    public void setCourseTimetableSlotByTimeslotId(CourseTimetableSlotEntity courseTimetableSlotByTimeslotId) {
        this.courseTimetableSlotByTimeslotId = courseTimetableSlotByTimeslotId;
    }

    @ManyToOne
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    public ClassroomInfoEntity getClassroomInfoByClassroomId() {
        return classroomInfoByClassroomId;
    }

    public void setClassroomInfoByClassroomId(ClassroomInfoEntity classroomInfoByClassroomId) {
        this.classroomInfoByClassroomId = classroomInfoByClassroomId;
    }
}
