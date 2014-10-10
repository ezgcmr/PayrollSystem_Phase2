/*
 *  1)  Shahbaz Mughal 
 *  2)  Mario Lugo
 *  3)  Marcio Dasilva
 *  4)  Ezgi Camur
 */

import java.util.*;

public class PayrollSystem_Phase2 
{
          
    public static void main(String[] args) 
    {
        System.out.println("*********************************************************************");
        System.out.println("*               Testing the HourlyEmployee class                    *");
        System.out.println("*********************************************************************");
                 
        System.out.println("\nTrying to create an HourlyEmployee with negative vacation hours.");
        try
        {
            Employee employee_1 = new HourlyEmployee("1", "Paul", "Wilkinson" , "12/18/1976", "07/07/2014", -10, 0, null, 20, 35);
        }
        catch( IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
               
        System.out.println("\nTrying to create an HourlyEmployee with negative year to date amount.");
        try
        {
            Employee employee_2 = new HourlyEmployee("2", "Janet", "Hernanez", "04/19/1987", "08/06/2013", 20.5, -27000.75, new ArrayList<Paycheck>(), 18.50, 40);
        }
        catch( IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("\nTrying to create an HourlyEmployee with negative hourly rate.");
        try
        {
            Employee employee_3 = new HourlyEmployee("3", "Rosa", "Ramirez", "11/07/1988", "08/25/2014", 0, 1400.0, null, -10.0, 30.0);
        }
        catch( IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("\nTrying to create an HourlyEmployee with negative period hours.");
        try
        {
            Employee employee_4 = new HourlyEmployee("4", "Beatrice", "Colton", "06/24/1976", "08/22/2014", 22.0, -40.0);
        }
        catch( IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("\nTrying to create a SalariedEmployee with negative salary.");
        try
        {
            Employee employee_5 = new SalariedEmployee("5", "Steven", "Estevez", "11/26/1983","09/08/2014", -58000.0);
        }
        catch( IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("\nTrying to create a Manager with negative bonus.");
        try
        {
            Employee manager_1 = new Manager("7", "Michael", "Perez", "03/02/1985", "08/01/2014", 67000, -100);
        }
        catch( IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        
        System.out.println("\n*********************************************************************");
        System.out.println("*         Testing the equals method of the Employee class.          *");
        System.out.println("*********************************************************************");
        
        Employee employee_1 = new HourlyEmployee("1", "Paul", "Wilkinson" , "12/18/1976", "07/07/2014", 20, 35);
        Employee employee_5 = new SalariedEmployee("5", "Steven", "Estevez", "11/26/1983","09/08/2014", 58000.0);
        
        System.out.println("\nAre employee_1 and employee_5 equal? " + employee_1.equals(employee_5));
        
        employee_5.setFirstName("Paul");
        employee_5.setLastName("Wilkinson");
        
        System.out.println("\nWhat about after having the same first and last name? " + employee_1.equals(employee_5));
        
        employee_5.setDateOfBirth("12/18/1976");
        
        System.out.println("\nWhat about now? " + employee_1.equals(employee_5));
        
        
        System.out.println("\n*********************************************************************");
        System.out.println("*        Testing the equals method of the Employee class.           *");
        System.out.println("*********************************************************************");
        
        Paycheck paycheck_1 = new Paycheck("5", "09/08/2014", "09/12/2014", "09/19/2014", 961.54, 192.30, 0.0, 769.24);
        Paycheck paycheck_2 = new Paycheck("5", "09/10/2014", "09/12/2014", "09/19/2014", 961.54, 192.30, 0.0, 769.24);
        
        System.out.println("\nAre paycheck_1 and paycheck_2 equal? " + paycheck_1.equals(paycheck_2));
        
        paycheck_1.setPeriodBeginDate("09/10/2014");
        
        System.out.println("\nWhat about now? " + paycheck_1.equals(paycheck_2));
        
        
        System.out.println("\n*********************************************************************");
        System.out.println("*       Testing the equals method of the Department class.          *");
        System.out.println("*********************************************************************");
        
        Department dept_1 = new Department("1", "Human Resources");
        Department dept_2 = new Department("2", "Human Resources", null, new ArrayList<Employee>());
        
        System.out.println("\nAre dept_1 and dept_2 equal? " + dept_1.equals(dept_2));
        
        dept_1.setDepartmentID("2");
        
        System.out.println("\nWhat about now? " + dept_1.equals(dept_2));
        
        
        System.out.println("\n*********************************************************************");
        System.out.println("*   Testing the findEmployee method of the PayrollUtility class.    *");
        System.out.println("*********************************************************************");
        
        Employee employee_2 = new HourlyEmployee("2", "Janet", "Hernanez", "04/19/1987", "08/06/2013", 20.5, 27000.75, new ArrayList<Paycheck>(), 18.50, 40);
        Employee employee_3 = new HourlyEmployee("3", "Rosa", "Ramirez", "11/07/1988", "08/25/2014", 0, 1400.0, null, 10.0, 30.0);
        Employee employee_4 = new HourlyEmployee("4", "Beatrice", "Colton", "06/24/1976", "08/22/2014", 22.0, 40.0);
        
        ArrayList<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(employee_2);
        listOfEmployees.add(employee_3);
        listOfEmployees.add(employee_4);
        listOfEmployees.add(employee_1);
        
        Employee foundEmployee = PayrollUtility.findEmployee(listOfEmployees, employee_5);
        if( foundEmployee != null)
            System.out.println("Employee Found:\n" + foundEmployee);
        else
            System.out.println("Employee " + employee_5.getFirstName() + " " + employee_5.getLastName() + " was not found in the list");
        
        employee_1.setLastName("Wilkins");
        
        foundEmployee = PayrollUtility.findEmployee(listOfEmployees, employee_5);
        if( foundEmployee != null)
            System.out.println("Employee Found:\n" + foundEmployee);
        else
            System.out.println("\nEmployee " + employee_5.getFirstName() + " " + employee_5.getLastName() + " was not found in the list");
        
        
        System.out.println("\n*********************************************************************");
        System.out.println("*   Testing the findPaycheck method of the PayrollUtility class.    *");
        System.out.println("*********************************************************************");
        
        paycheck_1.setEmployeeID("1");
                
        Paycheck paycheck_3 = new Paycheck("3", "09/08/2014", "09/12/2014", "09/19/2014", 1288.45, 257.70, 80.0, 1110.75);
        Paycheck paycheck_4 = new Paycheck("4", "09/08/2014", "09/12/2014", "09/19/2014", 1250.0, 250.0, 72.0, 1072.0);
        
        ArrayList<Paycheck> listOfPaychecks = new ArrayList<>();
        listOfPaychecks.add(paycheck_2);
        listOfPaychecks.add(paycheck_3);
        listOfPaychecks.add(paycheck_4);
        
        Paycheck foundPaycheck = PayrollUtility.findPaycheck(listOfPaychecks, paycheck_1);
        
        if( foundPaycheck != null)
            System.out.println("Paycheck found:\n" + foundPaycheck);
        else
            System.out.println("\nPaycheck for employee ID " + paycheck_1.getEmployeeID() + ", Pay Period from: " + paycheck_1.getPeriodBeginDate() + " to: " + paycheck_1.getPeriodEndDate() + " was not found in the list");
        
        paycheck_2.setEmployeeID("1");
        
        foundPaycheck = PayrollUtility.findPaycheck(listOfPaychecks, paycheck_1);
        
        if( foundPaycheck != null)
            System.out.println("Paycheck found:\n" + foundPaycheck);
        else
            System.out.println("\nPaycheck for employee ID " + paycheck_1.getEmployeeID() + ", Pay Period from: " + paycheck_1.getPeriodBeginDate() + " to: " + paycheck_1.getPeriodEndDate() + " was not found in the list");
        
        
        System.out.println("\n*********************************************************************");
        System.out.println("*  Testing the findDepartment method of the PayrollUtility class.   *");
        System.out.println("*********************************************************************");
        
        Department dept_3 = new Department("3", "Sales and Marketing");
        
        ArrayList<Department> listOfDepartments = new ArrayList<>();
        listOfDepartments.add(dept_1);
        listOfDepartments.add(dept_3);
        
        Department foundDepartment = PayrollUtility.findDepartment(listOfDepartments, dept_2);
        
        if( foundDepartment != null)
            System.out.println("Department Found:\n" + foundDepartment);
        else
            System.out.println("\nDepartment with ID: " + dept_2.getDepartmentID() + ", Department Name: " + dept_2.getDepartmentName() + " was not found in the list");
        
        dept_1.setDepartmentID("1");
        
        foundDepartment = PayrollUtility.findDepartment(listOfDepartments, dept_2);
        
        if( foundDepartment != null)
            System.out.println("Department Found:\n" + foundDepartment);
        else
            System.out.println("\nDepartment with ID: " + dept_2.getDepartmentID() + ", Department Name: " + dept_2.getDepartmentName() + " was not found in the list");
        
    }
    
}
