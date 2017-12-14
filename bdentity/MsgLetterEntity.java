package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "msg_letter", schema = "kampus_old", catalog = "")
public class MsgLetterEntity {
    private int id;
    private int recipientId;
    private int senderId;
    private int letterBodyHeadId;
    private int msgType;
    private Timestamp time;
    private byte viewed;
    private UserAccountOldEntity userAccountOldByRecipientId;
    private UserAccountOldEntity userAccountOldBySenderId;
    private MsgLetterBodyPullEntity msgLetterBodyPullByLetterBodyHeadId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "recipient_id", nullable = false)
    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    @Basic
    @Column(name = "sender_id", nullable = false)
    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "letter_body_head_id", nullable = false)
    public int getLetterBodyHeadId() {
        return letterBodyHeadId;
    }

    public void setLetterBodyHeadId(int letterBodyHeadId) {
        this.letterBodyHeadId = letterBodyHeadId;
    }

    @Basic
    @Column(name = "msg_type", nullable = false)
    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "viewed", nullable = false)
    public byte getViewed() {
        return viewed;
    }

    public void setViewed(byte viewed) {
        this.viewed = viewed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgLetterEntity that = (MsgLetterEntity) o;
        return id == that.id &&
                recipientId == that.recipientId &&
                senderId == that.senderId &&
                letterBodyHeadId == that.letterBodyHeadId &&
                msgType == that.msgType &&
                viewed == that.viewed &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, recipientId, senderId, letterBodyHeadId, msgType, time, viewed);
    }

    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id", nullable = false)
    public UserAccountOldEntity getUserAccountOldByRecipientId() {
        return userAccountOldByRecipientId;
    }

    public void setUserAccountOldByRecipientId(UserAccountOldEntity userAccountOldByRecipientId) {
        this.userAccountOldByRecipientId = userAccountOldByRecipientId;
    }

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    public UserAccountOldEntity getUserAccountOldBySenderId() {
        return userAccountOldBySenderId;
    }

    public void setUserAccountOldBySenderId(UserAccountOldEntity userAccountOldBySenderId) {
        this.userAccountOldBySenderId = userAccountOldBySenderId;
    }

    @ManyToOne
    @JoinColumn(name = "letter_body_head_id", referencedColumnName = "id", nullable = false)
    public MsgLetterBodyPullEntity getMsgLetterBodyPullByLetterBodyHeadId() {
        return msgLetterBodyPullByLetterBodyHeadId;
    }

    public void setMsgLetterBodyPullByLetterBodyHeadId(MsgLetterBodyPullEntity msgLetterBodyPullByLetterBodyHeadId) {
        this.msgLetterBodyPullByLetterBodyHeadId = msgLetterBodyPullByLetterBodyHeadId;
    }
}
