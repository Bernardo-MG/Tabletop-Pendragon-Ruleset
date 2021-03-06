package com.wandrell.tabletop.testing.pendragon.test.unit.chargen;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.pattern.command.ResultCommand;
import com.wandrell.tabletop.character.Gender;
import com.wandrell.tabletop.pendragon.model.character.stats.PendragonSkillBox;
import com.wandrell.tabletop.pendragon.service.chargen.command.IsAbleToBecomeExtraSkillCommand;

public final class TestIsAbleBecomeExtraSkillCommand {

    public TestIsAbleBecomeExtraSkillCommand() {
        super();
    }

    @Test
    public final void testIsAble_Combat_Male_NotAble() throws Exception {
        final PendragonSkillBox skill;
        final ResultCommand<Boolean> command;

        skill = Mockito.mock(PendragonSkillBox.class);

        Mockito.when(skill.isCombatSkill()).thenReturn(true);

        command = new IsAbleToBecomeExtraSkillCommand(skill, Gender.MALE);

        command.execute();
        Assert.assertTrue(!command.getResult());
    }

    @Test
    public final void testIsAble_Female_CombatIn_Able() throws Exception {
        final PendragonSkillBox skill;
        final ResultCommand<Boolean> command;

        skill = Mockito.mock(PendragonSkillBox.class);

        Mockito.when(skill.isCombatSkill()).thenReturn(true);
        Mockito.when(skill.getName()).thenReturn("dagger");

        command = new IsAbleToBecomeExtraSkillCommand(skill, Gender.FEMALE);

        command.execute();
        Assert.assertTrue(command.getResult());
    }

    @Test
    public final void testIsAble_Female_CombatOut_NotAble() throws Exception {
        final PendragonSkillBox skill;
        final ResultCommand<Boolean> command;

        skill = Mockito.mock(PendragonSkillBox.class);

        Mockito.when(skill.isCombatSkill()).thenReturn(true);
        Mockito.when(skill.getName()).thenReturn("");

        command = new IsAbleToBecomeExtraSkillCommand(skill, Gender.FEMALE);

        command.execute();
        Assert.assertTrue(!command.getResult());
    }

    @Test
    public final void testIsAble_Female_NotCombat_Able() throws Exception {
        final PendragonSkillBox skill;
        final ResultCommand<Boolean> command;

        skill = Mockito.mock(PendragonSkillBox.class);

        Mockito.when(skill.isCombatSkill()).thenReturn(false);

        command = new IsAbleToBecomeExtraSkillCommand(skill, Gender.FEMALE);

        command.execute();
        Assert.assertTrue(command.getResult());
    }

    @Test
    public final void testIsAble_NotCombat_Male_Able() throws Exception {
        final PendragonSkillBox skill;
        final ResultCommand<Boolean> command;

        skill = Mockito.mock(PendragonSkillBox.class);

        Mockito.when(skill.isCombatSkill()).thenReturn(false);

        command = new IsAbleToBecomeExtraSkillCommand(skill, Gender.MALE);

        command.execute();
        Assert.assertTrue(command.getResult());
    }

}
