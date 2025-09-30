package com.chaigptrobotics.specifics;

import com.chaigptrobotics.specifics.anno.RecommendSynchronized;

/// Parent class of commands
public abstract class CommandDaddy {

    @RecommendSynchronized
    public abstract void checkTriggered(boolean commandTrigger);

}
