package com.mazio.freeForAllApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mazio.freeForAllApp.model.Game;
import com.mazio.freeForAllApp.model.Player;
import com.mazio.freeForAllApp.service.GameService;

@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
   @RestController
   @RequestMapping("/")
public class GameController {

    @Autowired
    GameService gameService;

    @CrossOrigin
    @GetMapping(value = "/game" , produces = MediaType.APPLICATION_JSON_VALUE ) 
    public Game getGameData() {
        return gameService.game;
    }

    @GetMapping(value = "/players" , produces = MediaType.APPLICATION_JSON_VALUE ) 
    public Player[] getPlayerData() {
        return gameService.game.players;
    }

    @PostMapping(value = "/start" , consumes = "text/plain;charset=UTF-8",  produces = MediaType.APPLICATION_JSON_VALUE ) 
    public ResponseEntity<Game> startGame(@RequestBody String players) throws JsonMappingException, JsonProcessingException {
        Player[] playerData = gameService.convertRawData(players);
        gameService.start(playerData);
        return new ResponseEntity<>(gameService.game, HttpStatus.OK);
    }
    
    @PostMapping(value = "/revealCard" , consumes = "text/plain;charset=UTF-8",  produces = MediaType.APPLICATION_JSON_VALUE ) 
    public ResponseEntity<Game> revealCard(@RequestBody String data) throws JsonMappingException, JsonProcessingException {
        gameService.standbyToVotingTime();
        return new ResponseEntity<>(gameService.game, HttpStatus.OK);
    }

    @PostMapping(value = "/lockBets" , consumes = "text/plain;charset=UTF-8",  produces = MediaType.APPLICATION_JSON_VALUE ) 
    public ResponseEntity<Game> lockBets(@RequestBody String data) throws JsonMappingException, JsonProcessingException {
        gameService.votingTimeToFight();
        return new ResponseEntity<>(gameService.game, HttpStatus.OK);
    }

    @PostMapping(value = "/declareWinner" , consumes = "text/plain;charset=UTF-8",  produces = MediaType.APPLICATION_JSON_VALUE ) 
    public ResponseEntity<Game> declareWinner(@RequestBody String winner) throws JsonMappingException, JsonProcessingException {
        gameService.fightToStandby(winner.toUpperCase());
        return new ResponseEntity<>(gameService.game, HttpStatus.OK);
    }

    @PostMapping(value = "/vote" , consumes = "text/plain;charset=UTF-8",  produces = MediaType.APPLICATION_JSON_VALUE ) 
    public ResponseEntity<Game> vote(@RequestBody String data, @RequestParam(name = "id") String id, @RequestParam(name = "bet") String bet) throws JsonMappingException, JsonProcessingException {
        gameService.bet(id,bet);
        return new ResponseEntity<>(gameService.game, HttpStatus.OK);
    }

    
}
