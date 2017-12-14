package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lesson", schema = "kampus_old", catalog = "")
public class LessonEntity {
    private int id;
    private String name;
    private Integer msgDescriptionId;
    private Integer numberOf;
    private Integer filepackInfoId;
    private Collection<TblNotificationMsgLetterEntity> tblNotificationMsgLettersById;
    private MsgDescriptionPullEntity msgDescriptionPullByMsgDescriptionId;
    private FileDirInfoEntity fileDirInfoByFilepackInfoId;
    private Collection<LessonCalendarEntity> lessonCalendarsById;
    private Collection<LessonHomeworkEntity> lessonHomeworksById;
    private Collection<LessonStudentMarkEntity> lessonStudentMarksById;
    private Collection<LessonVisitLogEntity> lessonVisitLogsById;
    private Collection<NotificationStudentLessonEntity> notificationStudentLessonsById;
    private Collection<NotificationTeacherLessonEntity> notificationTeacherLessonsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "number_of", nullable = true)
    public Integer getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(Integer numberOf) {
        this.numberOf = numberOf;
    }

    @Basic
    @Column(name = "filepack_info_id", nullable = true)
    public Integer getFilepackInfoId() {
        return filepackInfoId;
    }

    public void setFilepackInfoId(Integer filepackInfoId) {
        this.filepackInfoId = filepackInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonEntity that = (LessonEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(msgDescriptionId, that.msgDescriptionId) &&
                Objects.equals(numberOf, that.numberOf) &&
                Objects.equals(filepackInfoId, that.filepackInfoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, msgDescriptionId, numberOf, filepackInfoId);
    }

    @OneToMany(mappedBy = "lessonByLessonId")
    public Collection<TblNotificationMsgLetterEntity> getTblNotificationMsgLettersById() {
        return tblNotificationMsgLettersById;
    }

    public void setTblNotificationMsgLettersById(Collection<TblNotificationMsgLetterEntity> tblNotificationMsgLettersById) {
        this.tblNotificationMsgLettersById = tblNotificationMsgLettersById;
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
    @JoinColumn(name = "filepack_info_id", referencedColumnName = "id")
    public FileDirInfoEntity getFileDirInfoByFilepackInfoId() {
        return fileDirInfoByFilepackInfoId;
    }

    public void setFileDirInfoByFilepackInfoId(FileDirInfoEntity fileDirInfoByFilepackInfoId) {
        this.fileDirInfoByFilepackInfoId = fileDirInfoByFilepackInfoId;
    }

    @OneToMany(mappedBy = "lessonByLessonId")
    public Collection<LessonCalendarEntity> getLessonCalendarsById() {
        return lessonCalendarsById;
    }

    public void setLessonCalendarsById(Collection<LessonCalendarEntity> lessonCalendarsById) {
        this.lessonCalendarsById = lessonCalendarsById;
    }

    @OneToMany(mappedBy = "lessonByLessonId")
    public Collection<LessonHomeworkEntity> getLessonHomeworksById() {
        return lessonHomeworksById;
    }

    public void setLessonHomeworksById(Collection<LessonHomeworkEntity> lessonHomeworksById) {
        this.lessonHomeworksById = lessonHomeworksById;
    }

    @OneToMany(mappedBy = "lessonByLessonId")
    public Collection<LessonStudentMarkEntity> getLessonStudentMarksById() {
        return lessonStudentMarksById;
    }

    public void setLessonStudentMarksById(Collection<LessonStudentMarkEntity> lessonStudentMarksById) {
        this.lessonStudentMarksById = lessonStudentMarksById;
    }

    @OneToMany(mappedBy = "lessonByLessonId")
    public Collection<LessonVisitLogEntity> getLessonVisitLogsById() {
        return lessonVisitLogsById;
    }

    public void setLessonVisitLogsById(Collection<LessonVisitLogEntity> lessonVisitLogsById) {
        this.lessonVisitLogsById = lessonVisitLogsById;
    }

    @OneToMany(mappedBy = "lessonByLessonId")
    public Collection<NotificationStudentLessonEntity> getNotificationStudentLessonsById() {
        return notificationStudentLessonsById;
    }

    public void setNotificationStudentLessonsById(Collection<NotificationStudentLessonEntity> notificationStudentLessonsById) {
        this.notificationStudentLessonsById = notificationStudentLessonsById;
    }

    @OneToMany(mappedBy = "lessonByLessonId")
    public Collection<NotificationTeacherLessonEntity> getNotificationTeacherLessonsById() {
        return notificationTeacherLessonsById;
    }

    public void setNotificationTeacherLessonsById(Collection<NotificationTeacherLessonEntity> notificationTeacherLessonsById) {
        this.notificationTeacherLessonsById = notificationTeacherLessonsById;
    }
}
