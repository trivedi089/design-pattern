package main.StructuralPattern.ProxyPattern;

// DAO Interface
interface EmployeeDAO {
    void create(String client, String employeeName);
    void delete(String client, String employeeName);
}

// Real DAO Implementation
class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void create(String client, String employeeName) {
        System.out.println("Employee " + employeeName + " created by " + client);
    }

    @Override
    public void delete(String client, String employeeName) {
        System.out.println("Employee " + employeeName + " deleted by " + client);
    }
}

// Client
public class WithoutProxyPattern {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAOImpl();
        dao.create("user1", "John");  // No checks
        dao.delete("user1", "John");  // No checks
    }
}
