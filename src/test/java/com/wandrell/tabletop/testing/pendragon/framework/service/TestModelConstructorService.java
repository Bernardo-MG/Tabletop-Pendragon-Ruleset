package com.wandrell.tabletop.testing.pendragon.framework.service;

import java.util.Collection;
import java.util.Map;

import org.mockito.Mockito;

import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.interval.IntervalTable;
import com.wandrell.tabletop.pendragon.model.character.Horse;
import com.wandrell.tabletop.pendragon.model.character.background.Religion;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.AttributesRandom;
import com.wandrell.tabletop.pendragon.model.character.stats.DerivedAttributesHolder;
import com.wandrell.tabletop.pendragon.model.character.stats.PendragonSkillBox;
import com.wandrell.tabletop.pendragon.model.character.stats.RandomSkill;
import com.wandrell.tabletop.pendragon.model.character.stats.TraitsHolder;
import com.wandrell.tabletop.pendragon.model.chargen.background.CultureCharacterTemplate;
import com.wandrell.tabletop.pendragon.model.chargen.background.CultureTemplate;
import com.wandrell.tabletop.pendragon.model.chargen.background.FamilyCharacteristicTable;
import com.wandrell.tabletop.pendragon.model.chargen.background.FamilyCharacteristicTemplate;
import com.wandrell.tabletop.pendragon.model.chargen.background.FatherClassTemplate;
import com.wandrell.tabletop.pendragon.model.chargen.inventory.AdditionalBelongings;
import com.wandrell.tabletop.pendragon.model.chargen.inventory.AdditionalBelongingsTable;
import com.wandrell.tabletop.pendragon.model.chargen.region.HomelandTemplate;
import com.wandrell.tabletop.pendragon.model.chargen.region.RegionTemplate;
import com.wandrell.tabletop.pendragon.model.glory.FatherClassGlory;
import com.wandrell.tabletop.pendragon.model.inventory.Item;
import com.wandrell.tabletop.pendragon.model.inventory.Money;
import com.wandrell.tabletop.pendragon.model.inventory.armor.Armor;
import com.wandrell.tabletop.pendragon.model.inventory.armor.ArmorType;
import com.wandrell.tabletop.pendragon.model.inventory.armor.Shield;
import com.wandrell.tabletop.pendragon.model.inventory.weapon.RangedWeapon;
import com.wandrell.tabletop.pendragon.model.inventory.weapon.Weapon;
import com.wandrell.tabletop.pendragon.model.manor.AnimalYearResult;
import com.wandrell.tabletop.pendragon.model.manor.Pet;
import com.wandrell.tabletop.pendragon.model.util.TextList;
import com.wandrell.tabletop.pendragon.service.model.ModelConstructorService;
import com.wandrell.tabletop.stats.valuebox.SkillBox;

