package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "tinyUnDB", catalog = "")
public class UserEntity extends BasicEntity {
    private int iduser;
    private String login;
    private String password;
    private String role;
    private String firstName;
    private String secondName;
    private Collection<StudentEntity> studentsByIduser;
    private Collection<UserExtraContactsEntity> userExtraContactsByIduser;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "iduser", nullable = false)
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 20)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 10)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name", nullable = true, length = 45)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return iduser == that.iduser &&
                Objects.equals(role, that.role) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(iduser, login, password, role, firstName, secondName);
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "userByUserIduser")// fetch = FetchType.EAGER)
//    @OneToMany(mappedBy = "userByUserIduser", fetch = FetchType.EAGER)
    public Collection<StudentEntity> getStudentsByIduser() {
        return studentsByIduser;
    }

    public void setStudentsByIduser(Collection<StudentEntity> studentsByIduser) {
        this.studentsByIduser = studentsByIduser;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "userByUserIduser")// fetch = FetchType.EAGER)
//    @OneToMany(mappedBy = "userByUserIduser", fetch = FetchType.EAGER)
    public Collection<UserExtraContactsEntity> getUserExtraContactsByIduser() {
        return userExtraContactsByIduser;
    }

    public void setUserExtraContactsByIduser(Collection<UserExtraContactsEntity> userExtraContactsByIduser) {
        this.userExtraContactsByIduser = userExtraContactsByIduser;
    }

    @Transient
    @Override
    public int getEntityId() {
        return getIduser();
    }
    @Transient
    @Override
    public void setFatherId(int id){

    }

}
