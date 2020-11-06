package cn.codewoo.service;

import cn.codewoo.entity.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "xdclass-video-service")
public interface IVideoService {
    @GetMapping("/api/v1/video/select_video")
    Video selectVideoById(@RequestParam int videoId);


    @PostMapping("/api/v1/video/save")
    int save(@RequestBody Video video);
}
