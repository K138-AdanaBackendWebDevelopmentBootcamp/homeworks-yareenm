package dev.patika.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudRepository<T>{

    List <T> findAll();
    T findById(int id);
    void saveToDb(T object);
    void deleteFromDb(int id);
    void updateOnDb(T object, int id);
    int findIdByName(String name);
}
