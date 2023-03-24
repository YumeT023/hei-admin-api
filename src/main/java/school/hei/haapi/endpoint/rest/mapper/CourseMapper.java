package school.hei.haapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Teacher;
import school.hei.haapi.model.Course;
import school.hei.haapi.model.User;
import school.hei.haapi.service.UserService;

@Component
@AllArgsConstructor
public class CourseMapper {
    private UserService userService;
    private UserMapper userMapper;

    public Course toDomain(school.hei.haapi.endpoint.rest.model.Course course) {
        User teacher = course.getMainTeacher() != null ? userMapper.toDomain(course.getMainTeacher()) : null;

        return Course.builder()
                .id(course.getId())
                .name(course.getName())
                .code(course.getCode())
                .credits(course.getCredits())
                .teacher(teacher)
                .build();
    }

    public school.hei.haapi.endpoint.rest.model.Course toRest(Course course) {
        Teacher teacher = userMapper.toRestTeacher(course.getTeacher());

        return new school.hei.haapi.endpoint.rest.model.Course()
                .id(course.getId())
                .name(course.getName())
                .code(course.getCode())
                .credits(course.getCredits())
                .mainTeacher(teacher);
    }
}
