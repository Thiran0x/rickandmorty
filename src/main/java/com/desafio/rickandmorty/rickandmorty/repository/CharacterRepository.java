package com.desafio.rickandmorty.rickandmorty.repository;

import com.desafio.rickandmorty.rickandmorty.exception.RepositoryException;
import com.desafio.rickandmorty.rickandmorty.model.RootModel;
import org.springframework.http.ResponseEntity;

/**
 * Created by Thiran0x on 01-05-2022.
 */
public interface CharacterRepository {
    public ResponseEntity<RootModel> getCharacterInfo(int id) throws RepositoryException;
}
