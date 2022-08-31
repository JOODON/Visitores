package BBS;

public class BBS {
    private int id;
    private String name;
    private String title;
    private String Date;

    public BBS(String name,String title) {
        super();
        this.name = name;
        this.title = title;
    }
    public BBS(int id, String name, String title, String Date) {
        super();
        this.id=id;
        this.name = name;
        this.title = title;
        this.Date=Date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
