package com.example.asset.transformer;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public abstract class CommonTransformer<T, E> implements ITransformer<T, E> {
    private final Class<T> tClass;
    private final Class<E> eClass;
    private final ModelMapper modelMapper;

    public CommonTransformer(Class<T> tClass, Class<E> eClass, ModelMapper modelMapper) {
        this.tClass = tClass;
        this.eClass = eClass;
        this.modelMapper = modelMapper;
    }

    @Override
    public T toDTO(E e) {
        return modelMapper.map(e, tClass);
    }

    @Override
    public E toEntity(T t) {
        return modelMapper.map(t, eClass);
    }

    @Override
    public T opToDTO(Optional<E> e) {
        if (e.isPresent()) {
            return modelMapper.map(e, tClass);
        }
        return null;
    }

    @Override
    public E opToEntity(Optional<T> t) {
        if (t.isPresent()) {
            return modelMapper.map(t, eClass);
        }
        return null;
    }
}
