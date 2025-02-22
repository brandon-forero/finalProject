public class PartTimeTeacher extends Teacher{
    private int hoursPerWeek;
    private double salary;

    public PartTimeTeacher(String name, double baseSalary, int hoursPerWeek) {
        super(name, baseSalary);
        this.hoursPerWeek = hoursPerWeek;
        this.salary = calculateSalary();
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
        this.salary = calculateSalary();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return this.getBaseSalary() * this.hoursPerWeek;
    }
}
