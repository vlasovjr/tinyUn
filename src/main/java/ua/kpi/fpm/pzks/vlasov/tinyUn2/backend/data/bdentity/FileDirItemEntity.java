package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.bdentity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "file_dir_item", schema = "kampus_old", catalog = "")
public class FileDirItemEntity {
    private int id;
    private int fileId;
    private int fileDirId;
    private FileUnitEntity fileUnitByFileId;
    private FileDirInfoEntity fileDirInfoByFileDirId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "file_id", nullable = false)
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "file_dir_id", nullable = false)
    public int getFileDirId() {
        return fileDirId;
    }

    public void setFileDirId(int fileDirId) {
        this.fileDirId = fileDirId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileDirItemEntity that = (FileDirItemEntity) o;
        return id == that.id &&
                fileId == that.fileId &&
                fileDirId == that.fileDirId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fileId, fileDirId);
    }

    @ManyToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id", nullable = false)
    public FileUnitEntity getFileUnitByFileId() {
        return fileUnitByFileId;
    }

    public void setFileUnitByFileId(FileUnitEntity fileUnitByFileId) {
        this.fileUnitByFileId = fileUnitByFileId;
    }

    @ManyToOne
    @JoinColumn(name = "file_dir_id", referencedColumnName = "id", nullable = false)
    public FileDirInfoEntity getFileDirInfoByFileDirId() {
        return fileDirInfoByFileDirId;
    }

    public void setFileDirInfoByFileDirId(FileDirInfoEntity fileDirInfoByFileDirId) {
        this.fileDirInfoByFileDirId = fileDirInfoByFileDirId;
    }
}
