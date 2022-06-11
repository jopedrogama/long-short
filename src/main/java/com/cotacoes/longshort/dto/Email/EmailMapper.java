package com.cotacoes.longshort.dto.Email;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cotacoes.longshort.model.RecieverEmailModel;

@Component
public class EmailMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RecieverEmailModel toModel(RecieverEmailDTO emailDTO) {
        return modelMapper.map(emailDTO, RecieverEmailModel.class);
    }
}
