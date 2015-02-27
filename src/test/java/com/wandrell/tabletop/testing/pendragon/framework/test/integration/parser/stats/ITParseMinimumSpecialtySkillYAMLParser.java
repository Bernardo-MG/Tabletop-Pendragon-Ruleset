package com.wandrell.tabletop.testing.pendragon.framework.test.integration.parser.stats;

import java.io.Reader;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.stats.SpecialtySkill;
import com.wandrell.tabletop.pendragon.service.ModelService;
import com.wandrell.tabletop.pendragon.util.parser.yaml.stats.SpecialtySkillYAMLParser;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITParseMinimumSpecialtySkillYAMLParser {

    private SpecialtySkill skill;

    public ITParseMinimumSpecialtySkillYAMLParser() {
        super();
    }

    @BeforeClass
    public final void initialize() throws Exception {
        final Parser<Reader, SpecialtySkill> parser;
        final ModelService modelService;

        modelService = TestServiceFactory.getInstance().getModelService();

        parser = new SpecialtySkillYAMLParser(modelService);

        skill = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.SPECIALTY_SKILL_MINIMUM));
    }

    @Test
    public final void testName() {
        Assert.assertEquals(skill.getName(), "test_specialty_skill");
    }

    @Test
    public final void testSkills() {
        Assert.assertTrue(skill.getSurrogatedSkills().isEmpty());
    }

}
