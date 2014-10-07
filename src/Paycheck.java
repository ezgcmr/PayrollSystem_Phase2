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
    
    // constructor
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

    // getter methods
    public String getEmployeeID()
    {
        return employeeID;
    }

    public String getPeriodBeginDate()
    {
        return periodBeginDate;
    }

    public String getPeriodEndDate()
    {
        return periodEndDate;
    }

    public String getPayDate()
    {
        return payDate;
    }

    public double getGrossAmount()
    {
        return grossAmount;
    }

    public double getTaxAmount()
    {
        return taxAmount;
    }

    public double getBonusAmount()
    {
        return bonusAmount;
    }

    public double getNetAmount()
    {
        return netAmount;
    }

    // setter methods
    public void setEmployeeID(String empID)
    {
        employeeID = empID;
    }

    public void setPeriodBeginDate(String beginDate)
    {
        periodBeginDate = beginDate;
    }

    public void setPeriodEndDate(String endDate)
    {
        periodEndDate = endDate;
    }

    public void setPayDate(String payDt)
    {
        payDate = payDt;
        
    }

    public void setGrossAmount(double payAmt)
    {
        grossAmount = payAmt;
    }

    public void setTaxAmount(double taxAmount)
    {
        this.taxAmount = taxAmount;
    }

    public void setBonusAmount(double bonusAmount)
    {
        this.bonusAmount = bonusAmount;
    }

    public void setNetAmount(double netAmount)
    {
        this.netAmount = netAmount;
    }
    
    @Override
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
    
    @Override // This method compares two Paycheck objects and returns true if they both have the same value for the employeeID, periodBeginDate, and periodEndDate instance variables.
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
