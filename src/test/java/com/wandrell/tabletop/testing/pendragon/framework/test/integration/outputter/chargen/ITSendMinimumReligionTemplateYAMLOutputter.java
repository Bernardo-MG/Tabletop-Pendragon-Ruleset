package com.wandrell.tabletop.testing.pendragon.framework.test.integration.outputter.chargen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.pattern.outputter.Outputter;
import com.wandrell.pattern.outputter.yaml.YAMLOutputter;
import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.chargen.ReligionTemplate;
import com.wandrell.tabletop.pendragon.util.parser.dictionary.chargen.ReligionTemplateMapParser;
import com.wandrell.tabletop.pendragon.util.parser.yaml.chargen.ReligionTemplateYAMLParser;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITSendMinimumReligionTemplateYAMLOutputter {

    private static final Random                                 random        = new Random();
    private static final String                                 TEMPLATE_PATH = "target/test_write_HomelandTemplate_";
    private final Parser<ReligionTemplate, Map<String, Object>> parserMap;

    {
        parserMap = new ReligionTemplateMapParser();
    }

    public ITSendMinimumReligionTemplateYAMLOutputter() {
        super();
    }

    @Test
    public final void testWriteFile() throws Exception {
        final ReligionTemplate religion;
        final ReligionTemplate religionOut;
        final Parser<Reader, ReligionTemplate> parser;
        final Path pathOut;
        final Outputter<Object> outputter;

        outputter = new YAMLOutputter();

        parser = new ReligionTemplateYAMLParser(TestServiceFactory
                .getInstance().getModelService());

        religion = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.RELIGION_MINIMUM));

        pathOut = Paths.get(TEMPLATE_PATH + getRandomID() + ".yml")
                .toAbsolutePath();

        outputter.send(parserMap.parse(religion), new BufferedWriter(
                new FileWriter(pathOut.toFile())));

        religionOut = parser.parse(new BufferedReader(new FileReader(pathOut
                .toFile())));

        Assert.assertEquals(religionOut.getName(), religion.getName());
        Assert.assertEquals(religionOut.getReligiousTraits(),
                religion.getReligiousTraits());
        Assert.assertEquals(religionOut.getDerivedAttributeBonus(),
                religion.getDerivedAttributeBonus());
        Assert.assertEquals(religionOut.getArmorBonus(),
                religion.getArmorBonus());
        Assert.assertEquals(religionOut.getDamageBonus(),
                religion.getDamageBonus());
        Assert.assertEquals(religionOut.getDamageDiceBonus(),
                religion.getDamageDiceBonus());
    }

    private final Integer getRandomID() {
        return random.nextInt(Integer.MAX_VALUE);
    }

}