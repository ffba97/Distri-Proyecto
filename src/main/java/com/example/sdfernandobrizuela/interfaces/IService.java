package com.example.sdfernandobrizuela.interfaces;

import com.example.sdfernandobrizuela.abstracts.AbstractDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface IService<T extends AbstractDto> {
    public T create(T t);
    public T getById(Integer id);
    public Page<T> getAll(Pageable pag);
    public T update(Integer id, T t);
    public boolean delete(Integer id);
}
