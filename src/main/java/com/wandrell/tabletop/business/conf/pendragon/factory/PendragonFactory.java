package com.wandrell.tabletop.business.conf.pendragon.factory;

import java.util.Collection;
import java.util.Properties;

import org.springframework.context.ApplicationContext;

import com.wandrell.tabletop.business.conf.pendragon.PendragonFactoryConf;
import com.wandrell.tabletop.business.model.pendragon.valuehandler.DirectedTrait;
import com.wandrell.tabletop.business.model.pendragon.valuehandler.Passion;
import com.wandrell.tabletop.business.model.pendragon.valuehandler.Skill;
import com.wandrell.tabletop.business.model.pendragon.valuehandler.SpecialtySkill;
import com.wandrell.util.ContextUtils;
import com.wandrell.util.FileUtils;
import com.wandrell.util.ResourceUtils;

public final class PendragonFactory {

    private static PendragonFactory instance;

    public static final synchronized PendragonFactory getInstance() {
        if (instance == null) {
            instance = new PendragonFactory();
        }

        return instance;
    }

    private PendragonFactory() {
        super();
    }

    public final DirectedTrait getDirectedTrait(final String name) {
        final ApplicationContext context;
        final Properties properties;

        properties = FileUtils
                .getProperties(ResourceUtils
                        .getClassPathInputStream(PendragonFactoryConf.PROPERTIES_DIRECTED_TRAIT));

        // TODO: This is hardcoded
        properties.setProperty("trait.name", name);

        // TODO: Try to reload changing only the values
        context = ContextUtils.getClassPathContext(properties,
                PendragonFactoryConf.CONTEXT_DIRECTED_TRAIT);

        return (DirectedTrait) context
                .getBean(PendragonFactoryConf.BEAN_DIRECTED_TRAIT);
    }

    public final Passion getPassion(final String name, final String descriptor) {
        final ApplicationContext context;
        final Properties properties;

        properties = FileUtils
                .getProperties(ResourceUtils
                        .getClassPathInputStream(PendragonFactoryConf.PROPERTIES_PASSION));

        // TODO: This is hardcoded
        properties.setProperty("passion.name", name);
        properties.setProperty("passion.descriptor", descriptor);

        // TODO: Try to reload changing only the values
        context = ContextUtils.getClassPathContext(properties,
                PendragonFactoryConf.CONTEXT_PASSION);

        // Spring framework builds the instance

        return (Passion) context.getBean(PendragonFactoryConf.BEAN_PASSION);
    }

    public final Skill getSkill(final String name, final Boolean combat,
            final Boolean court, final Boolean knight, final Boolean knowledge,
            final Boolean repeat) {
        final ApplicationContext context;
        final Properties properties;

        properties = FileUtils
                .getProperties(ResourceUtils
                        .getClassPathInputStream(PendragonFactoryConf.PROPERTIES_SKILL));

        // TODO: This is hardcoded
        properties.setProperty("skill.name", name);
        properties.setProperty("skill.flag.combat", combat.toString());
        properties.setProperty("skill.flag.court", court.toString());
        properties.setProperty("skill.flag.knight", knight.toString());
        properties.setProperty("skill.flag.knowledge", knowledge.toString());
        properties.setProperty("skill.flag.repeat", repeat.toString());

        // TODO: Try to reload changing only the values
        context = ContextUtils.getClassPathContext(properties,
                PendragonFactoryConf.CONTEXT_SKILL);

        // Spring framework builds the instance

        return (Skill) context.getBean(PendragonFactoryConf.BEAN_SKILL);
    }

    public final SpecialtySkill getSpecialtySkill(final String name,
            final Collection<String> skills) {
        final ApplicationContext context;
        final Properties properties;
        StringBuilder skillsToken;

        properties = FileUtils
                .getProperties(ResourceUtils
                        .getClassPathInputStream(PendragonFactoryConf.PROPERTIES_SPECIALTY_SKILL));

        skillsToken = new StringBuilder("");
        for (final String skill : skills) {
            if (skillsToken.length() > 0) {
                skillsToken.append(",");
            }

            skillsToken.append(skill);
        }

        // TODO: This is hardcoded
        properties.setProperty("skill.name", name);
        properties.setProperty("skill.skills", skillsToken.toString());

        // TODO: Try to reload changing only the values
        context = ContextUtils.getClassPathContext(properties,
                PendragonFactoryConf.CONTEXT_SPECIALTY_SKILL);

        return (SpecialtySkill) context
                .getBean(PendragonFactoryConf.BEAN_SPECIALTY_SKILL);
    }

}