package APP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connextion {
    private final String url;
    private final String user;
    private final String password;


    public Connextion() {
        this.url = "jdbc:postgresql://localhost:5432/" + Configuration.DatabaseName;
        this.user = Configuration.User;
        this.password = Configuration.Password;
    }

    public Connection createConnection() {
        try {
            return DriverManager.getConnection(
                    this.url, this.user, this.password
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
