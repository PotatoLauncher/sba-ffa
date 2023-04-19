package com.mazio.freeForAllApp.constants;

import java.util.ArrayList;
import java.util.Arrays;

public class GameConstants {
    //GAME STATES
    public static final String GAME_STATE_STANDBY = "STANDBY";
    public static final String GAME_STATE_VOTING_TIME = "VOTING_TIME";
    public static final String GAME_STATE_FIGHT = "FIGHT";

    //PLAYER TYPE
    public static final String PLAYER_TYPE_HUMAN = "HUMAN";
    public static final String PLAYER_TYPE_CHAT = "CHAT";
    public static final String PLAYER_TYPE_RANDO = "RANDO";

    //CARDS
    public static final String CARD_WHITE_NAME = "Normal Round";
    public static final String CARD_WHITE_DESC = "No effects.";
    static public float CARD_WHITE_ODDS = 5f;


    public static final String CARD_RED_NAME = "Red Theft";
    public static final String CARD_RED_DESC = "WIP Steal points from a rival when winning.";
    static public float CARD_RED_ODDS = 1f;

    public static final String CARD_PINK_NAME = "Pink Gift";
    public static final String CARD_PINK_DESC = "WIP Share your winnings with a friend.";
    static public float CARD_PINK_ODDS = 1f;


    public static final String CARD_YELLOW_NAME = "Yellow Champ";
    public static final String CARD_YELLOW_DESC = "Get even more Streak when winning!";
    static public float CARD_YELLOW_ODDS = 1f;

    public static final String CARD_GREEN_NAME = "Green Shield";
    public static final String CARD_GREEN_DESC = "Keep your streak, even if you lose!";
    static public float CARD_GREEN_ODDS = 1f;

    public static final String CARD_ORANGE_NAME = "Orange Circle";
    public static final String CARD_ORANGE_DESC = "Vote together for greater rewards!";
    static public float CARD_ORANGE_ODDS = 1f;

    public static final String CARD_BLACK_NAME = "Black Boost";
    public static final String CARD_BLACK_DESC = "Gives a comeback bonus to losing players!";
    static public float CARD_BLACK_ODDS = 1f;


    public static final String CARD_TEAL_NAME = "Teal Swap";
    public static final String CARD_TEAL_DESC = "WIP Vote for the player in line.";
    static public float CARD_TEAL_ODDS = 1f;

    public static final String CARD_CYAN_NAME = "Cyan Swap";
    public static final String CARD_CYAN_DESC = "WIP Vote for the previous player in line.";
    static public float CARD_CYAN_ODDS = 1f;

    public static final String CARD_LIME_NAME = "Lime Paradox";
    public static final String CARD_LIME_DESC = "WIP Swap votes with another player at random!";
    static public float CARD_LIME_ODDS = 1f;


    public static final String CARD_GRAY_NAME = "Gray Vision";
    public static final String CARD_GRAY_DESC = "WIP Reveals other players bets.";
    static public float CARD_GRAY_ODDS = 1f;

    public static final String CARD_DARK_NAME = "Dark Blindfold";
    public static final String CARD_DARK_DESC = "WIP Vote completely blind!";
    static public float CARD_DARK_ODDS = 1f;                  


    public static final String CARD_PURPLE_NAME = "Purple Reaper";
    public static final String CARD_PURPLE_DESC = "A random loser gets punished!";
    static public float CARD_PURPLE_ODDS = 1f;
              
    public static final String CARD_BRONZE_NAME = "Bronze Crown";
    public static final String CARD_BRONZE_DESC = "A random winner gets even richer!";
    static public float CARD_BRONZE_ODDS = 1f;


    public static final String CARD_MAGENTA_NAME = "Magenta Box";
    public static final String CARD_MAGENTA_DESC = "WIP Gain an item if you lose the round.";
    static public float CARD_MAGENTA_ODDS = 0f;
              
