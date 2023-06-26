package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Topic;
import com.example.demo.model.request.TopicRequest;
import com.example.demo.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    public Page<Topic> getAll(Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        return topicRepository.findAll(pageRequest);
    }


    public Topic createTopic(TopicRequest request) {
        String topicName = request.getName();

        // Kiểm tra topic trong cơ sở dữ liệu
        Topic existingTopic = topicRepository.findByName(topicName);

        // Kiểm tra kết quả truy vấn
        if (existingTopic != null) {
            // Topic đã tồn tại, xử lý thông báo lỗi hoặc ném một ngoại lệ
            throw new IllegalArgumentException("Topic already exists");
        }

        // Tạo mới topic
        Topic topic = new Topic();
        topic.setName(topicName);
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Integer id, TopicRequest request) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Topic not found with ID: " + id));

        String newTopicName = request.getName();

        // Kiểm tra xem tên topic đã thay đổi hay chưa
        if (!topic.getName().equals(newTopicName)) {
            // Kiểm tra topic mới có tồn tại trong cơ sở dữ liệu hay không
            Topic existingTopic = topicRepository.findByName(newTopicName);
            if (existingTopic != null) {
                // Topic đã tồn tại, xử lý thông báo lỗi hoặc ném một ngoại lệ
                throw new IllegalArgumentException("Topic already exists");
            }
        }

        // Cập nhật tên topic
        topic.setName(newTopicName);
        return topicRepository.save(topic);
    }

    public void deleteTopic(Integer id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Topic not found with ID: " + id));
        topicRepository.delete(topic);;

    }
}

