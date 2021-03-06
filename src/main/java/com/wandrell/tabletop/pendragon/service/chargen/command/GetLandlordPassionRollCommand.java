package com.wandrell.tabletop.pendragon.service.chargen.command;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.wandrell.pattern.command.ResultCommand;
import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.parser.DiceExpressionParser;
import com.wandrell.util.ResourceUtils;

public final class GetLandlordPassionRollCommand implements
        ResultCommand<DiceExpression> {

    private final String   descriptor;
    private DiceExpression formula;
    private final String   name;

    public GetLandlordPassionRollCommand(final String name,
            final String descriptor) {
        super();

        this.name = name;
        this.descriptor = descriptor;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void execute() throws Exception {
        final Yaml yaml;
        final Parser<String, DiceExpression> parser;
        final Iterator<Map<String, Object>> itr;
        Collection<Map<String, Object>> values;
        Map<String, Object> value;

        yaml = new Yaml();

        values = (Collection<Map<String, Object>>) yaml
                .load(ResourceUtils
                        .getClassPathReader("config/stat/pendragon_passion_landlord.yml"));

        parser = new DiceExpressionParser();

        formula = null;
        itr = values.iterator();
        while ((itr.hasNext()) && (formula == null)) {
            value = itr.next();

            if ((value.get("name").equals(name))
                    && (value.get("descriptor").equals(descriptor))) {
                formula = parser.parse(value.get("roll").toString());
            }
        }

        if (formula == null) {
            formula = parser.parse("0");
        }
    }

    @Override
    public final DiceExpression getResult() {
        return formula;
    }

}
