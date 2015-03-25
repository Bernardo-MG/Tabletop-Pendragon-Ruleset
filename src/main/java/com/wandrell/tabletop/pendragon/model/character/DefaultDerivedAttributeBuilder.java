package com.wandrell.tabletop.pendragon.model.character;

import com.wandrell.tabletop.pendragon.character.stats.derived.DamageValueBox;
import com.wandrell.tabletop.pendragon.character.stats.derived.DexterityRollValueBox;
import com.wandrell.tabletop.pendragon.character.stats.derived.HealingRateValueBox;
import com.wandrell.tabletop.pendragon.character.stats.derived.HitPointsValueBox;
import com.wandrell.tabletop.pendragon.character.stats.derived.MajorWoundsValueBox;
import com.wandrell.tabletop.pendragon.character.stats.derived.MoveRateValueBox;
import com.wandrell.tabletop.pendragon.character.stats.derived.UnconciousValueBox;
import com.wandrell.tabletop.pendragon.character.stats.derived.WeightValueBox;
import com.wandrell.tabletop.pendragon.service.ruleset.DerivedAttributesService;
import com.wandrell.tabletop.valuebox.ValueBox;

public final class DefaultDerivedAttributeBuilder implements
        DerivedAttributeBuilder {

    private final DerivedAttributesService derivedService;

    public DefaultDerivedAttributeBuilder(
            final DerivedAttributesService derivedService) {
        super();

        this.derivedService = derivedService;
    }

    @Override
    public final ValueBox getDamage(final PendragonBaseCharacter character) {
        return new DamageValueBox(character, getDerivedAttributesService());
    }

    @Override
    public final ValueBox getDexterityRoll(
            final PendragonBaseCharacter character) {
        return new DexterityRollValueBox(character,
                getDerivedAttributesService());
    }

    @Override
    public final ValueBox
            getHealingRate(final PendragonBaseCharacter character) {
        return new HealingRateValueBox(character, getDerivedAttributesService());
    }

    @Override
    public final ValueBox getHitPoints(final PendragonBaseCharacter character) {
        return new HitPointsValueBox(character, getDerivedAttributesService());
    }

    @Override
    public final ValueBox getMajorWoundTreshold(
            final PendragonBaseCharacter character) {
        return new MajorWoundsValueBox(character, getDerivedAttributesService());
    }

    @Override
    public final ValueBox getMoveRate(final PendragonBaseCharacter character) {
        return new MoveRateValueBox(character, getDerivedAttributesService());
    }

    @Override
    public final ValueBox getUnconciousTreshold(
            final PendragonBaseCharacter character) {
        return new UnconciousValueBox(character, getDerivedAttributesService());
    }

    @Override
    public final ValueBox getWeight(final PendragonBaseCharacter character) {
        return new WeightValueBox(character, getDerivedAttributesService());
    }

    private final DerivedAttributesService getDerivedAttributesService() {
        return derivedService;
    }

}
