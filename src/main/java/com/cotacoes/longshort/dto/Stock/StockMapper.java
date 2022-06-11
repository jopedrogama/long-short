package com.cotacoes.longshort.dto.Stock;

import com.cotacoes.longshort.model.StockModel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {

    @Autowired
    private ModelMapper modelMapper;

    public StockModel toModel(StockDto stockDto) {
        return modelMapper.map(stockDto, StockModel.class);
    }
}
