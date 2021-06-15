/**
 * Compute Employee wage for multiple companies
 * Note: Each Company has its own wage, number of working days
 *      and working hours per month.
 *
 * @author Tushar Akhade
 * @Since 15 Jun 2021
 */

import java.util.Scanner;
public class EmployeeWage {
    private static final int IS_FUllTime = 1;
    private static final int IS_PARTTIME = 2;
    private static final int IS_ABSENT = 0;
    private String companyName;
    private int max_working_hrs;
    private int days_in_month;
    private int wage_per_hr;
    EmployeeWage(String companyName, int max_working_hrs, int days_in_month, int wage_per_hr) {
        this.companyName = companyName;
        this.max_working_hrs = max_working_hrs;
        this.days_in_month = days_in_month;
        this.wage_per_hr = wage_per_hr;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a company name : ");
        String companyName = s.next();
        System.out.print("Enter maximum work hours of month : ");
        int max_working_hrs = s.nextInt();
        System.out.print("Enter maximum days in month : ");
        int days_in_month = s.nextInt();
        System.out.print("Enter wage per hour : ");
        int wage_per_hr = s.nextInt();
        EmployeeWage e = new EmployeeWage(companyName, max_working_hrs, days_in_month, wage_per_hr);
        e.employeeWage();
    }

    // Checking the employee attendance and paying salary based on their working hours
    void employeeWage() {
        int working_hr = 0;
        int total_working_hr = 0;
        int monthly_total_wage = 0;
        int daily_wage_array[] = new int[20];
        for (int i = 0; i < days_in_month && total_working_hr < max_working_hrs; i++) {
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
            daily_wage_array[i] = working_hr * wage_per_hr;
        }
        for (int j = 0; j < days_in_month; j++) {
            int day = j + 1;
            System.out.println("Day " + day + " wage is " + daily_wage_array[j]);
            monthly_total_wage = monthly_total_wage + daily_wage_array[j];
        }
        System.out.println("\nMonthly wage is " + monthly_total_wage);
    }

}
