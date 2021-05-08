package XML;

import java.util.ArrayList;

/**
 * @author Grzegorz Nowakowski
 */
public class ConsolidateXmlNodeList {

    private ArrayList<String> consolidateList = new ArrayList<>();

    public ConsolidateXmlNodeList() {

        //client_item
        consolidateList.add("trade_in_item_list");



        //npc_clients
        consolidateList.add("extra_currency_trade_info");
        consolidateList.add("trade_info");
        consolidateList.add("trade_in_trade_info");
        consolidateList.add("abyss_trade_info");
        consolidateList.add("coupon_trade_info");
        consolidateList.add("abyss_trade_buy_info");
        consolidateList.add("event_tool_trade_info");
        consolidateList.add("abyss_qina_trade_info");

        //quests
        consolidateList.add("fighter_selectable_reward");
        consolidateList.add("knight_selectable_reward");
        consolidateList.add("ranger_selectable_reward");
        consolidateList.add("assassin_selectable_reward");
        consolidateList.add("wizard_selectable_reward");
        consolidateList.add("elementalist_selectable_reward");
        consolidateList.add("priest_selectable_reward");
        consolidateList.add("chanter_selectable_reward");
        consolidateList.add("gunner_selectable_reward");
        consolidateList.add("rider_selectable_reward");
        consolidateList.add("painter_selectable_reward");

        //client_achievements
        consolidateList.add("item_list");
        consolidateList.add("action_list");

        //client_achievement_events
        consolidateList.add("item_list_1");
        consolidateList.add("item_list_2");
        consolidateList.add("item_list_3");
        consolidateList.add("item_list_4");

        //client_assembly_items



        //client_equipment_skill
        consolidateList.add("skill_list");




    }

    public ArrayList<String> getConsolidateList() {
        return consolidateList;
    }

    public void setConsolidateList(ArrayList<String> consolidateList) {
        this.consolidateList = consolidateList;
    }
}
