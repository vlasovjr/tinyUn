package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "notification_student_transcript", schema = "kampus_old", catalog = "")
public class NotificationStudentTranscriptEntity {
    private int id;
    private int transcriptContentId;
    private String notifType;
    private Timestamp notifTime;
    private Byte viewed;
    private Timestamp destroyTime;
    private StudentTranscriptFieldEntity studentTranscriptFieldByTranscriptContentId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "transcript_content_id", nullable = false)
    public int getTranscriptContentId() {
        return transcriptContentId;
    }

    public void setTranscriptContentId(int transcriptContentId) {
        this.transcriptContentId = transcriptContentId;
    }

    @Basic
    @Column(name = "notif_type", nullable = false, length = 45)
    public String getNotifType() {
        return notifType;
    }

    public void setNotifType(String notifType) {
        this.notifType = notifType;
    }

    @Basic
    @Column(name = "notif_time", nullable = false)
    public Timestamp getNotifTime() {
        return notifTime;
    }

    public void setNotifTime(Timestamp notifTime) {
        this.notifTime = notifTime;
    }

    @Basic
    @Column(name = "viewed", nullable = true)
    public Byte getViewed() {
        return viewed;
    }

    public void setViewed(Byte viewed) {
        this.viewed = viewed;
    }

    @Basic
    @Column(name = "destroy_time", nullable = false)
    public Timestamp getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(Timestamp destroyTime) {
        this.destroyTime = destroyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationStudentTranscriptEntity that = (NotificationStudentTranscriptEntity) o;
        return id == that.id &&
                transcriptContentId == that.transcriptContentId &&
                Objects.equals(notifType, that.notifType) &&
                Objects.equals(notifTime, that.notifTime) &&
                Objects.equals(viewed, that.viewed) &&
                Objects.equals(destroyTime, that.destroyTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, transcriptContentId, notifType, notifTime, viewed, destroyTime);
    }

    @ManyToOne
    @JoinColumn(name = "transcript_content_id", referencedColumnName = "id", nullable = false)
    public StudentTranscriptFieldEntity getStudentTranscriptFieldByTranscriptContentId() {
        return studentTranscriptFieldByTranscriptContentId;
    }

    public void setStudentTranscriptFieldByTranscriptContentId(StudentTranscriptFieldEntity studentTranscriptFieldByTranscriptContentId) {
        this.studentTranscriptFieldByTranscriptContentId = studentTranscriptFieldByTranscriptContentId;
    }
}
