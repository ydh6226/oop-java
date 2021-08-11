package abstraction.service;

import abstraction.domain.CloudFile;
import abstraction.repository.CloudFileRepository;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;

public class NaverCloudFileService implements CloudFileService {

    private final CloudFileRepository cloudFileRepository;

    NaverCloudFileService(CloudFileRepository cloudFileRepository) {
        this.cloudFileRepository = cloudFileRepository;
    }

    @Override
    public CloudFile findById(Long fileId) {
        return null;
    }

    @Override
    public List<CloudFile> findAll() {
        return null;
    }

    @Override
    public Long addFile(File file) {
        return null;
    }
}
