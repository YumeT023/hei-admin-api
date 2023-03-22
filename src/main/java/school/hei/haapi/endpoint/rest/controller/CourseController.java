package school.hei.haapi.endpoint.rest.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.service.CourseService;

@RestController
@AllArgsConstructor
public class CourseController {
  private final CourseService service;
  private final CourseMapper mapper;

  @GetMapping("/courses")
  public List<Course> getCourses(
      @RequestParam("page_size") BoundedPageSize pageSize,
      @RequestParam(value = "page") PageFromOne page,
      @RequestParam(value = "creditsOrder", required = false, defaultValue = "ASC")
      Direction creditsOrder,
      @RequestParam(value = "codeOrder", required = false, defaultValue = "ASC")
      Direction codeOrder,
      @RequestParam(value = "code", required = false, defaultValue = "")
      String code,
      @RequestParam(value = "name", required = false, defaultValue = "")
      String name,
      @RequestParam(value = "teacher_first_name", required = false, defaultValue = "")
      String teacherFirstName,
      @RequestParam(value = "teacher_last_name", required = false, defaultValue = "")
      String teacherLastName,
      @RequestParam(value = "credits", required = false) Integer credits
  ) {
    return service.getAll(page, pageSize, code, name, credits, teacherFirstName, teacherLastName,
            codeOrder, creditsOrder)
        .stream()
        .map(mapper::toRest)
        .collect(Collectors.toUnmodifiableList());
  }
}
