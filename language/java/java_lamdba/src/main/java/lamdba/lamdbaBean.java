package lamdba;

/**
 * 这个是一个lamdba表达式用来模拟一个数据库table表
 */
public class lamdbaBean {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public lamdbaBean setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public lamdbaBean setName(String name) {
        this.name = name;
        return this;
    }

}
