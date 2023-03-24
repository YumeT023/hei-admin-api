package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.Course;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.repository.CourseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getCourses(
            PageFromOne page,
            BoundedPageSize pageSize,
            String teacherFirstName,
            String teacherLastName,
            String code,
            Integer credits,
            String name,
            Sort.Direction codeOrder,
            Sort.Direction creditsOrder
    ) {
        Pageable pageable = PageRequest.of(
                page.getValue()-1, pageSize.getValue(),
                Sort.by(codeOrder, "code").and(Sort.by(creditsOrder, "credits"))
        );

        return courseRepository.findAllByCriteria(
                code,
                name,
                credits,
                teacherFirstName,
                teacherLastName,
                pageable
        );
    }
}
