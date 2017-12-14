package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lesson_homework", schema = "kampus_old", catalog = "")
public class LessonHomeworkEntity {
    private int id;
    private int lessonId;
    private Date deadlineDate;
    private Integer msgDescriptionId;
    private int fileDirInfoId;
    private LessonEntity lessonByLessonId;
    private MsgDescriptionPullEntity msgDescriptionPullByMsgDescriptionId;
    private FileDirInfoEntity fileDirInfoByFileDirInfoId;
    private Collection<LessonHomeworkStudentMarkEntity> lessonHomeworkStudentMarksById;
    private Collection<LessonHwFromStudentEntity> lessonHwFromStudentsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "deadline_date", nullable = true)
    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
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
    @Column(name = "file_dir_info_id", nullable = false)
    public int getFileDirInfoId() {
        return fileDirInfoId;
    }

    public void setFileDirInfoId(int fileDirInfoId) {
        this.fileDirInfoId = fileDirInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonHomeworkEntity that = (LessonHomeworkEntity) o;
        return id == that.id &&
                lessonId == that.lessonId &&
                fileDirInfoId == that.fileDirInfoId &&
                Objects.equals(deadlineDate, that.deadlineDate) &&
                Objects.equals(msgDescriptionId, that.msgDescriptionId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, lessonId, deadlineDate, msgDescriptionId, fileDirInfoId);
    }

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

    @ManyToOne
    @JoinColumn(name = "file_dir_info_id", referencedColumnName = "id", nullable = false)
    public FileDirInfoEntity getFileDirInfoByFileDirInfoId() {
        return fileDirInfoByFileDirInfoId;
    }

    public void setFileDirInfoByFileDirInfoId(FileDirInfoEntity fileDirInfoByFileDirInfoId) {
        this.fileDirInfoByFileDirInfoId = fileDirInfoByFileDirInfoId;
    }

    @OneToMany(mappedBy = "lessonHomeworkByLessonHomeworkId")
    public Collection<LessonHomeworkStudentMarkEntity> getLessonHomeworkStudentMarksById() {
        return lessonHomeworkStudentMarksById;
    }

    public void setLessonHomeworkStudentMarksById(Collection<LessonHomeworkStudentMarkEntity> lessonHomeworkStudentMarksById) {
        this.lessonHomeworkStudentMarksById = lessonHomeworkStudentMarksById;
    }

    @OneToMany(mappedBy = "lessonHomeworkByLessonHomeworkId")
    public Collection<LessonHwFromStudentEntity> getLessonHwFromStudentsById() {
        return lessonHwFromStudentsById;
    }

    public void setLessonHwFromStudentsById(Collection<LessonHwFromStudentEntity> lessonHwFromStudentsById) {
        this.lessonHwFromStudentsById = lessonHwFromStudentsById;
    }
}
