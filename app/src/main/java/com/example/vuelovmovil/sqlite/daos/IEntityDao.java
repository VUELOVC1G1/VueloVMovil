package com.example.vuelovmovil.sqlite.daos;

public interface IEntityDao<T, K> {
    boolean save(T t);

    T getById(K k);

    boolean update(T t);

    boolean delete(T t);
}
