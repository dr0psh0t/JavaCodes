package com.codingwithjohn.enumsample;

public enum Cereals {

    CAPTAIN_CRUNCH(50),
    FROOT_LOOPS(60),
    REESES_PUFFS(100),
    COCOA_PUFFS(75);

    final int levelOfDeliciousness;

    Cereals(int levelOfDeliciousness) {
        this.levelOfDeliciousness = levelOfDeliciousness;
    }
}
