package by.vlad.spring.mvc_hibernate_aop.dao;

import by.vlad.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        var currentSession = sessionFactory.getCurrentSession();

        var employeeList = currentSession.createQuery("from Employee ", Employee.class)
                .getResultList();
        return employeeList;
    }

    @Override
    public void saveEmployee(Employee employee) {
        var currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        var currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        var currentSession = sessionFactory.getCurrentSession();
        Query<Employee> query = currentSession.createQuery("delete from Employee where id = :empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
