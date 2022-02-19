package hlft.violet.action;

public class Action {
    private final String description;
    private final Type type;

    public Action(String description, Type type) {
        this.description = description;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        FAIL,
        SUCCESS
    }
}
