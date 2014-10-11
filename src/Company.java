/**
 *  @author  Shahbaz Mughal, Mario Lugo, Marcio Dasilva, Ezgi Camur 
 */

import java.util.ArrayList;

/**This class represents the company that is using this software*/

public class Company
{
    // instance variables
    private String companyName;
    private ArrayList<Department> departmentList;
      
    
    /**
     * The Constructor sets the company's name, the list of department
     *
     * @param name The company's name
     * @param departments The list of departments
     */ 
    public Company(String name, ArrayList<Department> departments)
    {
        companyName = name;
        departmentList = departments;
    }

    /**
    getCompanyName method
    @return The company's name
   */
    public String getCompanyName()
    {
        return companyName;
    }

    /**
    getDepartmentList method
    @return The department list
   */
    public ArrayList<Department> getDepartmentList()
    {
        return departmentList;
    }

    /**
    setCompanyName method
    @param name
   */
    public void setCompanyName(String name)
    {
        companyName = name;
    }

    /**
    setDepartmentList method
    @param departments
   */
    public void setDepartmentList(ArrayList<Department> departments)
    {
        departmentList = departments;
    }
    
    /**
    generatePayroll method
    @param the employee's begin date, end date, pay date
    @return the payroll information of the employee
   */ 
    public String generatePayroll(String beginDate, String endDate, String payDate)
    {
        String output = "";
        Manager manager;
        Paycheck paycheck;
        double grossPay, tax, bonus, netPay;
        
        for(Department dept: departmentList)
        {
            output += "------------------------------------------------------------------\n";
            output += dept.getDepartmentName() + " (" + dept.getDepartmentID() + ")\n";
            output += "------------------------------------------------------------------\n";
            output += "Manager:\n";
            
            // get the department's manager and his/her payroll information
            manager = dept.getDepartmentManager();
            
            grossPay = manager.calculateGrossAmount();
            tax = manager.calculateTaxDeduction();
            bonus = manager.getBonusAfterTax();
            netPay = grossPay - tax + bonus;
            
            output += getNameLine(manager.getFirstName() + " " + manager.getLastName(), grossPay);
            output += getPayrollLine( "Bonus after tax:", bonus );
            output += getPayrollLine( "Tax:", tax );
            output += getPayrollLine( "Net Pay:", netPay );
            
            // add a paycheck to the manager, calling constructor to create a paycheck object from Paycheck class
            paycheck = new Paycheck(manager.getEmployeeID(), beginDate, endDate, payDate, grossPay, tax, bonus, netPay);
            manager.addPaycheck(paycheck);
            
            // update the manager's vacation hours
            manager.setAccruedVacationHours( manager.getAccruedVacationHours() + manager.calculateVacationHours() );
            
            // update the manager's yearToDate amount
            manager.setYearToDate(manager.getYearToDate()+ grossPay );
            
            output += "Employees:\n";
            // get department's employees and their payroll information
            for(Employee employee: dept.getListOfEmployees() )
            {               
                grossPay = employee.calculateGrossAmount();
                tax = employee.calculateTaxDeduction();
                netPay = grossPay - tax;
                
                output += getNameLine( employee.getFirstName() + " " + employee.getLastName(), grossPay );
                output += getPayrollLine( "Tax:", tax );
                output += getPayrollLine( "Net Pay:", netPay ) + "\n";
                
                // add a paycheck to the employee
                paycheck = new Paycheck(employee.getEmployeeID(), beginDate, endDate, payDate, grossPay, tax, 0, netPay);
                employee.addPaycheck(paycheck);
                
                // update the employee's vacation hours
                employee.setAccruedVacationHours( employee.getAccruedVacationHours() + employee.calculateVacationHours() );
            
                // update the employee's yearToDate amount
                employee.setYearToDate(employee.getYearToDate()+ grossPay );
            }
        }
        return output;
    }
    //method for formatting
    private String getNameLine(String name, double value)
    {
        return String.format("%-40s", name) + "Gross Amount:" + PayrollUtility.convertToCurrencyString(value);
    }
    
    //method for formatting
    private String getPayrollLine(String title, double value)
    {
        return String.format("%53s", title) + PayrollUtility.convertToCurrencyString(value);
    }
    
    /**
     * @Override 
     * The toString method returns a String containing a company name and department list.
     * @return A reference to a String.
     */
    public String toString()
    {
        return  String.format("%-27s%s\n", "Company Name:", getCompanyName() ) +
                String.format("%-27s%s\n", "Departments:", getDepartmentList() ); 
    }
}
