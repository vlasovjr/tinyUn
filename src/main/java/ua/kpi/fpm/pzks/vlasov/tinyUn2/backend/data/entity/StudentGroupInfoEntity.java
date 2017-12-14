package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.util.LocalDatePersistenceConverter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_group_info", schema = "tinyUnDB", catalog = "")
public class StudentGroupInfoEntity extends BasicEntity{
    private int idstudentGroupInfo;
    private String name;
    private String academicDegree;
    private java.time.LocalDate yearOfFoundation;
    private java.time.LocalDate yearOfIssue;
    private String status;
    private int departmentIddepartment;
    private String tmpCurator;
    private Integer starostaIdstudent;
    private Collection<StudentEntity> studentsByIdstudentGroupInfo;
    private DepartmentEntity departmentByDepartmentIddepartment;
    private StudentEntity studentByStarostaIdstudent;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idstudent_group_info", nullable = false)
    public int getIdstudentGroupInfo() {
        return idstudentGroupInfo;
    }

    public void setIdstudentGroupInfo(int idstudentGroupInfo) {
        this.idstudentGroupInfo = idstudentGroupInfo;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "academic_degree", nullable = true, length = 45)
    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    @Basic
    @Convert(converter = LocalDatePersistenceConverter.class)
    @Column(name = "year_of_foundation", nullable = true)
    public java.time.LocalDate getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(java.time.LocalDate yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    @Basic
    @Convert(converter = LocalDatePersistenceConverter.class)
    @Column(name = "year_of_issue", nullable = true)
    public java.time.LocalDate getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(java.time.LocalDate yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "department_iddepartment", nullable = false)
    public int getDepartmentIddepartment() {
        return departmentIddepartment;
    }

    public void setDepartmentIddepartment(int departmentIddepartment) {
        this.departmentIddepartment = departmentIddepartment;
    }

    @Basic
    @Column(name = "tmp_curator", nullable = true, length = 45)
    public String getTmpCurator() {
        return tmpCurator;
    }

    public void setTmpCurator(String tmpCurator) {
        this.tmpCurator = tmpCurator;
    }

    @Basic
    @Column(name = "starosta_idstudent", nullable = true)
    public Integer getStarostaIdstudent() {
        return starostaIdstudent;
    }

    public void setStarostaIdstudent(Integer starostaIdstudent) {
        this.starostaIdstudent = starostaIdstudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroupInfoEntity that = (StudentGroupInfoEntity) o;
        return idstudentGroupInfo == that.idstudentGroupInfo &&
                departmentIddepartment == that.departmentIddepartment &&
                Objects.equals(name, that.name) &&
                Objects.equals(academicDegree, that.academicDegree) &&
                Objects.equals(yearOfFoundation, that.yearOfFoundation) &&
                Objects.equals(yearOfIssue, that.yearOfIssue) &&
                Objects.equals(status, that.status) &&
                Objects.equals(tmpCurator, that.tmpCurator) &&
                Objects.equals(starostaIdstudent, that.starostaIdstudent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idstudentGroupInfo, name, academicDegree, yearOfFoundation, yearOfIssue, status, departmentIddepartment, tmpCurator, starostaIdstudent);
    }

    @OneToMany(mappedBy = "studentGroupInfoByStudentGroupInfoIdstudentGroupInfo", fetch = FetchType.EAGER)
    public Collection<StudentEntity> getStudentsByIdstudentGroupInfo() {
        return studentsByIdstudentGroupInfo;
    }

    public void setStudentsByIdstudentGroupInfo(Collection<StudentEntity> studentsByIdstudentGroupInfo) {
        this.studentsByIdstudentGroupInfo = studentsByIdstudentGroupInfo;
    }

    @ManyToOne
    @JoinColumn(name = "department_iddepartment", referencedColumnName = "iddepartment", nullable = false, insertable=false, updatable=false)
    public DepartmentEntity getDepartmentByDepartmentIddepartment() {
        return departmentByDepartmentIddepartment;
    }

    public void setDepartmentByDepartmentIddepartment(DepartmentEntity departmentByDepartmentIddepartment) {
        this.departmentByDepartmentIddepartment = departmentByDepartmentIddepartment;
    }

    @ManyToOne
    @JoinColumn(name = "starosta_idstudent", referencedColumnName = "idstudent", insertable=false, updatable=false)
    public StudentEntity getStudentByStarostaIdstudent() {
        return studentByStarostaIdstudent;
    }

    public void setStudentByStarostaIdstudent(StudentEntity studentByStarostaIdstudent) {
        this.studentByStarostaIdstudent = studentByStarostaIdstudent;
    }

    @Transient
    @Override
    public int getEntityId() {
        return idstudentGroupInfo;
    }

    @Transient
    @Override
    public void setFatherId(int id) {
        departmentIddepartment = id;
    }
}
