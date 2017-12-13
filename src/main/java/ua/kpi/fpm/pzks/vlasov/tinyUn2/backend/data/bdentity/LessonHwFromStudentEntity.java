package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "lesson_hw_from_student", schema = "kampus_old", catalog = "")
public class LessonHwFromStudentEntity {
    private int id;
    private int lessonHomeworkId;
    private int studentId;
    private int fileDirInfoId;
    private Timestamp uploadtime;
    private Integer msgDescriptionId;
    private Timestamp viewed;
    private LessonHomeworkEntity lessonHomeworkByLessonHomeworkId;
    private StudentEntity studentByStudentId;
    private FileDirInfoEntity fileDirInfoByFileDirInfoId;
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
    @Column(name = "lesson_homework_id", nullable = false)
    public int getLessonHomeworkId() {
        return lessonHomeworkId;
    }

    public void setLessonHomeworkId(int lessonHomeworkId) {
        this.lessonHomeworkId = lessonHomeworkId;
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
    @Column(name = "file_dir_info_id", nullable = false)
    public int getFileDirInfoId() {
        return fileDirInfoId;
    }

    public void setFileDirInfoId(int fileDirInfoId) {
        this.fileDirInfoId = fileDirInfoId;
    }

    @Basic
    @Column(name = "uploadtime", nullable = false)
    public Timestamp getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Timestamp uploadtime) {
        this.uploadtime = uploadtime;
    }

    @Basic
    @Column(name = "msg_description_id", nullable = true)
    public Integer getMsgDescriptionId() {
        return msgDescriptionId;
    }

    public void setMsgDescriptionId(Integer msgDescriptionId) {
        this.msgDescriptionId = msgDescriptionId;
    }

    @Basic
    @Column(name = "viewed", nullable = true)
    public Timestamp getViewed() {
        return viewed;
    }

    public void setViewed(Timestamp viewed) {
        this.viewed = viewed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonHwFromStudentEntity that = (LessonHwFromStudentEntity) o;
        return id == that.id &&
                lessonHomeworkId == that.lessonHomeworkId &&
                studentId == that.studentId &&
                fileDirInfoId == that.fileDirInfoId &&
                Objects.equals(uploadtime, that.uploadtime) &&
                Objects.equals(msgDescriptionId, that.msgDescriptionId) &&
                Objects.equals(viewed, that.viewed);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, lessonHomeworkId, studentId, fileDirInfoId, uploadtime, msgDescriptionId, viewed);
    }

    @ManyToOne
    @JoinColumn(name = "lesson_homework_id", referencedColumnName = "id", nullable = false)
    public LessonHomeworkEntity getLessonHomeworkByLessonHomeworkId() {
        return lessonHomeworkByLessonHomeworkId;
    }

    public void setLessonHomeworkByLessonHomeworkId(LessonHomeworkEntity lessonHomeworkByLessonHomeworkId) {
        this.lessonHomeworkByLessonHomeworkId = lessonHomeworkByLessonHomeworkId;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public StudentEntity getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(StudentEntity studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "file_dir_info_id", referencedColumnName = "id", nullable = false)
    public FileDirInfoEntity getFileDirInfoByFileDirInfoId() {
        return fileDirInfoByFileDirInfoId;
    }

    public void setFileDirInfoByFileDirInfoId(FileDirInfoEntity fileDirInfoByFileDirInfoId) {
        this.fileDirInfoByFileDirInfoId = fileDirInfoByFileDirInfoId;
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
