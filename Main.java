import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final List<Student> students = new ArrayList<>();
    private final List<Staff> staffMembers = new ArrayList<>();

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        String[] options = {"Student", "Staff", "Finish"};

        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Select Student or Staff.",
                    "Accounting App",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 0) {
                addStudent();
            } else if (choice == 1) {
                addStaff();
            } else {
                break;
            }
        }

        processPayments();
    }

    private void addStudent() {
        String name = JOptionPane.showInputDialog("Enter Student Name:");
        String address = JOptionPane.showInputDialog("Enter Student Address:");

        int year = 0;
        boolean validInput = false;

        while (!validInput) {
            String yearInput = JOptionPane.showInputDialog("Enter student year (1-4):");
            try {
                year = Integer.parseInt(yearInput);
                if (year >= 1 && year <= 4) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Year must be between 1 and 4", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (!name.isEmpty() && !address.isEmpty()) {
            students.add(new Student(name, address, year));
        } else {
            JOptionPane.showMessageDialog(null, "Please enter valid information", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addStaff() {
        String name = JOptionPane.showInputDialog("Enter Staff Name:");
        String address = JOptionPane.showInputDialog("Enter Staff Address:");

        int yearsOfService = 0;
        boolean validInput = false;

        while (!validInput) {
            String yearsInput = JOptionPane.showInputDialog("Enter staff years of service:");
            try {
                yearsOfService = Integer.parseInt(yearsInput);
                if (yearsOfService > 0 && yearsOfService <= 30) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Years of Service must be between 1 and 30", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (!name.isEmpty() && !address.isEmpty()) {
            staffMembers.add(new Staff(name, address, yearsOfService));
        } else {
            JOptionPane.showMessageDialog(null, "Please enter valid information", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processPayments() {
        double incoming = 0;
        double outgoing = 0;

        StringBuilder report = new StringBuilder("Students: [Total: ").append(students.size()).append("]\n");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            report.append(i + 1).append(". ").append(student).append("\n");
            incoming += student.getInvoiceAmount();
        }

        report.append("\nStaff: [Total: ").append(staffMembers.size()).append("]\n");
        for (int i = 0; i < staffMembers.size(); i++) {
            Staff staff = staffMembers.get(i);
            report.append(i + 1).append(". ").append(staff).append("\n");
            outgoing += staff.getBiWeeklyPay();
        }

        double total = incoming - outgoing;
        report.append("\nResults:\n")
                .append("Outgoing: $").append(String.format("%.2f", outgoing)).append("\n")
                .append("Incoming: $").append(String.format("%.2f", incoming)).append("\n")
                .append("Total: $").append(String.format("%.2f", total));

        JOptionPane.showMessageDialog(null, report.toString(), "Report", JOptionPane.INFORMATION_MESSAGE);
    }


}
