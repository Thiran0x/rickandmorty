package com.desafio.rickandmorty.rickandmorty.service.impl;

import com.desafio.rickandmorty.rickandmorty.exception.RepositoryException;
import com.desafio.rickandmorty.rickandmorty.model.OriginModel;
import com.desafio.rickandmorty.rickandmorty.model.RootModel;
import com.desafio.rickandmorty.rickandmorty.repository.CharacterRepository;
import com.desafio.rickandmorty.rickandmorty.repository.LocationRepository;
import com.desafio.rickandmorty.rickandmorty.service.CharacterAndLocationInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Matias Arce on 29-04-2022.
 */
@Service
public class CharacterAndLocationInfoServiceImpl implements CharacterAndLocationInfoService {

    private static final Log LOGGER = LogFactory.getLog(CharacterAndLocationInfoServiceImpl.class);
    private static CharacterRepository characterRepository;
    private static LocationRepository locationRepository;

    @Autowired
    public CharacterAndLocationInfoServiceImpl(CharacterRepository characterRepository,LocationRepository locationRepository) {
        this.characterRepository = characterRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public ResponseEntity<RootModel> findCharacterByID(int id) {
        LOGGER.info("Access to [CharacterAndLocationInfoServiceImpl.findCharacterByID] with [id:"+id+"]");
        try{
            LOGGER.info("Consulting service [CharacterAndLocationInfoServiceImpl.findCharacterByID] with [id:"+id+"]");
            ResponseEntity<RootModel> responseEntity= characterRepository.getCharacterInfo(id);
            LOGGER.info("[CharacterAndLocationInfoServiceImpl.findCharacterByID] with [id:"+id+"][RESULTADO|"+responseEntity.getStatusCode()+"]");

            return new ResponseEntity<RootModel>(responseEntity.getBody(), responseEntity.getStatusCode());

        }catch (RepositoryException e){
            LOGGER.error("[CharacterAndLocationInfoServiceImpl.findCharacterByID] with [id:"+id+"][RESULTADO|ERROR]["+e.getMessage()+"]");
            return new ResponseEntity<RootModel>(new RootModel(), e.getHttpStatus());
        } catch (Exception e){
            LOGGER.error("[CharacterAndLocationInfoServiceImpl.findCharacterByID] with [id:"+id+"][RESULTADO|ERROR]["+e.getMessage()+"]");
            return new ResponseEntity<RootModel>(new RootModel(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<OriginModel> findLocation(String url) {
        LOGGER.info("Access to [CharacterAndLocationInfoServiceImpl.findLocation] with [ENDPOINT:"+url+"]");
        try{
            LOGGER.info("Consulting service [CharacterAndLocationInfoServiceImpl.findLocation] with [ENDPOINT:"+url+"]");
            ResponseEntity<OriginModel> responseEntity= locationRepository.getLocationInfo(url);
            LOGGER.info("[CharacterAndLocationInfoServiceImpl.findLocation] with [ENDPOINT:"+url+"][RESULTADO|"+responseEntity.getStatusCode()+"]");

            return new ResponseEntity<OriginModel>(responseEntity.getBody(), responseEntity.getStatusCode());

        }catch (RepositoryException e){
            LOGGER.error("[CharacterAndLocationInfoServiceImpl.findLocation] with [ENDPOINT:"+url+"][RESULTADO|ERROR]["+e.getMessage()+"]");
            return new ResponseEntity<OriginModel>(new OriginModel(), e.getHttpStatus());
        } catch (Exception e){
            LOGGER.error("[CharacterAndLocationInfoServiceImpl.findLocation] with [ENDPOINT:"+url+"][RESULTADO|ERROR]["+e.getMessage()+"]");
            return new ResponseEntity<OriginModel>(new OriginModel(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
