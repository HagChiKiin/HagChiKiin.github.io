import statics.WorkerLevel;

public class Worker {
    private int id;
    private WorkerLevel level;

    public Worker(int id, WorkerLevel level) {
        this.id = id;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

}
