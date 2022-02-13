package hlft.violet.system.resources;

public class Link {
    private final String head;
    private final String describe;

    public Link(String head, String describe) {
        this.head = head;
        this.describe = describe;
    }

    public Link(String conformity) {
        String var = conformity.substring(0, conformity.indexOf(":"));
        this.head = var;
        this.describe = conformity.substring(var.length()+1);
    }

    public String getHead() {
        return head;
    }

    public String getDescribe() {
        return describe;
    }

    @Override
    public String toString() {
        return this.head + ":" + this.describe;
    }
}
