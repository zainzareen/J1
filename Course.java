import java.util.HashMap;
import java.util.Map;

class Course {
    private int studentId;
    private String name;
    private String program;
    private String semester;
    private Map<String, Integer> courseMarks; // Course code -> Marks mapping

    public Course(int studentId, String name, String program, String semester) {
        this.studentId = studentId;
        this.name = name;
        this.program = program;
        this.semester = semester;
        this.courseMarks = new HashMap<>();
    }

    public void registerCourse(String courseCode, String courseName) {
        // Register a course for the student
        courseMarks.put(courseCode, null); // Initialize marks as null
    }

    public void updateMarks(String courseCode, int marks) {
        // Update marks for a specific course
        if (courseMarks.containsKey(courseCode)) {
            courseMarks.put(courseCode, marks);
        }
    }

    public void printStudentInfo() {
        System.out.println("Student Information:");
        System.out.println("Name: " + name);
        System.out.println("Program: " + program);
        System.out.println("Semester: " + semester);
        System.out.println("Courses Registered:");
        for (String courseCode : courseMarks.keySet()) {
            System.out.println("- " + courseCode);
        }
    }

    public void printFailedCourses() {
        System.out.println("Failed Courses:");
        for (Map.Entry<String, Integer> entry : courseMarks.entrySet()) {
            String courseCode = entry.getKey();
            Integer marks = entry.getValue();
            if (marks != null && marks < 40) {
                System.out.println("- " + courseCode + " (Marks: " + marks + ")");
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        Course student1 = new Course(1, "Alice", "Computer Science", "Spring");
        student1.registerCourse("CS101", "Introduction to Programming");
        student1.registerCourse("CS201", "Data Structures");
        student1.updateMarks("CS101", 65);
        student1.updateMarks("CS201", 30);

        student1.printStudentInfo();
        student1.printFailedCourses();
    }
}
