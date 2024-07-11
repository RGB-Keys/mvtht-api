package mvtht.api.infra.mapper;

import java.util.List;

public interface Mapper<T, REQ, UPT, RESP> {
    T toEntity(REQ request);

    public void update(UPT updateDto, T entity);

    RESP toResponse(T entity);

    List<RESP> toResponseList(List<T> entities);
}
