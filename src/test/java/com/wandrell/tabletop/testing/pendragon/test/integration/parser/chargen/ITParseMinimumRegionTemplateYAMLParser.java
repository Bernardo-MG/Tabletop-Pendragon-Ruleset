package com.wandrell.tabletop.testing.pendragon.test.integration.parser.chargen;

import java.io.Reader;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.chargen.region.RegionTemplate;
import com.wandrell.tabletop.pendragon.service.model.ModelConstructorService;
import com.wandrell.tabletop.pendragon.util.parser.yaml.chargen.RegionTemplateYAMLParser;
import com.wandrell.tabletop.testing.pendragon.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITParseMinimumRegionTemplateYAMLParser {

    private RegionTemplate region;

    public ITParseMinimumRegionTemplateYAMLParser() {
        super();
    }

    @BeforeClass
    public final void initialize() throws Exception {
        final Parser<Reader, RegionTemplate> parser;
        final ModelConstructorService modelService;

        modelService = TestServiceFactory.getInstance()
                .getModelConstructorService();

        parser = new RegionTemplateYAMLParser(modelService);

        region = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.REGION_MINIMUM));
    }

    @Test
    public final void testName() {
        Assert.assertEquals(region.getName(), "test_region");
    }

}
