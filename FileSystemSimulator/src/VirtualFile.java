public class VirtualFile {
    private String name;
    private String content;

    public VirtualFile(String name) {
        this.name = name;
        this.content = "";
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void rename(String newName) {
        this.name = newName;
    }
}