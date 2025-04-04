public class Task {
    private String id;
    private String title;
    private String description;
    private String deadline; // LocalDateTime yerine String kullanıyoruz
    private int points;
    private boolean completed;
    private boolean approved;
    private int rating;

    public Task(String id, String title, String description, String deadline, int points) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.points = points;
        this.completed = false;
        this.approved = false;
        this.rating = 0;
    }

    // Getter ve setter metodları
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDeadline() { return deadline; }
    public int getPoints() { return points; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    @Override
    public String toString() {
        return String.format("Görev: %s - %s (Deadline: %s, Puan: %d, Tamamlandı: %s, Onaylandı: %s)",
            title, description, deadline, points, completed ? "Evet" : "Hayır", approved ? "Evet" : "Hayır");
    }
}