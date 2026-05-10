import java.util.*;

public class StudentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();

        while(true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Update Student");
            System.out.println("6. Sort By Name");
            System.out.println("7. Sort By Marks");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    Student s =
                            new Student(id, name, age, marks);

                    service.addStudent(s);

                    break;

                case 2:

                    service.displayStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    service.searchStudent(searchId);

                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    int removeId = sc.nextInt();

                    service.removeStudent(removeId);

                    break;

                case 5:

                    System.out.print("Enter Student ID: ");
                    int updateId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();

                    System.out.print("Enter New Marks: ");
                    double newMarks = sc.nextDouble();

                    service.updateStudent(updateId,
                            newName, newAge, newMarks);

                    break;

                case 6:

                    service.sortByName();

                    break;

                case 7:

                    service.sortByMarks();

                    break;

                case 8:

                    System.out.println("Thank You");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}


class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student Added Successfully");
    }

    // Display all students
    public void displayStudents() {

        if(students.isEmpty()) {
            System.out.println("No Students Found");
            return;
        }

        for(Student s : students) {
            System.out.println(s);
        }
    }

    // Search student
    public void searchStudent(int id) {

        for(Student s : students) {
            if(s.getId() == id) {
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found");
    }

    // Remove student
    public void removeStudent(int id) {

        Iterator<Student> it = students.iterator();

        while(it.hasNext()) {

            Student s = it.next();

            if(s.getId() == id) {
                it.remove();
                System.out.println("Student Removed");
                return;
            }
        }

        System.out.println("Student Not Found");
    }

    // Update student
    public void updateStudent(int id, String name,
                              int age, double marks) {

        for(Student s : students) {

            if(s.getId() == id) {

                s.setName(name);
                s.setAge(age);
                s.setMarks(marks);

                System.out.println("Student Updated");
                return;
            }
        }

        System.out.println("Student Not Found");
    }

    // Sort by name
    public void sortByName() {

        Collections.sort(students,
                Comparator.comparing(Student::getName));

        System.out.println("Sorted By Name");
    }

    // Sort by marks
    public void sortByMarks() {

        Collections.sort(students,
                Comparator.comparingDouble(Student::getMarks));

        System.out.println("Sorted By Marks");
    }
}
class Student {

    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Age: " + age +
               ", Marks: " + marks;
    }
}