package com.wandrell.tabletop.pendragon.service.chargen.command;

import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.wandrell.pattern.command.ReturnCommand;
import com.wandrell.tabletop.pendragon.conf.FileConfig;
import com.wandrell.util.ResourceUtils;

public final class GetAttributePointsCommand implements ReturnCommand<Integer> {

    public GetAttributePointsCommand() {
        super();
    }

    @SuppressWarnings("unchecked")
    @Override
    public final Integer execute() {
        final Yaml yaml;
        final Integer value;
        Map<String, Object> values;

        yaml = new Yaml();

        values = (Map<String, Object>) yaml.load(ResourceUtils
                .getClassPathReader(FileConfig.RULESET_CHARGEN_CONFIG));
        values = (Map<String, Object>) values.get("points");
        value = (Integer) values.get("attributes");

        return value;
    }

}
