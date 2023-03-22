package school.hei.haapi.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import school.hei.haapi.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
  @Query("select c from Course c")
  List<Course> findAllByCriteria(Pageable pageable);
}
