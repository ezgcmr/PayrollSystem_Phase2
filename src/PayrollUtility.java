/**
 *  @author  Shahbaz Mughal, Mario Lugo, Marcio Dasilva, Ezgi Camur 
 */

import java.text.NumberFormat;
import java.util.ArrayList;

/**This class represents payroll utility and has constant variables that we use in SalariedEmployee class*/

public class PayrollUtility
{
    public static final int NUMBER_OF_PAY_PERIODS = 52;
    
    public static final double THRESHOLD = 950;
    public static final double TAX_RATE_LESS_THAN_THRESHOLD = .15;
    public static final double TAX_RATE_THRESHOLD_OR_MORE = .20;
       
    public static final double VAC_HOURS_LESS_THAN_THRESHOLD = 2;
    public static final double VAC_HOURS_THRESHOLD_OR_MORE = 3;
    
    public static final double BONUS_TAX_RATE = 0.20;
    
    /**
    convertToCurrencyString method
    @return string format
   */
    public static String convertToCurrencyString(double value)
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return String.format("%13s%n", fmt.format(value)); 
    }
    
    /**
    convertToCurrencyStringLeftAligned method
    @return string format
   */
    public static String convertToCurrencyStringLeftAligned(double value)
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return String.format("%s", fmt.format(value)); 
    }
    
    /**
    findEmployee method
    @return the employee in the list found to be equal to the parameter. Otherwise it returns null
   */
    public static Employee findEmployee(ArrayList<Employee> employeeList, Employee employee)
    {
    	for ( Employee this_employee : employeeList )
    	{
    		if(this_employee.equals(employee)) { 
    			return this_employee;
    		}
    	}
		return null;
    }
    
    /**
    findPaycheck method
    @return the paycheck in the list found to be equal to the parameter. Otherwise it returns null
    */
    public static Paycheck findPaycheck(ArrayList<Paycheck> paycheckList, Paycheck paycheck)
    {
    	for ( Paycheck this_paycheck : paycheckList )
    	{
    		if (this_paycheck.equals(paycheck)) {
    			return this_paycheck;
    		}
    	}
		return null;
    }
    
    /**
    findDepartment method
    @return the department in the list found to be equal to the parameter. Otherwise, it returns null.
    */
    public static Department findDepartment(ArrayList<Department> departmentList, Department department)
    {
    	for ( Department this_department : departmentList )
    	{
    		if(this_department.equals(department)) { 
    			return this_department;
    		}
    	}
		return null;
    }
}