package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "kampus_old", catalog = "")
public class StudentEntity {
    private int id;
    private int userId;
    private String idCardSeries;
    private Integer idCardNumber;
    private Date issuedBy;
    private Date validTo;
    private String educationType;
    private int studentGroupInfoId;
    private String status;
    private Integer studentDocPhotoId;
    private Collection<TblNotificationMsgLetterEntity> tblNotificationMsgLettersById;
    private Collection<LessonHomeworkStudentMarkEntity> lessonHomeworkStudentMarksById;
    private Collection<LessonHwFromStudentEntity> lessonHwFromStudentsById;
    private Collection<LessonStudentMarkEntity> lessonStudentMarksById;
    private Collection<LessonVisitLogEntity> lessonVisitLogsById;
    private Collection<NotificationStudentLessonEntity> notificationStudentLessonsById;
    private Collection<NotificationTeacherLessonEntity> notificationTeacherLessonsById;
    private UserAccountOldEntity userAccountOldByUserId;
    private StudentGroupInfoEntity studentGroupInfoByStudentGroupInfoId;
    private FileUnitEntity fileUnitByStudentDocPhotoId;
    private Collection<StudentGroupInfoEntity> studentGroupInfosById;
    private Collection<StudentTranscriptInfoEntity> studentTranscriptInfosById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "id_card_series", nullable = true, length = 3)
    public String getIdCardSeries() {
        return idCardSeries;
    }

    public void setIdCardSeries(String idCardSeries) {
        this.idCardSeries = idCardSeries;
    }

    @Basic
    @Column(name = "id_card_number", nullable = true)
    public Integer getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(Integer idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    @Basic
    @Column(name = "issued_by", nullable = true)
    public Date getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(Date issuedBy) {
        this.issuedBy = issuedBy;
    }

    @Basic
    @Column(name = "valid_to", nullable = true)
    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Basic
    @Column(name = "education_type", nullable = true, length = 45)
    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    @Basic
    @Column(name = "student_group_info_id", nullable = false)
    public int getStudentGroupInfoId() {
        return studentGroupInfoId;
    }

    public void setStudentGroupInfoId(int studentGroupInfoId) {
        this.studentGroupInfoId = studentGroupInfoId;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "student_doc_photo_id", nullable = true)
    public Integer getStudentDocPhotoId() {
        return studentDocPhotoId;
    }

    public void setStudentDocPhotoId(Integer studentDocPhotoId) {
        this.studentDocPhotoId = studentDocPhotoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id &&
                userId == that.userId &&
                studentGroupInfoId == that.studentGroupInfoId &&
                Objects.equals(idCardSeries, that.idCardSeries) &&
                Objects.equals(idCardNumber, that.idCardNumber) &&
                Objects.equals(issuedBy, that.issuedBy) &&
                Objects.equals(validTo, that.validTo) &&
                Objects.equals(educationType, that.educationType) &&
                Objects.equals(status, that.status) &&
                Objects.equals(studentDocPhotoId, that.studentDocPhotoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, idCardSeries, idCardNumber, issuedBy, validTo, educationType, studentGroupInfoId, status, studentDocPhotoId);
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<TblNotificationMsgLetterEntity> getTblNotificationMsgLettersById() {
        return tblNotificationMsgLettersById;
    }

    public void setTblNotificationMsgLettersById(Collection<TblNotificationMsgLetterEntity> tblNotificationMsgLettersById) {
        this.tblNotificationMsgLettersById = tblNotificationMsgLettersById;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<LessonHomeworkStudentMarkEntity> getLessonHomeworkStudentMarksById() {
        return lessonHomeworkStudentMarksById;
    }

    public void setLessonHomeworkStudentMarksById(Collection<LessonHomeworkStudentMarkEntity> lessonHomeworkStudentMarksById) {
        this.lessonHomeworkStudentMarksById = lessonHomeworkStudentMarksById;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<LessonHwFromStudentEntity> getLessonHwFromStudentsById() {
        return lessonHwFromStudentsById;
    }

    public void setLessonHwFromStudentsById(Collection<LessonHwFromStudentEntity> lessonHwFromStudentsById) {
        this.lessonHwFromStudentsById = lessonHwFromStudentsById;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<LessonStudentMarkEntity> getLessonStudentMarksById() {
        return lessonStudentMarksById;
    }

    public void setLessonStudentMarksById(Collection<LessonStudentMarkEntity> lessonStudentMarksById) {
        this.lessonStudentMarksById = lessonStudentMarksById;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<LessonVisitLogEntity> getLessonVisitLogsById() {
        return lessonVisitLogsById;
    }

    public void setLessonVisitLogsById(Collection<LessonVisitLogEntity> lessonVisitLogsById) {
        this.lessonVisitLogsById = lessonVisitLogsById;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<NotificationStudentLessonEntity> getNotificationStudentLessonsById() {
        return notificationStudentLessonsById;
    }

    public void setNotificationStudentLessonsById(Collection<NotificationStudentLessonEntity> notificationStudentLessonsById) {
        this.notificationStudentLessonsById = notificationStudentLessonsById;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<NotificationTeacherLessonEntity> getNotificationTeacherLessonsById() {
        return notificationTeacherLessonsById;
    }

    public void setNotificationTeacherLessonsById(Collection<NotificationTeacherLessonEntity> notificationTeacherLessonsById) {
        this.notificationTeacherLessonsById = notificationTeacherLessonsById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserAccountOldEntity getUserAccountOldByUserId() {
        return userAccountOldByUserId;
    }

    public void setUserAccountOldByUserId(UserAccountOldEntity userAccountOldByUserId) {
        this.userAccountOldByUserId = userAccountOldByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "student_group_info_id", referencedColumnName = "id", nullable = false)
    public StudentGroupInfoEntity getStudentGroupInfoByStudentGroupInfoId() {
        return studentGroupInfoByStudentGroupInfoId;
    }

    public void setStudentGroupInfoByStudentGroupInfoId(StudentGroupInfoEntity studentGroupInfoByStudentGroupInfoId) {
        this.studentGroupInfoByStudentGroupInfoId = studentGroupInfoByStudentGroupInfoId;
    }

    @ManyToOne
    @JoinColumn(name = "student_doc_photo_id", referencedColumnName = "id")
    public FileUnitEntity getFileUnitByStudentDocPhotoId() {
        return fileUnitByStudentDocPhotoId;
    }

    public void setFileUnitByStudentDocPhotoId(FileUnitEntity fileUnitByStudentDocPhotoId) {
        this.fileUnitByStudentDocPhotoId = fileUnitByStudentDocPhotoId;
    }

    @OneToMany(mappedBy = "studentByStarostaId")
    public Collection<StudentGroupInfoEntity> getStudentGroupInfosById() {
        return studentGroupInfosById;
    }

    public void setStudentGroupInfosById(Collection<StudentGroupInfoEntity> studentGroupInfosById) {
        this.studentGroupInfosById = studentGroupInfosById;
    }

    @OneToMany(mappedBy = "studentByStudentId")
    public Collection<StudentTranscriptInfoEntity> getStudentTranscriptInfosById() {
        return studentTranscriptInfosById;
    }

    public void setStudentTranscriptInfosById(Collection<StudentTranscriptInfoEntity> studentTranscriptInfosById) {
        this.studentTranscriptInfosById = studentTranscriptInfosById;
    }
}
