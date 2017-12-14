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
@Table(name = "department", schema = "tinyUnDB", catalog = "")
public class DepartmentEntity extends BasicEntity  {
    private int iddepartment;
    private int facultyIdfaculty;
    private String name;
    private FacultyEntity facultyByFacultyIdfaculty;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "iddepartment", nullable = false)
    public int getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(int iddepartment) {
        this.iddepartment = iddepartment;
    }

    @Basic
    @Column(name = "faculty_idfaculty", nullable = false)
    public int getFacultyIdfaculty() {
        return facultyIdfaculty;
    }

    public void setFacultyIdfaculty(int facultyIdfaculty) {
        this.facultyIdfaculty = facultyIdfaculty;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return iddepartment == that.iddepartment &&
                facultyIdfaculty == that.facultyIdfaculty &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(iddepartment, facultyIdfaculty, name);
    }

    @ManyToOne
    @JoinColumn(name = "faculty_idfaculty", referencedColumnName = "idfaculty", nullable = false, insertable=false, updatable=false)
    public FacultyEntity getFacultyByFacultyIdfaculty() {
        return facultyByFacultyIdfaculty;
    }

    public void setFacultyByFacultyIdfaculty(FacultyEntity facultyByFacultyIdfaculty) {
        this.facultyByFacultyIdfaculty = facultyByFacultyIdfaculty;
    }

    @Transient
    @Override
    public int getEntityId() {
        return getIddepartment();
    }

    @Transient
    @Override
    public void setFatherId(int id) {
        facultyIdfaculty = id;
    }
}
