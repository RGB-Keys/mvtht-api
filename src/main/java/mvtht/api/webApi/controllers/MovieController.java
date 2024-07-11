package mvtht.api.controllers;

import jakarta.transaction.Transactional;
import mvtht.api.domain.dtos.request.MovieRequest;
import mvtht.api.domain.dtos.response.MovieResponse;
import mvtht.api.domain.dtos.update.MovieUpdate;
import mvtht.api.domain.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
        var movie = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @RequestBody MovieUpdate request) {
        var movie = service.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieResponse> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}