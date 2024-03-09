package br.stapassoli.reactive.service;

import br.stapassoli.reactive.entity.Student;
import br.stapassoli.reactive.repository.StudentRepository;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Flux<Student> findAll() {
        return this.studentRepository.findAll().delayElements(Duration.ofMillis(2000));
    }

    public Mono<Student> saveStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Mono<Student> findAllByName(String firstName) {
        Mono<Student> student = this.studentRepository.findByFirstNameIgnoreCase(firstName);
        student.subscribe();
        return student;
    }

    public Mono<Student> findById(Integer id) {
        return this.studentRepository.findById(id);
    }

}
