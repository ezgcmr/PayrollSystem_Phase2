/*
 *  1)  Shahbaz Mughal 
 *  2)  Mario Lugo
 *  3)  Marcio Dasilva
 *  4)  Ezgi Camur
 */

import java.util.ArrayList;

public class Department 
{
    // instance variables
    private String departmentID;
    private String departmentName;
    private Manager departmentManager;
    private ArrayList<Employee> listOfEmployees;
    
    // constructor
    public Department(String id, String name, Manager manager, ArrayList<Employee> employees)
    {
        departmentID = id;
        departmentName = name;
        departmentManager = manager;
        listOfEmployees = employees;
    }
    
    // overloaded constructor
    public Department(String id, String name)
    {
        departmentID = id;
        departmentName = name;
        listOfEmployees = new ArrayList<>();
    }
    
    // getter methods
    public String getDepartmentID()
    {
        return departmentID;
    }
    
    public String getDepartmentName()
    {
        return departmentName;
    }
    
    public Manager getDepartmentManager()
    {
        return departmentManager;
    }
    
    public ArrayList<Employee> getListOfEmployees()
    {
        return listOfEmployees;
    }
    
    // setter methods
    public void setDepartmentID(String id)
    {
        departmentID = id;
    } 
    
    public void setDepartmentName(String name)
    {
        departmentName = name;
    }
    
    public void setDepartmentManager(Manager deptManager)
    {
        departmentManager = deptManager;
    }
    
    public void setListOfEmployees(ArrayList<Employee> employeeList)
    {
        listOfEmployees = employeeList;
    }
    
    @Override
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
    
    @Override //This method compares two Department objects and returns true if they both have the same value for the departmentID and departmentName instance variables.
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
