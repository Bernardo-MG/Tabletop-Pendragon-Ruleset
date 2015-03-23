package com.wandrell.tabletop.testing.pendragon.test.integration.parser.chargen;

import java.io.Reader;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.chargen.FatherClassTemplate;
import com.wandrell.tabletop.pendragon.service.model.ModelConstructorService;
import com.wandrell.tabletop.pendragon.util.parser.yaml.chargen.FatherClassTemplateYAMLParser;
import com.wandrell.tabletop.skill.DefaultSkillName;
import com.wandrell.tabletop.skill.SkillName;
import com.wandrell.tabletop.testing.pendragon.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITParseFatherClassTemplateYAMLParser {

    private FatherClassTemplate fatherClass;

    public ITParseFatherClassTemplateYAMLParser() {
        super();
    }

    @BeforeClass
    public final void initialize() throws Exception {
        final Parser<Reader, FatherClassTemplate> parser;
        final ModelConstructorService modelService;

        modelService = TestServiceFactory.getInstance()
                .getModelConstructorService();

        parser = new FatherClassTemplateYAMLParser(modelService);

        fatherClass = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.FATHER_CLASS));
    }

    @Test
    public final void testBaseDirectedTraits() {
        SkillName trait;

        Assert.assertEquals(fatherClass.getDirectedTraitsBase().size(), 1);

        trait = new DefaultSkillName("directed_trait_2", "descriptor_2");
        Assert.assertEquals(fatherClass.getDirectedTraitsBase().get(trait),
                (Integer) 10);
    }

    @Test
    public final void testDirectedTraits() {
        SkillName trait;

        Assert.assertEquals(fatherClass.getDirectedTraits().size(), 3);

        trait = new DefaultSkillName("directed_trait_1", "descriptor_1");
        Assert.assertEquals(fatherClass.getDirectedTraits().get(trait),
                (Integer) 5);

        trait = new DefaultSkillName("directed_trait_2", "descriptor_2");
        Assert.assertEquals(fatherClass.getDirectedTraits().get(trait),
                (Integer) 6);

        trait = new DefaultSkillName("directed_trait_3", "descriptor_3");
        Assert.assertEquals(fatherClass.getDirectedTraits().get(trait),
                (Integer) 7);
    }

    @Test
    public final void testMoney() {
        Assert.assertEquals(fatherClass.getMoney().getTextValue(), "3d6+10");
    }

    @Test
    public final void testName() {
        Assert.assertEquals(fatherClass.getName(), "test_father_class");
    }

    @Test
    public final void testNonCombatSkillPoints() {
        Assert.assertEquals(fatherClass.getNonCombatSkillBonus(), (Integer) 6);
    }

    @Test
    public final void testSkillPoints() {
        Assert.assertEquals(fatherClass.getSkillsPoints(), (Integer) 5);
    }

    @Test
    public final void testSkillsGroup() {
        SkillName skill;

        Assert.assertEquals(fatherClass.getSkillsGroup().size(), 2);

        skill = new DefaultSkillName("skill_1", "");
        Assert.assertTrue(fatherClass.getSkillsGroup().contains(skill));

        skill = new DefaultSkillName("skill_2", "descriptor_2");
        Assert.assertTrue(fatherClass.getSkillsGroup().contains(skill));
    }

    @Test
    public final void testSkillsGroupBonusPoints() {
        Assert.assertEquals(fatherClass.getSkillsGroupBonusPoints(),
                (Integer) 7);
    }

    @Test
    public final void testSkillsGroupDividePoints() {
        Assert.assertEquals(fatherClass.getSkillsGroupDividePoints(),
                (Integer) 8);
    }

    @Test
    public final void testSpecialtySkills() {
        Assert.assertEquals(fatherClass.getSpecialtySkills().size(), 1);

        Assert.assertEquals(
                fatherClass.getSpecialtySkills().get("specialty_skill_1"),
                (Integer) 12);
    }

}