package APP;

import java.sql.Timestamp;
import java.time.LocalDate;

public class ModelToDo {
    private int id;
    private String title;
    private String description;
    private Timestamp deadline;
    private int priority;
    private boolean done ;

    public ModelToDo(int id, String title, String description, Timestamp deadline, int priority,boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.done = done;

        LocalDate currentDate = LocalDate.now();
        LocalDate todoDate = deadline.toLocalDateTime().toLocalDate();
        if (todoDate.isAfter(currentDate)) {
            this.priority = priority;
        } else {
            throw new IllegalArgumentException("La DATE doit être antérieure à la date d'aujourd'hui.");
        }
    }


    public String getTitle() {return title;}

    public String getDescription() {return description;}

    public Timestamp getDeadline() {return deadline;}

    public int getPriority() {return priority;}

    public void setId(int id) {
        this.id = id;
    }

    public void setDone(boolean done) {this.done = done;}

    public int getId() {return id;}

    public boolean isDone() {return done;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "ModelToDo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", priority=" + priority +
                '}';
    }
      /*CREATE TABLE todo (
  id INT PRIMARY KEY,
  title VARCHAR(255),
  description VARCHAR(255),
  deadline TIMESTAMP CHECK (CURRENT_TIMESTAMP < deadline),
  priority INT CHECK (priority >= 0 AND priority <= 10),
  done BOOLEAN DEFAULT TRUE CHECK (done IN (TRUE, FALSE))
);

*/
}
