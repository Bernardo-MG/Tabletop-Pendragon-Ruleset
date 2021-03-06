package com.wandrell.tabletop.testing.pendragon.test.integration.parser.inventory;

import java.io.Reader;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.pendragon.model.inventory.weapon.Weapon;
import com.wandrell.tabletop.pendragon.service.model.ModelConstructorService;
import com.wandrell.tabletop.pendragon.util.parser.yaml.inventory.WeaponYAMLParser;
import com.wandrell.tabletop.testing.pendragon.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITParseMinimumWeaponYAMLParser {

    private Weapon weapon;

    public ITParseMinimumWeaponYAMLParser() {
        super();
    }

    @BeforeClass
    public final void initialize() throws Exception {
        final Parser<Reader, Weapon> parser;
        final ModelConstructorService modelService;

        modelService = TestServiceFactory.getInstance()
                .getModelConstructorService();

        parser = new WeaponYAMLParser(modelService);

        weapon = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.WEAPON_MINIMUM));
    }

    @Test
    public final void testArmorBonus() {
        Assert.assertEquals(weapon.getArmorBonusDice().size(), 0);
    }

    @Test
    public final void testDamageBonus() {
        Assert.assertEquals(weapon.getDamageBonus(), (Integer) 11);
    }

    @Test
    public final void testDamageDiceBonus() {
        Assert.assertEquals(weapon.getDamageDiceBonus(), (Integer) 22);
    }

    @Test
    public final void testDamageOverride() {
        Assert.assertEquals(weapon.getDamageOverrideDice(), (Integer) 0);
    }

    @Test
    public final void testFlags() {
        Assert.assertTrue(!weapon.isBreakingEnemyOnDraw());
        Assert.assertTrue(!weapon.isBreakingOnFumble());
        Assert.assertTrue(!weapon.isHittingBack());
        Assert.assertTrue(!weapon.isIgnoringShield());
        Assert.assertTrue(!weapon.isReducingShieldToRoll());
    }

    @Test
    public final void testName() {
        Assert.assertEquals(weapon.getName(), "test_weapon");
    }

    @Test
    public final void testSkill() {
        Assert.assertEquals(weapon.getSkill(), "skill_1");
    }

    @Test
    public final void testTwoHanded() {
        Assert.assertEquals(weapon.isTwoHanded(), (Boolean) false);
    }

}
