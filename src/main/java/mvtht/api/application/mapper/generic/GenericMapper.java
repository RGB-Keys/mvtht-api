package mvtht.api.application.mapper.generic;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class GenericMapper<T, REQ, UPT, RESP> implements Mapper<T, REQ, UPT, RESP> {

    private final ModelMapper mapper;
    private final Class<T> entityClass;
    private final Class<RESP> responseClass;

    @Autowired
    public GenericMapper(Class<T> entityClass, Class<RESP> responseClass, ModelMapper mapper) {
        this.entityClass = entityClass;
        this.responseClass = responseClass;
        this.mapper = mapper;
    }

    @Override
    public T toEntity(REQ request) {
        return mapper.map(request, entityClass);
    }

    @Override
    public void update(UPT updateDto, T entity) {
        mapper.map(updateDto, entity);
    }

    @Override
    public RESP toResponse(T entity) {
        return mapper.map(entity, responseClass);
    }

    @Override
    public List<RESP> toResponseList(List<T> entities) {
        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}
