package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user_account__old", schema = "kampus_old", catalog = "")
public class UserAccountOldEntity {
    private int id;
    private String login;
    private String password;
    private int roleId;
    private String firstName;
    private String secondName;
    private Integer photoAvatarId;
    private Collection<FileDirInfoEntity> fileDirInfosById;
    private Collection<FileUnitEntity> fileUnitsById;
    private Collection<MsgChanelEntity> msgChanelsById;
    private Collection<MsgChannelMembersEntity> msgChannelMembersById;
    private Collection<MsgChatroomEntity> msgChatroomsById;
    private Collection<MsgChatroomLetterEntity> msgChatroomLettersById;
    private Collection<MsgChatroomMembersEntity> msgChatroomMembersById;
    private Collection<MsgLetterEntity> msgLettersById;
    private Collection<MsgLetterEntity> msgLettersById_0;
 //   private Collection<StudentEntity> studentsById;
    private Collection<TeacherEntity> teachersById;
    private FileUnitEntity fileUnitByPhotoAvatarId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name", nullable = false, length = 20)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "photo_avatar_id", nullable = true)
    public Integer getPhotoAvatarId() {
        return photoAvatarId;
    }

    public void setPhotoAvatarId(Integer photoAvatarId) {
        this.photoAvatarId = photoAvatarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccountOldEntity that = (UserAccountOldEntity) o;
        return id == that.id &&
                roleId == that.roleId &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(secondName, that.secondName) &&
                Objects.equals(photoAvatarId, that.photoAvatarId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, roleId, firstName, secondName, photoAvatarId);
    }


    @OneToMany(mappedBy = "userAccountOldByUserHolderId")
    public Collection<FileDirInfoEntity> getFileDirInfosById() {
        return fileDirInfosById;
    }

    public void setFileDirInfosById(Collection<FileDirInfoEntity> fileDirInfosById) {
        this.fileDirInfosById = fileDirInfosById;
    }

    @OneToMany(mappedBy = "userAccountOldByUserHolderId")
    public Collection<FileUnitEntity> getFileUnitsById() {
        return fileUnitsById;
    }

    public void setFileUnitsById(Collection<FileUnitEntity> fileUnitsById) {
        this.fileUnitsById = fileUnitsById;
    }

    @OneToMany(mappedBy = "userAccountOldByUserHolderId")
    public Collection<MsgChanelEntity> getMsgChanelsById() {
        return msgChanelsById;
    }

    public void setMsgChanelsById(Collection<MsgChanelEntity> msgChanelsById) {
        this.msgChanelsById = msgChanelsById;
    }

    @OneToMany(mappedBy = "userAccountOldByUserId")
    public Collection<MsgChannelMembersEntity> getMsgChannelMembersById() {
        return msgChannelMembersById;
    }

    public void setMsgChannelMembersById(Collection<MsgChannelMembersEntity> msgChannelMembersById) {
        this.msgChannelMembersById = msgChannelMembersById;
    }

    @OneToMany(mappedBy = "userAccountOldByUserHolderId")
    public Collection<MsgChatroomEntity> getMsgChatroomsById() {
        return msgChatroomsById;
    }

    public void setMsgChatroomsById(Collection<MsgChatroomEntity> msgChatroomsById) {
        this.msgChatroomsById = msgChatroomsById;
    }

    @OneToMany(mappedBy = "userAccountOldBySenderId")
    public Collection<MsgChatroomLetterEntity> getMsgChatroomLettersById() {
        return msgChatroomLettersById;
    }

    public void setMsgChatroomLettersById(Collection<MsgChatroomLetterEntity> msgChatroomLettersById) {
        this.msgChatroomLettersById = msgChatroomLettersById;
    }

    @OneToMany(mappedBy = "userAccountOldByUserId")
    public Collection<MsgChatroomMembersEntity> getMsgChatroomMembersById() {
        return msgChatroomMembersById;
    }

    public void setMsgChatroomMembersById(Collection<MsgChatroomMembersEntity> msgChatroomMembersById) {
        this.msgChatroomMembersById = msgChatroomMembersById;
    }

    @OneToMany(mappedBy = "userAccountOldByRecipientId")
    public Collection<MsgLetterEntity> getMsgLettersById() {
        return msgLettersById;
    }

    public void setMsgLettersById(Collection<MsgLetterEntity> msgLettersById) {
        this.msgLettersById = msgLettersById;
    }

    @OneToMany(mappedBy = "userAccountOldBySenderId")
    public Collection<MsgLetterEntity> getMsgLettersById_0() {
        return msgLettersById_0;
    }

    public void setMsgLettersById_0(Collection<MsgLetterEntity> msgLettersById_0) {
        this.msgLettersById_0 = msgLettersById_0;
    }

  /*  @OneToMany(mappedBy = "userAccountOldByUserId")
    public Collection<StudentEntity> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<StudentEntity> studentsById) {
        this.studentsById = studentsById;
    }
*/
    @OneToMany(mappedBy = "userAccountOldByUserId")
    public Collection<TeacherEntity> getTeachersById() {
        return teachersById;
    }

    public void setTeachersById(Collection<TeacherEntity> teachersById) {
        this.teachersById = teachersById;
    }

    @ManyToOne
    @JoinColumn(name = "photo_avatar_id", referencedColumnName = "id")
    public FileUnitEntity getFileUnitByPhotoAvatarId() {
        return fileUnitByPhotoAvatarId;
    }

    public void setFileUnitByPhotoAvatarId(FileUnitEntity fileUnitByPhotoAvatarId) {
        this.fileUnitByPhotoAvatarId = fileUnitByPhotoAvatarId;
    }
}
