package com.wandrell.tabletop.pendragon.service.model;

import java.util.Collection;

import com.wandrell.tabletop.pendragon.model.stats.DefaultPendragonSkillBox;
import com.wandrell.tabletop.pendragon.model.stats.DefaultSpecialtySkillBox;
import com.wandrell.tabletop.pendragon.model.stats.PendragonSkillBox;
import com.wandrell.tabletop.pendragon.model.stats.SpecialtySkillBox;
import com.wandrell.tabletop.valuebox.DefaultSkillBox;
import com.wandrell.tabletop.valuebox.SkillBox;

public final class DefaultStatConstructorService implements
        StatConstructorService {

    public DefaultStatConstructorService() {
        super();
    }

    @Override
    public final SkillBox getDirectedTrait(final String name,
            final String descriptor, final Integer value) {
        final SkillBox skill;

        skill = new DefaultSkillBox(name, value, 0, Integer.MAX_VALUE);

        if (!descriptor.isEmpty()) {
            skill.setDescriptor(descriptor);
        }

        return skill;
    }

    @Override
    public final SkillBox getPassion(final String name,
            final String descriptor, final Integer value) {
        final SkillBox skill;

        skill = new DefaultSkillBox(name, value, 0, Integer.MAX_VALUE);

        if (!descriptor.isEmpty()) {
            skill.setDescriptor(descriptor);
        }

        return skill;
    }

    @Override
    public final PendragonSkillBox getSkill(final String name,
            final String descriptor, final Integer value,
            final Boolean combatSkill, final Boolean knightlySkill,
            final Boolean knowledgeSkill, final Boolean courtlySkill) {
        final PendragonSkillBox skill;

        skill = new DefaultPendragonSkillBox(name, value, 0, Integer.MAX_VALUE,
                combatSkill, knightlySkill, knowledgeSkill, courtlySkill);

        if (!descriptor.isEmpty()) {
            skill.setDescriptor(descriptor);
        }

        return skill;
    }

    @Override
    public final SpecialtySkillBox getSpecialtySkill(final String name,
            final Integer value, final Collection<String> skills) {
        return new DefaultSpecialtySkillBox(name, value, 0, Integer.MAX_VALUE,
                skills);
    }

}
