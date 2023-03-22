package school.hei.haapi.endpoint.rest.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
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
      @RequestParam(value = "code", required = false, defaultValue = "")
      String code,
      @RequestParam(value = "name", required = false, defaultValue = "")
      String name,
      @RequestParam(value = "teacher_first_name", required = false, defaultValue = "")
      String teacherFirstName,
      @RequestParam(value = "teacher_last_name", required = false, defaultValue = "")
      String teacherLastName,
      @RequestParam(value = "credits", required = false) Integer credits,
      @RequestParam PageFromOne page,
      @RequestParam("page_size") BoundedPageSize pageSize
  ) {
    return service.getAll(page, pageSize, code, name, credits, teacherFirstName, teacherLastName)
        .stream()
        .map(mapper::toRest)
        .collect(Collectors.toUnmodifiableList());
  }
}
