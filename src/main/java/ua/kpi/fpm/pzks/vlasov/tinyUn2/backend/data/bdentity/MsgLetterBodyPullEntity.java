package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "msg_letter_body_pull", schema = "kampus_old", catalog = "")
public class MsgLetterBodyPullEntity {
    private int id;
    private String msgBody;
    private Collection<MsgChannelLetterEntity> msgChannelLettersById;
    private Collection<MsgChatroomLetterEntity> msgChatroomLettersById;
    private Collection<MsgLetterEntity> msgLettersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "msg_body", nullable = false, length = 500)
    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgLetterBodyPullEntity that = (MsgLetterBodyPullEntity) o;
        return id == that.id &&
                Objects.equals(msgBody, that.msgBody);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, msgBody);
    }

    @OneToMany(mappedBy = "msgLetterBodyPullByLetterBodyHeadId")
    public Collection<MsgChannelLetterEntity> getMsgChannelLettersById() {
        return msgChannelLettersById;
    }

    public void setMsgChannelLettersById(Collection<MsgChannelLetterEntity> msgChannelLettersById) {
        this.msgChannelLettersById = msgChannelLettersById;
    }

    @OneToMany(mappedBy = "msgLetterBodyPullByLetterBodyHeadId")
    public Collection<MsgChatroomLetterEntity> getMsgChatroomLettersById() {
        return msgChatroomLettersById;
    }

    public void setMsgChatroomLettersById(Collection<MsgChatroomLetterEntity> msgChatroomLettersById) {
        this.msgChatroomLettersById = msgChatroomLettersById;
    }

    @OneToMany(mappedBy = "msgLetterBodyPullByLetterBodyHeadId")
    public Collection<MsgLetterEntity> getMsgLettersById() {
        return msgLettersById;
    }

    public void setMsgLettersById(Collection<MsgLetterEntity> msgLettersById) {
        this.msgLettersById = msgLettersById;
    }
}
