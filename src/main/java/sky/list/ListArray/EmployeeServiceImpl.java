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
    public String addEmployee(String lastName, String firstName) throws EmpIntServErrException {
        Employee newEmp = new Employee(lastName, firstName);
        if (employee.size() < 10) {
            employee.add(newEmp);

            return "Сотрудник " + newEmp.toString() + " успешно создан.";
        } else {
            throw new EmpIntServErrException();
        }
    }

    @Override
    public String deleteEmployee(String lastName, String firstName) throws EmpNotFoundException {
        Employee compareEmp = new Employee(lastName, firstName);
        if (employee.contains(compareEmp)) {
            employee.remove(compareEmp);
            return "Сотрудник " + compareEmp.toString() + " удален.";
        } else {
            throw new EmpNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) throws EmpNotFoundException {
        Employee employeeForSearch = new Employee(lastName, firstName);
        for (int i = 0; i < employee.size(); i++) {

            if (employee.get(i).equals(employeeForSearch)) {
                return employee.get(i);
            }
        }
        throw new EmpNotFoundException();
    }
}
