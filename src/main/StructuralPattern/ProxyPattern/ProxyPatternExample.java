package main.StructuralPattern.ProxyPattern;

// DAO Interface stays same
interface EmployeeeDAO {
    void create(String client, String employeeeName);
    void delete(String client, String employeeeName);
}

// Real DAO Implementation
class EmployeeeDAOImpl implements EmployeeeDAO {
    @Override
    public void create(String client, String employeeeName) {
        System.out.println("Employee " + employeeeName + " created by " + client);
    }

    @Override
    public void delete(String client, String employeeeName) {
        System.out.println("Employee " + employeeeName + " deleted by " + client);
    }
}

// Proxy Class (Access Control)
class EmployeeeDAOProxy implements EmployeeeDAO {
    private EmployeeeDAO realDAO;
    private String clientRole;

    public EmployeeeDAOProxy(String clientRole) {
        this.realDAO = new EmployeeeDAOImpl();
        this.clientRole = clientRole;
    }

    @Override
    public void create(String client, String employeeeName) {
        if (clientRole.equals("ADMIN")) {
            realDAO.create(client, employeeeName);
        } else {
            System.out.println("ACCESS DENIED: Only ADMIN can create employees.");
        }
    }

    @Override
    public void delete(String client, String employeeeName) {
        if (clientRole.equals("ADMIN")) {
            realDAO.delete(client, employeeeName);
        } else {
            System.out.println("ACCESS DENIED: Only ADMIN can delete employees.");
        }
    }
}

// Client
public class ProxyPatternExample {
    public static void main(String[] args) {
        EmployeeeDAO adminProxy = new EmployeeeDAOProxy("ADMIN");
        adminProxy.create("adminUser", "John");   // ✅ Allowed
        adminProxy.delete("adminUser", "John");   // ✅ Allowed

        EmployeeeDAO userProxy = new EmployeeeDAOProxy("USER");
        userProxy.create("normalUser", "Jane");   // ❌ Denied
        userProxy.delete("normalUser", "Jane");   // ❌ Denied
    }
}

