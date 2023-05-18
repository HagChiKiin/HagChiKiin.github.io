package com.example.btvn.service;

import com.example.btvn.model.ReaderModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderService {
    private final List<ReaderModel> readerModels = new ArrayList<>();

    public List<ReaderModel> getAlReader() {
        return readerModels;
    }
    public void saveReader(ReaderModel readerModel) {
        readerModel.setId(readerModels.size());
        readerModels.add(readerModel);
    }

    public void delete(int id) {
        readerModels.removeIf(a->a.getId() == id);
    }

    public ReaderModel findById(int id) {
        for (ReaderModel r: readerModels
             ) {if(r.getId() == id) return r;
        }
        return null;
    }

    public void updateReader(ReaderModel readerModel) {
        readerModels.forEach(s->{
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

