package com.wandrell.tabletop.testing.pendragon.framework.conf.factory;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import com.google.common.base.Predicate;
import com.wandrell.pattern.repository.CollectionRepository;
import com.wandrell.pattern.repository.FilteredRepository;
import com.wandrell.tabletop.interval.Interval;
import com.wandrell.tabletop.pendragon.model.character.Horse;
import com.wandrell.tabletop.pendragon.model.character.stats.DefaultAttributesHolder;
import com.wandrell.tabletop.pendragon.model.chargen.background.FamilyCharacteristicTemplate;
import com.wandrell.tabletop.pendragon.model.chargen.inventory.AdditionalBelongings;
import com.wandrell.tabletop.pendragon.model.chargen.inventory.AdditionalBelongingsTable;
import com.wandrell.tabletop.pendragon.model.chargen.region.RegionTemplate;
import com.wandrell.tabletop.pendragon.model.inventory.Item;
import com.wandrell.tabletop.pendragon.model.inventory.armor.Shield;
import com.wandrell.tabletop.pendragon.model.inventory.weapon.Weapon;
import com.wandrell.tabletop.pendragon.model.manor.Pet;
import com.wandrell.tabletop.pendragon.service.model.ModelConstructorService;
import com.wandrell.tabletop.pendragon.service.model.StatConstructorService;
import com.wandrell.tabletop.stats.valuebox.SkillBox;
import com.wandrell.tabletop.testing.pendragon.framework.service.TestModelConstructorService;
import com.wandrell.tabletop.testing.pendragon.framework.service.TestStatConstructorService;

public final class TestServiceFactory {

    private static final TestServiceFactory instance = new TestServiceFactory();

    public static final TestServiceFactory getInstance() {
        return instance;
    }

    private TestServiceFactory() {
        super();
    }

    public final
            FilteredRepository<AdditionalBelongingsTable, Predicate<AdditionalBelongingsTable>>
            getAdditionalBelongingsTableRepository() {
        final FilteredRepository<AdditionalBelongingsTable, Predicate<AdditionalBelongingsTable>> repository;

        repository = new CollectionRepository<AdditionalBelongingsTable>();

        repository.add(getModelConstructorService()
                .getAdditionalBelongingsTable("luck_female",
                        new LinkedHashMap<Interval, AdditionalBelongings>()));
        repository.add(getModelConstructorService()
                .getAdditionalBelongingsTable("luck_male",
                        new LinkedHashMap<Interval, AdditionalBelongings>()));

        return repository;
    }

    public final
            FilteredRepository<FamilyCharacteristicTemplate, Predicate<FamilyCharacteristicTemplate>>
            getFamilyCharacteristicTemplateRepository() {
        final FilteredRepository<FamilyCharacteristicTemplate, Predicate<FamilyCharacteristicTemplate>> repository;

        repository = new CollectionRepository<FamilyCharacteristicTemplate>();

        repository.add(getModelConstructorService()
                .getFamilyCharacteristicTemplate("char_female",
                        new DefaultAttributesHolder(),
                        new LinkedList<SkillBox>()));
        repository.add(getModelConstructorService()
                .getFamilyCharacteristicTemplate("char_male",
                        new DefaultAttributesHolder(),
                        new LinkedList<SkillBox>()));

        return repository;
    }

    public final FilteredRepository<Horse, Predicate<Horse>>
            getHorseRepository() {
        final FilteredRepository<Horse, Predicate<Horse>> repository;

        repository = new CollectionRepository<Horse>();

        repository.add(getModelConstructorService().getHorse("horse_1", 1, 2,
                3, 4, 5, 6, 7, true, true, true));
        repository.add(getModelConstructorService().getHorse("horse_2", 1, 2,
                3, 4, 5, 6, 7, true, true, true));
        repository.add(getModelConstructorService().getHorse("horse_3", 1, 2,
                3, 4, 5, 6, 7, true, true, true));
        repository.add(getModelConstructorService().getHorse("horse_4", 1, 2,
                3, 4, 5, 6, 7, true, true, true));
        repository.add(getModelConstructorService().getHorse("horse_5", 1, 2,
                3, 4, 5, 6, 7, true, true, true));

        return repository;
    }

