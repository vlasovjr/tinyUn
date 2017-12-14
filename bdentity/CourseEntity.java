package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "kampus_old", catalog = "")
public class CourseEntity {
    private int id;
    private String name;
    private String officialCourseId;
    private Collection<CourseSemesterInfoEntity> courseSemesterInfosById;

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
    @Column(name = "official_course_id", nullable = true, length = 45)
    public String getOfficialCourseId() {
        return officialCourseId;
    }

    public void setOfficialCourseId(String officialCourseId) {
        this.officialCourseId = officialCourseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(officialCourseId, that.officialCourseId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, officialCourseId);
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<CourseSemesterInfoEntity> getCourseSemesterInfosById() {
        return courseSemesterInfosById;
    }

    public void setCourseSemesterInfosById(Collection<CourseSemesterInfoEntity> courseSemesterInfosById) {
        this.courseSemesterInfosById = courseSemesterInfosById;
    }
}
