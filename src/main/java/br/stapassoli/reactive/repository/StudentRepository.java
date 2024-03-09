package br.stapassoli.reactive.repository;

import br.stapassoli.reactive.entity.Student;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE LOWER(s.firstName) = LOWER(:firstName)")
    Mono<Student> findByFirstNameIgnoreCase (String firstName);

}
