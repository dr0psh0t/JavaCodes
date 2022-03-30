package com.effectivejava.enumerations;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public class PhaseEnumTest {
    public static void main(String[] args) {

    }

    private enum Phase {
        SOLID, LIQUID, GAS;

        private enum Transition {
            MELT(SOLID, LIQUID),
            FREEZE(LIQUID, SOLID),
            BOIL(LIQUID, GAS),
            CONDENSE(GAS, LIQUID),
            SUBLIME(SOLID, GAS),
            DEPOSIT(GAS, SOLID);

            private final Phase from;
            private final Phase to;

            Transition(Phase from, Phase to) {
                this.from = from;
                this.to = to;
            }

            public static Transition from(Phase from, Phase to) {
                return null;
            }
        }
    }
}