    public final FilteredRepository<Item, Predicate<Item>> getItemRepository() {
        final FilteredRepository<Item, Predicate<Item>> repository;

        repository = new CollectionRepository<Item>();

        repository.add(getModelConstructorService().getItem("item_1",
                "description_1"));
        repository.add(getModelConstructorService().getItem("item_2",
                "description_2"));
        repository.add(getModelConstructorService().getItem("item_3",
                "description_3"));
        repository.add(getModelConstructorService().getItem("item_4",
                "description_4"));
        repository.add(getModelConstructorService().getItem("item_5",
                "description_5"));

        return repository;
    }

    public final ModelConstructorService getModelConstructorService() {
        return new TestModelConstructorService();
    }

    public final FilteredRepository<Pet, Predicate<Pet>> getPetRepository() {
        final FilteredRepository<Pet, Predicate<Pet>> repository;

        repository = new CollectionRepository<Pet>();

        repository.add(getModelConstructorService().getPet("pet_1", null));
        repository.add(getModelConstructorService().getPet("pet_2", null));
        repository.add(getModelConstructorService().getPet("pet_3", null));
        repository.add(getModelConstructorService().getPet("pet_4", null));
        repository.add(getModelConstructorService().getPet("pet_5", null));

        return repository;
    }

    public final FilteredRepository<RegionTemplate, Predicate<RegionTemplate>>
            getRegionRepository() {
        final FilteredRepository<RegionTemplate, Predicate<RegionTemplate>> repository;

        repository = new CollectionRepository<RegionTemplate>();

        repository.add(getModelConstructorService().getRegionTemplate(
                "test_region_1", null));
        repository.add(getModelConstructorService().getRegionTemplate(
                "test_region_2", null));
        repository.add(getModelConstructorService().getRegionTemplate(
                "test_region_3", null));
        repository.add(getModelConstructorService().getRegionTemplate(
                "test_region_4", null));
        repository.add(getModelConstructorService().getRegionTemplate(
                "test_region_5", null));

        return repository;
    }

    public final FilteredRepository<Shield, Predicate<Shield>>
            getShieldRepository() {
        final FilteredRepository<Shield, Predicate<Shield>> repository;

        repository = new CollectionRepository<Shield>();

        repository.add(getModelConstructorService().getShield("shield_1",
                "description_1", 0));
        repository.add(getModelConstructorService().getShield("shield_2",
                "description_2", 0));
        repository.add(getModelConstructorService().getShield("shield_3",
                "description_3", 0));
        repository.add(getModelConstructorService().getShield("shield_4",
                "description_4", 0));
        repository.add(getModelConstructorService().getShield("shield_5",
                "description_5", 0));

        return repository;
    }

    public final StatConstructorService getStatConstructorService() {
        return new TestStatConstructorService();
    }

    public final FilteredRepository<Weapon, Predicate<Weapon>>
            getWeaponRepository() {
        final FilteredRepository<Weapon, Predicate<Weapon>> repository;

        repository = new CollectionRepository<Weapon>();

        repository.add(getModelConstructorService().getWeapon("weapon_1",
                "description_1", "skill_1", false, 0, 0, 0, 0, 0, null, false,
                false, false, false, false));
        repository.add(getModelConstructorService().getWeapon("weapon_2",
                "description_2", "skill_2", false, 0, 0, 0, 0, 0, null, false,
                false, false, false, false));
        repository.add(getModelConstructorService().getWeapon("weapon_3",
                "description_3", "skill_3", false, 0, 0, 0, 0, 0, null, false,
                false, false, false, false));
        repository.add(getModelConstructorService().getWeapon("weapon_4",
                "description_4", "skill_4", false, 0, 0, 0, 0, 0, null, false,
                false, false, false, false));
        repository.add(getModelConstructorService().getWeapon("weapon_5",
                "description_5", "skill_5", false, 0, 0, 0, 0, 0, null, false,
                false, false, false, false));

        return repository;
    }

}
