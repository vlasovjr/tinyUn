package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "msg_chanel", schema = "kampus_old", catalog = "")
public class MsgChanelEntity {
    private int id;
    private String name;
    private int userHolderId;
    private Integer avatarPhotoId;
    private UserAccountOldEntity userAccountOldByUserHolderId;
    private FileUnitEntity fileUnitByAvatarPhotoId;
    private Collection<MsgChannelLetterEntity> msgChannelLettersById;
    private Collection<MsgChannelMembersEntity> msgChannelMembersById;

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
    @Column(name = "user_holder_id", nullable = false)
    public int getUserHolderId() {
        return userHolderId;
    }

    public void setUserHolderId(int userHolderId) {
        this.userHolderId = userHolderId;
    }

    @Basic
    @Column(name = "avatar_photo_id", nullable = true)
    public Integer getAvatarPhotoId() {
        return avatarPhotoId;
    }

    public void setAvatarPhotoId(Integer avatarPhotoId) {
        this.avatarPhotoId = avatarPhotoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgChanelEntity that = (MsgChanelEntity) o;
        return id == that.id &&
                userHolderId == that.userHolderId &&
                Objects.equals(name, that.name) &&
                Objects.equals(avatarPhotoId, that.avatarPhotoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, userHolderId, avatarPhotoId);
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
    @JoinColumn(name = "avatar_photo_id", referencedColumnName = "id")
    public FileUnitEntity getFileUnitByAvatarPhotoId() {
        return fileUnitByAvatarPhotoId;
    }

    public void setFileUnitByAvatarPhotoId(FileUnitEntity fileUnitByAvatarPhotoId) {
        this.fileUnitByAvatarPhotoId = fileUnitByAvatarPhotoId;
    }

    @OneToMany(mappedBy = "msgChanelByChannelId")
    public Collection<MsgChannelLetterEntity> getMsgChannelLettersById() {
        return msgChannelLettersById;
    }

    public void setMsgChannelLettersById(Collection<MsgChannelLetterEntity> msgChannelLettersById) {
        this.msgChannelLettersById = msgChannelLettersById;
    }

    @OneToMany(mappedBy = "msgChanelByChannelId")
    public Collection<MsgChannelMembersEntity> getMsgChannelMembersById() {
        return msgChannelMembersById;
    }

    public void setMsgChannelMembersById(Collection<MsgChannelMembersEntity> msgChannelMembersById) {
        this.msgChannelMembersById = msgChannelMembersById;
    }
}
