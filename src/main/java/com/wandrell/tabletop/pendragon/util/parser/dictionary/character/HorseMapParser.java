package com.wandrell.tabletop.pendragon.util.parser.dictionary.character;

import java.util.LinkedHashMap;
import java.util.Map;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.character.Horse;

public final class HorseMapParser implements Parser<Horse, Map<String, Object>> {

    public HorseMapParser() {
        super();
    }

    @Override
    public final Map<String, Object> parse(final Horse value) {
        final Map<String, Object> data;
        final Map<String, Integer> attributes;
        final Map<String, Integer> derived;
        final Map<String, Boolean> flags;

        data = new LinkedHashMap<String, Object>();
        attributes = new LinkedHashMap<String, Integer>();
        derived = new LinkedHashMap<String, Integer>();
        flags = new LinkedHashMap<String, Boolean>();

        attributes.put("constitution", value.getConstitution());
        attributes.put("dexterity", value.getDexterity());
        attributes.put("size", value.getSize());
        attributes.put("strength", value.getStrength());

        derived.put("damage", 55);
        derived.put("movement_rate", 66);

        flags.put("armored", value.isArmored());
        flags.put("combat", value.isCombatHorse());
        flags.put("hunting", value.isHuntingHorse());

        data.put("type", value.getHorseType());
        data.put("natural_armor", value.getNaturalArmor());
        data.put("attributes", attributes);
        data.put("derived_attributes", derived);
        data.put("flags", flags);

        return data;
    }

}