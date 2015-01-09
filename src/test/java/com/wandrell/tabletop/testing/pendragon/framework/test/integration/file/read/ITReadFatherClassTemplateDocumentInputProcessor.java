package com.wandrell.tabletop.testing.pendragon.framework.test.integration.file.read;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.tabletop.business.model.pendragon.chargen.FatherClassTemplate;
import com.wandrell.tabletop.business.model.skill.DefaultNameAndDescriptor;
import com.wandrell.tabletop.business.model.skill.NameAndDescriptor;
import com.wandrell.tabletop.business.service.pendragon.ModelService;
import com.wandrell.tabletop.business.util.parser.xml.pendragon.input.chargen.FatherClassTemplateDocumentInputProcessor;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.FileConf;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;
import com.wandrell.util.parser.InputParser;
import com.wandrell.util.parser.xml.input.JDOMDocumentInputProcessor;
import com.wandrell.util.parser.xml.input.JDOMStAXInputParser;

public final class ITReadFatherClassTemplateDocumentInputProcessor {

    private FatherClassTemplate fatherClass;

    public ITReadFatherClassTemplateDocumentInputProcessor() {
        super();
    }

    @BeforeClass
    public final void initialize() throws Exception {
        final InputParser<FatherClassTemplate> parser;
        final JDOMDocumentInputProcessor<FatherClassTemplate> processor;
        final ModelService modelService;

        modelService = TestServiceFactory.getInstance().getModelService();

        processor = new FatherClassTemplateDocumentInputProcessor(modelService);
        parser = new JDOMStAXInputParser<FatherClassTemplate>(processor);

        fatherClass = parser.read(ResourceUtils
                .getClassPathInputStream(FileConf.FATHER_CLASS));
    }

    @Test
    public final void testBaseDirectedTraits() {
        NameAndDescriptor trait;

        Assert.assertEquals(fatherClass.getDirectedTraitsBase().size(), 1);

        trait = new DefaultNameAndDescriptor("directed_trait_2", "descriptor_2");
        Assert.assertEquals(fatherClass.getDirectedTraitsBase().get(trait),
                (Integer) 10);
    }

    @Test
    public final void testDirectedTraits() {
        NameAndDescriptor trait;

        Assert.assertEquals(fatherClass.getDirectedTraits().size(), 3);

        trait = new DefaultNameAndDescriptor("directed_trait_1", "descriptor_1");
        Assert.assertEquals(fatherClass.getDirectedTraits().get(trait),
                (Integer) 5);

        trait = new DefaultNameAndDescriptor("directed_trait_2", "descriptor_2");
        Assert.assertEquals(fatherClass.getDirectedTraits().get(trait),
                (Integer) 6);

        trait = new DefaultNameAndDescriptor("directed_trait_3", "descriptor_3");
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
        NameAndDescriptor skill;

        Assert.assertEquals(fatherClass.getSkillsGroup().size(), 2);

        skill = new DefaultNameAndDescriptor("skill_1", "");
        Assert.assertTrue(fatherClass.getSkillsGroup().contains(skill));

        skill = new DefaultNameAndDescriptor("skill_2", "descriptor_2");
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