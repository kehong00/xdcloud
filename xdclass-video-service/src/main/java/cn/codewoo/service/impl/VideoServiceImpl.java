package cn.codewoo.service.impl;

import cn.codewoo.entity.Video;
import cn.codewoo.mapper.VideoMapper;
import cn.codewoo.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName VideoServiceImpl
 * @Description 视频表服务层
 * @Author kehong
 * @Date 2020/11/4 8:01 下午
 * @Version 1.0
 **/
@Service
public class VideoServiceImpl implements IVideoService {

    @Autowired(required = false)
    VideoMapper videoMapper;


    @Override
    public Video selectVideoById(int id) {
        return videoMapper.selectVideoById(id);
    }
}
