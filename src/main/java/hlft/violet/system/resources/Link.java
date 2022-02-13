package hlft.violet.system.resources;

public class Link {
    private final String head;
    private final String describe;

    /**
     * @param head MC的命名空间的Light版
     * @param describe 文件名
     */
    public Link(String head, String describe) {
        this.head = head;
        this.describe = describe;
    }

    /**
     * @param conformity 示例："minecraft:stone"，将head与describe整合。
     */
    public Link(String conformity) {
        String var = conformity.substring(0, conformity.indexOf(":"));
        this.head = var;
        this.describe = conformity.substring(var.length()+1);
    }

    /**
     * @return {@link Link#head}
     */
    public String getHead() {
        return head;
    }

    /**
     * @return {@link Link#describe}
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 可以看作{@link Link#Link(String conformity)}的还原方法
     */
    @Override
    public String toString() {
        return this.head + ":" + this.describe;
    }
}
