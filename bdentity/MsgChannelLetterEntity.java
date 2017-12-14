package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "msg_channel_letter", schema = "kampus_old", catalog = "")
public class MsgChannelLetterEntity {
    private int id;
    private int channelId;
    private int letterBodyHeadId;
    private int msgType;
    private Timestamp time;
    private MsgChanelEntity msgChanelByChannelId;
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
    @Column(name = "channel_id", nullable = false)
    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgChannelLetterEntity that = (MsgChannelLetterEntity) o;
        return id == that.id &&
                channelId == that.channelId &&
                letterBodyHeadId == that.letterBodyHeadId &&
                msgType == that.msgType &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, channelId, letterBodyHeadId, msgType, time);
    }

    @ManyToOne
    @JoinColumn(name = "channel_id", referencedColumnName = "id", nullable = false)
    public MsgChanelEntity getMsgChanelByChannelId() {
        return msgChanelByChannelId;
    }

    public void setMsgChanelByChannelId(MsgChanelEntity msgChanelByChannelId) {
        this.msgChanelByChannelId = msgChanelByChannelId;
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
