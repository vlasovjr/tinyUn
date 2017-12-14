package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_transcript_field", schema = "tinyUnDB", catalog = "")
public class StudentTranscriptFieldEntity extends BasicEntity  {
    private int idstudentTranscriptField;
    private int studentIdstudent;
    private StudentEntity studentByStudentIdstudent;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idstudent_transcript_field", nullable = false)
    public int getIdstudentTranscriptField() {
        return idstudentTranscriptField;
    }

    public void setIdstudentTranscriptField(int idstudentTranscriptField) {
        this.idstudentTranscriptField = idstudentTranscriptField;
    }

    @Basic
    @Column(name = "student_idstudent", nullable = false)
    public int getStudentIdstudent() {
        return studentIdstudent;
    }

    public void setStudentIdstudent(int studentIdstudent) {
        this.studentIdstudent = studentIdstudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTranscriptFieldEntity that = (StudentTranscriptFieldEntity) o;
        return idstudentTranscriptField == that.idstudentTranscriptField &&
                studentIdstudent == that.studentIdstudent;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idstudentTranscriptField, studentIdstudent);
    }

    @ManyToOne
    @JoinColumn(name = "student_idstudent", referencedColumnName = "idstudent", nullable = false, insertable=false, updatable=false)
    public StudentEntity getStudentByStudentIdstudent() {
        return studentByStudentIdstudent;
    }

    public void setStudentByStudentIdstudent(StudentEntity studentByStudentIdstudent) {
        this.studentByStudentIdstudent = studentByStudentIdstudent;
    }

    @Transient
    @Override
    public int getEntityId() {
        return idstudentTranscriptField;
    }

    @Transient
    @Override
    public void setFatherId(int id) {

    }
}
