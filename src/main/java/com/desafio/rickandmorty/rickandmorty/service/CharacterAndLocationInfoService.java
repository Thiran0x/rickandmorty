package com.desafio.rickandmorty.rickandmorty.service;

import com.desafio.rickandmorty.rickandmorty.model.OriginModel;
import com.desafio.rickandmorty.rickandmorty.model.RootModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Matias Arce on 29-04-2022.
 */
public interface CharacterAndLocationInfoService {
    ResponseEntity<RootModel> findCharacterByID(int id);
    ResponseEntity<OriginModel> findLocation(String url);
}
