package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student", schema = "tinyUnDB", catalog = "")
public class StudentEntity extends BasicEntity{
    private int idstudent;
    private Integer userIduser;
    private String idCardSeries;
    private Integer idCardNumber;
    private Date idCardIssued;
    private Date idCardDeadline;
    private String transcriptNumber;
    private int studentGroupInfoIdstudentGroupInfo;
    private String status;
    private UserEntity userByUserIduser;
    private StudentGroupInfoEntity studentGroupInfoByStudentGroupInfoIdstudentGroupInfo;
    private Collection<StudentGroupInfoEntity> studentGroupInfosByIdstudent;
    private Collection<StudentTranscriptFieldEntity> studentTranscriptFieldsByIdstudent;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idstudent", nullable = false)
    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    @Basic
    @Column(name = "user_iduser", nullable = true)
    public Integer getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(Integer userIduser) {
        this.userIduser = userIduser;
    }

    @Basic
    @Column(name = "id_card_series", nullable = true, length = 5)
    public String getIdCardSeries() {
        return idCardSeries;
    }

    public void setIdCardSeries(String idCardSeries) {
        this.idCardSeries = idCardSeries;
    }

    @Basic
    @Column(name = "id_card_number", nullable = true)
    public Integer getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(Integer idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    @Basic
    @Column(name = "id_card_issued", nullable = true)
    public Date getIdCardIssued() {
        return idCardIssued;
    }

    public void setIdCardIssued(Date idCardIssued) {
        this.idCardIssued = idCardIssued;
    }

    @Basic
    @Column(name = "id_card_deadline", nullable = true)
    public Date getIdCardDeadline() {
        return idCardDeadline;
    }

    public void setIdCardDeadline(Date idCardDeadline) {
        this.idCardDeadline = idCardDeadline;
    }

    @Basic
    @Column(name = "transcript_number", nullable = true, length = 45)
    public String getTranscriptNumber() {
        return transcriptNumber;
    }

    public void setTranscriptNumber(String transcriptNumber) {
        this.transcriptNumber = transcriptNumber;
    }

    @Basic
    @Column(name = "student_group_info_idstudent_group_info", nullable = false)
    public int getStudentGroupInfoIdstudentGroupInfo() {
        return studentGroupInfoIdstudentGroupInfo;
    }

    public void setStudentGroupInfoIdstudentGroupInfo(int studentGroupInfoIdstudentGroupInfo) {
        this.studentGroupInfoIdstudentGroupInfo = studentGroupInfoIdstudentGroupInfo;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 100)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return idstudent == that.idstudent &&
                studentGroupInfoIdstudentGroupInfo == that.studentGroupInfoIdstudentGroupInfo &&
                Objects.equals(userIduser, that.userIduser) &&
                Objects.equals(idCardSeries, that.idCardSeries) &&
                Objects.equals(idCardNumber, that.idCardNumber) &&
                Objects.equals(idCardIssued, that.idCardIssued) &&
                Objects.equals(idCardDeadline, that.idCardDeadline) &&
                Objects.equals(transcriptNumber, that.transcriptNumber) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idstudent, userIduser, idCardSeries, idCardNumber, idCardIssued, idCardDeadline, transcriptNumber, studentGroupInfoIdstudentGroupInfo, status);
    }

    @ManyToOne
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", insertable=false, updatable=false)
    public UserEntity getUserByUserIduser() {
        return userByUserIduser;
    }

    public void setUserByUserIduser(UserEntity userByUserIduser) {
        this.userByUserIduser = userByUserIduser;
    }

    @ManyToOne
    @JoinColumn(name = "student_group_info_idstudent_group_info", referencedColumnName = "idstudent_group_info", nullable = false, insertable=false, updatable=false)
    public StudentGroupInfoEntity getStudentGroupInfoByStudentGroupInfoIdstudentGroupInfo() {
        return studentGroupInfoByStudentGroupInfoIdstudentGroupInfo;
    }

    public void setStudentGroupInfoByStudentGroupInfoIdstudentGroupInfo(StudentGroupInfoEntity studentGroupInfoByStudentGroupInfoIdstudentGroupInfo) {
        this.studentGroupInfoByStudentGroupInfoIdstudentGroupInfo = studentGroupInfoByStudentGroupInfoIdstudentGroupInfo;
    }

    @OneToMany(mappedBy = "studentByStarostaIdstudent", fetch = FetchType.EAGER)
    public Collection<StudentGroupInfoEntity> getStudentGroupInfosByIdstudent() {
        return studentGroupInfosByIdstudent;
    }

    public void setStudentGroupInfosByIdstudent(Collection<StudentGroupInfoEntity> studentGroupInfosByIdstudent) {
        this.studentGroupInfosByIdstudent = studentGroupInfosByIdstudent;
    }

    @OneToMany(mappedBy = "studentByStudentIdstudent", fetch = FetchType.EAGER)
    public Collection<StudentTranscriptFieldEntity> getStudentTranscriptFieldsByIdstudent() {
        return studentTranscriptFieldsByIdstudent;
    }

    public void setStudentTranscriptFieldsByIdstudent(Collection<StudentTranscriptFieldEntity> studentTranscriptFieldsByIdstudent) {
        this.studentTranscriptFieldsByIdstudent = studentTranscriptFieldsByIdstudent;
    }

    @Transient
    @Override
    public int getEntityId() {
        return idstudent;
    }

    @Transient
    @Override
    public void setFatherId(int id) {

    }
}
