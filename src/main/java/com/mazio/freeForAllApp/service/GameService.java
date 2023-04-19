package com.mazio.freeForAllApp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.mazio.freeForAllApp.constants.GameConstants;
import com.mazio.freeForAllApp.model.Game;
import com.mazio.freeForAllApp.model.Player;

@Service
public class GameService {
    
    public Game game;
    
    public GameService(){
        System.out.println("Création de Service!!");
        game = new Game();
    }

    public void start(Player[] players){
        game = new Game();
        game.players = players;
    }

    public Player[] convertRawData(String data){
        data = data.replace("[{", "").replace("}]", "");
        String[] parsedData = data.split("\\},\\{");
        Player[] res = new Player[parsedData.length];

        for(int i=0; i<res.length; i++){
            res[i] = new Player();
            res[i].playerType =parsedData[i].split(",")[0].split(":")[1].replace("\"", "");
            res[i].playerID   =parsedData[i].split(",")[1].split(":")[1].replace("\"", "");
            res[i].playerName =parsedData[i].split(",")[2].split(":")[1].replace("\"", "");
        }
        return res;
    }

    //GAME STATE CHANGES
    public void standbyToVotingTime(){
        if(game.gameState != GameConstants.GAME_STATE_STANDBY) return;
        game.gameState = GameConstants.GAME_STATE_VOTING_TIME;
        drawCard();
        for(int i=0; i<game.players.length; i++) 
            switch (game.players[i].playerType){
                case GameConstants.PLAYER_TYPE_RANDO:
                    if(Math.random() > 0.5f) bet(game.players[i].playerID, GameConstants.BET_RED);
                                        else bet(game.players[i].playerID, GameConstants.BET_BLUE);
                break;
                default: break;
            };
    }

    public void votingTimeToFight(){
        if(game.gameState != GameConstants.GAME_STATE_VOTING_TIME) return;
        game.gameState = GameConstants.GAME_STATE_FIGHT;

        ArrayList<Player> red = new ArrayList<>();
        ArrayList<Player> blue = new ArrayList<>();
        for(int i=0; i<game.players.length; i++) 
            switch(game.players[i].vote){
                case GameConstants.BET_NONE:
                    if(Math.random() > 0.5f) bet(game.players[i].playerID, GameConstants.BET_RED);
                                        else bet(game.players[i].playerID, GameConstants.BET_BLUE);
                    break;
            };

        for(int i=0; i<game.players.length; i++) 
            switch(game.players[i].vote){
                case GameConstants.BET_RED:
                    red.add(game.players[i]);
                    break;
                case GameConstants.BET_BLUE:
                    blue.add(game.players[i]);
                    break;
            };

        if((game.gameCard.equals(GameConstants.CARD_PURPLE_NAME))){
            if(blue.size()> 0) blue.get((int) Math.floor(Math.random()*blue.size())).statuses.add(GameConstants.STATUS_REAPED);
            if(red.size()> 0) red.get((int) Math.floor(Math.random()*red.size())).statuses.add(GameConstants.STATUS_REAPED);
        }

        if((game.gameCard.equals(GameConstants.CARD_BRONZE_NAME))){
            if(blue.size()> 0) blue.get((int) Math.floor(Math.random()*blue.size())).statuses.add(GameConstants.STATUS_CROWNED);
            if(red.size()> 0) red.get((int) Math.floor(Math.random()*red.size())).statuses.add(GameConstants.STATUS_CROWNED);
        }

        calcMultipliers();
    }

