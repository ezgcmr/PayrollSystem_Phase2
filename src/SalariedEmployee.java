/*
 *  1)  Shahbaz Mughal 
 *  2)  Mario Lugo
 *  3)  Marcio Dasilva
 *  4)  Ezgi Camur
 */

import java.util.ArrayList;

public class SalariedEmployee extends Employee
{
    // instance variable
    private double annualSalary;
    
    // constructor
    public SalariedEmployee(String id, String first, String last, String birth, String hired, double accumVacationHrs, double ytd, ArrayList<Paycheck> paychecks, double salary)
    {
        super(id, first, last, birth, hired, accumVacationHrs, ytd, paychecks);
        
        if( salary >= 0 )
    		annualSalary = salary; 
    	else
    		throw new IllegalArgumentException("The salary cannot be negative");
    }
    
    // overloaded constructor
    public SalariedEmployee(String id, String first, String last, String birth, String hired, double salary)
    {
        super(id, first, last, birth, hired);
        
        annualSalary = salary;
    }
    
    // getter method
    public double getAnnualSalary()
    {
        return annualSalary;
    }
    
    // setter method
    public void setAnnualSalary(double salary)
    {
    	if( salary >= 0 )
    		annualSalary = salary; 
    	else
    		throw new IllegalArgumentException("The salary cannot be negative"); 
    }
    
    @Override
    public String toString()
    {
        return  super.toString() +
                String.format("%-27s%s\n", "Annual Salary:", PayrollUtility.convertToCurrencyStringLeftAligned(annualSalary) );
    }
   
    @Override
    public double calculateGrossAmount()
    {
        return annualSalary / PayrollUtility.NUMBER_OF_PAY_PERIODS;
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
    
    @Override
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
