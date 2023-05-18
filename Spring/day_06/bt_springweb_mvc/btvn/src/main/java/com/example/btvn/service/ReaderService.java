package com.example.btvn.service;

import com.example.btvn.entity.Reader;
import com.example.btvn.model.ReaderModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReaderService {
    ObjectMapper objectMapper;
    List<Reader> readers = new ArrayList<>();
    private static int AUTO_ID = 1;

    public List<ReaderModel> getAlReader() {
        List<ReaderModel> result = new ArrayList<>();
        for (Reader r : readers) {
            ReaderModel readerModel = objectMapper.convertValue(r, ReaderModel.class);
            result.add(readerModel);
        }
        return result;

    }
    public void saveReader(ReaderModel readerModel) {
        Reader reader = objectMapper.convertValue(readerModel, Reader.class);
        reader.setId(AUTO_ID);
        readers.add(reader);
        AUTO_ID++;

    }

    public void delete(int id) {
        readers.removeIf(a->a.getId() == id);
    }

    public ReaderModel findById(int id) {
        Optional<Reader> readerOptional = readers
                .stream()
                .filter(s->s.getId() == id)
                .findFirst();  // lay thang dau tien
        if(readerOptional.isEmpty()){
            return null;
        }
        Reader reader = readerOptional.get();
        return objectMapper.convertValue(reader, ReaderModel.class);
    }

    public void updateReader(ReaderModel readerModel) {
        readers.forEach(s->{
            if(s.getId() != readerModel.getId()){
                return;
            }
            s.setId(readerModel.getId());
            s.setName(readerModel.getName());
            s.setAddress(readerModel.getAddress());
            s.setPhone(readerModel.getPhone());
            s.setReaderType(readerModel.getReaderType());
        });
    }
}

