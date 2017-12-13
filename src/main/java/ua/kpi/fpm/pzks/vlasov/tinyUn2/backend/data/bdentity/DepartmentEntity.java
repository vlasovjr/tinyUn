package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "department", schema = "kampus_old", catalog = "")
public class DepartmentEntity {
    private int id;
    private String name;
    private int facultyId;
    private Collection<CourseSemesterInfoEntity> courseSemesterInfosById;
    private FacultyEntity facultyByFacultyId;
    private Collection<DepartmentSpecialtyEntity> departmentSpecialtiesById;
    private Collection<StudentGroupInfoEntity> studentGroupInfosById;
    private Collection<TeacherEntity> teachersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "faculty_id", nullable = false)
    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return id == that.id &&
                facultyId == that.facultyId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, facultyId);
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<CourseSemesterInfoEntity> getCourseSemesterInfosById() {
        return courseSemesterInfosById;
    }

    public void setCourseSemesterInfosById(Collection<CourseSemesterInfoEntity> courseSemesterInfosById) {
        this.courseSemesterInfosById = courseSemesterInfosById;
    }

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id", nullable = false)
    public FacultyEntity getFacultyByFacultyId() {
        return facultyByFacultyId;
    }

    public void setFacultyByFacultyId(FacultyEntity facultyByFacultyId) {
        this.facultyByFacultyId = facultyByFacultyId;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<DepartmentSpecialtyEntity> getDepartmentSpecialtiesById() {
        return departmentSpecialtiesById;
    }

    public void setDepartmentSpecialtiesById(Collection<DepartmentSpecialtyEntity> departmentSpecialtiesById) {
        this.departmentSpecialtiesById = departmentSpecialtiesById;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<StudentGroupInfoEntity> getStudentGroupInfosById() {
        return studentGroupInfosById;
    }

    public void setStudentGroupInfosById(Collection<StudentGroupInfoEntity> studentGroupInfosById) {
        this.studentGroupInfosById = studentGroupInfosById;
    }

    @OneToMany(mappedBy = "departmentByDepartmentId")
    public Collection<TeacherEntity> getTeachersById() {
        return teachersById;
    }

    public void setTeachersById(Collection<TeacherEntity> teachersById) {
        this.teachersById = teachersById;
    }
}
