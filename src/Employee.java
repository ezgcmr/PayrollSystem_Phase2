/*
 *  1)  Shahbaz Mughal 
 *  2)  Mario Lugo
 *  3)  Marcio Dasilva
 *  4)  Ezgi Camur
 */

import java.util.ArrayList;
//import java.util.Objects;

public abstract class Employee implements Payable
{
    // instance variables
    private String employeeID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String dateHired;
    private double accruedVacationHours;
    private double yearToDate;
    private ArrayList<Paycheck> listOfPaychecks;
      
    // constructor
    public Employee(String id, String first, String last, String birth, String hired, double vacationHrs, double ytd, ArrayList<Paycheck> paychecks)
    {
        employeeID = id;
        firstName = first;
        lastName = last;
        dateOfBirth = birth;
        dateHired = hired;
        listOfPaychecks = paychecks;
        
        // if the vacationHrs parameter is negative, throw an exception.
        if( vacationHrs >= 0)
        	accruedVacationHours = vacationHrs;	
        else
        	throw new IllegalArgumentException("The number of vacation hours cannot be negative.");
        
     // if the yearToDate parameter is negative, throw an exception.
    	if( ytd >= 0 )
    		yearToDate = ytd;
    	else
    		throw new IllegalArgumentException("The year to date amount cannot be negative.");
    }
    
    // overloaded constructor
    public Employee(String id, String first, String last, String birth, String hired)
    {
        employeeID = id;
        firstName = first;
        lastName = last;
        dateOfBirth = birth;
        dateHired = hired;
        accruedVacationHours = 0;
        yearToDate = 0;
        listOfPaychecks = new ArrayList<>();
    }
    
    // getter methods
    public String getEmployeeID()
    {
        return employeeID;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }
    
    public String getDateHired()
    {
        return dateHired;
    }
    
    public double getAccruedVacationHours()
    {
        return accruedVacationHours;
    }
    
    public double getYearToDate()
    {
        return yearToDate;
    }
    
    public ArrayList<Paycheck> getListOfPaychecks()
    {
        return listOfPaychecks;
    }
    
    // setter methods
    public void setEmployeeID(String id)
    {
        employeeID = id;
    }
    
    public void setFirstName(String first)
    {
        firstName = first;
    }
    
    public void setLastName(String last)
    {
        lastName = last;
    }
    
    public void setDateOfBirth(String birth)
    {
        dateOfBirth = birth;
    }
    
    public void setDateHired(String hired)
    {
        dateHired = hired;
    }
    
    public void setAccruedVacationHours(double vacationHrs)
    {
    	// if the vacationHrs parameter is negative, throw an exception.
    	if( vacationHrs >= 0 )
    		accruedVacationHours = vacationHrs;
    	else
    		throw new IllegalArgumentException("The number of vacation hours cannot be negative.");
    }
    
    public void setYearToDate(double ytd)
    {
    	// if the yearToDate parameter is negative, throw an exception.
    	if( ytd >= 0 )
    		yearToDate = ytd;
    	else
    		throw new IllegalArgumentException("The year to date amount cannot be negative.");
    }
    
    public void setListOfPaychecks(ArrayList<Paycheck> paychecks)
    {
        listOfPaychecks = paychecks;
    }
  
    @Override 
    public String toString()
    {
        return  String.format("\n%-27s%s\n", "Employee ID:", employeeID) +
                String.format("%-27s%s\n", "First Name:", firstName) +
                String.format("%-27s%s\n", "Last Name:", lastName) +
                String.format("%-27s%s\n", "Date of Birth:", dateOfBirth) +
                String.format("%-27s%s\n", "Date Hired:", dateHired) +
                String.format("%-27s%s\n", "Accrued Vacation Hours:", accruedVacationHours) +
                String.format("%-27s%s\n", "Amount Paid Year to Date:", PayrollUtility.convertToCurrencyStringLeftAligned(yearToDate)) +
                String.format("%-27s%s\n", "Paychecks Received:", listOfPaychecks);       
    }
    
    
    @Override //This method compares two Employee objects and returns true if they both have the same value for the firstName, lastName, and dateOfBirth instance variables.

    public boolean equals(Object obj) 
    {
	    // check that the type of the parameter is Employee
	    if( !(obj instanceof Employee) )
	    	return false;
            
	    // we already know that obj is of type Employee, so it's safe to cast
	    Employee employee = (Employee) obj;
            
	    // return true or false depending on whether firstName, lastName, and dateOfBirth have the same value
	    return employee.firstName.equals(this.firstName) && employee.lastName.equals(this.lastName) && employee.dateOfBirth.equals(this.dateOfBirth);
    }
    
    public void addPaycheck(Paycheck paycheck)
    {
        //add another paycheck in Paycheck list
        listOfPaychecks.add(paycheck);
    }
    
//    @Override
//    public int hashCode()
//    {
//    	int hash = 7;
//    	hash = 47 * hash + Objects.hashCode(this.firstName);
//    	hash = 47 * hash + Objects.hashCode(this.lastName);
//    	hash = 47 * hash + Objects.hashCode(this.dateOfBirth);
//    	
//    }
}
