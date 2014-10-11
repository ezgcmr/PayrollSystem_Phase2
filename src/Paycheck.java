/**
 *  @author  Shahbaz Mughal, Mario Lugo, Marcio Dasilva, Ezgi Camur 
 */

/** This class represents a single paycheck that an employee receives for a pay period.*/

public class Paycheck
{
    // instance variables
    private String employeeID;
    private String periodBeginDate;
    private String periodEndDate;
    private String payDate;
    private double grossAmount;
    private double taxAmount;
    private double bonusAmount;
    private double netAmount;
    
    /**
     * The Constructor sets the employee's ID, begin date, end date, pay date, gross amount, tax amount, bonus amount, net amount 
     *
     * @param empID The employee's ID number.
     * @param beginDate The employee's begin date
     * @param endDate The employee's end date
     * @param payDt The employee's pay date
     * @param grossAmt The employee's salaries gross amount
     * @param taxAmt The employee's salaries tax amount
     * @param bonusAmt The employee's salaries bonus amount
     * @param netAmt The employee's salaries net amount
     */

    public Paycheck(String empID, String beginDate, String endDate, String payDt, double grossAmt, double taxAmt, double bonusAmt, double netAmt)
    {
        employeeID = empID;
        periodBeginDate = beginDate;
        periodEndDate = endDate;
        payDate = payDt;
        grossAmount = grossAmt;
        taxAmount = taxAmt;
        bonusAmount = bonusAmt;
        netAmount = netAmt;
    }

    /**
    getEmployeeID method
    @return The employee's id
   */
    public String getEmployeeID()
    {
        return employeeID;
    }

    /**
    getPeriodBeginDate method
    @return The employee's period begin date
   */
    public String getPeriodBeginDate()
    {
        return periodBeginDate;
    }

    /**
    getPeriodEndDate method
    @return The employee's period end date
   */
    public String getPeriodEndDate()
    {
        return periodEndDate;
    }

    /**
    getPayDate method
    @return The employee's payDate
   */
    public String getPayDate()
    {
        return payDate;
    }

    /**
    getGrossAmount method
    @return The employee's gross amount
   */
    public double getGrossAmount()
    {
        return grossAmount;
    }

    /**
    getTaxAmount method
    @return The employee's tax amount
   */
    public double getTaxAmount()
    {
        return taxAmount;
    }

    /**
    getBonusAmount method
    @return The employee's bonus amount
   */
    public double getBonusAmount()
    {
        return bonusAmount;
    }

    /**
    getNetAmount method
    @return The employee's net amount
   */
    public double getNetAmount()
    {
        return netAmount;
    }

    /**
    setEmployeeID method
    @param empID The employee's id
   */
    public void setEmployeeID(String empID)
    {
        employeeID = empID;
    }

    /**
    setPeriodBeginDate method
    @param beginDate The employee's begin date
   */
    public void setPeriodBeginDate(String beginDate)
    {
        periodBeginDate = beginDate;
    }

    /**
    setPeriodEndDate method
    @param endDate The employee's end date
   */
    public void setPeriodEndDate(String endDate)
    {
        periodEndDate = endDate;
    }

    /**
    setPayDate method
    @param payDt The employee's pay date
   */
    public void setPayDate(String payDt)
    {
        payDate = payDt;
        
    }

    /**
    setGrossAmount method
    @param payAmt The employee's pay amount
   */
    public void setGrossAmount(double payAmt)
    {
        grossAmount = payAmt;
    }

    /**
    setTaxAmount method
    @param taxAmount The employee's tax amount
   */
    public void setTaxAmount(double taxAmount)
    {
        this.taxAmount = taxAmount;
    }
    
    
    /**
    setBonusAmount method
    @param bonusAmount The employee's bonus amount
   */
    public void setBonusAmount(double bonusAmount)
    {
        this.bonusAmount = bonusAmount;
    }

    /**
    setNetAmount method
    @param netAmount The employee's net amount
   */
    public void setNetAmount(double netAmount)
    {
        this.netAmount = netAmount;
    }
    
    /**
     * @Override 
     * The toString method returns a String containing the employee's id and paycheck information.
     *
     * @return A reference to a String.
     */
    public String toString()
    {
        return  "\n" +
                String.format("%27s%-27s%s\n", " ", "Employee ID:", employeeID) +
                String.format("%27s%-27s%s\n", " ", "Period Begin Date:", periodBeginDate) +
                String.format("%27s%-27s%s\n", " ", "Period End Date:", periodEndDate) +  
                String.format("%27s%-27s%s\n", " ", "Pay Date:", payDate) + 
                String.format("%27s%-27s%s\n", " ", "Gross Amount:", PayrollUtility.convertToCurrencyStringLeftAligned(grossAmount) ) + 
                String.format("%27s%-27s%s\n", " ", "Tax Amount:", PayrollUtility.convertToCurrencyStringLeftAligned(taxAmount) ) + 
                String.format("%27s%-27s%s\n", " ", "Bonus Amount:", PayrollUtility.convertToCurrencyStringLeftAligned(bonusAmount) ) + 
                String.format("%27s%-27s%s\n", " ", "Net Amount:", PayrollUtility.convertToCurrencyStringLeftAligned(netAmount) );
    }
    
    /**
     *@Override This method compares two Paycheck objects and 
     *returns true if they both have the same value for the employeeID, periodBeginDate, and periodEndDate
     *instance variables.Otherwise, null is returned.
 	*/
    public boolean equals(Object obj) 
    {
	    // check that the type of the parameter is Employee
	    if( !(obj instanceof Paycheck) )
	    	return false;
            
	    // we already know that obj is of type Employee, so it's safe to cast
	    Paycheck paycheck = (Paycheck) obj;
	            
	    // return true or false depending on whether firstName, lastName, and dateOfBirth have the same value
	    return paycheck.employeeID.equals(this.employeeID) && paycheck.periodBeginDate.equals(this.periodBeginDate) && paycheck.periodEndDate.equals(this.periodEndDate);
    }
    
}
