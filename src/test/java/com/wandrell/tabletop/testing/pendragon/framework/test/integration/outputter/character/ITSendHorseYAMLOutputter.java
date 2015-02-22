package com.wandrell.tabletop.testing.pendragon.framework.test.integration.outputter.character;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.pattern.outputter.Outputter;
import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.character.Horse;
import com.wandrell.tabletop.pendragon.service.ModelService;
import com.wandrell.tabletop.pendragon.util.outputter.character.HorseYAMLOutputter;
import com.wandrell.tabletop.pendragon.util.parser.character.HorseYAMLParser;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITSendHorseYAMLOutputter {

    private static final Random    random        = new Random();
    private static final String    TEMPLATE_PATH = "target/test_write_Horse_";
    private final Outputter<Horse> outputter;

    {
        outputter = new HorseYAMLOutputter();
    }

    public ITSendHorseYAMLOutputter() {
        super();
    }

    @Test
    public final void testWriteFile() throws Exception {
        final Horse horse;
        final Horse horseOut;
        final Parser<Reader, Horse> parser;
        final ModelService modelService;
        final Path pathOut;

        modelService = TestServiceFactory.getInstance().getModelService();

        parser = new HorseYAMLParser(modelService);

        horse = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.HORSE));

        pathOut = Paths.get(TEMPLATE_PATH + getRandomID() + ".yml")
                .toAbsolutePath();

        outputter.send(horse,
                new BufferedWriter(new FileWriter(pathOut.toFile())));

        horseOut = parser.parse(new BufferedReader(new FileReader(pathOut
                .toFile())));

        Assert.assertEquals(horse.getHorseType(), horseOut.getHorseType());

        Assert.assertEquals(horse.getNaturalArmor(), horseOut.getNaturalArmor());

        Assert.assertEquals(horse.getConstitution(), horseOut.getConstitution());
        Assert.assertEquals(horse.getDexterity(), horseOut.getDexterity());
        Assert.assertEquals(horse.getSize(), horseOut.getSize());
        Assert.assertEquals(horse.getStrength(), horseOut.getStrength());

        Assert.assertEquals(horse.getDamage(), horseOut.getDamage());
        Assert.assertEquals(horse.getMovementRate(), horseOut.getMovementRate());

        Assert.assertEquals(horse.isArmored(), horseOut.isArmored());
        Assert.assertEquals(horse.isCombatHorse(), horseOut.isCombatHorse());
        Assert.assertEquals(horse.isHuntingHorse(), horseOut.isHuntingHorse());
    }

    private final Integer getRandomID() {
        return random.nextInt(Integer.MAX_VALUE);
    }

}
