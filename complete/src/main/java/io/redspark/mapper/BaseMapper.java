package io.redspark.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @param <E> entity
 * @param <D> dto
 */
public abstract class BaseMapper<E, D> {
    
    public PageImpl<D> toPage(Page<E> pages, Pageable page) {
        List<D> result = new ArrayList<D>();
        
        for (E entity : pages) {
            result.add(toDTO(entity));
        }
        
        return new PageImpl<D>(result, page, pages.getTotalElements());
    }
    
    public List<D> toListDTO(List<E> list) {
        List<D> result = new ArrayList<D>();
        
        for(E entity : list) {
            result.add(toDTO(entity));
        }
        
        return result;
    }
    
    public List<E> toListEntity(List<D> list) {
        List<E> result = new ArrayList<E>();
        
        for(D dto : list) {
            result.add(toEntity(dto));
        }
        
        return result;
    }
    
    public abstract D toDTO(E entity);
    
    public abstract E toEntity(D dto);
}
