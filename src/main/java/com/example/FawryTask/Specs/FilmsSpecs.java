package com.example.FawryTask.Specs;

import com.example.FawryTask.Entities.Films;
import com.example.FawryTask.Utils.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class FilmsSpecs {
    public static Specification<Films> withFilter(String imdbID,String title,String year,String type){
        return (Root<Films> root , CriteriaQuery<?> criteriaQuery,  CriteriaBuilder criteriaBuilder) ->{
            Predicate predicate= criteriaBuilder.conjunction();
            if(!StringUtils.isNull(imdbID))
            {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("imdbID")), "%" + imdbID.toLowerCase() + "%"));
            }
            if(!StringUtils.isNull(title))
            {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
            }
            if(!StringUtils.isNull(year))
            {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("year")), "%" + year.toLowerCase() + "%"));
            }
            if(!StringUtils.isNull(type))
            {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("type")), "%" + type.toLowerCase() + "%"));
            }
            return predicate;
        };
    }
}
