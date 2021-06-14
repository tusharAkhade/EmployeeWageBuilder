public class EmployeeWage
{
	public static void main(String args[])
	{
		int is_present = 1;
		int emp_check = (int)(Math.floor(Math.random() * 10)) % 2;
		if( emp_check == is_present)
		{
			System.out.println("Employee is present");
		}
		else
			System.out.println("Employee is absent");
	}
}