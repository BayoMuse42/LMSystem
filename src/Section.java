package src;

public class Section {

    protected String name;
    protected String content;

    public Section(String name, String content) {
        this.name = name;
        this.content = content;
    }
    
    public String getContent() {
        return this.content;
    }

    public String getName(){
        return this.name;
    }
    

}
