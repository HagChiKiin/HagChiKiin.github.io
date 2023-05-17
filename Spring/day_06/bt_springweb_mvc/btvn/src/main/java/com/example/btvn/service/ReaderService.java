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

    public void delete(int id) {
        readers.removeIf(a->a.getId() == id);
    }

    public Reader findById(int id) {
        for (Reader r: readers
             ) {if(r.getId() == id) return r;
        }
        return null;
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
            s.setReaderType(reader.getReaderType());
        });
    }
}

