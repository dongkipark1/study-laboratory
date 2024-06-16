package org.example.videosample.video;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class VideoService {

    private static final Logger logger = LoggerFactory.getLogger(VideoService.class);

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video saveVideo(String title, String description, MultipartFile file) throws IOException {
        logger.info("Saving video: title={}, description={}", title, description);
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
            logger.info("Created upload directory: {}", uploadPath);
        }
        String filePath = uploadPath.resolve(file.getOriginalFilename()).toString();
        file.transferTo(new File(filePath));
        logger.info("Saved file to: {}", filePath);

        Video video = new Video();
        video.setTitle(title);
        video.setDescription(description);
        video.setFilePath("uploads/" + file.getOriginalFilename()); // 경로가 올바른지 확인
        Video savedVideo = videoRepository.save(video);
        logger.info("Video saved with id={}", savedVideo.getId());
        return savedVideo;
    }

    public Video getVideoById(Integer id) {
        logger.info("Getting video by id={}", id);
        return videoRepository.findById(id).orElseThrow(() -> new RuntimeException("Video not found"));
    }
}
