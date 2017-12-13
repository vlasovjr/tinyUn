package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "___tbl_notification_msg_letter", schema = "kampus_old", catalog = "")
public class TblNotificationMsgLetterEntity {
    private int id;
    private Integer studentId;
    private Integer lessonId;
    private String notifType;
    private Timestamp notifTime;
    private Byte viewed;
    private Timestamp destroyTime;
    private StudentEntity studentByStudentId;
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
    @Column(name = "student_id", nullable = true)
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "lesson_id", nullable = true)
    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    @Basic
    @Column(name = "notif_type", nullable = true, length = 45)
    public String getNotifType() {
        return notifType;
    }

    public void setNotifType(String notifType) {
        this.notifType = notifType;
    }

    @Basic
    @Column(name = "notif_time", nullable = true)
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
    @Column(name = "destroy_time", nullable = true)
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
        TblNotificationMsgLetterEntity that = (TblNotificationMsgLetterEntity) o;
        return id == that.id &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(lessonId, that.lessonId) &&
                Objects.equals(notifType, that.notifType) &&
                Objects.equals(notifTime, that.notifTime) &&
                Objects.equals(viewed, that.viewed) &&
                Objects.equals(destroyTime, that.destroyTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, studentId, lessonId, notifType, notifTime, viewed, destroyTime);
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public StudentEntity getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(StudentEntity studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    public LessonEntity getLessonByLessonId() {
        return lessonByLessonId;
    }

    public void setLessonByLessonId(LessonEntity lessonByLessonId) {
        this.lessonByLessonId = lessonByLessonId;
    }
}
