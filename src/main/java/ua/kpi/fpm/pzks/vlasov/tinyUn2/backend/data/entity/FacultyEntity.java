package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "faculty", schema = "tinyUnDB", catalog = "")
public class FacultyEntity extends BasicEntity  {
    private int idfaculty;
    private int universityIduniversity;
    private String name;
    private Collection<DepartmentEntity> departmentsByIdfaculty;
    private UniversityEntity universityByUniversityIduniversity;

    @Id
    @Column(name = "idfaculty", nullable = false)
    public int getIdfaculty() {
        return idfaculty;
    }

    public void setIdfaculty(int idfaculty) {
        this.idfaculty = idfaculty;
    }

    @Basic
    @Column(name = "university_iduniversity", nullable = false)
    public int getUniversityIduniversity() {
        return universityIduniversity;
    }

    public void setUniversityIduniversity(int universityIduniversity) {
        this.universityIduniversity = universityIduniversity;
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
        FacultyEntity that = (FacultyEntity) o;
        return idfaculty == that.idfaculty &&
                universityIduniversity == that.universityIduniversity &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idfaculty, universityIduniversity, name);
    }

    @OneToMany(mappedBy = "facultyByFacultyIdfaculty", fetch = FetchType.EAGER)
    public Collection<DepartmentEntity> getDepartmentsByIdfaculty() {
        return departmentsByIdfaculty;
    }

    public void setDepartmentsByIdfaculty(Collection<DepartmentEntity> departmentsByIdfaculty) {
        this.departmentsByIdfaculty = departmentsByIdfaculty;
    }

    @ManyToOne
    @JoinColumn(name = "university_iduniversity", referencedColumnName = "iduniversity", nullable = false, insertable=false, updatable=false)
    public UniversityEntity getUniversityByUniversityIduniversity() {
        return universityByUniversityIduniversity;
    }

    public void setUniversityByUniversityIduniversity(UniversityEntity universityByUniversityIduniversity) {
        this.universityByUniversityIduniversity = universityByUniversityIduniversity;
    }

    @Transient
    @Override
    public int getEntityId() {
        return getIdfaculty();
    }

    @Transient
    @Override
    public void setFatherId(int id) {
        universityIduniversity = id;
    }
}
