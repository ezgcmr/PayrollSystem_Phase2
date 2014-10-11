/**
 *  @author  Shahbaz Mughal, Mario Lugo, Marcio Dasilva, Ezgi Camur 
 */
import java.util.ArrayList;
/**
 * This class extends the Employee class and it represents an employee that gets paid by the hour.
 */
public class HourlyEmployee extends Employee
{
    // instance variables
    private double hourlyRate;
    private double periodHours;  
    
  /**
   * The Constructor sets the employee's ID, First Name, Last Name, Date Of Birth, Date Hired, Accrued Vacation Hours, 
   * Year to Date, List Of Paychecks, hourly rate, period hours
   *
   * @param id The employee's ID number.
   * @param first The employee's first name
   * @param last The employee's last name
   * @param birth The employee's birth date
   * @param hired The employee's the date of hired
   * @param vacationHrs The employee's vacation hours 
   * @param ytd The employee's year to date amount
   * @param paychecks The employee's paycheck
   * @param rate The employee's hourly rate
   * @param periodHrs The employee's period hours
   * @exception Hourly Employee constructor When rate is negative.
   */
        
    public HourlyEmployee(String id, String first, String last, String birth, String hired, double vacationHrs, double ytd, ArrayList<Paycheck> paychecks, double rate, double periodHrs)
    {
        super(id, first, last, birth, hired, vacationHrs, ytd, paychecks);
        
        if( rate >= 0 )
    		hourlyRate = rate;
    	else
    		throw new IllegalArgumentException("The hourly rate cannot be negative");
        
        if( periodHrs >= 0 )
        	periodHours = periodHrs;
    	else
    		throw new IllegalArgumentException("The period hours cannot be negative");
    }
    
    /**
     * The Overloading Constructor sets the employee's ID, First Name, Last Name, Date Of Birth, Date Hired, Hourly rate, Period of Hours
     *
     * @param id The employee's ID number.
     * @param first The employee's first name
     * @param last The employee's last name
     * @param birth The employee's birth date
     * @param hired The employee's the date of hired
     * @param rate The employee's hourly rate
     * @param periodHrs The employee's period hours
     */
    public HourlyEmployee(String id, String first, String last, String birth, String hired, double rate, double periodHrs)
    {
        super(id, first, last, birth, hired);
        
        if( rate >= 0 )
    		hourlyRate = rate;
    	else
    		throw new IllegalArgumentException("The hourly rate cannot be negative");
        
        if( periodHrs >= 0 )
        	periodHours = periodHrs;
    	else
    		throw new IllegalArgumentException("The period hours cannot be negative");      
    }
    
    /**
    getHourlyRate method
    @return The employee's hourly rate
   */
    public double getHourlyRate()
    {
        return hourlyRate;
    }
    
    /**
    getPeriodHours method
    @return The employee's period hours
   */
    public double getPeriodHours()
    {
        return periodHours;
    }
    
    /**
    setHourlyRate method
    @param rate
    @exception setHourlyRate When rate is negative.
   */
    public void setHourlyRate(double rate)
    {
    	// if the yearToDate parameter is negative, throw an exception.
    	if( rate >= 0 )
    		hourlyRate = rate;
    	else
    		throw new IllegalArgumentException("The hourly rate cannot be negative");
    }
    
    /**
    setPeriodHours method
    @param rate
    @exception setPeriodHours When periodHrs is negative.
   */
    public void setPeriodHours(double periodHrs)
    {
    	if( periodHrs >= 0 )
        	periodHours = periodHrs;
    	else
    		throw new IllegalArgumentException("The period hours cannot be negative");
    }
    
    /**
     * @Override 
     * The toString method returns a String containing the employee's data.
     *
     * @return A reference to a String.
     */
    public String toString()
    {
        return  super.toString() + 
                String.format("%-27s%s\n", "Hourly Rate:", PayrollUtility.convertToCurrencyStringLeftAligned(hourlyRate) ) +
                String.format("%-27s%s\n", "Period Hours:", periodHours );
    }
    
    /**
    calculateVacationHours method
    @return 0
   */
    public double calculateVacationHours()
    {
    	return 0;
    }
    
    /**
     * @Override
     * calculateGrossAmount method 
     * @return the gross amount that the hourly employee gets paid during a pay period.
   */
    public double calculateGrossAmount()
    {
        return hourlyRate * periodHours;
    }
    
    /**
     * @Override
     * calculateTaxDeduction method 
     * @return the tax amount to be subtracted from the gross amount, which is calculated as a percentage of the gross amount.
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
    
}
