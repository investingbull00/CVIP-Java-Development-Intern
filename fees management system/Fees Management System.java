import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private double feesPaid;
    private double feesTotal;

    public Student(String studentId, String name, double feesTotal) {
        this.studentId = studentId;
        this.name = name;
        this.feesTotal = feesTotal;
        this.feesPaid = 0;
    }

    public void payFees(double amount) {
        feesPaid += amount;
    }

    public double getRemainingFees() {
        return feesTotal - feesPaid;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double getFeesTotal() {
        return feesTotal;
    }
}

class FeesManagementSystem {
    private ArrayList<Student> students;

    public FeesManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Fees Paid: ₹" + student.getFeesPaid());
            System.out.println("Total Fees: ₹" + student.getFeesTotal());
            System.out.println("Remaining Fees: ₹" + student.getRemainingFees());
            System.out.println("------------");
        }
    }

    public static void main(String[] args) {
        FeesManagementSystem feeSystem = new FeesManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Total Fees: ");
                    double feesTotal = scanner.nextDouble();
                    Student student = new Student(studentId, name, feesTotal);
                    feeSystem.addStudent(student);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    feeSystem.displayStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
