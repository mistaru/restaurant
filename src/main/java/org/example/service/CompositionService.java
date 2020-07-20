package org.example.service;


import org.example.model.Ingredients;
import org.example.repository.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompositionService {

    @Autowired
    CompositionRepository compositionRepository;

    List<Ingredients> listIng(int id) {
        return compositionRepository.findListIngredients(id);
    }

}