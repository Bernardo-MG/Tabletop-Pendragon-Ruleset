package com.wandrell.tabletop.pendragon.service.chargen;

import static com.google.common.base.Preconditions.checkNotNull;

import com.wandrell.pattern.command.CommandExecutor;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.pendragon.service.chargen.command.GetKnightStartingGloryRollCommand;

public final class DefaultCharGenGloryService implements CharGenGloryService {

    private final CommandExecutor comExec;
    private DiceExpression        initialKnightGlory;

    public DefaultCharGenGloryService(final CommandExecutor executor) {
        super();

        checkNotNull(executor, "Received a null pointer as command executor");

        comExec = executor;
    }

    @Override
    public final DiceExpression getKnightStartingGlory() {
        if (initialKnightGlory == null) {
            initialKnightGlory = getCommandExecutor().execute(
                    new GetKnightStartingGloryRollCommand());
        }

        return initialKnightGlory;
    }

    private final CommandExecutor getCommandExecutor() {
        return comExec;
    }

}
