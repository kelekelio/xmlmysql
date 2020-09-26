UPDATE client_items JOIN client_version
    ON client_items.id = client_version.id
SET client_items.client_version = client_version.client_version;

UPDATE client_items JOIN translation_small
    ON client_items.description = translation_small.name
SET
client_items.search_ko = translation_small.body,
client_items.search_en = translation_small.lan_en,
client_items.search_de = translation_small.lan_de,
client_items.search_fr = translation_small.lan_fr,
client_items.search_pl = translation_small.lan_pl,
client_items.search_es = translation_small.lan_es,
client_items.search_it = translation_small.lan_it,
client_items.search_us = translation_small.lan_us;

UPDATE gather_src JOIN translation_small
    ON gather_src.description = translation_small.name
SET
gather_src.search_ko = translation_small.body,
gather_src.search_en = translation_small.lan_en,
gather_src.search_de = translation_small.lan_de,
gather_src.search_fr = translation_small.lan_fr,
gather_src.search_pl = translation_small.lan_pl,
gather_src.search_es = translation_small.lan_es,
gather_src.search_it = translation_small.lan_it,
gather_src.search_us = translation_small.lan_us;

UPDATE client_quest JOIN quest_version
    ON client_quest.id = quest_version.id
SET client_quest.client_version = quest_version.client_version;

UPDATE client_quest JOIN translation_small
    ON client_quest.description = translation_small.name
SET
client_quest.search_ko = translation_small.body,
client_quest.search_en = translation_small.lan_en,
client_quest.search_de = translation_small.lan_de,
client_quest.search_fr = translation_small.lan_fr,
client_quest.search_pl = translation_small.lan_pl,
client_quest.search_es = translation_small.lan_es,
client_quest.search_it = translation_small.lan_it,
client_quest.search_us = translation_small.lan_us;


UPDATE client_quest JOIN quest_youtube
    ON client_quest.id = quest_youtube.id
SET client_quest.youtube = quest_youtube.youtube;

UPDATE client_npcs_monster JOIN npc_version_new
    ON client_npcs_monster.id = npc_version_new.id
SET client_npcs_monster.client_version = npc_version_new.client_version;



UPDATE client_npcs_monster JOIN npc_data_new
    ON client_npcs_monster.id = npc_data_new.id
SET
client_npcs_monster.level = npc_data_new.level,
client_npcs_monster.hp = npc_data_new.hp,
client_npcs_monster.map = npc_data_new.map;



UPDATE client_npcs_monster JOIN translation_small
    ON client_npcs_monster.description = translation_small.name
SET
client_npcs_monster.search_ko = translation_small.body,
client_npcs_monster.search_en = translation_small.lan_en,
client_npcs_monster.search_de = translation_small.lan_de,
client_npcs_monster.search_fr = translation_small.lan_fr,
client_npcs_monster.search_pl = translation_small.lan_pl,
client_npcs_monster.search_es = translation_small.lan_es,
client_npcs_monster.search_it = translation_small.lan_it,
client_npcs_monster.search_us = translation_small.lan_us;


UPDATE gather_src JOIN translation_small
    ON gather_src.description = translation_small.name
SET
gather_src.search_ko = translation_small.body,
gather_src.search_en = translation_small.lan_en,
gather_src.search_de = translation_small.lan_de,
gather_src.search_fr = translation_small.lan_fr,
gather_src.search_pl = translation_small.lan_pl,
gather_src.search_es = translation_small.lan_es,
gather_src.search_it = translation_small.lan_it,
gather_src.search_us = translation_small.lan_us;


UPDATE client_skills JOIN translation_small
    ON client_skills.description = translation_small.name
SET
client_skills.search_ko = translation_small.body,
client_skills.search_en = translation_small.lan_en,
client_skills.search_de = translation_small.lan_de,
client_skills.search_fr = translation_small.lan_fr,
client_skills.search_pl = translation_small.lan_pl,
client_skills.search_es = translation_small.lan_es,
client_skills.search_it = translation_small.lan_it,
client_skills.search_us = translation_small.lan_us;


UPDATE client_skills JOIN skill_version_new
    ON client_skills.name = skill_version_new.name
SET client_skills.client_version = skill_version_new.client_version;


UPDATE client_combine_recipe JOIN translation_small
    ON client_combine_recipe.description = translation_small.name
SET
client_combine_recipe.search_ko = translation_small.body,
client_combine_recipe.search_en = translation_small.lan_en,
client_combine_recipe.search_de = translation_small.lan_de,
client_combine_recipe.search_fr = translation_small.lan_fr,
client_combine_recipe.search_pl = translation_small.lan_pl,
client_combine_recipe.search_es = translation_small.lan_es,
client_combine_recipe.search_it = translation_small.lan_it,
client_combine_recipe.search_us = translation_small.lan_us;