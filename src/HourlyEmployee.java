/*
 *  1)  Shahbaz Mughal 
 *  2)  Mario Lugo
 *  3)  Marcio Dasilva
 *  4)  Ezgi Camur
 */

import java.util.ArrayList;

public class HourlyEmployee extends Employee
{
    // instance variables
    private double hourlyRate;
    private double periodHours;
        
    // constructor
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
    
    // overloaded constructor
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
    
    // getter methods
    public double getHourlyRate()
    {
        return hourlyRate;
    }
    
    public double getPeriodHours()
    {
        return periodHours;
    }
    
    // setter methods
    public void setHourlyRate(double rate)
    {
    	// if the yearToDate parameter is negative, throw an exception.
    	if( rate >= 0 )
    		hourlyRate = rate;
    	else
    		throw new IllegalArgumentException("The hourly rate cannot be negative");
    }
    
    public void setPeriodHours(double periodHrs)
    {
    	if( periodHrs >= 0 )
        	periodHours = periodHrs;
    	else
    		throw new IllegalArgumentException("The period hours cannot be negative");
    }
    
    @Override
    public String toString()
    {
        return  super.toString() + 
                String.format("%-27s%s\n", "Hourly Rate:", PayrollUtility.convertToCurrencyStringLeftAligned(hourlyRate) ) +
                String.format("%-27s%s\n", "Period Hours:", periodHours );
    }
    
    public double calculateVacationHours()
    {
    	return 0;
    }
    
    @Override
    public double calculateGrossAmount()
    {
        return hourlyRate * periodHours;
    }
    
    @Override
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
