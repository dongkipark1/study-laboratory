package org.example.videosample.video;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class VideoController {

    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload";  // 확장자를 생략하고 파일명만 작성
    }

    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("title") String title,
                              @RequestParam("description") String description,
                              @RequestParam("file") MultipartFile file,
                              Model model) {
        try {
            logger.info("Uploading video: title={}, description={}", title, description);
            Video video = videoService.saveVideo(title, description, file);
            logger.info("Video uploaded successfully: id={}", video.getId());
            model.addAttribute("video", video);
            return "redirect:/video/" + video.getId();
        } catch (IOException e) {
            logger.error("Failed to upload video", e);
            model.addAttribute("message", "Failed to upload video");
            return "upload";  // 확장자를 생략하고 파일명만 작성
        }
    }

    @GetMapping("/video/{id}")
    public String getVideo(@PathVariable Integer id, Model model) {
        logger.info("Fetching video with id={}", id);
        Video video = videoService.getVideoById(id);
        model.addAttribute("video", video);
        return "video";  // 확장자를 생략하고 파일명만 작성
    }
}
