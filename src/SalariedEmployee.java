/**
 *  @author  Shahbaz Mughal, Mario Lugo, Marcio Dasilva, Ezgi Camur 
 */

import java.util.ArrayList;
/**
 * This class extends the Employee class and it represents an employee that gets paid a salary.
*/

public class SalariedEmployee extends Employee
{
    // instance variable
    private double annualSalary;
    
    /**
     * The Constructor sets employee ID, First Name, Last Name, Date Of Birth, Date Hired, Accrued Vacation Hours, 
     * Year to Date, List Of Paychecks
     *
     * @param id The employee's ID number.
     * @param first The employee's first name
     * @param last The employee's last name
     * @param birth The employee's birth date
     * @param hired The employee's the date of hired
     * @param vacationHrs The employee's vacation hours 
     * @param ytd The employee's year to date amount
     * @param paychecks The employee's paycheck
     * @param slary The eEployee's salary
     * @exception SalariedEmployee constructor When salary is negative.
     */
    public SalariedEmployee(String id, String first, String last, String birth, String hired, double accumVacationHrs, double ytd, ArrayList<Paycheck> paychecks, double salary)
    {
        super(id, first, last, birth, hired, accumVacationHrs, ytd, paychecks);
        
        if( salary >= 0 )
    		annualSalary = salary; 
    	else
    		throw new IllegalArgumentException("The salary cannot be negative");
    }
    
    /**
     * The Overloading Constructor sets the employee's ID, First Name, Last Name, Date Of Birth, Date Hired, Hourly rate, Period of Hours, salary
     *
     * @param id The employee's ID number.
     * @param first The employee's first name
     * @param last The employee's last name
     * @param birth The employee's birth date
     * @param hired The employee's the date of hired
     * @param slary The eEployee's salary
     */
    public SalariedEmployee(String id, String first, String last, String birth, String hired, double salary)
    {
        super(id, first, last, birth, hired);
        
        annualSalary = salary;
    }
    
    /**
    getAnnualSalary method
    @return The employee's annual salary
   */
    public double getAnnualSalary()
    {
        return annualSalary;
    }
    
    /**
    setPeriodHours method
    @param salary
    @exception setAnnualSalary When periodHrs is negative.
   */
    public void setAnnualSalary(double salary)
    {
    	if( salary >= 0 )
    		annualSalary = salary; 
    	else
    		throw new IllegalArgumentException("The salary cannot be negative"); 
    }
    
    /**
     * @Override 
     * The toString method returns a String containing the employee's data.
     * @return A reference to a String.
     */
    public String toString()
    {
        return  super.toString() +
                String.format("%-27s%s\n", "Annual Salary:", PayrollUtility.convertToCurrencyStringLeftAligned(annualSalary) );
    }
   
    /**
     * @Override
     * calculateGrossAmount method 
     * @return the gross amount the salaried employee gets paid during a pay period.
     */
    public double calculateGrossAmount()
    {
        return annualSalary / PayrollUtility.NUMBER_OF_PAY_PERIODS;
    }
    
    /**
     * @Override
     * calculateTaxDeduction method 
     * @return the tax amount to be subtracted from the gross amount and is calculated as a percentage of the gross amount.
     */
    public double calculateTaxDeduction()
    {
        double taxRate = (calculateGrossAmount() < PayrollUtility.THRESHOLD) ? PayrollUtility.TAX_RATE_LESS_THAN_THRESHOLD : PayrollUtility.TAX_RATE_THRESHOLD_OR_MORE;
        return calculateGrossAmount() * taxRate;
        
        /* Could also be written as follows: */
        /*
        if( calculateGrossAmount() < PayrollUtility.THRESHOLD )
            return calculateGrossAmount() * PayrollUtility.TAX_RATE_LESS_THAN_THRESHOLD;
        else
            return calculateGrossAmount() * PayrollUtility.TAX_RATE_THRESHOLD_OR_MORE;
        */
    }
    
    /**
     * @Override
     * calculateVacationHours method 
     * @return the number of vacation hours that the employee accrues during a pay period.
     */
    public double calculateVacationHours()
    {
        return (calculateGrossAmount() < PayrollUtility.THRESHOLD) ? PayrollUtility.VAC_HOURS_LESS_THAN_THRESHOLD : PayrollUtility.VAC_HOURS_THRESHOLD_OR_MORE;
        
        /* Could also be written as follows: */
        /*
        if(calculateGrossAmount() < PayrollUtility.THRESHOLD)
            return PayrollUtility.VAC_HOURS_LESS_THAN_THRESHOLD;
        else
            return PayrollUtility.VAC_HOURS_THRESHOLD_OR_MORE;
        */
    }
    
    
}
