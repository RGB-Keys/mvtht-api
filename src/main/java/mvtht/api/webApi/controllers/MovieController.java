package mvtht.api.webApi.controllers;

import jakarta.transaction.Transactional;
import mvtht.api.application.dtos.request.MovieRequest;
import mvtht.api.application.dtos.response.MovieResponse;
import mvtht.api.application.dtos.update.MovieUpdate;
import mvtht.api.domain.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping
    @Transactional
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request) {
        var movie = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> list() {
        var movieList = service.list();
        return ResponseEntity.status(HttpStatus.OK).body(movieList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MovieResponse>> search(@PathVariable Long id) {
        var movie = service.search(id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @RequestBody MovieUpdate updateRequest) {
        var movie = service.update(id, updateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<MovieResponse> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}