package dev.lpa;

import dev.lpa.game.GameConsole;
import dev.lpa.pirate.PirateGame;

public class Main {

    public static void main(String[] args) {

//        ///TEST THE SHOOTER GAME
//        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
//
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);
//
//
//        ///TEST PIRATE GAME
//        //TEST Weapon Enum
//        Weapon weapon = Weapon.getWeaponByChar('P');
//        System.out.println("Weapon = " + weapon + ", hitPoints= " + weapon.getHitPoints() + ", minLevel= " + weapon.getMinLevel());
//
//        var list = Weapon.getWeaponsByLevel(0);
//        var list2 = Weapon.getWeaponsByLevel(2);
//        System.out.println(list);
//        System.out.println(list2);
//
//        //TEST PIRATE
//        Pirate tim = new Pirate("Tim");
//        System.out.println(tim);
//
//        //TEST PIRATEGAME
//        //loads data without an instance of PirateGame created.
//        // Imagine running from a db, if this failed, youd want to stop other processes
//        PirateGame.getTowns(0).forEach(t -> System.out.println(t.information()));
//        System.out.println("-".repeat(30));
//        PirateGame.getTowns(1).forEach(t -> System.out.println(t.information()));
//


//         TEST PIRATEGAME CONSOLE
        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);


    }
}

