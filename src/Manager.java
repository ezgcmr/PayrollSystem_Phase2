/**
 *  @author  Shahbaz Mughal, Mario Lugo, Marcio Dasilva, Ezgi Camur 
 */

import java.util.ArrayList;
/** 
 * This class extends the SalariedEmployee class and it represents a department’s manager. 
 */

public class Manager extends SalariedEmployee
{
    // instance variable
    private double weeklyBonus;
    
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
     * @param salary The employee's salary
     * @param bonus The employee's bonus
     * @exception Manager constructor When bonus is negative.
     */
    
    public Manager(String id, String first, String last, String birth, String hired, double accumVacationHrs, double ytd, ArrayList<Paycheck> paychecks, double salary, double bonus)
    {
        super(id, first, last, birth, hired, accumVacationHrs, ytd, paychecks, salary);
        
        if( bonus >= 0 )
      		 weeklyBonus = bonus; 
      	else
      		throw new IllegalArgumentException("The bonus cannot be negative");
    }
    
    /**
     * The Overloading Constructor sets the employee's ID, First Name, Last Name, Date Of Birth, Date Hired, salary, bonus
     *
     * @param id The employee's ID number.
     * @param first The employee's first name
     * @param last The employee's last name
     * @param birth The employee's birth date
     * @param hired The employee's the date of hired
     * @param salary The employee's salary
     * @param bonus The employe's bonus
     * @exception Manager constructor When bonus is negative.
     */
    public Manager(String id, String first, String last, String birth, String hired, double salary, double bonus)
    {
        super(id, first, last, birth, hired, salary);
        
        if( bonus >= 0 )
   		 weeklyBonus = bonus; 
   	else
   		throw new IllegalArgumentException("The bonus cannot be negative");
    }
    
    /**
    getWeeklyBonus method
    @return The employee's weekly bonus
   */
    public double getWeeklyBonus()
    {
        return weeklyBonus;
    }
    
    /**
    setWeeklyBonus method
    @param bonus
    @exception setWeeklyBonus When bonus is negative.
   */
    public void setWeeklyBonus(double bonus)
    {
    	if( bonus >= 0 )
    		 weeklyBonus = bonus; 
    	else
    		throw new IllegalArgumentException("The bonus cannot be negative");
    }
    
    /**
    getBonusAfterTax method
    @return the bonus amount that the manager gets during a pay period after deducting taxes
   */
    public double getBonusAfterTax()
    {
        return weeklyBonus - (weeklyBonus * PayrollUtility.BONUS_TAX_RATE);
        
        /* Could also be written as follows: */
        /*
        return weeklyBonus * ( 1 -  PayrollUtility.BONUS_TAX_RATE);
        */
    }
    
    /**
     * @Override 
     * The toString method returns a String containing the employee's data.
     * @return A reference to a String.
     */
    public String toString()
    {
        return  super.toString() +
                String.format("%-27s%s\n","Weekly Bonus:", PayrollUtility.convertToCurrencyStringLeftAligned(weeklyBonus) );
    }
}
