package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "file_dir_in_dir", schema = "kampus_old", catalog = "")
public class FileDirInDirEntity {
    private int id;
    private int childeFileDirId;
    private int parentFileDirId;
    private FileDirInfoEntity fileDirInfoByChildeFileDirId;
    private FileDirInfoEntity fileDirInfoByParentFileDirId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "childe_file_dir_id", nullable = false)
    public int getChildeFileDirId() {
        return childeFileDirId;
    }

    public void setChildeFileDirId(int childeFileDirId) {
        this.childeFileDirId = childeFileDirId;
    }

    @Basic
    @Column(name = "parent_file_dir_id", nullable = false)
    public int getParentFileDirId() {
        return parentFileDirId;
    }

    public void setParentFileDirId(int parentFileDirId) {
        this.parentFileDirId = parentFileDirId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileDirInDirEntity that = (FileDirInDirEntity) o;
        return id == that.id &&
                childeFileDirId == that.childeFileDirId &&
                parentFileDirId == that.parentFileDirId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, childeFileDirId, parentFileDirId);
    }

    @ManyToOne
    @JoinColumn(name = "childe_file_dir_id", referencedColumnName = "id", nullable = false)
    public FileDirInfoEntity getFileDirInfoByChildeFileDirId() {
        return fileDirInfoByChildeFileDirId;
    }

    public void setFileDirInfoByChildeFileDirId(FileDirInfoEntity fileDirInfoByChildeFileDirId) {
        this.fileDirInfoByChildeFileDirId = fileDirInfoByChildeFileDirId;
    }

    @ManyToOne
    @JoinColumn(name = "parent_file_dir_id", referencedColumnName = "id", nullable = false)
    public FileDirInfoEntity getFileDirInfoByParentFileDirId() {
        return fileDirInfoByParentFileDirId;
    }

    public void setFileDirInfoByParentFileDirId(FileDirInfoEntity fileDirInfoByParentFileDirId) {
        this.fileDirInfoByParentFileDirId = fileDirInfoByParentFileDirId;
    }
}
