package school.hei.haapi.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.Course;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.repository.CourseRepository;

import static org.springframework.data.domain.Sort.by;

@Service
@AllArgsConstructor
public class CourseService {
  private final CourseRepository repository;

  public List<Course> getAll(PageFromOne page, BoundedPageSize pageSize, String code, String name,
                             Integer credits, String teacherFirstName, String teacherLastName,
                             Direction codeOrder, Direction creditsOrder) {
    Sort sort = by(codeOrder, "code")
        .and(by(creditsOrder, "credits"));
    Pageable pageable = PageRequest.of(
        page.getValue() - 1,
        pageSize.getValue(), sort);
    return repository.findAllByCriteria(code, name, credits, teacherFirstName, teacherLastName,
        pageable);
  }
}
