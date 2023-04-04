package com.jetbrains.marco.photoz.clone.repository;

import com.jetbrains.marco.photoz.clone.model.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.OptionalInt;

public interface PhotozRepository extends CrudRepository<Photo,Integer> {

    void deleteById(Integer id);

    //Optional<Object> findAllById(Integer id);

    void delete(Integer id);

    OptionalInt findAllById(Integer id);
}
