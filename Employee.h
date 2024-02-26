#ifndef EMPLOYEE_H
#define EMPLOYEE_H

#include <string>

class Employee 
{
public:
    std::string firstName;
    std::string middleName;
    std::string lastName;
    std::string streetAddress;
    std::string city;
    std::string state;
    std::string zipCode;
    std::string areaCode;
    std::string prefix;
    std::string exchange;

    virtual double calculatePayroll() = 0;
};

class Salary : public Employee 
{
public:
    double annualSalary;
    double calculatePayroll() override;
};

class Clerical : public Employee 
{
public:
    double hourlyRate;
    double hoursWorked;
    double calculatePayroll() override;
};

class FactoryWorker : public Employee 
{
public:
    double hourlyRate;
    double hoursWorked;
    double holidayHours;
    double calculatePayroll() override;
};

class EmployeeFactory 
{
public:
    static EmployeeFactory& getInstance();
    Employee* createEmployee(std::string type);
private:
    EmployeeFactory() {}
};

#endif

