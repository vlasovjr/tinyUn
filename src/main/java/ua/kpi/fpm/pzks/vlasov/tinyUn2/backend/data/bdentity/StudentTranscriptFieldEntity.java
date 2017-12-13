package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "student_transcript_field", schema = "kampus_old", catalog = "")
public class StudentTranscriptFieldEntity {
    private int id;
    private int studentTranscriptInfoId;
    private int courseSemesterInfoId;
    private int teacherId;
    private String nationalScale;
    private int score;
    private String ects;
    private Date date;
    private Integer numberOfProtection;
    private int semester;
    private Collection<NotificationStudentTranscriptEntity> notificationStudentTranscriptsById;
    private StudentTranscriptInfoEntity studentTranscriptInfoByStudentTranscriptInfoId;
    private CourseSemesterInfoEntity courseSemesterInfoByCourseSemesterInfoId;
    private TeacherEntity teacherByTeacherId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_transcript_info_id", nullable = false)
    public int getStudentTranscriptInfoId() {
        return studentTranscriptInfoId;
    }

    public void setStudentTranscriptInfoId(int studentTranscriptInfoId) {
        this.studentTranscriptInfoId = studentTranscriptInfoId;
    }

    @Basic
    @Column(name = "course_semester_info_id", nullable = false)
    public int getCourseSemesterInfoId() {
        return courseSemesterInfoId;
    }

    public void setCourseSemesterInfoId(int courseSemesterInfoId) {
        this.courseSemesterInfoId = courseSemesterInfoId;
    }

    @Basic
    @Column(name = "teacher_id", nullable = false)
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "national_scale", nullable = true, length = 20)
    public String getNationalScale() {
        return nationalScale;
    }

    public void setNationalScale(String nationalScale) {
        this.nationalScale = nationalScale;
    }

    @Basic
    @Column(name = "score", nullable = false)
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Basic
    @Column(name = "ects", nullable = false, length = 3)
    public String getEcts() {
        return ects;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "number_of_protection", nullable = true)
    public Integer getNumberOfProtection() {
        return numberOfProtection;
    }

    public void setNumberOfProtection(Integer numberOfProtection) {
        this.numberOfProtection = numberOfProtection;
    }

    @Basic
    @Column(name = "semester", nullable = false)
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentTranscriptFieldEntity that = (StudentTranscriptFieldEntity) o;
        return id == that.id &&
                studentTranscriptInfoId == that.studentTranscriptInfoId &&
                courseSemesterInfoId == that.courseSemesterInfoId &&
                teacherId == that.teacherId &&
                score == that.score &&
                semester == that.semester &&
                Objects.equals(nationalScale, that.nationalScale) &&
                Objects.equals(ects, that.ects) &&
                Objects.equals(date, that.date) &&
                Objects.equals(numberOfProtection, that.numberOfProtection);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, studentTranscriptInfoId, courseSemesterInfoId, teacherId, nationalScale, score, ects, date, numberOfProtection, semester);
    }

    @OneToMany(mappedBy = "studentTranscriptFieldByTranscriptContentId")
    public Collection<NotificationStudentTranscriptEntity> getNotificationStudentTranscriptsById() {
        return notificationStudentTranscriptsById;
    }

    public void setNotificationStudentTranscriptsById(Collection<NotificationStudentTranscriptEntity> notificationStudentTranscriptsById) {
        this.notificationStudentTranscriptsById = notificationStudentTranscriptsById;
    }

    @ManyToOne
    @JoinColumn(name = "student_transcript_info_id", referencedColumnName = "id", nullable = false)
    public StudentTranscriptInfoEntity getStudentTranscriptInfoByStudentTranscriptInfoId() {
        return studentTranscriptInfoByStudentTranscriptInfoId;
    }

    public void setStudentTranscriptInfoByStudentTranscriptInfoId(StudentTranscriptInfoEntity studentTranscriptInfoByStudentTranscriptInfoId) {
        this.studentTranscriptInfoByStudentTranscriptInfoId = studentTranscriptInfoByStudentTranscriptInfoId;
    }

    @ManyToOne
    @JoinColumn(name = "course_semester_info_id", referencedColumnName = "id", nullable = false)
    public CourseSemesterInfoEntity getCourseSemesterInfoByCourseSemesterInfoId() {
        return courseSemesterInfoByCourseSemesterInfoId;
    }

    public void setCourseSemesterInfoByCourseSemesterInfoId(CourseSemesterInfoEntity courseSemesterInfoByCourseSemesterInfoId) {
        this.courseSemesterInfoByCourseSemesterInfoId = courseSemesterInfoByCourseSemesterInfoId;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    public TeacherEntity getTeacherByTeacherId() {
        return teacherByTeacherId;
    }

    public void setTeacherByTeacherId(TeacherEntity teacherByTeacherId) {
        this.teacherByTeacherId = teacherByTeacherId;
    }
}
