public class Staff extends Person {
    private final int yearsOfService;
    private double salary;

    public Staff(String name, String address, int yearsOfService) {
        super(name + " Staff", address + " Staff St.");
        this.yearsOfService = yearsOfService;
        calculateSalary();
    }

    private void calculateSalary() {
        salary = 50000 + (yearsOfService * 500);
    }

    public double getBiWeeklyPay() {
        return salary / 26;
    }

    @Override
    public String toString() {
        return super.toString() + ", years = " + yearsOfService + ", pay = $" + String.format("%.2f", salary);
    }
}
