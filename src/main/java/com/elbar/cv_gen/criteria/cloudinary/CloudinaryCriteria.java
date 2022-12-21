package com.elbar.cv_gen.criteria.cloudinary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CloudinaryCriteria {
    private int size;
    private int page;
    private Sort.Direction direction;

    public int getPage() {
        if (Objects.isNull(page))
            page = 0;
        return page;
    }

    public int getSize() {
        if (Objects.isNull(size))
            size = 10;
        return size;
    }

    public Sort.Direction getSort() {
        if (Objects.isNull(direction)) {
            direction = Sort.Direction.ASC;
        }
        return direction;
    }
}
