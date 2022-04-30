package com.desafio.rickandmorty.rickandmorty.controller;

import com.desafio.rickandmorty.rickandmorty.model.OriginModel;
import com.desafio.rickandmorty.rickandmorty.model.RootModel;
import com.desafio.rickandmorty.rickandmorty.service.CharacterAndLocationInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Matias Arce on 29-04-2022.
 */
@RestController
@RequestMapping("/api")
public class RickAndMortyController {

    private static final Log LOGGER = LogFactory.getLog(RickAndMortyController.class);
    private static CharacterAndLocationInfoService characterAndLocationInfoService;

    @Autowired
    public RickAndMortyController(CharacterAndLocationInfoService characterAndLocationInfoService) {
        this.characterAndLocationInfoService = characterAndLocationInfoService;
    }

    @RequestMapping(value = "/character/{id}", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<RootModel> getFullCharacterInfo(@PathVariable("id") int id){
        LOGGER.info("Access to [RickAndMortyController.getFullCharacterInfo][GET][ID|"+id+"]");

        ResponseEntity<RootModel> rootModelResponseEntity;
        ResponseEntity<OriginModel> originModelResponseEntity;

        rootModelResponseEntity = characterAndLocationInfoService.findCharacterByID(id);
        if(rootModelResponseEntity.getStatusCode().equals(HttpStatus.OK)){
            rootModelResponseEntity.getBody().setEpisode_count(rootModelResponseEntity.getBody().getEpisode().size());

            originModelResponseEntity = characterAndLocationInfoService.findLocation(rootModelResponseEntity.getBody().getOrigin().getUrl());
            if(originModelResponseEntity.getStatusCode().equals(HttpStatus.OK)){
                rootModelResponseEntity.getBody().setOrigin(originModelResponseEntity.getBody());
            }
        }

        return rootModelResponseEntity;
    }
}
