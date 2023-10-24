package com.example.sdfernandobrizuela.interfaces;

import com.example.sdfernandobrizuela.abstracts.AbstractDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IController <T extends AbstractDto>{
    public T getById(Integer id);
    public List<T> getAll(@PathVariable(value = "page_num") Integer page);
    public T update(Integer id, T t);
    public String delete(Integer id);
}