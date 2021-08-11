package abstraction.service;

import abstraction.domain.CloudType;
import abstraction.repository.GoogleCloudFileRepository;
import abstraction.repository.NaverCloudFileRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CloudFileServiceFactory {

    private static final Map<CloudType, CloudFileService> cloudFileServiceMap = new HashMap<>();

    static {
        cloudFileServiceMap.put(CloudType.GOOGLE, new GoogleCloudFileService(new GoogleCloudFileRepository()));
        cloudFileServiceMap.put(CloudType.NAVER, new NaverCloudFileService(new NaverCloudFileRepository()));
    }

    public static CloudFileService getInstance(CloudType cloudType) {
        CloudFileService cloudFileService = cloudFileServiceMap.get(cloudType);
        if (cloudFileService == null) {
            throw new IllegalArgumentException("Not Supported Cloud");
        }
        return cloudFileService;
    }
}
