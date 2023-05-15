package com.example.btvn.service;

import com.example.btvn.entity.Book;
import com.example.btvn.entity.Reader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderService {
    private final List<Reader> readers = new ArrayList<>();

    public List<Reader> getAlReader() {
        return readers;
    }
    public void saveReader(Reader reader) {
        reader.setId(readers.size());
        readers.add(reader);
    }

    public void delete(String id) {
        readers.removeIf(a->a.getId() == Integer.parseInt(id));
    }

    public Reader findById(String id) {
        return readers.stream().filter(s->s.getId() == Integer.parseInt(id)).findFirst().get();
    }

    public void updateReader(Reader reader) {
        readers.forEach(s->{
            if(s.getId() != reader.getId()){
                return;
            }
            s.setId(reader.getId());
            s.setName(reader.getName());
            s.setAddress(reader.getAddress());
            s.setPhone(reader.getPhone());
        });
    }
}

