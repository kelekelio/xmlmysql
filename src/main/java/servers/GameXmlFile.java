package servers;

public class GameXmlFile {
    private String path;
    private String initialNode;
    private String tableName;
    private boolean truncate = true;
    private boolean versions = false;
    private String lang;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getInitialNode() {
        return initialNode;
    }

    public void setInitialNode(String initialNode) {
        this.initialNode = initialNode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isTruncate() {
        return truncate;
    }

    public void setTruncate(boolean truncate) {
        this.truncate = truncate;
    }

    public boolean isVersions() {
        return versions;
    }

    public void setVersions(boolean versions) {
        this.versions = versions;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
