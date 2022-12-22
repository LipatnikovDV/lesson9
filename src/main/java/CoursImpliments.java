public class CoursImpliments implements Course {
    private String name;

    public CoursImpliments(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
