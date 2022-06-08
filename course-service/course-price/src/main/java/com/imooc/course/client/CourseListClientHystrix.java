package com.imooc.course.client;

import com.imooc.course.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 断路器实现类
 */
@Component
public class CourseListClientHystrix implements CourseListClient {
    @Override
    public List<Course> courseList() {
        List<Course> defaultCourses = new ArrayList<>();
        Course defaultCourse = new Course();
        defaultCourse.setId(1);
        defaultCourse.setCourseName("默认课程");
        defaultCourse.setCourseId(1);
        defaultCourse.setValid(1);
        defaultCourses.add(defaultCourse);
        return defaultCourses;
    }
}
