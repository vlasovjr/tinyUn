package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course_semester_info", schema = "kampus_old", catalog = "")
public class CourseSemesterInfoEntity {
    private int id;
    private int courseId;
    private Integer hourse;
    private Integer credits;
    private String typeOfAttestation;
    private int part;
    private int departmentId;
    private int yearOfCreation;
    private Integer amountLections;
    private Integer amountPractice;
    private Integer amountLaboratory;
    private Integer fileDirInfoId;
    private CourseEntity courseByCourseId;
    //private DepartmentEntity departmentByDepartmentId;
    private FileDirInfoEntity fileDirInfoByFileDirInfoId;
    private Collection<CourseSemesterRequiredEntity> courseSemesterRequiredsById;
    private Collection<CourseSemesterUnitReaderEntity> courseSemesterUnitReadersById;
    //private Collection<StudentTranscriptFieldEntity> studentTranscriptFieldsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "course_id", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "hourse", nullable = true)
    public Integer getHourse() {
        return hourse;
    }

    public void setHourse(Integer hourse) {
        this.hourse = hourse;
    }

    @Basic
    @Column(name = "credits", nullable = true)
    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @Basic
    @Column(name = "type_of_attestation", nullable = false, length = 45)
    public String getTypeOfAttestation() {
        return typeOfAttestation;
    }

    public void setTypeOfAttestation(String typeOfAttestation) {
        this.typeOfAttestation = typeOfAttestation;
    }

    @Basic
    @Column(name = "part", nullable = false)
    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    @Basic
    @Column(name = "department_id", nullable = false)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "year_of_creation", nullable = true)
    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    @Basic
    @Column(name = "amount_lections", nullable = true)
    public Integer getAmountLections() {
        return amountLections;
    }

    public void setAmountLections(Integer amountLections) {
        this.amountLections = amountLections;
    }

    @Basic
    @Column(name = "amount_practice", nullable = true)
    public Integer getAmountPractice() {
        return amountPractice;
    }

    public void setAmountPractice(Integer amountPractice) {
        this.amountPractice = amountPractice;
    }

    @Basic
    @Column(name = "amount_laboratory", nullable = true)
    public Integer getAmountLaboratory() {
        return amountLaboratory;
    }

    public void setAmountLaboratory(Integer amountLaboratory) {
        this.amountLaboratory = amountLaboratory;
    }

    @Basic
    @Column(name = "file_dir_info_id", nullable = true)
    public Integer getFileDirInfoId() {
        return fileDirInfoId;
    }

    public void setFileDirInfoId(Integer fileDirInfoId) {
        this.fileDirInfoId = fileDirInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSemesterInfoEntity that = (CourseSemesterInfoEntity) o;
        return id == that.id &&
                courseId == that.courseId &&
                part == that.part &&
                departmentId == that.departmentId &&
                yearOfCreation == that.yearOfCreation &&
                Objects.equals(hourse, that.hourse) &&
                Objects.equals(credits, that.credits) &&
                Objects.equals(typeOfAttestation, that.typeOfAttestation) &&
                Objects.equals(amountLections, that.amountLections) &&
                Objects.equals(amountPractice, that.amountPractice) &&
                Objects.equals(amountLaboratory, that.amountLaboratory) &&
                Objects.equals(fileDirInfoId, that.fileDirInfoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, courseId, hourse, credits, typeOfAttestation, part, departmentId, yearOfCreation, amountLections, amountPractice, amountLaboratory, fileDirInfoId);
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    public CourseEntity getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(CourseEntity courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }
/*
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    public DepartmentEntity getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(DepartmentEntity departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }
//*/
    @ManyToOne
    @JoinColumn(name = "file_dir_info_id", referencedColumnName = "id")
    public FileDirInfoEntity getFileDirInfoByFileDirInfoId() {
        return fileDirInfoByFileDirInfoId;
    }

    public void setFileDirInfoByFileDirInfoId(FileDirInfoEntity fileDirInfoByFileDirInfoId) {
        this.fileDirInfoByFileDirInfoId = fileDirInfoByFileDirInfoId;
    }

    @OneToMany(mappedBy = "courseSemesterInfoByCourseSemesterInfoId")
    public Collection<CourseSemesterRequiredEntity> getCourseSemesterRequiredsById() {
        return courseSemesterRequiredsById;
    }

    public void setCourseSemesterRequiredsById(Collection<CourseSemesterRequiredEntity> courseSemesterRequiredsById) {
        this.courseSemesterRequiredsById = courseSemesterRequiredsById;
    }

    @OneToMany(mappedBy = "courseSemesterInfoByCourseSemesterInfoId")
    public Collection<CourseSemesterUnitReaderEntity> getCourseSemesterUnitReadersById() {
        return courseSemesterUnitReadersById;
    }

    public void setCourseSemesterUnitReadersById(Collection<CourseSemesterUnitReaderEntity> courseSemesterUnitReadersById) {
        this.courseSemesterUnitReadersById = courseSemesterUnitReadersById;
    }
/*
    @OneToMany(mappedBy = "courseSemesterInfoByCourseSemesterInfoId")
    public Collection<StudentTranscriptFieldEntity> getStudentTranscriptFieldsById() {
        return studentTranscriptFieldsById;
    }

    public void setStudentTranscriptFieldsById(Collection<StudentTranscriptFieldEntity> studentTranscriptFieldsById) {
        this.studentTranscriptFieldsById = studentTranscriptFieldsById;
    }//*/
}
