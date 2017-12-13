package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "msg_channel_members", schema = "kampus_old", catalog = "")
public class MsgChannelMembersEntity {
    private int id;
    private int userId;
    private int channelId;
    private UserAccountOldEntity userAccountOldByUserId;
    private MsgChanelEntity msgChanelByChannelId;

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
    @Column(name = "channel_id", nullable = false)
    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgChannelMembersEntity that = (MsgChannelMembersEntity) o;
        return id == that.id &&
                userId == that.userId &&
                channelId == that.channelId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, channelId);
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
    @JoinColumn(name = "channel_id", referencedColumnName = "id", nullable = false)
    public MsgChanelEntity getMsgChanelByChannelId() {
        return msgChanelByChannelId;
    }

    public void setMsgChanelByChannelId(MsgChanelEntity msgChanelByChannelId) {
        this.msgChanelByChannelId = msgChanelByChannelId;
    }
}
