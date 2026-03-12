package com.klu.skill7.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.skill7.model.Course;

@Service
public class CourseService {

    List<Course> courses = new ArrayList<>();

    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        for(Course c : courses) {
            if(c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    public Course updateCourse(int id, Course newCourse) {
        for(Course c : courses) {
            if(c.getCourseId() == id) {
                c.setTitle(newCourse.getTitle());
                c.setDuration(newCourse.getDuration());
                c.setFee(newCourse.getFee());
                return c;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id) {
        return courses.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {

        List<Course> result = new ArrayList<>();

        for(Course c : courses) {
            if(c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }

        return result;
    }
}