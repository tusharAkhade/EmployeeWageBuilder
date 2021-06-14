public class EmployeeWage
{
	public static void main(String args[])
	{
		int is_fulltime_present = 1;
		int is_parttime_present = 2;
		int wage_per_hr = 20;
		int working_hr=0;
		int days_in_month=20;
		int monthly_total_wage = 0;
		int daily_wage_array[] = new int[20];
		for (int i=0; i<days_in_month; i++) {
			int emp_check = (int)(Math.floor(Math.random() * 10)) % 3;
			switch (emp_check) {
				case 1:
					working_hr = 8;
					break;
				case 2:
					working_hr = 4;
					break;
				default:
					working_hr = 0;
			}
			daily_wage_array[i] = working_hr * wage_per_hr;
		}

		for (int j=0; j<days_in_month; j++) {
			int day = j+1;
			System.out.println("Day " + day + " wage is " + daily_wage_array[j]);
			monthly_total_wage = monthly_total_wage + daily_wage_array[j];
		}
		System.out.println("\nMonthly wage is " + monthly_total_wage);
	}
}