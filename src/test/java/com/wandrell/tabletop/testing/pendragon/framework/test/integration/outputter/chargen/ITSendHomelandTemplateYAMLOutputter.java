package com.wandrell.tabletop.testing.pendragon.framework.test.integration.outputter.chargen;

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
import com.wandrell.tabletop.pendragon.model.chargen.HomelandTemplate;
import com.wandrell.tabletop.pendragon.service.ModelService;
import com.wandrell.tabletop.pendragon.util.outputter.chargen.HomelandTemplateYAMLOutputter;
import com.wandrell.tabletop.pendragon.util.parser.chargen.HomelandTemplateYAMLParser;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITSendHomelandTemplateYAMLOutputter {

    private static final Random               random        = new Random();
    private static final String               TEMPLATE_PATH = "target/test_write_HomelandTemplate_";
    private final Outputter<HomelandTemplate> outputter;

    {
        outputter = new HomelandTemplateYAMLOutputter();
    }

    public ITSendHomelandTemplateYAMLOutputter() {
        super();
    }

    @Test
    public final void testWriteFile() throws Exception {
        final HomelandTemplate homeland;
        final HomelandTemplate homelandOut;
        final Parser<Reader, HomelandTemplate> parser;
        final ModelService modelService;
        final Path pathOut;

        modelService = TestServiceFactory.getInstance().getModelService();

        parser = new HomelandTemplateYAMLParser(modelService);

        homeland = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.HOMELAND));

        pathOut = Paths.get(TEMPLATE_PATH + getRandomID() + ".yml")
                .toAbsolutePath();

        outputter.send(homeland,
                new BufferedWriter(new FileWriter(pathOut.toFile())));

        homelandOut = parser.parse(new BufferedReader(new FileReader(pathOut
                .toFile())));

        Assert.assertEquals(homelandOut.getName(), homeland.getName());
        Assert.assertEquals(homelandOut.getDirectedTraits(),
                homeland.getDirectedTraits());
        Assert.assertEquals(homelandOut.getPassions(), homeland.getPassions());
        Assert.assertEquals(homelandOut.getSkills(), homeland.getSkills());
        Assert.assertEquals(homelandOut.getSpecialtySkills(),
                homeland.getSpecialtySkills());
        Assert.assertEquals(homelandOut.getTraits(), homeland.getTraits());
    }

    private final Integer getRandomID() {
        return random.nextInt(Integer.MAX_VALUE);
    }

}