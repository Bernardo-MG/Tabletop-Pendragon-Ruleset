package com.wandrell.tabletop.pendragon.util.parser.yaml.chargen;

import java.io.Reader;
import java.util.Collection;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.character.stats.DefaultTraitsHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.TraitsHolder;
import com.wandrell.tabletop.pendragon.model.chargen.region.RegionTemplate;
import com.wandrell.tabletop.pendragon.service.model.ModelConstructorService;

public final class RegionTemplateYAMLParser implements
        Parser<Reader, RegionTemplate> {

    private final ModelConstructorService modelService;

    public RegionTemplateYAMLParser(final ModelConstructorService service) {
        super();

        modelService = service;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final RegionTemplate parse(final Reader reader) {
        final Yaml yaml;
        final Map<String, Object> values;
        final Map<String, Collection<Map<String, Object>>> bonus;
        final String name;
        final TraitsHolder traits;

        yaml = new Yaml();

        values = (Map<String, Object>) yaml.load(reader);

        // Name
        name = (String) values.get("name");

        bonus = (Map<String, Collection<Map<String, Object>>>) values
                .get("bonus");

        if (bonus != null) {
            // Traits
            if (bonus.containsKey("traits")) {
                traits = getTraits(bonus.get("traits"));
            } else {
                traits = new DefaultTraitsHolder();
            }
        } else {
            traits = new DefaultTraitsHolder();
        }

        return getModelService().getRegionTemplate(name, traits);
    }

    private final ModelConstructorService getModelService() {
        return modelService;
    }

    private final TraitsHolder getTraits(
            final Collection<Map<String, Object>> traits) {
        final TraitsHolder traitsHolder;

        traitsHolder = new DefaultTraitsHolder();

        for (final Map<String, Object> child : traits) {
            if (child.get("name").equals("arbitrary")) {
                traitsHolder.setArbitrary((Integer) child.get("value"));
            } else if (child.get("name").equals("chaste")) {
                traitsHolder.setChaste((Integer) child.get("value"));
            } else if (child.get("name").equals("cowardly")) {
                traitsHolder.setCowardly((Integer) child.get("value"));
            } else if (child.get("name").equals("cruel")) {
                traitsHolder.setCruel((Integer) child.get("value"));
            } else if (child.get("name").equals("deceitful")) {
                traitsHolder.setDeceitful((Integer) child.get("value"));
            } else if (child.get("name").equals("energetic")) {
                traitsHolder.setEnergetic((Integer) child.get("value"));
            } else if (child.get("name").equals("forgiving")) {
                traitsHolder.setForgiving((Integer) child.get("value"));
            } else if (child.get("name").equals("generous")) {
                traitsHolder.setGenerous((Integer) child.get("value"));
            } else if (child.get("name").equals("honest")) {
                traitsHolder.setHonest((Integer) child.get("value"));
            } else if (child.get("name").equals("indulgent")) {
                traitsHolder.setIndulgent((Integer) child.get("value"));
            } else if (child.get("name").equals("just")) {
                traitsHolder.setJust((Integer) child.get("value"));
            } else if (child.get("name").equals("lazy")) {
                traitsHolder.setLazy((Integer) child.get("value"));
            } else if (child.get("name").equals("lustful")) {
                traitsHolder.setLustful((Integer) child.get("value"));
            } else if (child.get("name").equals("merciful")) {
                traitsHolder.setMerciful((Integer) child.get("value"));
            } else if (child.get("name").equals("modest")) {
                traitsHolder.setModest((Integer) child.get("value"));
            } else if (child.get("name").equals("pious")) {
                traitsHolder.setPious((Integer) child.get("value"));
            } else if (child.get("name").equals("proud")) {
                traitsHolder.setProud((Integer) child.get("value"));
            } else if (child.get("name").equals("prudent")) {
                traitsHolder.setPrudent((Integer) child.get("value"));
            } else if (child.get("name").equals("reckless")) {
                traitsHolder.setReckless((Integer) child.get("value"));
            } else if (child.get("name").equals("selfish")) {
                traitsHolder.setSelfish((Integer) child.get("value"));
            } else if (child.get("name").equals("suspicious")) {
                traitsHolder.setSuspicious((Integer) child.get("value"));
            } else if (child.get("name").equals("temperate")) {
                traitsHolder.setTemperate((Integer) child.get("value"));
            } else if (child.get("name").equals("trusting")) {
                traitsHolder.setTrusting((Integer) child.get("value"));
            } else if (child.get("name").equals("valorous")) {
                traitsHolder.setValorous((Integer) child.get("value"));
            } else if (child.get("name").equals("vengeful")) {
                traitsHolder.setVengeful((Integer) child.get("value"));
            } else if (child.get("name").equals("wordly")) {
                traitsHolder.setWorldly((Integer) child.get("value"));
            }
        }

        return traitsHolder;
    }

}
