package abstraction.controller;

import abstraction.domain.CloudFile;
import abstraction.domain.CloudType;
import abstraction.service.CloudFileService;
import abstraction.service.CloudFileServiceFactory;

import java.io.File;
import java.util.List;

public class CloudFileController {

    public CloudFile findById(CloudType cloudType, Long fileId) {
        CloudFileService cloudFileService = CloudFileServiceFactory.getInstance(cloudType);
        return cloudFileService.findById(fileId);
    }

    public List<CloudFile> findAll(CloudType cloudType) {
        CloudFileService cloudFileService = CloudFileServiceFactory.getInstance(cloudType);
        return cloudFileService.findAll();
    }

    public Long addFile(CloudType cloudType, File file) {
        CloudFileService cloudFileService = CloudFileServiceFactory.getInstance(cloudType);
        return cloudFileService.addFile(file);
    }
}
