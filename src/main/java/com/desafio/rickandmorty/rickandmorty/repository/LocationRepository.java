package com.desafio.rickandmorty.rickandmorty.repository;

import com.desafio.rickandmorty.rickandmorty.exception.RepositoryException;
import com.desafio.rickandmorty.rickandmorty.model.OriginModel;
import org.springframework.http.ResponseEntity;

/**
 * Created by Matias Arce on 01-05-2022.
 */
public interface LocationRepository {
    public ResponseEntity<OriginModel> getLocationInfo(String url) throws RepositoryException;
}
