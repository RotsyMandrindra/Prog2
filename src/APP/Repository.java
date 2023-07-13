package APP;

import java.sql.Timestamp;

public interface Repository {
    void insert(int id, String title, String description, Timestamp deadline, int priority,boolean done);
    void delete(int id);
    void update(int id, String title, String description, Timestamp deadline, int priority,boolean done);
    void selectById(int id);
    void selectAll();


}
