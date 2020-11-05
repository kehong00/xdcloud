package cn.codewoo.controller;

import cn.codewoo.entity.Order;
import cn.codewoo.entity.Video;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderController
 * @Description 订单相关api
 * @Author kehong
 * @Date 2020/11/4 8:24 下午
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/v1/video_order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/save")
    public Object save(int videoId){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("xdclass-video-service");
        ServiceInstance serviceInstance = serviceInstances.get(0);
        Video video = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/api/v1/video/select_video?videoId=" + videoId, Video.class);
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setId(1);
        order.setState(1);
        order.setUserId(1);
        order.setVideoId(video.getId());
        order.setVideoImg(video.getCoverImg());
        order.setVideoTitle(video.getTitle());
        return order;

    }

}
