package com.mazio.freeForAllApp.model;

import java.util.ArrayList;

import com.mazio.freeForAllApp.constants.GameConstants;

public class Player {

    public String playerName;

    /* Player type:
     * HUMAN: Normal voting
     * CHAT: Twitch chat, votes as a group
     * RANDO: Bot, acts randomly
     */ 
    public String playerType;

    //Random id used in play link (or Twitch account)
    public String playerID;

    //Total points
    public int points;

    //Winning bets in a row
    public int streak;

    //Current point multiplier
    public int multiplier;

    //Item
    public String item;

    //Statuses
    public ArrayList<String> statuses;

    //Bet 
    public String vote;

    //Item target
    public String target;

    public Player(){
        playerName = "";
        playerType = "";
        playerID = "";
        points = 0;
        streak = 0;
        multiplier = 1;
        item = "";
        vote = GameConstants.BET_NONE;
        target = GameConstants.ITEM_NONE;
        statuses = new ArrayList<>();
    }
}
