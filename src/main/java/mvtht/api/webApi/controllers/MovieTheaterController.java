package mvtht.api.webApi.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mvtht.api.application.dtos.request.MovieTheaterRequest;
import mvtht.api.application.dtos.response.MovieTheaterResponse;
import mvtht.api.application.dtos.update.MovieTheaterUpdate;
import mvtht.api.domain.services.MovieTheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movietht")
public class MovieTheaterController {

    @Autowired
    private MovieTheaterService service;

    @PostMapping
    @Transactional
    public ResponseEntity<MovieTheaterResponse> save(@RequestBody MovieTheaterRequest request) {
        var movietht = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(movietht);
    }

    @GetMapping
    public ResponseEntity<List<MovieTheaterResponse>> list() {
        var moviethtlist = service.list();
        return ResponseEntity.status(HttpStatus.OK).body(moviethtlist);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MovieTheaterResponse>> search(Long id) {
        var movietht = service.search(id);
        return ResponseEntity.status(HttpStatus.OK).body(movietht);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<MovieTheaterResponse> update(@PathVariable Long id,
                                                       @RequestBody @Valid MovieTheaterUpdate updateRequest) {

        var movietht = service.update(id, updateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(movietht);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<MovieTheaterResponse> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
