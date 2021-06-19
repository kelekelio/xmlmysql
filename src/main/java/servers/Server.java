package servers;

import DLL.ClientVersion;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private Integer id;
    private String dbName;
    private String clientPath;
    private ArrayList<GameXmlFile> xmlFiles = new ArrayList<GameXmlFile>();
    private String clientVersion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getClientPath() {
        return clientPath;
    }

    public void setClientPath(String clientPath) {
        this.clientPath = clientPath;
    }

    public ArrayList<GameXmlFile> getXmlFiles() {
        return xmlFiles;
    }

    public void setXmlFiles(ArrayList<GameXmlFile> xmlFiles) {
        this.xmlFiles = xmlFiles;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public void reset() {
        this.id = null;
        this.dbName = null;
        this.clientPath = null;
        this.xmlFiles.clear();
    }

}
