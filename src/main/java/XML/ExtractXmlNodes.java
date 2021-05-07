package XML;

import java.util.ArrayList;

/**
 * @author Grzegorz Nowakowski
 */
public class ExtractXmlNodes {
    private ArrayList<String> extractList = new ArrayList<>();

    public ExtractXmlNodes() {
        //client_assembly_items.xml
        extractList.add("assemble_parts");

        //client_combine_recipe.xml
        extractList.add("combine_recipe_expansion");

        //client_disassembly_item_SetList.xml
        extractList.add("disassembly_create_item_list");

        //client_disassembly_item.xml
        extractList.add("disassemble_set_list");

        //client_item_random_option.xml
        extractList.add("random_attr_group_list");

        //client_real_item_random_option.xml
        extractList.add("random_option_list");

        //client_item_enchanttable.xml
        extractList.add("enchant_attr_list");
        extractList.add("limitless_attr_list");

        //client_item_upgrade.xml
        extractList.add("upgrade_list");
    }

    public ArrayList<String> getExtractList() {
        return extractList;
    }

    public void setExtractList(ArrayList<String> extractList) {
        this.extractList = extractList;
    }
}
