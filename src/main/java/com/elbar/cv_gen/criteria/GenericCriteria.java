package com.elbar.cv_gen.criteria;

import lombok.*;
import org.springframework.data.domain.Sort;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GenericCriteria implements BaseCriteria {
    private Integer size;
    private Integer page;
    private Sort.Direction sort;

    public Integer getSize() {
        if (Objects.isNull(size))
            size = 10;
        return size;
    }

    public Integer getPage() {
        if (Objects.isNull(page))
            page = 0;
        return page;
    }

    public Sort.Direction getSort() {
        if (Objects.isNull(sort))
            sort = Sort.Direction.ASC;
        return sort;
    }
}
