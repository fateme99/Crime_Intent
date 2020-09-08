package com.example.crimeintent.repository;

import java.util.List;
import java.util.UUID;

public interface IRepository<E> {

    List<E> getList();
    E get(UUID id);
    void insert(E e);
    void insertList(List<E> eList);
    void delete(UUID id);
    void update(E e);
}
