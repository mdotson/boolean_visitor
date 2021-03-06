package com.github.mdotson.filters;

import com.github.mdotson.BooleanVisitor;
import lombok.Value;

import java.util.List;

@Value
public class AndFilter implements Filter {

    private final List<Filter> filters;

    @Override
    public boolean accept(BooleanVisitor visitor) {
        return filters.stream().reduce(true,
                (previousValue, filter) -> previousValue && filter.accept(visitor),
                (previousValue, currentValue) -> previousValue && currentValue);
    }
}
