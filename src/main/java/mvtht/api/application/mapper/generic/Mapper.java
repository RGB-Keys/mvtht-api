package mvtht.api.application.mapper.generic;

import java.util.List;

public interface Mapper<T, REQ, UPT, RESP> {
    T toEntity(REQ request);

    void update(UPT updateDto, T entity);

    RESP toResponse(T entity);

    List<RESP> toResponseList(List<T> entities);
}
