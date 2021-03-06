package com.wandrell.tabletop.testing.pendragon.test.integration.parser.character.background;

import java.io.Reader;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.character.background.Religion;
import com.wandrell.tabletop.pendragon.util.parser.yaml.character.background.ReligionYAMLParser;
import com.wandrell.tabletop.testing.pendragon.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITParseReligionYAMLParser {

    private Religion religion;

    public ITParseReligionYAMLParser() {
        super();
    }

    @BeforeClass
    public final void initialize() throws Exception {
        final Parser<Reader, Religion> parser;

        parser = new ReligionYAMLParser(TestServiceFactory.getInstance()
                .getModelConstructorService());

        religion = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.RELIGION));
    }

    @Test
    public final void testArmorBonus() {
        Assert.assertEquals(religion.getArmorBonus(), (Integer) 5);
    }

    @Test
    public final void testDamageBonus() {
        Assert.assertEquals(religion.getDamageBonus(), (Integer) 6);
    }

    @Test
    public final void testDamageDiceBonus() {
        Assert.assertEquals(religion.getDamageDiceBonus(), (Integer) 7);
    }

    @Test
    public final void testDerivedAttributesBonus() {
        // TODO: Check the others are all set at zero

        Assert.assertEquals(religion.getDerivedAttributeBonus().getDamage(),
                (Integer) 3);

        Assert.assertEquals(religion.getDerivedAttributeBonus().getHitPoints(),
                (Integer) 2);
    }

    @Test
    public final void testReligion() {
        Assert.assertEquals(religion.getName(), "test_religion");
    }

    @Test
    public final void testTraits() {
        Assert.assertEquals(religion.getReligiousTraits().size(), 5);

        Assert.assertTrue(religion.getReligiousTraits().contains("temperate"));
        Assert.assertTrue(religion.getReligiousTraits().contains("merciful"));
        Assert.assertTrue(religion.getReligiousTraits().contains("just"));
        Assert.assertTrue(religion.getReligiousTraits().contains("honest"));
        Assert.assertTrue(religion.getReligiousTraits().contains("chaste"));
    }

}
