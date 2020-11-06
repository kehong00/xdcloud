package cn.codewoo.controller;

import cn.codewoo.entity.Video;
import cn.codewoo.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName controller
 * @Description 视频相关api
 * @Author kehong
 * @Date 2020/11/4 7:57 下午
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    @Autowired
    private IVideoService videoService;

    @GetMapping("/select_video")
    public Object selectVideoById(HttpServletRequest request, int videoId){
        Video video = videoService.selectVideoById(videoId);
        video.setServerInfo(request.getServerName() + ":" + request.getServerPort());
        return video;
    }
}
