package school.hei.haapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.OrderingEnum;

@Component
@AllArgsConstructor
public class OrderingEnumMapper {
    public OrderingEnum toRest(Sort.Direction direction){
        return direction.isDescending() ? OrderingEnum.ASC: OrderingEnum.DESC;
    }

    public Sort.Direction toDomain(OrderingEnum direction){
        if (direction.toString().equals(Sort.Direction.ASC.toString()))
            return Sort.Direction.ASC;
        return Sort.Direction.DESC;
    }
}
