package cn.codewoo.mapper;

import cn.codewoo.entity.Video;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName VideoMapper
 * @Description 视频mapper
 * @Author kehong
 * @Date 2020/11/4 8:02 下午
 * @Version 1.0
 **/
public interface VideoMapper {
    /**
     * 根据视频id获取视频信息
     * @param videoId 视频id
     * @return
     */
    @Select("SELECT * FROM video WHERE id = #{id}")
    Video selectVideoById(int videoId);
}
