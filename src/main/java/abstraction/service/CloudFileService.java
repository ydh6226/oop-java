package abstraction.service;

import abstraction.domain.CloudFile;
import abstraction.domain.CloudType;

import javax.swing.text.html.Option;
import java.io.File;
import java.util.List;
import java.util.Optional;

public interface CloudFileService {

    CloudFile findById(Long fileId);

    List<CloudFile> findAll();

    Long addFile(File file);
}