    public static final String CARD_VIOLET_NAME = "Violet Treasure";
    public static final String CARD_VIOLET_DESC = "WIP Gain an item if you win the round.";
    static public float CARD_VIOLET_ODDS = 0f;
              
    public static final String CARD_LAVENDER_NAME = "Lavender Revolution";
    public static final String CARD_LAVENDER_DESC = "WIP Chat members take control of the game!";
    static public float CARD_LAVENDER_ODDS = 0f;


    public static final String CARD_INDIGO_NAME = "Indigo Ratio";
    public static final String CARD_INDIGO_DESC = "Twice the reward, think twice!!";
    static public float CARD_INDIGO_ODDS = 1f;

    public static final String CARD_GOLDEN_NAME = "Golden Ratio";
    public static final String CARD_GOLDEN_DESC = "A golden opportunity for cash!!!!";
    static public float CARD_GOLDEN_ODDS = 0.05f;

    public static final String CARD_RAINBOW_NAME = "Rainbow Ratio";
    public static final String CARD_RAINBOW_DESC = "Feeling Lucky ?";
    static public float CARD_RAINBOW_ODDS = 0.005f;

    public static final ArrayList<String> CARD_NAME_LIST = new ArrayList<>(Arrays.asList(
        CARD_WHITE_NAME,
        CARD_RED_NAME,
        CARD_PINK_NAME,
        CARD_YELLOW_NAME,
        CARD_GREEN_NAME,
        CARD_ORANGE_NAME,
        CARD_BLACK_NAME,
        CARD_TEAL_NAME,
        CARD_CYAN_NAME,
        CARD_LIME_NAME,
        CARD_GRAY_NAME,
        CARD_DARK_NAME,
        CARD_PURPLE_NAME,
        CARD_BRONZE_NAME,
        CARD_INDIGO_NAME,
        CARD_GOLDEN_NAME,
        CARD_RAINBOW_NAME
    ));

    public static final ArrayList<String> CARD_DESC_LIST = new ArrayList<>(Arrays.asList(
        CARD_WHITE_DESC,
        CARD_RED_DESC,
        CARD_PINK_DESC,
        CARD_YELLOW_DESC,
        CARD_GREEN_DESC,
        CARD_ORANGE_DESC,
        CARD_BLACK_DESC,
        CARD_TEAL_DESC,
        CARD_CYAN_DESC,
        CARD_LIME_DESC,
        CARD_GRAY_DESC,
        CARD_DARK_DESC,
        CARD_PURPLE_DESC,
        CARD_BRONZE_DESC,
        CARD_INDIGO_DESC,
        CARD_GOLDEN_DESC,
        CARD_RAINBOW_DESC
    ));

    public static final ArrayList<Float> CARD_ODDS_LIST = new ArrayList<>(Arrays.asList(
        CARD_WHITE_ODDS,
        CARD_RED_ODDS,
        CARD_PINK_ODDS,
        CARD_YELLOW_ODDS,
        CARD_GREEN_ODDS,
        CARD_ORANGE_ODDS,
        CARD_BLACK_ODDS,
        CARD_TEAL_ODDS,
        CARD_CYAN_ODDS,
        CARD_LIME_ODDS,
        CARD_GRAY_ODDS,
        CARD_DARK_ODDS,
        CARD_PURPLE_ODDS,
        CARD_BRONZE_ODDS,
        CARD_INDIGO_ODDS,
        CARD_GOLDEN_ODDS,
        CARD_RAINBOW_ODDS
    ));
    public static final float CARD_ODDS_TOTAL = 19.055f;

    //ITEMS
    public static final String ITEM_NONE = "NONE";

    //BETS
    public static final String BET_NONE = "NONE";
    public static final String BET_RED = "RED";
    public static final String BET_BLUE = "BLUE";

    //STATUSES
    public static final String STATUS_REAPED = "REAPED";
    public static final String STATUS_CROWNED = "CROWNED";
}
