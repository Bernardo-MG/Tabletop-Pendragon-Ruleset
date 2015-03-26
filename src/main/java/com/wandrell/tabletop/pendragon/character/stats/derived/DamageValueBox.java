package com.wandrell.tabletop.pendragon.character.stats.derived;

import com.wandrell.tabletop.event.ValueChangeEvent;
import com.wandrell.tabletop.pendragon.model.character.PendragonBaseCharacter;
import com.wandrell.tabletop.pendragon.model.character.event.PendragonCharacterListenerAdapter;
import com.wandrell.tabletop.pendragon.service.ruleset.DerivedAttributesService;
import com.wandrell.tabletop.valuebox.AbstractValueBox;

public final class DamageValueBox extends AbstractValueBox {

    private final PendragonBaseCharacter   character;
    private final DerivedAttributesService derivedService;

    public DamageValueBox(final PendragonBaseCharacter character,
            final DerivedAttributesService derivedService) {
        super();

        this.character = character;
        this.derivedService = derivedService;

        character
                .addPendragonCharacterListener(new PendragonCharacterListenerAdapter() {

                    @Override
                    public final void sizeChanged(final ValueChangeEvent event) {
                        fireValueChangedEvent(new ValueChangeEvent(this, 0, 0));
                    }

                    @Override
                    public final void strengthChanged(
                            final ValueChangeEvent event) {
                        fireValueChangedEvent(new ValueChangeEvent(this, 0, 0));
                    }

                });
    }

    @Override
    public final DamageValueBox createNewInstance() {
        return new DamageValueBox(character, derivedService);
    }

    @Override
    public final Integer getValue() {
        return derivedService.getDamage(character);
    }

}