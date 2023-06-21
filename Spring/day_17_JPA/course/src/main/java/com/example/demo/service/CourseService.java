package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Course;
import com.example.demo.model.Supporter;
import com.example.demo.model.Topic;
import com.example.demo.model.request.UpsertCourseRequest;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.SupporterRepository;
import com.example.demo.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private final SupporterRepository supporterRepository;

    private final TopicRepository topicRepository;




    public Page<Course> getAllCourse(Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        return courseRepository.findAll(pageRequest);
    }

    public Page<Course> getAllCourse(Integer page, Integer pageSize, String type) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        return courseRepository.findByType(pageRequest, type);
    }

    public List<Course> getAllCourse(String type) {
        return courseRepository.findByType(type);
    }

    public Course getCourseDetail(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found course with id = " + id);
                });
    }

    public Course createCourse(UpsertCourseRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setType(request.getType());
        course.setThumbnail(request.getThumbnail());

        Optional<Supporter> optionalSupporter = supporterRepository.findById(request.getSupporterId());
        optionalSupporter.ifPresent(course::setSupporter);

        Set<Topic> topics = new HashSet<>();
        if (request.getTopicIds() != null) {
            for (Integer topicId : request.getTopicIds()) {
                Optional<Topic> optionalTopic = topicRepository.findById(topicId);
                optionalTopic.ifPresent(topics::add);
            }
        }
        course.setTopics(topics);

        return courseRepository.save(course);
    }

    public Course updateCourse(Integer id, UpsertCourseRequest request) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.setName(request.getName());
            course.setDescription(request.getDescription());
            course.setType(request.getType());
            course.setThumbnail(request.getThumbnail());

            Optional<Supporter> optionalSupporter = supporterRepository.findById(request.getSupporterId());
            optionalSupporter.ifPresent(course::setSupporter);

            Set<Topic> topics = new HashSet<>();
            if (request.getTopicIds() != null) {
                for (Integer topicId : request.getTopicIds()) {
                    Optional<Topic> optionalTopic = topicRepository.findById(topicId);
                    optionalTopic.ifPresent(topics::add);
                }
            }
            course.setTopics(topics);

            return courseRepository.save(course);
        } else {
            return null;
        }
    }


    public void deleteCourse(Integer id){
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found id");
                });
        courseRepository.delete(course);
    }
}
