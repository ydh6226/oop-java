package abstraction.repository;

import abstraction.domain.CloudFile;

import java.util.List;
import java.util.Optional;

public interface CloudFileRepository {

    Optional<CloudFile> findById(Long fileId);

    List<CloudFile> findAll();

    Long addFile(CloudFile file);
}
