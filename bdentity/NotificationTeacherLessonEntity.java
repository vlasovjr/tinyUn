package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "notification_teacher_lesson", schema = "kampus_old", catalog = "")
public class NotificationTeacherLessonEntity {
    private int id;
    private int studentId;
    private int lessonId;
    private String notifType;
    private Timestamp notifTime;
    private Byte viewed;
    private Timestamp destroyTime;
    //private StudentEntity studentByStudentId;
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
    @Column(name = "student_id", nullable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
    @Column(name = "notif_type", nullable = false, length = 45)
    public String getNotifType() {
        return notifType;
    }

    public void setNotifType(String notifType) {
        this.notifType = notifType;
    }

    @Basic
    @Column(name = "notif_time", nullable = false)
    public Timestamp getNotifTime() {
        return notifTime;
    }

    public void setNotifTime(Timestamp notifTime) {
        this.notifTime = notifTime;
    }

    @Basic
    @Column(name = "viewed", nullable = true)
    public Byte getViewed() {
        return viewed;
    }

    public void setViewed(Byte viewed) {
        this.viewed = viewed;
    }

    @Basic
    @Column(name = "destroy_time", nullable = false)
    public Timestamp getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(Timestamp destroyTime) {
        this.destroyTime = destroyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationTeacherLessonEntity that = (NotificationTeacherLessonEntity) o;
        return id == that.id &&
                studentId == that.studentId &&
                lessonId == that.lessonId &&
                Objects.equals(notifType, that.notifType) &&
                Objects.equals(notifTime, that.notifTime) &&
                Objects.equals(viewed, that.viewed) &&
                Objects.equals(destroyTime, that.destroyTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, studentId, lessonId, notifType, notifTime, viewed, destroyTime);
    }
/*
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public StudentEntity getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(StudentEntity studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }
//*/
    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id", nullable = false)
    public LessonEntity getLessonByLessonId() {
        return lessonByLessonId;
    }

    public void setLessonByLessonId(LessonEntity lessonByLessonId) {
        this.lessonByLessonId = lessonByLessonId;
    }
}
