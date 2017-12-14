package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "student_group_info", schema = "kampus_old", catalog = "")
public class StudentGroupInfoEntity {
    private int id;
    private String name;
    private int semester;
    private String groupType;
    private Date formed;
    private Date release;
    private String status;
    private int departmentId;
    private int starostaId;
    private int curatorId;
    private Collection<CourseSemesterUnitGroupEntity> courseSemesterUnitGroupsById;
    private Collection<StudentEntity> studentsById;
    //private DepartmentEntity departmentByDepartmentId;
    private StudentEntity studentByStarostaId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "semester", nullable = false)
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Basic
    @Column(name = "group_type", nullable = false, length = 45)
    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    @Basic
    @Column(name = "formed", nullable = true)
    public Date getFormed() {
        return formed;
    }

    public void setFormed(Date formed) {
        this.formed = formed;
    }

    @Basic
    @Column(name = "release", nullable = true)
    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
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
    @Column(name = "department_id", nullable = false)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "starosta_id", nullable = false)
    public int getStarostaId() {
        return starostaId;
    }

    public void setStarostaId(int starostaId) {
        this.starostaId = starostaId;
    }

    @Basic
    @Column(name = "curator_id", nullable = false)
    public int getCuratorId() {
        return curatorId;
    }

    public void setCuratorId(int curatorId) {
        this.curatorId = curatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroupInfoEntity that = (StudentGroupInfoEntity) o;
        return id == that.id &&
                semester == that.semester &&
                departmentId == that.departmentId &&
                starostaId == that.starostaId &&
                curatorId == that.curatorId &&
                Objects.equals(name, that.name) &&
                Objects.equals(groupType, that.groupType) &&
                Objects.equals(formed, that.formed) &&
                Objects.equals(release, that.release) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, semester, groupType, formed, release, status, departmentId, starostaId, curatorId);
    }

    @OneToMany(mappedBy = "studentGroupInfoByStudentGroupInfoId")
    public Collection<CourseSemesterUnitGroupEntity> getCourseSemesterUnitGroupsById() {
        return courseSemesterUnitGroupsById;
    }

    public void setCourseSemesterUnitGroupsById(Collection<CourseSemesterUnitGroupEntity> courseSemesterUnitGroupsById) {
        this.courseSemesterUnitGroupsById = courseSemesterUnitGroupsById;
    }

    @OneToMany(mappedBy = "studentGroupInfoByStudentGroupInfoId")
    public Collection<StudentEntity> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<StudentEntity> studentsById) {
        this.studentsById = studentsById;
    }

  //  @ManyToOne
   // @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    //public DepartmentEntity getDepartmentByDepartmentId() {
    //    return departmentByDepartmentId;
   // }

  //  public void setDepartmentByDepartmentId(DepartmentEntity departmentByDepartmentId) {
  //      this.departmentByDepartmentId = departmentByDepartmentId;
   // }

    @ManyToOne
    @JoinColumn(name = "starosta_id", referencedColumnName = "id", nullable = false)
    public StudentEntity getStudentByStarostaId() {
        return studentByStarostaId;
    }

    public void setStudentByStarostaId(StudentEntity studentByStarostaId) {
        this.studentByStarostaId = studentByStarostaId;
    }
}
