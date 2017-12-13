package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lesson_calendar", schema = "kampus_old", catalog = "")
public class LessonCalendarEntity {
    private int id;
    private int courseTimetableSlotId;
    private int lessonId;
    private Timestamp date;
    private CourseTimetableSlotEntity courseTimetableSlotByCourseTimetableSlotId;
    private LessonEntity lessonByLessonId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "course_timetable_slot_id", nullable = false)
    public int getCourseTimetableSlotId() {
        return courseTimetableSlotId;
    }

    public void setCourseTimetableSlotId(int courseTimetableSlotId) {
        this.courseTimetableSlotId = courseTimetableSlotId;
    }

    @Basic
    @Column(name = "lesson_id", nullable = false)
    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonCalendarEntity that = (LessonCalendarEntity) o;
        return id == that.id &&
                courseTimetableSlotId == that.courseTimetableSlotId &&
                lessonId == that.lessonId &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, courseTimetableSlotId, lessonId, date);
    }

    @ManyToOne
    @JoinColumn(name = "course_timetable_slot_id", referencedColumnName = "id", nullable = false)
    public CourseTimetableSlotEntity getCourseTimetableSlotByCourseTimetableSlotId() {
        return courseTimetableSlotByCourseTimetableSlotId;
    }

    public void setCourseTimetableSlotByCourseTimetableSlotId(CourseTimetableSlotEntity courseTimetableSlotByCourseTimetableSlotId) {
        this.courseTimetableSlotByCourseTimetableSlotId = courseTimetableSlotByCourseTimetableSlotId;
    }

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id", nullable = false)
    public LessonEntity getLessonByLessonId() {
        return lessonByLessonId;
    }

    public void setLessonByLessonId(LessonEntity lessonByLessonId) {
        this.lessonByLessonId = lessonByLessonId;
    }
}
