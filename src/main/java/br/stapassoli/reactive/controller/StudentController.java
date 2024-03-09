package br.stapassoli.reactive.controller;

import br.stapassoli.reactive.entity.Student;
import br.stapassoli.reactive.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Mono<Student> createStudent(@RequestBody Student student) {
        return this.studentService.saveStudent(student);
    }

    @GetMapping("/all")
    public Flux<Student> findAll() {
        return this.studentService.findAll();
    }

    @GetMapping
    public Mono<Student> findAllByName(@RequestParam(name = "name") String name) {
        return this.studentService.findAllByName(name);
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable(name = "id") Integer id) {
        return this.studentService.findById(id);
    }

}
