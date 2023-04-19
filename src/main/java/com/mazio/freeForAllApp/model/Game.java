package com.mazio.freeForAllApp.model;

import com.mazio.freeForAllApp.constants.GameConstants;

public class Game {
    /* Current state:
     * STANDBY: Before card reveal and after end of round
     * VOTING_TIME: Card was revealed, time to vote
     * FIGHT: Vote ended, bets are locked
     */ 
    public String gameState;

    //Currently chosen card
    public String gameCard;
    public String gameCardEffect;

    public Player[] players;

    public Game(){
        gameState = GameConstants.GAME_STATE_STANDBY;
        gameCard = GameConstants.CARD_WHITE_NAME;
        gameCardEffect = GameConstants.CARD_WHITE_DESC;
        players = new Player[1];
        players[0] = new Player();
        players[0].playerType = GameConstants.PLAYER_TYPE_HUMAN;
    }

}
