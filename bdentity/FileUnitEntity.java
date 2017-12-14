package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "file_unit", schema = "kampus_old", catalog = "")
public class FileUnitEntity {
    private int id;
    private int userHolderId;
    private String fileUrl;
    private String name;
    private Integer descriptionId;
    private String extension;
    private String status;
    private Timestamp upload;
    private Timestamp lastUse;
    private Collection<FileDirItemEntity> fileDirItemsById;
    private UserAccountOldEntity userAccountOldByUserHolderId;
    private MsgDescriptionPullEntity msgDescriptionPullByDescriptionId;
    private Collection<MsgChanelEntity> msgChanelsById;
    private Collection<MsgChatroomEntity> msgChatroomsById;
 //   private Collection<StudentEntity> studentsById;
 //   private Collection<StudentTranscriptInfoEntity> studentTranscriptInfosById;
    private Collection<UserAccountOldEntity> userAccountOldsById;

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
    @Column(name = "file_url", nullable = false, length = 45)
    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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
    @Column(name = "extension", nullable = true, length = 45)
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
        FileUnitEntity that = (FileUnitEntity) o;
        return id == that.id &&
                userHolderId == that.userHolderId &&
                Objects.equals(fileUrl, that.fileUrl) &&
                Objects.equals(name, that.name) &&
                Objects.equals(descriptionId, that.descriptionId) &&
                Objects.equals(extension, that.extension) &&
                Objects.equals(status, that.status) &&
                Objects.equals(upload, that.upload) &&
                Objects.equals(lastUse, that.lastUse);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userHolderId, fileUrl, name, descriptionId, extension, status, upload, lastUse);
    }

    @OneToMany(mappedBy = "fileUnitByFileId")
    public Collection<FileDirItemEntity> getFileDirItemsById() {
        return fileDirItemsById;
    }

    public void setFileDirItemsById(Collection<FileDirItemEntity> fileDirItemsById) {
        this.fileDirItemsById = fileDirItemsById;
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

    @OneToMany(mappedBy = "fileUnitByAvatarPhotoId")
    public Collection<MsgChanelEntity> getMsgChanelsById() {
        return msgChanelsById;
    }

    public void setMsgChanelsById(Collection<MsgChanelEntity> msgChanelsById) {
        this.msgChanelsById = msgChanelsById;
    }

    @OneToMany(mappedBy = "fileUnitByAvatarPhotoId")
    public Collection<MsgChatroomEntity> getMsgChatroomsById() {
        return msgChatroomsById;
    }

    public void setMsgChatroomsById(Collection<MsgChatroomEntity> msgChatroomsById) {
        this.msgChatroomsById = msgChatroomsById;
    }

    /*

    @OneToMany(mappedBy = "fileUnitByStudentDocPhotoId")
    public Collection<StudentEntity> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<StudentEntity> studentsById) {
        this.studentsById = studentsById;
    }

    @OneToMany(mappedBy = "fileUnitByPhotoDocId")
    public Collection<StudentTranscriptInfoEntity> getStudentTranscriptInfosById() {
        return studentTranscriptInfosById;
    }

    public void setStudentTranscriptInfosById(Collection<StudentTranscriptInfoEntity> studentTranscriptInfosById) {
        this.studentTranscriptInfosById = studentTranscriptInfosById;
    }
//*/
    @OneToMany(mappedBy = "fileUnitByPhotoAvatarId")
    public Collection<UserAccountOldEntity> getUserAccountOldsById() {
        return userAccountOldsById;
    }

    public void setUserAccountOldsById(Collection<UserAccountOldEntity> userAccountOldsById) {
        this.userAccountOldsById = userAccountOldsById;
    }
}
