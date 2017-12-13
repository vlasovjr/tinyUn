package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "faculty", schema = "kampus_old", catalog = "")
public class FacultyEntity {
    private int id;
    private String name;
    private Collection<DepartmentEntity> departmentsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyEntity that = (FacultyEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "facultyByFacultyId")
    public Collection<DepartmentEntity> getDepartmentsById() {
        return departmentsById;
    }

    public void setDepartmentsById(Collection<DepartmentEntity> departmentsById) {
        this.departmentsById = departmentsById;
    }
}
