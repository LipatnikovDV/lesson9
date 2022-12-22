import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Course CourseJava = new CoursImpliments("Java");
        Course CoursePyton = new CoursImpliments("Pyton");
        Course CourseLinux = new CoursImpliments("Linux");

        List<Student> students = Arrays.asList(
                new StudentsImpliments("Липатников", Arrays.asList(CourseJava, CoursePyton)),
                new StudentsImpliments("Вахрушев", Arrays.asList(CoursePyton, CourseLinux)),
                new StudentsImpliments("Гадя", Arrays.asList(CourseJava, CourseLinux)),
                new StudentsImpliments("Петрович", Arrays.asList(CourseJava, CoursePyton, CourseLinux)),
                new StudentsImpliments("Смирнова", null)
        );

        System.out.println(getUniqueCourses(students));
        System.out.println(getInquisitiveStudent(students));
        System.out.println(getStudentsByCourses(students, CoursePyton));
    }

    public static List<Course> getUniqueCourses(List<Student> students) {
        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .map(Student::getAllCourses)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Student> getInquisitiveStudent(List<Student> students) {
        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> {
                    List<Course> c1 = o1.getAllCourses();
                    List<Course> c2 = o2.getAllCourses();
                    return Integer.compare(
                            c2 == null ? 0 : c2.size(),
                            c1 == null ? 0 : c1.size()
                    );
                })
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsByCourses(List<Student> students, Course course) {
        if (course == null) {
            return new ArrayList<>();
        }

        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .filter(student -> {
                    List<Course> courses = student.getAllCourses();
                    courses = courses == null ? Collections.emptyList() : courses;
                    return courses.contains(course);
                })
                .collect(Collectors.toList());
    }
}
