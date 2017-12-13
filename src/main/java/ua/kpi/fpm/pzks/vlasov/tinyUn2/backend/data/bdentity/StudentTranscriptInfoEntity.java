package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "student_transcript_info", schema = "kampus_old", catalog = "")
public class StudentTranscriptInfoEntity {
    private int id;
    private int studentId;
    private String number;
    private Integer departmentSpecialtyId;
    private Date entered;
    private Integer photoDocId;
    private Collection<StudentTranscriptFieldEntity> studentTranscriptFieldsById;
    private StudentEntity studentByStudentId;
    private DepartmentSpecialtyEntity departmentSpecialtyByDepartmentSpecialtyId;
    private FileUnitEntity fileUnitByPhotoDocId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_id", nullable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "department_specialty_id", nullable = true)
    public Integer getDepartmentSpecialtyId() {
        return departmentSpecialtyId;
    }

    public void setDepartmentSpecialtyId(Integer departmentSpecialtyId) {
        this.departmentSpecialtyId = departmentSpecialtyId;
    }

    @Basic
    @Column(name = "entered", nullable = true)
    public Date getEntered() {
        return entered;
    }

    public void setEntered(Date entered) {
        this.entered = entered;
    }

    @Basic
    @Column(name = "photo_doc_id", nullable = true)
    public Integer getPhotoDocId() {
        return photoDocId;
    }

    public void setPhotoDocId(Integer photoDocId) {
        this.photoDocId = photoDocId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTranscriptInfoEntity that = (StudentTranscriptInfoEntity) o;
        return id == that.id &&
                studentId == that.studentId &&
                Objects.equals(number, that.number) &&
                Objects.equals(departmentSpecialtyId, that.departmentSpecialtyId) &&
                Objects.equals(entered, that.entered) &&
                Objects.equals(photoDocId, that.photoDocId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, studentId, number, departmentSpecialtyId, entered, photoDocId);
    }

    @OneToMany(mappedBy = "studentTranscriptInfoByStudentTranscriptInfoId")
    public Collection<StudentTranscriptFieldEntity> getStudentTranscriptFieldsById() {
        return studentTranscriptFieldsById;
    }

    public void setStudentTranscriptFieldsById(Collection<StudentTranscriptFieldEntity> studentTranscriptFieldsById) {
        this.studentTranscriptFieldsById = studentTranscriptFieldsById;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public StudentEntity getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(StudentEntity studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "department_specialty_id", referencedColumnName = "id")
    public DepartmentSpecialtyEntity getDepartmentSpecialtyByDepartmentSpecialtyId() {
        return departmentSpecialtyByDepartmentSpecialtyId;
    }

    public void setDepartmentSpecialtyByDepartmentSpecialtyId(DepartmentSpecialtyEntity departmentSpecialtyByDepartmentSpecialtyId) {
        this.departmentSpecialtyByDepartmentSpecialtyId = departmentSpecialtyByDepartmentSpecialtyId;
    }

    @ManyToOne
    @JoinColumn(name = "photo_doc_id", referencedColumnName = "id")
    public FileUnitEntity getFileUnitByPhotoDocId() {
        return fileUnitByPhotoDocId;
    }

    public void setFileUnitByPhotoDocId(FileUnitEntity fileUnitByPhotoDocId) {
        this.fileUnitByPhotoDocId = fileUnitByPhotoDocId;
    }
}
