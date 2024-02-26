#include "Employee.h"
#include <string>
#pragma once

using namespace std;


double Salary::calculatePayroll()
{
        return annualSalary / 12;
}



double Clerical::calculatePayroll() 
{
    if (hoursWorked > 40) 
    {
        return 40 * hourlyRate + (hoursWorked - 40) * 1.5 * hourlyRate;
    }
    else 
    {
        return hoursWorked * hourlyRate;
    }
}

double FactoryWorker::calculatePayroll() 
{
    double regularHours = (hoursWorked > 40) ? 40 : hoursWorked;
    double overtimeHours = (hoursWorked > 40) ? (hoursWorked - 40) : 0;
    return regularHours * hourlyRate + overtimeHours * 2 * hourlyRate + holidayHours * 3 * hourlyRate;
}


    
EmployeeFactory& EmployeeFactory::getInstance() 
{
    static EmployeeFactory instance;
    return instance;
}

    
Employee* EmployeeFactory::createEmployee(std::string type)
{
    if (type == "Salary") 
    {
        return new Salary();
    }
    else if (type == "Clerical") 
    {
        return new Clerical();
    }
    else if (type == "FactoryWorker") 
    {
        return new FactoryWorker();
    }
    else 
    {
        return nullptr;
    }
}
