/**
 * Refactor the code to manage employee wage of multiple companies
 * we are using single object to manage all the companies employee wage
 * @author Tushar Akhade
 * @since 19 Jun 2021
 */

public class EmployeeWageBuilder {
    public static final int IS_FUllTime = 1;
    public static final int IS_PARTTIME = 2;
    public static final int IS_ABSENT = 0;

    private int numOfCompany = 0;
    private EmployeeWage[] employeeWages;

    public static void main(String[] args) {
        EmployeeWageBuilder employeeWageBuilder = new EmployeeWageBuilder();
        employeeWageBuilder.addCompanyWAge("d-mart", 100, 20, 100);
        employeeWageBuilder.addCompanyWAge("jio-Mart", 150, 25, 110);
        employeeWageBuilder.computeEmpWage();
    }

    public EmployeeWageBuilder() {
        employeeWages = new EmployeeWage[10];
    }

    private void addCompanyWAge(String companyName, int max_working_hrs, int days_in_month, int wage_per_hr) {
        employeeWages[numOfCompany] = new EmployeeWage(companyName, max_working_hrs, days_in_month, wage_per_hr);
        numOfCompany++;
    }

    private void computeEmpWage() {
        for (int i = 0; i < numOfCompany; i++) {
            employeeWages[i].setTotalWage(this.computeEmpWage(employeeWages[i]));
            System.out.println(employeeWages[i]);
        }
    }

    private int computeEmpWage(EmployeeWage employeeWage) {
        int working_hr = 0;
        int total_working_hr = 0;
        int monthly_total_wage = 0;
        int daily_wage_array[] = new int[employeeWage.days_in_month];
        int days = 0;
        while (days < employeeWage.days_in_month && total_working_hr < employeeWage.max_working_hrs) {
            int emp_check = (int) (Math.floor(Math.random() * 10)) % 3;
            switch (emp_check) {
                case IS_FUllTime -> {
                    working_hr = 8;
                }
                case IS_PARTTIME -> {
                    working_hr = 4;
                }
                case IS_ABSENT -> {
                    working_hr = 0;
                }
            }
            total_working_hr += working_hr;
            daily_wage_array[days] = working_hr * employeeWage.wage_per_hr;
            days++;
        }
        for (int j = 0; j < employeeWage.days_in_month; j++) {
            int day = j + 1;
            System.out.println("Day " + day + " wage is " + daily_wage_array[j]);
            monthly_total_wage = monthly_total_wage + daily_wage_array[j];
        }

        return monthly_total_wage;
    }
}
