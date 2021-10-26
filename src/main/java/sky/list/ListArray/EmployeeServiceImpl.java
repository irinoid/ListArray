package sky.list.ListArray;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private ArrayList<Employee> employee;

    public EmployeeServiceImpl() {
        employee = new ArrayList<>();
    }


    @Override
    public Employee addEmployee(String lastName, String firstName) throws EmpIntServErrException {
        if (employee.size() < 10) {
            employee.add(new Employee(lastName, firstName));
            int i = employee.size() - 1;
            return employee.get(i);
        } else {
            throw new EmpIntServErrException();
        }
    }

    @Override
    public String deleteEmployee(String lastName, String firstName) throws EmpNotFoundException {
        Employee compareEmp = new Employee(lastName, firstName);
        if (employee.contains(compareEmp)) {
            employee.remove(compareEmp);
            return lastName + " " + firstName;
        } else {
            throw new EmpNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) throws EmpNotFoundException {
        for (int i = 0; i < employee.size(); i++) {
            if ((employee.get(i).getFirstName().equals(firstName)) && (employee.get(i).getLastName().equals(lastName))) {
                return employee.get(i);
            }
        }
        throw new EmpNotFoundException();
    }
}
