package mvtht.api.application.services;

import mvtht.api.application.mapper.generic.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericService<T, ID, REQ, UPT, RESP> {

    private final JpaRepository<T, ID> repository;
    private final Mapper<T, REQ, UPT, RESP> mapper;

    @Autowired
    public GenericService(JpaRepository<T, ID> repository, Mapper<T, REQ, UPT, RESP> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RESP save(REQ request) {
        T entity = mapper.toEntity(request);
        T savedEntity = repository.save(entity);
        return mapper.toResponse(savedEntity);
    }

    public List<RESP> list() {
        List<T> entities = repository.findAll();
        return mapper.toResponseList(entities);
    }

    public Optional<RESP> search(ID id) {
        Optional<T> entity = repository.findById(id);
        return entity.map(mapper::toResponse);
    }

    public RESP update(ID id, UPT updateRequest) {
        Optional<T> optEntity = repository.findById(id);

        if (optEntity.isEmpty()) {
            throw new RuntimeException("Entity not found...");
        }

        T entity = optEntity.get();
        mapper.update(updateRequest, entity);

        T updatedEntity = repository.save(entity);
        return mapper.toResponse(updatedEntity);
    }

    public void delete(ID id) { repository.deleteById(id); }

}