package school.hei.haapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Course;

@Component
@AllArgsConstructor
public class CourseMapper {
  private final UserMapper userMapper;

  public Course toRest(school.hei.haapi.model.Course course) {
    return new Course()
        .id(course.getId())
        .name(course.getName())
        .code(course.getCode())
        .totalHours(course.getTotalHours())
        .credits(course.getCredits())
        .mainTeacher(userMapper.toRestTeacher(course.getMainTeacher()));
  }
}
