package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lesson_student_mark", schema = "kampus_old", catalog = "")
public class LessonStudentMarkEntity {
    private int id;
    private int studentId;
    private int lessonId;
    private String makr;
    private Integer msgDescriptionId;
  //  private StudentEntity studentByStudentId;
    private LessonEntity lessonByLessonId;
    private MsgDescriptionPullEntity msgDescriptionPullByMsgDescriptionId;

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
    @Column(name = "makr", nullable = false, length = 10)
    public String getMakr() {
        return makr;
    }

    public void setMakr(String makr) {
        this.makr = makr;
    }

    @Basic
    @Column(name = "msg_description_id", nullable = true)
    public Integer getMsgDescriptionId() {
        return msgDescriptionId;
    }

    public void setMsgDescriptionId(Integer msgDescriptionId) {
        this.msgDescriptionId = msgDescriptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonStudentMarkEntity that = (LessonStudentMarkEntity) o;
        return id == that.id &&
                studentId == that.studentId &&
                lessonId == that.lessonId &&
                Objects.equals(makr, that.makr) &&
                Objects.equals(msgDescriptionId, that.msgDescriptionId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, studentId, lessonId, makr, msgDescriptionId);
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

    @ManyToOne
    @JoinColumn(name = "msg_description_id", referencedColumnName = "id")
    public MsgDescriptionPullEntity getMsgDescriptionPullByMsgDescriptionId() {
        return msgDescriptionPullByMsgDescriptionId;
    }

    public void setMsgDescriptionPullByMsgDescriptionId(MsgDescriptionPullEntity msgDescriptionPullByMsgDescriptionId) {
        this.msgDescriptionPullByMsgDescriptionId = msgDescriptionPullByMsgDescriptionId;
    }
}