    public void fightToStandby(String winner){
        if(game.gameState != GameConstants.GAME_STATE_FIGHT) return;
        game.gameState = GameConstants.GAME_STATE_STANDBY;

        ArrayList<Player> winners = new ArrayList<>();
        ArrayList<Player> losers = new ArrayList<>();

        switch (winner){
            case GameConstants.BET_BLUE:
            case GameConstants.BET_RED:
                for(int i=0; i<game.players.length; i++) 
                    if(game.players[i].vote.equals(winner)){
                        win(game.players[i]);
                        winners.add(game.players[i]);
                    }
                    else{
                        lose(game.players[i]);
                        losers.add(game.players[i]);
                    }
            break;
            default: break;
        };
        if(game.gameCard.equals(GameConstants.CARD_PURPLE_NAME) && losers.size()!=0){
            for(int i=0; i<game.players.length; i++) if(game.players[i].statuses.contains(GameConstants.STATUS_REAPED))
                game.players[i].points -= Math.round(game.players[i].multiplier*2*(100+(25*game.players[i].streak)));   
        }
        
        if(game.gameCard.equals(GameConstants.CARD_BRONZE_NAME) && winners.size()!=0){
            for(int i=0; i<game.players.length; i++) if(game.players[i].statuses.contains(GameConstants.STATUS_CROWNED))
                game.players[i].points += Math.round(game.players[i].multiplier*2*(100+(25*game.players[i].streak)));    
        }  

        for(int i=0; i<game.players.length; i++){
            bet(game.players[i].playerID, GameConstants.BET_NONE);
            game.players[i].multiplier = 1;
            game.players[i].statuses.clear();
        }
    }

    //SCORE LOGIC
    public void lose(Player player){
        if(!game.gameCard.equals(GameConstants.CARD_GREEN_NAME))player.streak = 0;
    }

    public void win(Player player){
        player.points += Math.round(player.multiplier*(100+(25*player.streak)));
        player.streak ++;
        if(game.gameCard.equals(GameConstants.CARD_YELLOW_NAME)) player.streak += 2;
    }

    public void calcMultipliers(){
        int RED = 0;
        int lowestScore = 999999999;
        for(int i=0; i<game.players.length; i++){
            if(game.players[i].vote == GameConstants.BET_RED) RED++;  
            if(game.players[i].points < lowestScore) lowestScore = game.players[i].points;
        } 

        for(int i=0; i<game.players.length; i++) 
            if(game.players[i].vote.equals(GameConstants.BET_RED)) game.players[i].multiplier = 1-RED+game.players.length;
                                                              else game.players[i].multiplier = 1+RED;
        for(int i=0; i<game.players.length; i++) 
            switch(game.gameCard){
                case GameConstants.CARD_INDIGO_NAME: 
                    game.players[i].multiplier*=2;
                    break;
                case GameConstants.CARD_GOLDEN_NAME: 
                    game.players[i].multiplier*=4;
                    break;
                case GameConstants.CARD_RAINBOW_NAME:
                    game.players[i].multiplier*=10;
                    break;
                case GameConstants.CARD_BLACK_NAME:
                    if(game.players[i].points == lowestScore) game.players[i].multiplier *= 3; 
                    break;
                case GameConstants.CARD_ORANGE_NAME:
                    game.players[i].multiplier = 1 + game.players.length - game.players[i].multiplier;
                    break;
                default:break;
            }
    }

    //CARD LOGIC
    public void drawCard(){
        double randomValue = Math.random()*GameConstants.CARD_ODDS_TOTAL;
        double incrementalValue = 0l;
        int index = 0;
        System.out.println(randomValue);
        for(int i=0; i<GameConstants.CARD_ODDS_LIST.size(); i++){
            incrementalValue+= GameConstants.CARD_ODDS_LIST.get(i);
            if(randomValue<=incrementalValue) break;
            index++;
        }
        game.gameCard = GameConstants.CARD_NAME_LIST.get(index);
        game.gameCardEffect = GameConstants.CARD_DESC_LIST.get(index);
        System.out.println(game.gameCard);
    }

    //PLAYER ACTIONS
    public void bet(String id, String bet){
        for(int i=0; i<game.players.length; i++) 
            if(id.equals(game.players[i].playerID)) game.players[i].vote = bet; 
    }
}
