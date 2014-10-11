/**
 *  @author  Shahbaz Mughal, Mario Lugo, Marcio Dasilva, Ezgi Camur 
 */
import java.util.ArrayList;
/**
 * This class represents an employee. It implements the Payable interface.
*/
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
      
    /**
     * The Constructor sets the employee's ID, First Name, Last Name, Date Of Birth, Date Hired, Accrued Vacation Hours, 
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
     * @exception Employee constructor When vacationHrs is negative.
     */
    
    
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
    
    /**
     * The Overloading Constructor sets the employee's ID, First Name, Last Name, Date Of Birth, Date Hired
     *
     * @param id The employee's ID number.
     * @param first The employee's first name
     * @param last The employee's last name
     * @param birth The employee's birth date
     * @param hired The employee's the date of hired
     */
    
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
    
    /**
    getEmployeeID method
    @return The employee's id
   */
    public String getEmployeeID()
    {
        return employeeID;
    }
    
    /**
    getFirstName method
    @return The employee's first name
   */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
    getLastName method
    @return The employee's last name
   */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
    getDateOfBirth method
    @return The employee's date of birth
   */
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }
    
    /**
    getDateHired method
    @return The employee's the date of hired
   */
    public String getDateHired()
    {
        return dateHired;
    }
    
    /**
    getAccruedVacationHours method
    @return The employee's accrued vacation hours
   */
    public double getAccruedVacationHours()
    {
        return accruedVacationHours;
    }
    
    /**
    getYearToDate method
    @return The employee's year to date
   */
    public double getYearToDate()
    {
        return yearToDate;
    }
    
    /**
    getListOfPaychecks method
    @return The employee's list of paychecks in array
   */
    public ArrayList<Paycheck> getListOfPaychecks()
    {
        return listOfPaychecks;
    }
    
    /**
    setEmployeeID method
    @param id The employee's id
   */
    public void setEmployeeID(String id)
    {
        employeeID = id;
    }
    
    /**
    setFirstName method
    @param first The employee's first name
   */
    public void setFirstName(String first)
    {
        firstName = first;
    }
    
    /**
    setLastName method
    @param last The employee's last name
   */
    public void setLastName(String last)
    {
        lastName = last;
    }
    
    /**
    setDateOfBirth method
    @param birth The employee's birth date
   */
    public void setDateOfBirth(String birth)
    {
        dateOfBirth = birth;
    }
    
    /**
    setDateHired method
    @param hired The employee's hired date
   */
    public void setDateHired(String hired)
    {
        dateHired = hired;
    }
    
    /**
    setAccruedVacationHours method
    @param vacationHrs
    @exception setAccruedVacationHours When vacationHrs is negative.
   */
    public void setAccruedVacationHours(double vacationHrs)
    {
    	// if the vacationHrs parameter is negative, throw an exception.
    	if( vacationHrs >= 0 )
    		accruedVacationHours = vacationHrs;
    	else
    		throw new IllegalArgumentException("The number of vacation hours cannot be negative.");
    }
    
    /**
    setYearToDate method
    @param ytd The employee's year to date if the year to date is not negative
    @exception setYearToDate When ytd is negative.
   */
    public void setYearToDate(double ytd)
    {
    	// if the yearToDate parameter is negative, throw an exception.
    	if( ytd >= 0 )
    		yearToDate = ytd;
    	else
    		throw new IllegalArgumentException("The year to date amount cannot be negative.");
    }
    
    /**
    setListOfPaychecks method
    @param paychecks The employee's paychecks as an array list
   */
    public void setListOfPaychecks(ArrayList<Paycheck> paychecks)
    {
        listOfPaychecks = paychecks;
    }
  
    /**
     * @Override 
     * The toString method returns a String containing the employee's data.
     *
     * @return A reference to a String.
     */
    
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
    
    /**
    *@Override This method compares two Employee objects and 
    *returns true if they both have the same value for the firstName, lastName, and dateOfBirth 
    *instance variables. Otherwise, null is returned.
	*/
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
    
    /**
    addPaycheck method add another paycheck in Paycheck list
    @param paychecks The employee's paycheck in the list
   */
    public void addPaycheck(Paycheck paycheck)
    {
        listOfPaychecks.add(paycheck);
    }
}
