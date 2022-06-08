package com.imooc.course.client;

import com.imooc.course.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Description:课程列表的feign客户端
 */

//fallback = CourseListClientHystrix.class  指定发生断路时调用的类
@FeignClient(value = "course-list",fallback = CourseListClientHystrix.class) //这个注解的作用是作为一个feign客户端并且指明针对哪个模块的。标识是配置文件的spring.application.name=xxx
public interface CourseListClient {

    @GetMapping("/courses")
    List<Course> courseList();
}
