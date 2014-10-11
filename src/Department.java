/**
 *  @author  Shahbaz Mughal, Mario Lugo, Marcio Dasilva, Ezgi Camur 
 */

import java.util.ArrayList;
/**
 * This class represents a department within the company.
 */
public class Department 
{
    // instance variables
    private String departmentID;
    private String departmentName;
    private Manager departmentManager;
    private ArrayList<Employee> listOfEmployees;
    
    /**
     * The Constructor sets the department's ID, name, manager, the list of employee
     *
     * @param id The department's ID number.
     * @param first The department's name
     * @param manager The manager
     * @param employees The list of employee
     */ 
   
    public Department(String id, String name, Manager manager, ArrayList<Employee> employees)
    {
        departmentID = id;
        departmentName = name;
        departmentManager = manager;
        listOfEmployees = employees;
    }
    
    /**
     * The Overloading Constructor sets the department's ID, name
     *
     * @param id The department's ID number.
     * @param first The department's name
     */ 
    public Department(String id, String name)
    {
        departmentID = id;
        departmentName = name;
        listOfEmployees = new ArrayList<>();
    }
    
    /**
    getDepartmentID method
    @return The deparment's id
   */
    public String getDepartmentID()
    {
        return departmentID;
    }
    
    /**
    getDepartmentName method
    @return The deparment's name
   */
    public String getDepartmentName()
    {
        return departmentName;
    }
    
    /**
    getDepartmentManager method
    @return The deparment's manager
   */
    public Manager getDepartmentManager()
    {
        return departmentManager;
    }
    
    /**
    getListOfEmployees method
    @return The deparment's list Of employees
   */
    public ArrayList<Employee> getListOfEmployees()
    {
        return listOfEmployees;
    }
    
    /**
    setDepartmentID method
    @param id
   */
    public void setDepartmentID(String id)
    {
        departmentID = id;
    } 
    
    /**
    setDepartmentName method
    @param name
   */
    public void setDepartmentName(String name)
    {
        departmentName = name;
    }
    
    /**
    setDepartmentManager method
    @param deptManager
   */
    public void setDepartmentManager(Manager deptManager)
    {
        departmentManager = deptManager;
    }
    
    /**
    setListOfEmployees method
    @param employeeList
   */
    public void setListOfEmployees(ArrayList<Employee> employeeList)
    {
        listOfEmployees = employeeList;
    }
    
    /**
     * @Override 
     * The toString method returns a String containing a department information.
     * @return A reference to a String.
     */
    public String toString()
    {
        return  String.format("\n%-27s%s\n", "Department ID:", departmentID) +
                String.format("%-27s%s\n", "Department Name:", departmentName) +
                "------------------------------------------------------------------\n" +
                String.format("%-27s%s\n", "Department Manager:", departmentManager) +
                "------------------------------------------------------------------\n" +
                String.format("%-27s%s\n", "List of Employees:", listOfEmployees) +
                "------------------------------------------------------------------\n";
    }
    
    /**
    *@Override This method compares two Department objects and 
    *returns true if they both have the same value for the departmentID and departmentName instance variables. 
    *Otherwise, null is returned.
	*/
    public boolean equals(Object obj) 
    {
	    // check that the type of the parameter is Employee
	    if( !(obj instanceof Department) )
	    	return false;
            
	    // we already know that obj is of type Employee, so it's safe to cast
	    Department department = (Department) obj;
	            
	    // return true or false depending on whether firstName, lastName, and dateOfBirth have the same value
	    return department.departmentID.equals(this.departmentID) && department.departmentName.equals(this.departmentName);
    }
}
