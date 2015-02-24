package com.wandrell.tabletop.testing.pendragon.framework.test.integration.parser.chargen;

import java.io.Reader;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.chargen.FamilyCharacteristicTable;
import com.wandrell.tabletop.pendragon.service.ModelService;
import com.wandrell.tabletop.pendragon.util.parser.yaml.chargen.FamilyCharacteristicTableYAMLParser;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITParseMinimumFamilyCharacteristicTableYAMLParser {

    private FamilyCharacteristicTable table;

    public ITParseMinimumFamilyCharacteristicTableYAMLParser() {
        super();
    }

    @BeforeClass
    public final void initialize() throws Exception {
        final Parser<Reader, FamilyCharacteristicTable> parser;
        final ModelService modelService;

        modelService = TestServiceFactory.getInstance().getModelService();

        parser = new FamilyCharacteristicTableYAMLParser(modelService);

        table = parser
                .parse(ResourceUtils
                        .getClassPathReader(TestModelFileConf.FAMILY_CHARACTERISTIC_MINIMUM));
    }

    @Test
    public final void testIntervals() {
        Assert.assertTrue(table.getIntervals().isEmpty());
    }

    @Test
    public final void testName() {
        Assert.assertEquals(table.getName(), "test_family_characteristic");
    }

}