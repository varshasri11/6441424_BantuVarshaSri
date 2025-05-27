import java.sql.*;

public class StudentJDBC {

    static class StudentDAO {
        private static final String URL = "jdbc:mysql://localhost:3306/sys";
        private static final String USER = "root";
        private static final String PASSWORD = "root"; 

        private Connection connect() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        public void insertStudent(String name, int age) {
            String query = "INSERT INTO students (name, age) VALUES (?, ?)";
            try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setInt(2, age);
                int rowsInserted = stmt.executeUpdate();
                System.out.println(rowsInserted + " student(s) inserted.");
            } catch (SQLException e) {
                System.out.println("Insert failed: " + e.getMessage());
            }
        }

        public void updateStudent(int id, String name, int age) {
            String query = "UPDATE students SET name = ?, age = ? WHERE id = ?";
            try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setInt(3, id);
                int rowsUpdated = stmt.executeUpdate();
                System.out.println(rowsUpdated + " student(s) updated.");
            } catch (SQLException e) {
                System.out.println("Update failed: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.insertStudent("Yashaswini", 21);

        dao.updateStudent(1, "Yashaswini R", 22);
    }
}
