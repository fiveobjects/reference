package org.openapex.samples.springboot.template.validator;

import javax.validation.Valid;
import javax.validation.constraints.Max;

public class DiceRoller {
    private DiceRoller(){}
    public static int roll(@Max(20) @Valid Integer number, @DiceConstraint @Valid Integer sides){
        return (int) Math.floor(Math.random() * ((sides * number)-number) + number);
    }
}
