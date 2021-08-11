package abstraction.repository;

import abstraction.domain.CloudFile;

import java.util.List;
import java.util.Optional;

public class NaverCloudFileRepository implements CloudFileRepository {

    @Override
    public Optional<CloudFile> findById(Long fileId) {
        return Optional.empty();
    }

    @Override
    public List<CloudFile> findAll() {
        return null;
    }

    @Override
    public Long addFile(CloudFile file) {
        return null;
    }
}
