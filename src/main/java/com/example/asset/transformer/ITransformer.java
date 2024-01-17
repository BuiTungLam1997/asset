package com.example.asset.transformer;

import java.util.Optional;

public interface ITransformer<T, E> {
    T toDTO(E e);

    E toEntity(T t);

    T opToDTO(Optional<E> e);

    E opToEntity(Optional<T> t);
}
