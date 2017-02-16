package io.redspark.mapper;

import io.redpsark.controller.dto.FacebookLocalDTO;
import io.redspark.domain.FacebookLocal;
import io.redspark.utils.MapperUtils;

import org.springframework.stereotype.Component;

@Component
public class FacebookMapper extends BaseMapper<FacebookLocal, FacebookLocalDTO> {
    
    private MapperUtils<FacebookLocal, FacebookLocalDTO> convert = new MapperUtils<FacebookLocal, FacebookLocalDTO>(FacebookLocal.class, FacebookLocalDTO.class);

    @Override
    public FacebookLocalDTO toDTO(FacebookLocal entity) {
        return convert.toDTO(entity);
    }

    @Override
    public FacebookLocal toEntity(FacebookLocalDTO dto) {
        return convert.toEntity(dto);
    }

}
