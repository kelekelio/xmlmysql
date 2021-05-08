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

        //client_item_enchanttable.xml & client_item_authorizetable.xml
        extractList.add("enchant_attr_list");
        extractList.add("limitless_attr_list");

        //client_item_upgrade.xml
        extractList.add("upgrade_list");

        //client_item_skill_enhance.xml
        extractList.add("enchant_prob_list");
        extractList.add("enchant_skill_list");

        //grind_item_compound.xml
        extractList.add("material_list");
        extractList.add("result_list");

        //enchant_datadriven
        extractList.add("enchant_level_list");

        //polish_bonus_setlist
        extractList.add("random_attr_group_list");

        //client_reinvent_candidate
        extractList.add("candidate_list");

        //client_assembly_items
        extractList.add("assemble_parts");

        //client_login_event
        extractList.add("reward_item_list");

        //client_reinvent_package
        extractList.add("candidate_list");
        extractList.add("ui_reward_list");

        //client_npc_goodslist & client_npc_purchase_list
        extractList.add("goods_list");

        //client_titles
        extractList.add("bonus_attrs");

    }

    public ArrayList<String> getExtractList() {
        return extractList;
    }

    public void setExtractList(ArrayList<String> extractList) {
        this.extractList = extractList;
    }
}
