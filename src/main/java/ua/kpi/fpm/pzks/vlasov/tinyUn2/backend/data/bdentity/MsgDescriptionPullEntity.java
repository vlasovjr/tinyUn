package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "msg_description_pull", schema = "kampus_old", catalog = "")
public class MsgDescriptionPullEntity {
    private int id;
    private String msgBody;
    private Collection<FileDirInfoEntity> fileDirInfosById;
    private Collection<FileUnitEntity> fileUnitsById;
    private Collection<LessonEntity> lessonsById;
    private Collection<LessonHomeworkEntity> lessonHomeworksById;
    private Collection<LessonHomeworkStudentMarkEntity> lessonHomeworkStudentMarksById;
    private Collection<LessonHwFromStudentEntity> lessonHwFromStudentsById;
    private Collection<LessonStudentMarkEntity> lessonStudentMarksById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "msg_body", nullable = false, length = 500)
    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgDescriptionPullEntity that = (MsgDescriptionPullEntity) o;
        return id == that.id &&
                Objects.equals(msgBody, that.msgBody);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, msgBody);
    }

    @OneToMany(mappedBy = "msgDescriptionPullByDescriptionId")
    public Collection<FileDirInfoEntity> getFileDirInfosById() {
        return fileDirInfosById;
    }

    public void setFileDirInfosById(Collection<FileDirInfoEntity> fileDirInfosById) {
        this.fileDirInfosById = fileDirInfosById;
    }

    @OneToMany(mappedBy = "msgDescriptionPullByDescriptionId")
    public Collection<FileUnitEntity> getFileUnitsById() {
        return fileUnitsById;
    }

    public void setFileUnitsById(Collection<FileUnitEntity> fileUnitsById) {
        this.fileUnitsById = fileUnitsById;
    }

    @OneToMany(mappedBy = "msgDescriptionPullByMsgDescriptionId")
    public Collection<LessonEntity> getLessonsById() {
        return lessonsById;
    }

    public void setLessonsById(Collection<LessonEntity> lessonsById) {
        this.lessonsById = lessonsById;
    }

    @OneToMany(mappedBy = "msgDescriptionPullByMsgDescriptionId")
    public Collection<LessonHomeworkEntity> getLessonHomeworksById() {
        return lessonHomeworksById;
    }

    public void setLessonHomeworksById(Collection<LessonHomeworkEntity> lessonHomeworksById) {
        this.lessonHomeworksById = lessonHomeworksById;
    }

    @OneToMany(mappedBy = "msgDescriptionPullByMsgDescriptionId")
    public Collection<LessonHomeworkStudentMarkEntity> getLessonHomeworkStudentMarksById() {
        return lessonHomeworkStudentMarksById;
    }

    public void setLessonHomeworkStudentMarksById(Collection<LessonHomeworkStudentMarkEntity> lessonHomeworkStudentMarksById) {
        this.lessonHomeworkStudentMarksById = lessonHomeworkStudentMarksById;
    }

    @OneToMany(mappedBy = "msgDescriptionPullByMsgDescriptionId")
    public Collection<LessonHwFromStudentEntity> getLessonHwFromStudentsById() {
        return lessonHwFromStudentsById;
    }

    public void setLessonHwFromStudentsById(Collection<LessonHwFromStudentEntity> lessonHwFromStudentsById) {
        this.lessonHwFromStudentsById = lessonHwFromStudentsById;
    }

    @OneToMany(mappedBy = "msgDescriptionPullByMsgDescriptionId")
    public Collection<LessonStudentMarkEntity> getLessonStudentMarksById() {
        return lessonStudentMarksById;
    }

    public void setLessonStudentMarksById(Collection<LessonStudentMarkEntity> lessonStudentMarksById) {
        this.lessonStudentMarksById = lessonStudentMarksById;
    }
}
