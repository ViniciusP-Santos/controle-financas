package br.com.ifg.controlefinanca.models.util;

import org.modelmapper.ModelMapper;

import java.util.Objects;

public class ModelMapperUtil {
    private static ModelMapper modelMapper;

    private ModelMapperUtil() {
    }

    public static ModelMapper getInstance() {
        if(Objects.isNull(modelMapper)){
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }
}