public final class TestModelConstructorService implements
        ModelConstructorService {

    @Override
    public final AdditionalBelongings getAdditionaBelongings(
            final Boolean choose, final String moneyName, final Money money,
            final String rerollTable, final Collection<DiceExpression> dice,
            final Collection<Horse> horses, final Collection<Item> items,
            final Collection<Pet> pets, final Collection<Shield> shields,
            final Collection<Weapon> weapons) {
        final AdditionalBelongings belongings;

        belongings = Mockito.mock(AdditionalBelongings.class);

        Mockito.when(belongings.hasToChoose()).thenReturn(choose);
        Mockito.when(belongings.getMoney()).thenReturn(money);
        Mockito.when(belongings.getMoneyName()).thenReturn(moneyName);
        Mockito.when(belongings.getRerollTable()).thenReturn(rerollTable);
        Mockito.when(belongings.getRerolls()).thenReturn(dice);
        Mockito.when(belongings.getHorses()).thenReturn(horses);
        Mockito.when(belongings.getItems()).thenReturn(items);
        Mockito.when(belongings.getPets()).thenReturn(pets);
        Mockito.when(belongings.getShields()).thenReturn(shields);
        Mockito.when(belongings.getWeapons()).thenReturn(weapons);

        return belongings;
    }

    @Override
    public final AdditionalBelongingsTable getAdditionalBelongingsTable(
            final String name,
            final Map<Interval, AdditionalBelongings> intervalsMap) {
        final AdditionalBelongingsTable table;

        table = Mockito.mock(AdditionalBelongingsTable.class);

        Mockito.when(table.getName()).thenReturn(name);
        Mockito.when(table.getIntervals()).thenReturn(intervalsMap);

        return table;
    }

    @Override
    public final AnimalYearResult getAnimalYearResult(final String description,
            final String puppy, final Boolean dies, final Money money) {
        final AnimalYearResult result;

        result = Mockito.mock(AnimalYearResult.class);

        Mockito.when(result.getDescription()).thenReturn(description);
        Mockito.when(result.getPuppy()).thenReturn(puppy);
        Mockito.when(result.isDying()).thenReturn(dies);
        Mockito.when(result.getMoney()).thenReturn(money);

        return result;
    }

    @Override
    public final Armor getArmor(final String name, final String description,
            final Money money, final ArmorType type, final Integer armorValue,
            final Integer dexModifier, final Boolean heavyLoad) {
        final Armor armor;

        armor = Mockito.mock(Armor.class);

        Mockito.when(armor.getName()).thenReturn(name);

        Mockito.when(armor.getDescription()).thenReturn(description);
        Mockito.when(armor.getMoney()).thenReturn(money);
        Mockito.when(armor.getArmorType()).thenReturn(type);
        Mockito.when(armor.getArmorValue()).thenReturn(armorValue);
        Mockito.when(armor.getDexterityModifier()).thenReturn(dexModifier);
        Mockito.when(armor.isHeavyLoad()).thenReturn(heavyLoad);

        return armor;
    }

    @Override
    public final CultureCharacterTemplate getCultureCharacterTemplate(
            final AttributesHolder attributesBonus,
            final AttributesRandom attributesRandom,
            final Collection<SkillBox> skillsBonus,
            final Collection<SkillBox> specialtySkills,
            final Collection<SkillBox> passionsBonus,
            final Collection<RandomSkill> passionsRandom,
            final Collection<SkillBox> directedBonus,
            final TraitsHolder traitsBonus) {
        final CultureCharacterTemplate template;

        template = Mockito.mock(CultureCharacterTemplate.class);

        Mockito.when(template.getAttributes()).thenReturn(attributesBonus);
        Mockito.when(template.getAttributesRandom()).thenReturn(
                attributesRandom);
        Mockito.when(template.getDirectedTraits()).thenReturn(directedBonus);
        Mockito.when(template.getPassions()).thenReturn(passionsBonus);
        Mockito.when(template.getPassionsRandom()).thenReturn(passionsRandom);
        Mockito.when(template.getSkills()).thenReturn(skillsBonus);
        Mockito.when(template.getSpecialtySkills()).thenReturn(specialtySkills);
        Mockito.when(template.getTraits()).thenReturn(traitsBonus);

        return template;
    }

    @Override
    public final CultureTemplate getCultureTemplate(final String name,
            final FamilyCharacteristicTemplate charMale,
            final FamilyCharacteristicTemplate charFemale,
            final AdditionalBelongingsTable belonginsMale,
            final AdditionalBelongingsTable belonginsFemale,
            final CultureCharacterTemplate templateMale,
            final CultureCharacterTemplate templateFemale) {
        final CultureTemplate template;

        template = Mockito.mock(CultureTemplate.class);

        Mockito.when(template.getName()).thenReturn(name);

        Mockito.when(template.getFemaleFamilyCharacteristic()).thenReturn(
                charFemale);
        Mockito.when(template.getMaleFamilyCharacteristic()).thenReturn(
                charMale);
        Mockito.when(template.getMaleInitialLuckTable()).thenReturn(
                belonginsMale);
        Mockito.when(template.getFemaleInitialLuckTable()).thenReturn(
                belonginsFemale);
        Mockito.when(template.getMaleTemplate()).thenReturn(templateMale);
        Mockito.when(template.getFemaleTemplate()).thenReturn(templateFemale);

        return template;
    }

    @Override
    public final FamilyCharacteristicTable getFamilyCharacteristicTable(
            final String name,
            final Map<Interval, FamilyCharacteristicTemplate> intervals) {
        final FamilyCharacteristicTable table;

        table = Mockito.mock(FamilyCharacteristicTable.class);

        Mockito.when(table.getName()).thenReturn(name);
        Mockito.when(table.getIntervals()).thenReturn(intervals);

        return table;
    }

    @Override
    public final FamilyCharacteristicTemplate getFamilyCharacteristicTemplate(
            final String name, final AttributesHolder attributes,
            final Collection<SkillBox> skills) {
        final FamilyCharacteristicTemplate template;

        template = Mockito.mock(FamilyCharacteristicTemplate.class);

        Mockito.when(template.getAttributes()).thenReturn(attributes);
        Mockito.when(template.getName()).thenReturn(name);
        Mockito.when(template.getSkills()).thenReturn(skills);

        return template;
    }

    @Override
    public final FatherClassGlory getFatherClassGlory(final String name,
            final Integer glory, final Integer yearlyGlory) {
        final FatherClassGlory fatherGlory;

        fatherGlory = Mockito.mock(FatherClassGlory.class);

        Mockito.when(fatherGlory.getFatherClass()).thenReturn(name);
        Mockito.when(fatherGlory.getBaseGlory()).thenReturn(glory);
        Mockito.when(fatherGlory.getYearlyGlory()).thenReturn(yearlyGlory);

        return fatherGlory;
    }

    @Override
    public final FatherClassTemplate getFatherClassTemplate(final String name,
            final Integer skillsGroupPoints,
            final Integer skillsGroupPointsDivide, final Integer skillsPoints,
            final Integer skillsNonCombatPoints, final DiceExpression money,
            final Collection<SkillBox> skillsGroup,
            final Collection<SkillBox> specialtySkills,
            final Collection<SkillBox> directedTraits,
            final Collection<SkillBox> directedTraitsBase) {
        final FatherClassTemplate fatherClass;

        fatherClass = Mockito.mock(FatherClassTemplate.class);

        Mockito.when(fatherClass.getName()).thenReturn(name);

        Mockito.when(fatherClass.getSkillsGroupBonusPoints()).thenReturn(
                skillsGroupPoints);
        Mockito.when(fatherClass.getSkillsGroupDividePoints()).thenReturn(
                skillsGroupPointsDivide);

        Mockito.when(fatherClass.getSkillsPoints()).thenReturn(skillsPoints);
        Mockito.when(fatherClass.getNonCombatSkillBonus()).thenReturn(
                skillsNonCombatPoints);

        Mockito.when(fatherClass.getMoney()).thenReturn(money);

        Mockito.when(fatherClass.getSkillsGroup()).thenReturn(skillsGroup);

        Mockito.when(fatherClass.getSpecialtySkills()).thenReturn(
                specialtySkills);

        Mockito.when(fatherClass.getDirectedTraits())
                .thenReturn(directedTraits);
        Mockito.when(fatherClass.getDirectedTraitsBase()).thenReturn(
                directedTraitsBase);

        return fatherClass;
    }

    @Override
    public final HomelandTemplate getHomelandTemplate(final String name,
            final RegionTemplate region, final Collection<SkillBox> skills,
            final Collection<SkillBox> specialtySkills,
            final Collection<SkillBox> directedTraits,
            final Collection<SkillBox> passions) {
        final HomelandTemplate homeland;

        homeland = Mockito.mock(HomelandTemplate.class);

        Mockito.when(homeland.getName()).thenReturn(name);
        Mockito.when(homeland.getRegion()).thenReturn(region);

        Mockito.when(homeland.getSkills()).thenReturn(skills);
        Mockito.when(homeland.getSpecialtySkills()).thenReturn(specialtySkills);
        Mockito.when(homeland.getDirectedTraits()).thenReturn(directedTraits);
        Mockito.when(homeland.getPassions()).thenReturn(passions);

        return homeland;
    }

    @Override
    public final Horse getHorse(final String type, final Integer constitution,
            final Integer dexterity, final Integer size,
            final Integer strength, final Integer damage,
            final Integer movement, final Integer armor, final Boolean armored,
            final Boolean combat, final Boolean hunting) {
        final Horse horse;
        final AttributesHolder attributes;
        final DerivedAttributesHolder derived;

        horse = Mockito.mock(Horse.class);
        attributes = Mockito.mock(AttributesHolder.class);
        derived = Mockito.mock(DerivedAttributesHolder.class);

        Mockito.when(horse.getHorseType()).thenReturn(type);
        Mockito.when(horse.getAttributes()).thenReturn(attributes);
        Mockito.when(horse.getDerivedAttributes()).thenReturn(derived);

        Mockito.when(attributes.getConstitution()).thenReturn(constitution);
        Mockito.when(attributes.getDexterity()).thenReturn(dexterity);
        Mockito.when(attributes.getSize()).thenReturn(size);
        Mockito.when(attributes.getStrength()).thenReturn(strength);

        Mockito.when(derived.getDamage()).thenReturn(damage);
        Mockito.when(derived.getMoveRate()).thenReturn(movement);

        Mockito.when(horse.getNaturalArmor()).thenReturn(armor);

        Mockito.when(horse.isArmored()).thenReturn(armored);
        Mockito.when(horse.isCombatHorse()).thenReturn(combat);
        Mockito.when(horse.isHuntingHorse()).thenReturn(hunting);

        return horse;
    }

    @Override
    public final Item getItem(final String name, final String description) {
        final Item item;

        item = Mockito.mock(Item.class);

        Mockito.when(item.getName()).thenReturn(name);
        Mockito.when(item.getDescription()).thenReturn(description);

        return item;
    }

    @Override
    public final Money getMoney(final Integer libra, final Integer denarii) {
        final Money money;

        money = Mockito.mock(Money.class);

        Mockito.when(money.getDenarii()).thenReturn(denarii);
        Mockito.when(money.getLibra()).thenReturn(libra);

        return money;
    }

    @Override
    public final Pet getPet(final String name,
            final IntervalTable<AnimalYearResult> yearResults) {
        final Pet pet;

        pet = Mockito.mock(Pet.class);

        Mockito.when(pet.getName()).thenReturn(name);
        Mockito.when(pet.getAnnualCheckMap()).thenReturn(yearResults);

        return pet;
    }

    @Override
    public final RegionTemplate getRegionTemplate(final String name,
            final TraitsHolder traits) {
        final RegionTemplate region;

        region = Mockito.mock(RegionTemplate.class);

        Mockito.when(region.getName()).thenReturn(name);
        Mockito.when(region.getTraits()).thenReturn(traits);

        return region;
    }

    @Override
    public final Religion getReligion(final String name,
            final Collection<String> traits,
            final DerivedAttributesHolder bonusDerived,
            final Integer bonusArmor, final Integer bonusDamage,
            final Integer bonusDamageDice) {
        final Religion religion;

        religion = Mockito.mock(Religion.class);

        Mockito.when(religion.getArmorBonus()).thenReturn(bonusArmor);
        Mockito.when(religion.getDamageBonus()).thenReturn(bonusDamage);
        Mockito.when(religion.getDamageDiceBonus()).thenReturn(bonusDamageDice);
        Mockito.when(religion.getDerivedAttributeBonus()).thenReturn(
                bonusDerived);
        Mockito.when(religion.getReligiousTraits()).thenReturn(traits);
        Mockito.when(religion.getName()).thenReturn(name);

        return religion;
    }

    @Override
    public final Shield getShield(final String name, final String description,
            final Integer armorValue) {
        final Shield shield;
        final Money money;

        money = getMoney(0, 0);

        shield = Mockito.mock(Shield.class);

        Mockito.when(shield.getName()).thenReturn(name);
        Mockito.when(shield.getDescription()).thenReturn(description);
        Mockito.when(shield.getMoney()).thenReturn(money);
        Mockito.when(shield.getArmorValue()).thenReturn(armorValue);

        return shield;
    }

    @Override
    public final PendragonSkillBox getSkill(final String name,
            final String descriptor, final Boolean combat, final Boolean court,
            final Boolean knight, final Boolean knowledge) {
        final PendragonSkillBox skill;

        skill = Mockito.mock(PendragonSkillBox.class);

        Mockito.when(skill.getName()).thenReturn(name);
        Mockito.when(skill.getDescriptor()).thenReturn(descriptor);

        Mockito.when(skill.isCombatSkill()).thenReturn(combat);
        Mockito.when(skill.isCourtlySkill()).thenReturn(court);
        Mockito.when(skill.isKnightlySkill()).thenReturn(knight);
        Mockito.when(skill.isKnowledgeSkill()).thenReturn(knowledge);

        return skill;
    }

    @Override
    public final TextList getTextList(final String name,
            final Collection<String> values) {
        final TextList list;

        list = Mockito.mock(TextList.class);

        Mockito.when(list.getName()).thenReturn(name);
        Mockito.when(list.getValues()).thenReturn(values);

        return list;
    }

    @Override
    public final Weapon getWeapon(final String name, final String description,
            final String skill, final Boolean twoHanded,
            final Integer damageBonus, final Integer diceBonus,
            final Integer damageOverride, final Integer maxRange,
            final Integer reload, final Map<ArmorType, Integer> armorBonus,
            final Boolean breaksEnemyOnDraw, final Boolean breaksOnFumble,
            final Boolean hitsBack, final Boolean ignoresShield,
            final Boolean reducesShieldToRoll) {
        final Weapon weapon;
        final Money money;

        money = getMoney(0, 0);

        if ((maxRange <= 0) || (reload <= 0)) {
            weapon = Mockito.mock(Weapon.class);
        } else {
            weapon = Mockito.mock(RangedWeapon.class);

            Mockito.when(((RangedWeapon) weapon).getMaxRange()).thenReturn(
                    maxRange);
            Mockito.when(((RangedWeapon) weapon).getRoundsToReload())
                    .thenReturn(reload);
        }

        Mockito.when(weapon.getName()).thenReturn(name);
        Mockito.when(weapon.getDescription()).thenReturn(description);
        Mockito.when(weapon.getMoney()).thenReturn(money);

        Mockito.when(weapon.getSkill()).thenReturn(skill);
        Mockito.when(weapon.isTwoHanded()).thenReturn(twoHanded);
        Mockito.when(weapon.getDamageBonus()).thenReturn(damageBonus);
        Mockito.when(weapon.getDamageDiceBonus()).thenReturn(diceBonus);

        Mockito.when(weapon.isBreakingEnemyOnDraw()).thenReturn(
                breaksEnemyOnDraw);
        Mockito.when(weapon.isBreakingOnFumble()).thenReturn(breaksOnFumble);
        Mockito.when(weapon.isHittingBack()).thenReturn(hitsBack);
        Mockito.when(weapon.isIgnoringShield()).thenReturn(ignoresShield);
        Mockito.when(weapon.isReducingShieldToRoll()).thenReturn(
                reducesShieldToRoll);

        Mockito.when(weapon.getDamageOverrideDice()).thenReturn(damageOverride);

        Mockito.when(weapon.getArmorBonusDice()).thenReturn(armorBonus);

        return weapon;
    }

}
