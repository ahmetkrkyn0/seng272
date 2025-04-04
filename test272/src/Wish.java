public class Wish {
    private String id;
    private String title;
    private String description;
    private String dateTime;  // LocalDateTime yerine String kullanıyoruz
    private boolean approved;
    private int requiredLevel;

    public Wish(String id, String title, String description, String dateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.approved = false;
        this.requiredLevel = 1;
    }

    // Getter ve setter metodları
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDateTime() { return dateTime; }
    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
    public int getRequiredLevel() { return requiredLevel; }
    public void setRequiredLevel(int requiredLevel) { this.requiredLevel = requiredLevel; }

    @Override
    public String toString() {
        return String.format("Dilek: %s - %s (Tarih: %s, Onaylandı: %s, Gereken Seviye: %d)",
            title, description, dateTime, approved ? "Evet" : "Hayır", requiredLevel);
    }
}