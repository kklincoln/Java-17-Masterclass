package dev.lpa.game;

import java.util.function.Predicate;

/// predicate is a functional interface type; chosen to allow game to continue until a condition is met. any of these options could end the game
public record GameAction(char key, String prompt, Predicate<Integer> action) {


}
