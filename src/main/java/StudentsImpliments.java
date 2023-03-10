import java.util.ArrayList;
import java.util.List;

public class StudentsImpliments implements Student {
    private String name;
    private List<Course> courses;

    public StudentsImpliments(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses == null ? new ArrayList<>(0) : courses;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return name;
    }
}
