package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "msg_chatroom_members", schema = "kampus_old", catalog = "")
public class MsgChatroomMembersEntity {
    private int id;
    private int userId;
    private int chatroomId;
    private UserAccountOldEntity userAccountOldByUserId;
    private MsgChatroomEntity msgChatroomByChatroomId;

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
    @Column(name = "chatroom_id", nullable = false)
    public int getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(int chatroomId) {
        this.chatroomId = chatroomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgChatroomMembersEntity that = (MsgChatroomMembersEntity) o;
        return id == that.id &&
                userId == that.userId &&
                chatroomId == that.chatroomId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, chatroomId);
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
    @JoinColumn(name = "chatroom_id", referencedColumnName = "id", nullable = false)
    public MsgChatroomEntity getMsgChatroomByChatroomId() {
        return msgChatroomByChatroomId;
    }

    public void setMsgChatroomByChatroomId(MsgChatroomEntity msgChatroomByChatroomId) {
        this.msgChatroomByChatroomId = msgChatroomByChatroomId;
    }
}
