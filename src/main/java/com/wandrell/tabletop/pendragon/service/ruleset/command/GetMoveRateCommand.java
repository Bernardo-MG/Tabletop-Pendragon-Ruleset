package com.wandrell.tabletop.pendragon.service.ruleset.command;

import com.wandrell.pattern.command.ResultCommand;

public final class GetMoveRateCommand implements ResultCommand<Integer> {

    private final Integer dexterity;
    private Integer       moveRate;
    private final Integer strength;

    public GetMoveRateCommand(final Integer dexterity, final Integer strength) {
        super();

        this.strength = strength;
        this.dexterity = dexterity;
    }

    @Override
    public final void execute() {
        final Float str;
        final Float dex;

        str = new Float(strength);
        dex = new Float(dexterity);

        moveRate = Math.round((str + dex) / 10);
    }

    @Override
    public final Integer getResult() {
        return moveRate;
    }

}
