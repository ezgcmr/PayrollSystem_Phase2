/*
 *  1)  Shahbaz Mughal 
 *  2)  Mario Lugo
 *  3)  Marcio Dasilva
 *  4)  Ezgi Camur
 */

import java.util.ArrayList;

public class Company
{
    // instance variables
    private String companyName;
    private ArrayList<Department> departmentList;
        
    // constructor
    public Company(String name, ArrayList<Department> departments)
    {
        companyName = name;
        departmentList = departments;
    }

    // getter methods
    public String getCompanyName()
    {
        return companyName;
    }

    public ArrayList<Department> getDepartmentList()
    {
        return departmentList;
    }

    // setter methods
    public void setCompanyName(String name)
    {
        companyName = name;
    }

    public void setDepartmentList(ArrayList<Department> departments)
    {
        departmentList = departments;
    }
    
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
            
            // add a paycheck to the manager, clling contsractor to create a paycheck object form Paycheck class
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
    //bu iki tane getNAme ve getPayrollLine for formatting
    private String getNameLine(String name, double value)
    {
        return String.format("%-40s", name) + "Gross Amount:" + PayrollUtility.convertToCurrencyString(value);
    }
    
    private String getPayrollLine(String title, double value)
    {
        return String.format("%53s", title) + PayrollUtility.convertToCurrencyString(value);
    }
    
    @Override
    public String toString()
    {
        return  String.format("%-27s%s\n", "Company Name:", getCompanyName() ) +
                String.format("%-27s%s\n", "Departments:", getDepartmentList() ); 
    }
}
