package APP;

import java.sql.*;

public class CRUDtoDo implements Repository {
    //creation connection pour le recuperer a chaque methode .
    private static Connection connection;
    public static void getConnection() {
        Connextion Db = new Connextion();
        connection = Db.createConnection();
    }
    // Pour suprimer des element dans la base de donner par sont Id .
    @Override
    public void delete(int id) {
        getConnection();
        try {
            String sql = "DELETE FROM todo WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("La suppression a été effectuée avec succès.");
            } else {
                System.out.println("Aucune ligne n'a été supprimée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Pour faire des mise a jours .
    @Override
    public void update(int id, String title, String description, Timestamp deadline, int priority, boolean done) {
        getConnection();
        try {
            String sql = "UPDATE todo SET title = ?, description = ?, deadline = ?, priority = ?, done = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setTimestamp(3, deadline);
            statement.setInt(4, priority);
            statement.setBoolean(5, done);
            statement.setInt(6, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La mise à jour a été effectuée avec succès.");
            } else {
                System.out.println("Aucune ligne n'a été mise à jour.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Pour trier des donner a l'aide de sont ID .
    @Override
    public void selectById(int id) {
        getConnection();
        try {
            String sql = "SELECT * FROM todo WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int Id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Timestamp deadline = resultSet.getTimestamp("deadline");
                int priority = resultSet.getInt("priority");
                boolean done = resultSet.getBoolean("done");
                System.out.println(
                        "id=" + Id +
                                ", title='" + title + "'" +
                                ", description='" + description + "'" +
                                ", deadline=" + deadline +
                                ", priority=" + priority +
                                ", done=" + done
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Pour selection tous les donner dans notre base .
    @Override
    public void selectAll() {
        getConnection();
        try {
            String sql = "SELECT * FROM todo";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Timestamp deadline = resultSet.getTimestamp("deadline");
                int priority = resultSet.getInt("priority");
                boolean done = resultSet.getBoolean("done");
                System.out.println(
                        "id=" + id +
                                ", title='" + title + "'" +
                                ", description='" + description + "'" +
                                ", deadline=" + deadline +
                                ", priority=" + priority +
                                ", done=" + done
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Pour inserer des donner dans notre bases .
    @Override
    public void insert(int id, String title, String description, Timestamp deadline, int priority, boolean done) {
        getConnection();
        try {
            String sql = "INSERT INTO todo (id, title, description, deadline, priority, done) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setTimestamp(4, deadline);
            statement.setInt(5, priority);
            statement.setBoolean(6, done);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("L'insertion a été effectuée avec succès.");
            } else {
                System.out.println("Aucune ligne n'a été insérée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
