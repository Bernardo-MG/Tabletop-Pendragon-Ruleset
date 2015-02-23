package com.wandrell.tabletop.testing.pendragon.framework.test.integration.outputter.inventory;

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
import com.wandrell.tabletop.pendragon.model.inventory.RangedWeapon;
import com.wandrell.tabletop.pendragon.model.inventory.Weapon;
import com.wandrell.tabletop.pendragon.service.ModelService;
import com.wandrell.tabletop.pendragon.util.outputter.inventory.WeaponYAMLOutputter;
import com.wandrell.tabletop.pendragon.util.parser.inventory.WeaponYAMLParser;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.TestModelFileConf;
import com.wandrell.tabletop.testing.pendragon.framework.framework.conf.factory.TestServiceFactory;
import com.wandrell.util.ResourceUtils;

public final class ITSendWeaponYAMLOutputter {

    private static final Random     random        = new Random();
    private static final String     TEMPLATE_PATH = "target/test_write_Weapon_";
    private final Outputter<Weapon> outputter;

    {
        outputter = new WeaponYAMLOutputter();
    }

    public ITSendWeaponYAMLOutputter() {
        super();
    }

    @Test
    public final void testWriteFile_Armor_Bonus() throws Exception {
        final Weapon weapon;
        final Weapon weaponOut;
        final Parser<Reader, Weapon> parser;
        final ModelService modelService;
        final Path pathOut;

        modelService = TestServiceFactory.getInstance().getModelService();

        parser = new WeaponYAMLParser(modelService);

        weapon = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.WEAPON_ARMOR_BONUS));

        pathOut = Paths.get(TEMPLATE_PATH + getRandomID() + ".yml")
                .toAbsolutePath();

        outputter.send(weapon,
                new BufferedWriter(new FileWriter(pathOut.toFile())));

        weaponOut = parser.parse(new BufferedReader(new FileReader(pathOut
                .toFile())));

        Assert.assertEquals(weapon.getName(), weaponOut.getName());

        Assert.assertEquals(weapon.getSkill(), weaponOut.getSkill());
        Assert.assertEquals(weapon.isTwoHanded(), weaponOut.isTwoHanded());
        Assert.assertEquals(weapon.getDamageBonus(), weaponOut.getDamageBonus());
        Assert.assertEquals(weapon.getDamageDiceBonus(),
                weaponOut.getDamageDiceBonus());

        Assert.assertEquals(weapon.isBreakingEnemyOnDraw(),
                weaponOut.isBreakingEnemyOnDraw());
        Assert.assertEquals(weapon.isBreakingOnFumble(),
                weaponOut.isBreakingOnFumble());
        Assert.assertEquals(weapon.isHittingBack(), weaponOut.isHittingBack());
        Assert.assertEquals(weapon.isIgnoringShield(),
                weaponOut.isIgnoringShield());
        Assert.assertEquals(weapon.isReducingShieldToRoll(),
                weaponOut.isReducingShieldToRoll());

        Assert.assertEquals(weapon.getArmorBonusDice(),
                weaponOut.getArmorBonusDice());
    }

    @Test
    public final void testWriteFile_Basic() throws Exception {
        final Weapon weapon;
        final Weapon weaponOut;
        final Parser<Reader, Weapon> parser;
        final ModelService modelService;
        final Path pathOut;

        modelService = TestServiceFactory.getInstance().getModelService();

        parser = new WeaponYAMLParser(modelService);

        weapon = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.WEAPON));

        pathOut = Paths.get(TEMPLATE_PATH + getRandomID() + ".yml")
                .toAbsolutePath();

        outputter.send(weapon,
                new BufferedWriter(new FileWriter(pathOut.toFile())));

        weaponOut = parser.parse(new BufferedReader(new FileReader(pathOut
                .toFile())));

        Assert.assertEquals(weapon.getName(), weaponOut.getName());

        Assert.assertEquals(weapon.getSkill(), weaponOut.getSkill());
        Assert.assertEquals(weapon.isTwoHanded(), weaponOut.isTwoHanded());
        Assert.assertEquals(weapon.getDamageBonus(), weaponOut.getDamageBonus());
        Assert.assertEquals(weapon.getDamageDiceBonus(),
                weaponOut.getDamageDiceBonus());

        Assert.assertEquals(weapon.isBreakingEnemyOnDraw(),
                weaponOut.isBreakingEnemyOnDraw());
        Assert.assertEquals(weapon.isBreakingOnFumble(),
                weaponOut.isBreakingOnFumble());
        Assert.assertEquals(weapon.isHittingBack(), weaponOut.isHittingBack());
        Assert.assertEquals(weapon.isIgnoringShield(),
                weaponOut.isIgnoringShield());
        Assert.assertEquals(weapon.isReducingShieldToRoll(),
                weaponOut.isReducingShieldToRoll());
    }

    @Test
    public final void testWriteFile_Damage_Overriden() throws Exception {
        final Weapon weapon;
        final Weapon weaponOut;
        final Parser<Reader, Weapon> parser;
        final ModelService modelService;
        final Path pathOut;

        modelService = TestServiceFactory.getInstance().getModelService();

        parser = new WeaponYAMLParser(modelService);

        weapon = parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.WEAPON_DAMAGE_OVERRIDEN));

        pathOut = Paths.get(TEMPLATE_PATH + getRandomID() + ".yml")
                .toAbsolutePath();

        outputter.send(weapon,
                new BufferedWriter(new FileWriter(pathOut.toFile())));

        weaponOut = parser.parse(new BufferedReader(new FileReader(pathOut
                .toFile())));

        Assert.assertEquals(weapon.getName(), weaponOut.getName());

        Assert.assertEquals(weapon.getSkill(), weaponOut.getSkill());
        Assert.assertEquals(weapon.isTwoHanded(), weaponOut.isTwoHanded());
        Assert.assertEquals(weapon.getDamageBonus(), weaponOut.getDamageBonus());
        Assert.assertEquals(weapon.getDamageDiceBonus(),
                weaponOut.getDamageDiceBonus());

        Assert.assertEquals(weapon.isBreakingEnemyOnDraw(),
                weaponOut.isBreakingEnemyOnDraw());
        Assert.assertEquals(weapon.isBreakingOnFumble(),
                weaponOut.isBreakingOnFumble());
        Assert.assertEquals(weapon.isHittingBack(), weaponOut.isHittingBack());
        Assert.assertEquals(weapon.isIgnoringShield(),
                weaponOut.isIgnoringShield());
        Assert.assertEquals(weapon.isReducingShieldToRoll(),
                weaponOut.isReducingShieldToRoll());

        Assert.assertEquals(weapon.getDamageOverrideDice(),
                weaponOut.getDamageOverrideDice());
    }

    @Test
    public final void testWriteFile_Ranged() throws Exception {
        final RangedWeapon weapon;
        final RangedWeapon weaponOut;
        final Parser<Reader, Weapon> parser;
        final ModelService modelService;
        final Path pathOut;

        modelService = TestServiceFactory.getInstance().getModelService();

        parser = new WeaponYAMLParser(modelService);

        weapon = (RangedWeapon) parser.parse(ResourceUtils
                .getClassPathReader(TestModelFileConf.WEAPON_RANGED));

        pathOut = Paths.get(TEMPLATE_PATH + getRandomID() + ".yml")
                .toAbsolutePath();

        outputter.send(weapon,
                new BufferedWriter(new FileWriter(pathOut.toFile())));

        weaponOut = (RangedWeapon) parser.parse(new BufferedReader(
                new FileReader(pathOut.toFile())));

        Assert.assertEquals(weapon.getName(), weaponOut.getName());

        Assert.assertEquals(weapon.getSkill(), weaponOut.getSkill());
        Assert.assertEquals(weapon.isTwoHanded(), weaponOut.isTwoHanded());
        Assert.assertEquals(weapon.getDamageBonus(), weaponOut.getDamageBonus());
        Assert.assertEquals(weapon.getDamageDiceBonus(),
                weaponOut.getDamageDiceBonus());

        Assert.assertEquals(weapon.isBreakingEnemyOnDraw(),
                weaponOut.isBreakingEnemyOnDraw());
        Assert.assertEquals(weapon.isBreakingOnFumble(),
                weaponOut.isBreakingOnFumble());
        Assert.assertEquals(weapon.isHittingBack(), weaponOut.isHittingBack());
        Assert.assertEquals(weapon.isIgnoringShield(),
                weaponOut.isIgnoringShield());
        Assert.assertEquals(weapon.isReducingShieldToRoll(),
                weaponOut.isReducingShieldToRoll());

        Assert.assertEquals(weapon.getMaxRange(), weaponOut.getMaxRange());
        Assert.assertEquals(weapon.getRoundsToReload(),
                weaponOut.getRoundsToReload());
    }

    private final Integer getRandomID() {
        return random.nextInt(Integer.MAX_VALUE);
    }

}
