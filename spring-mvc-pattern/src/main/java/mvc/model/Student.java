package mvc.model;

public class Student {
    private Long id;
    private String name;
    private int score;

    public Student(Long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Студент: [id: %d, name: %s, score: %f]", id, name, score);
    }
}
