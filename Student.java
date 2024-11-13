public class Student extends Person {
    private final int year;
    private double fees;

    public Student(String name, String address, int year) {
        super(name + " Student", address + " Student St.");
        this.year = year;
        calculateFees();
    }

    private void calculateFees() {
        fees = 3000 + (year - 1) * 100;
    }

    public double getInvoiceAmount() {
        return fees / 2;
    }

    @Override
    public String toString() {
        return super.toString() + ", year = " + year + ", fee = $" + String.format("%.2f", fees);
    }
}
