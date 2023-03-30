package src;

public class Section {

    protected String name;
    protected String content;

    /**
     * constructor
     * @param name
     * @param content
     */
    public Section(String name, String content) {
        this.name = name;
        this.content = content;
    }
    
    /**
     * gets section content
     * @return
     */
    public String getContent() {
        return this.content;
    }

    /**
     * gets name of section
     * @return
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * returns string description of section
     */
    public String toString() {
        return "Name: " + name + " content " + content;
    }

}
