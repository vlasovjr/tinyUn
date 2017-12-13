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
@Table(name = "user_extra_contacts", schema = "tinyUnDB", catalog = "")
public class UserExtraContactsEntity extends BasicEntity{
    private int iduserExtraContacts;
    private int userIduser;
    private String type;
    private String contact;
    private String visibility;
    private UserEntity userByUserIduser;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "iduser_extra_contacts", unique=true, nullable=false, insertable=true, updatable=true)
    public int getIduserExtraContacts() {
        return iduserExtraContacts;
    }

    public void setIduserExtraContacts(int iduserExtraContacts) {
        this.iduserExtraContacts = iduserExtraContacts;
    }

    @Basic
    @Column(name = "user_iduser", nullable = false)
    public int getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(int userIduser) {
        this.userIduser = userIduser;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "contact", nullable = false, length = 45)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "visibility", nullable = true, length = 45)
    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserExtraContactsEntity that = (UserExtraContactsEntity) o;
        return iduserExtraContacts == that.iduserExtraContacts &&
                userIduser == that.userIduser &&
                Objects.equals(type, that.type) &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(visibility, that.visibility);
    }

    @Override
    public int hashCode() {

        return Objects.hash(iduserExtraContacts, userIduser, type, contact, visibility);
    }

    @ManyToOne
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", nullable = false, insertable=false, updatable=false)
    public UserEntity getUserByUserIduser() {
        return userByUserIduser;
    }

    public void setUserByUserIduser(UserEntity userByUserIduser) {
        this.userByUserIduser = userByUserIduser;
    }

    @Transient
    @Override
    public int getEntityId() {
        return getIduserExtraContacts();
    }

    @Transient
    @Override
    public void setFatherId(int id){
        this.userIduser = id;
    }
}
