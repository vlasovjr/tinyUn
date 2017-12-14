package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "department_specialty", schema = "kampus_old", catalog = "")
public class DepartmentSpecialtyEntity {
    private int id;
    private int departmentId;
    private Integer number;
    private String name;
   // private DepartmentEntity departmentByDepartmentId;
    //private Collection<StudentTranscriptInfoEntity> studentTranscriptInfosById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "number", nullable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
        DepartmentSpecialtyEntity that = (DepartmentSpecialtyEntity) o;
        return id == that.id &&
                departmentId == that.departmentId &&
                Objects.equals(number, that.number) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, departmentId, number, name);
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
//*
    @OneToMany(mappedBy = "departmentSpecialtyByDepartmentSpecialtyId")
    public Collection<StudentTranscriptInfoEntity> getStudentTranscriptInfosById() {
        return studentTranscriptInfosById;
    }

    public void setStudentTranscriptInfosById(Collection<StudentTranscriptInfoEntity> studentTranscriptInfosById) {
        this.studentTranscriptInfosById = studentTranscriptInfosById;
    }//*/
}
