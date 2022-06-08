package com.imooc.course.service.impl;

import com.imooc.course.client.CourseListClient;
import com.imooc.course.dao.CoursePriceMapper;
import com.imooc.course.entity.Course;
import com.imooc.course.entity.CourseAndPrice;
import com.imooc.course.entity.CoursePrice;
import com.imooc.course.service.CoursePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：     课程价格的服务实现类
 */
@Service
public class CoursePriceServiceImpl implements CoursePriceService {

    @Autowired
    CoursePriceMapper coursePriceMapper;

    @Resource
    CourseListClient courseListClient;

    @Override
    public CoursePrice getCoursePrice(Integer courseId) {
        return coursePriceMapper.findCoursePrice(courseId);
    }

    @Override
    public List<CourseAndPrice> getCourseAndPrice() {
        List<Course> courseList = courseListClient.courseList();
        List<CourseAndPrice> courseAndPriceList = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);
            if (null != course) {
                CourseAndPrice courseAndPrice = new CourseAndPrice();
                courseAndPrice.setId(course.getId());
                courseAndPrice.setCourseId(course.getCourseId());
                courseAndPrice.setName(course.getCourseName());
                courseAndPrice.setPrice(coursePriceMapper.
                        findCoursePrice(course.getCourseId()).getPrice());
                courseAndPriceList.add(courseAndPrice);
            }
        }
        return courseAndPriceList;
    }

}
