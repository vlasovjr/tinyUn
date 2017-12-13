package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "file_dir_info", schema = "kampus_old", catalog = "")
public class FileDirInfoEntity {
    private int id;
    private int userHolderId;
    private String name;
    private Integer descriptionId;
    private String status;
    private Timestamp upload;
    private Timestamp lastUse;
    private Collection<CourseSemesterInfoEntity> courseSemesterInfosById;
    private Collection<FileDirInDirEntity> fileDirInDirsById;
    private Collection<FileDirInDirEntity> fileDirInDirsById_0;
    private UserAccountOldEntity userAccountOldByUserHolderId;
    private MsgDescriptionPullEntity msgDescriptionPullByDescriptionId;
    private Collection<FileDirItemEntity> fileDirItemsById;
    private Collection<LessonEntity> lessonsById;
    private Collection<LessonHomeworkEntity> lessonHomeworksById;
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
    @Column(name = "user_holder_id", nullable = false)
    public int getUserHolderId() {
        return userHolderId;
    }

    public void setUserHolderId(int userHolderId) {
        this.userHolderId = userHolderId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description_id", nullable = true)
    public Integer getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Integer descriptionId) {
        this.descriptionId = descriptionId;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "upload", nullable = false)
    public Timestamp getUpload() {
        return upload;
    }

    public void setUpload(Timestamp upload) {
        this.upload = upload;
    }

    @Basic
    @Column(name = "last_use", nullable = true)
    public Timestamp getLastUse() {
        return lastUse;
    }

    public void setLastUse(Timestamp lastUse) {
        this.lastUse = lastUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileDirInfoEntity that = (FileDirInfoEntity) o;
        return id == that.id &&
                userHolderId == that.userHolderId &&
                Objects.equals(name, that.name) &&
                Objects.equals(descriptionId, that.descriptionId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(upload, that.upload) &&
                Objects.equals(lastUse, that.lastUse);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userHolderId, name, descriptionId, status, upload, lastUse);
    }

    @OneToMany(mappedBy = "fileDirInfoByFileDirInfoId")
    public Collection<CourseSemesterInfoEntity> getCourseSemesterInfosById() {
        return courseSemesterInfosById;
    }

    public void setCourseSemesterInfosById(Collection<CourseSemesterInfoEntity> courseSemesterInfosById) {
        this.courseSemesterInfosById = courseSemesterInfosById;
    }

    @OneToMany(mappedBy = "fileDirInfoByChildeFileDirId")
    public Collection<FileDirInDirEntity> getFileDirInDirsById() {
        return fileDirInDirsById;
    }

    public void setFileDirInDirsById(Collection<FileDirInDirEntity> fileDirInDirsById) {
        this.fileDirInDirsById = fileDirInDirsById;
    }

    @OneToMany(mappedBy = "fileDirInfoByParentFileDirId")
    public Collection<FileDirInDirEntity> getFileDirInDirsById_0() {
        return fileDirInDirsById_0;
    }

    public void setFileDirInDirsById_0(Collection<FileDirInDirEntity> fileDirInDirsById_0) {
        this.fileDirInDirsById_0 = fileDirInDirsById_0;
    }

    @ManyToOne
    @JoinColumn(name = "user_holder_id", referencedColumnName = "id", nullable = false)
    public UserAccountOldEntity getUserAccountOldByUserHolderId() {
        return userAccountOldByUserHolderId;
    }

    public void setUserAccountOldByUserHolderId(UserAccountOldEntity userAccountOldByUserHolderId) {
        this.userAccountOldByUserHolderId = userAccountOldByUserHolderId;
    }

    @ManyToOne
    @JoinColumn(name = "description_id", referencedColumnName = "id")
    public MsgDescriptionPullEntity getMsgDescriptionPullByDescriptionId() {
        return msgDescriptionPullByDescriptionId;
    }

    public void setMsgDescriptionPullByDescriptionId(MsgDescriptionPullEntity msgDescriptionPullByDescriptionId) {
        this.msgDescriptionPullByDescriptionId = msgDescriptionPullByDescriptionId;
    }

    @OneToMany(mappedBy = "fileDirInfoByFileDirId")
    public Collection<FileDirItemEntity> getFileDirItemsById() {
        return fileDirItemsById;
    }

    public void setFileDirItemsById(Collection<FileDirItemEntity> fileDirItemsById) {
        this.fileDirItemsById = fileDirItemsById;
    }

    @OneToMany(mappedBy = "fileDirInfoByFilepackInfoId")
    public Collection<LessonEntity> getLessonsById() {
        return lessonsById;
    }

    public void setLessonsById(Collection<LessonEntity> lessonsById) {
        this.lessonsById = lessonsById;
    }

    @OneToMany(mappedBy = "fileDirInfoByFileDirInfoId")
    public Collection<LessonHomeworkEntity> getLessonHomeworksById() {
        return lessonHomeworksById;
    }

    public void setLessonHomeworksById(Collection<LessonHomeworkEntity> lessonHomeworksById) {
        this.lessonHomeworksById = lessonHomeworksById;
    }

    @OneToMany(mappedBy = "fileDirInfoByFileDirInfoId")
    public Collection<LessonHwFromStudentEntity> getLessonHwFromStudentsById() {
        return lessonHwFromStudentsById;
    }

    public void setLessonHwFromStudentsById(Collection<LessonHwFromStudentEntity> lessonHwFromStudentsById) {
        this.lessonHwFromStudentsById = lessonHwFromStudentsById;
    }
}
