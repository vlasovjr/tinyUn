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
@Table(name = "university", schema = "tinyUnDB", catalog = "")
public class UniversityEntity extends BasicEntity {
    private int iduniversity;
    private String name;
    private Collection<FacultyEntity> facultiesByIduniversity;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "iduniversity", nullable = false)
    public int getIduniversity() {
        return iduniversity;
    }

    public void setIduniversity(int iduniversity) {
        this.iduniversity = iduniversity;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
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
        UniversityEntity that = (UniversityEntity) o;
        return iduniversity == that.iduniversity &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(iduniversity, name);
    }

    @OneToMany(mappedBy = "universityByUniversityIduniversity", fetch = FetchType.EAGER)
    public Collection<FacultyEntity> getFacultiesByIduniversity() {
        return facultiesByIduniversity;
    }

    public void setFacultiesByIduniversity(Collection<FacultyEntity> facultiesByIduniversity) {
        this.facultiesByIduniversity = facultiesByIduniversity;
    }

    @Transient
    @Override
    public int getEntityId() {
        return getIduniversity();
    }

    @Transient
    @Override
    public void setFatherId(int id) {

    }
}
