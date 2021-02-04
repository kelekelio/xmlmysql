package XML;

import java.util.ArrayList;

/**
 * @author Grzegorz Nowakowski
 */
public class ExtractXmlNodes {
    private ArrayList<String> extractList = new ArrayList<>();

    public ExtractXmlNodes() {
        //client_assembly_items
        extractList.add("assemble_parts");


        extractList.add("combine_recipe_expansion");
    }

    public ArrayList<String> getExtractList() {
        return extractList;
    }

    public void setExtractList(ArrayList<String> extractList) {
        this.extractList = extractList;
    }
}
