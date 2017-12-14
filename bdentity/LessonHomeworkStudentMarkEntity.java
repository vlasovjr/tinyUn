package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lesson_homework_student_mark", schema = "kampus_old", catalog = "")
public class LessonHomeworkStudentMarkEntity {
    private int id;
    private int studentId;
    private int lessonHomeworkId;
    private String mark;
    private Integer msgDescriptionId;
   // private StudentEntity studentByStudentId;
    private LessonHomeworkEntity lessonHomeworkByLessonHomeworkId;
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
    @Column(name = "lesson_homework_id", nullable = false)
    public int getLessonHomeworkId() {
        return lessonHomeworkId;
    }

    public void setLessonHomeworkId(int lessonHomeworkId) {
        this.lessonHomeworkId = lessonHomeworkId;
    }

    @Basic
    @Column(name = "mark", nullable = false, length = 10)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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
        LessonHomeworkStudentMarkEntity that = (LessonHomeworkStudentMarkEntity) o;
        return id == that.id &&
                studentId == that.studentId &&
                lessonHomeworkId == that.lessonHomeworkId &&
                Objects.equals(mark, that.mark) &&
                Objects.equals(msgDescriptionId, that.msgDescriptionId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, studentId, lessonHomeworkId, mark, msgDescriptionId);
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
    @JoinColumn(name = "lesson_homework_id", referencedColumnName = "id", nullable = false)
    public LessonHomeworkEntity getLessonHomeworkByLessonHomeworkId() {
        return lessonHomeworkByLessonHomeworkId;
    }

    public void setLessonHomeworkByLessonHomeworkId(LessonHomeworkEntity lessonHomeworkByLessonHomeworkId) {
        this.lessonHomeworkByLessonHomeworkId = lessonHomeworkByLessonHomeworkId;
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
