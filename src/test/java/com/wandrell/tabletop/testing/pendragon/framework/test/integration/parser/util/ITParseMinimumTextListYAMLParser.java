package com.wandrell.tabletop.testing.pendragon.framework.test.integration.parser.util;

import java.io.Reader;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.util.TextList;
import com.wandrell.tabletop.pendragon.service.ModelService;
import com.wandrell.tabletop.pendragon.util.parser.yaml.util.TextListYAMLParser;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITParseMinimumTextListYAMLParser {

    private TextList list;

    public ITParseMinimumTextListYAMLParser() {
        super();
    }

    @BeforeClass
    public final void initialize() throws Exception {
        final Parser<Reader, TextList> parser;
        final ModelService modelService;

        modelService = TestServiceFactory.getInstance().getModelService();

        parser = new TextListYAMLParser(modelService);

        list = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.LIST_MINIMUM));
    }

    @Test
    public final void testName() {
        Assert.assertEquals(list.getName(), "test_list");
    }

    @Test
    public final void testValues() {
        Assert.assertTrue(list.getValues().isEmpty());
    }

}
