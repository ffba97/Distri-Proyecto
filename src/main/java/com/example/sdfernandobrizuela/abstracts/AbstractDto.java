package com.example.sdfernandobrizuela.abstracts;

import com.example.sdfernandobrizuela.interfaces.IDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractDto implements IDto {
    private Integer id;

    @Override
    public Integer getId(){
        return id;
    }

    @Override
    public void setId(Integer id){
        this.id=id;
    }

}
