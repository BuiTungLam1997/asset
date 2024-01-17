package com.example.asset.mapper;

import java.util.Optional;

public interface CommonMapper<T, E> {
    T toDTO(E e);

    E toEntity(T t);

    T opToDTO(Optional<E> e);

    E opToEntity(Optional<T> t);
}
