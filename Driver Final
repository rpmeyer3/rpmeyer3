#include <iostream>
#include <vector>
#include <random>
#include "Employee.h"  

enum class PayrollType { SALARY, CLERICAL, FACTORY };

int main() 
{
    std::vector<Employee*> employees;
    EmployeeFactory& factory = EmployeeFactory::getInstance();

    /*It may take a long time to create 10 employees Mr.Richardson, so feel free to adjust the 
        number of employees to create that you are not stuck making employees for an hour */
   

    for (int i = 0; i < 1; ++i) 
    {
        std::string type;
        std::cout << "Enter employee type (Salary, Clerical, FactoryWorker): ";
        std::cin >> type;

        Employee* employee = factory.createEmployee(type);
        if (employee == nullptr) 
        {
            std::cout << "Invalid employee type. Try again.\n";
            --i;
            continue;
        }

        std::cout << "Enter full employee name (ex. Ryan Paul Meyer): ";
        std::cin >> employee->firstName >> employee->middleName >> employee->lastName;

        std::cout << "Enter employee address (ex. 3456 Arivaderche Ln. Altanta, GA 30040): ";
        std::cin >> employee->streetAddress >> employee->city >> employee->state >> employee->zipCode;

        std::cout << "Enter employee phone(ex. 456-678-3422): ";
        std::cin >> employee->areaCode >> employee->prefix >> employee->exchange;

        if (type == "Salary") 
        {
            std::cout << "Enter annual salary: ";
            std::cin >> dynamic_cast<Salary*>(employee)->annualSalary;
        }
        else 
        {
            std::cout << "Enter hourly rate: ";
            std::cin >> dynamic_cast<Clerical*>(employee)->hourlyRate;

            std::cout << "Enter hours worked this month: ";
            std::cin >> dynamic_cast<Clerical*>(employee)->hoursWorked;

            if (type == "FactoryWorker") 
            {
                std::cout << "Enter holiday hours: ";
                std::cin >> dynamic_cast<FactoryWorker*>(employee)->holidayHours;
            }
        }

        employees.push_back(employee);
    }

    for (const auto& employee : employees) 
    {
        std::cout << "Payroll this month for " << employee->firstName << " " << employee->lastName << ": " << employee->calculatePayroll() << "\n";
    }

    
    for (auto& employee : employees) 
    {
        delete employee;
    }

    return 0;
}
