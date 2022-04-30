package com.desafio.rickandmorty.rickandmorty.repository;

import com.desafio.rickandmorty.rickandmorty.exception.RepositoryException;
import com.desafio.rickandmorty.rickandmorty.model.RootModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * Created by Matias Arce on 29-04-2022.
 */
@Repository
public class CharacterRepository {

    private static final Log LOGGER = LogFactory.getLog(CharacterRepository.class);
    private static Environment env;
    private static RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public CharacterRepository(Environment env, RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder=restTemplateBuilder;
        this.env=env;
    }

    public ResponseEntity<RootModel> getCharacterInfo(int id) throws RepositoryException{
        try{
            //ResponseEntity<String> responseEntity;
            ResponseEntity<RootModel> rootModelResponseEntity;
            LOGGER.info("Consulting repository [CharacterRepository.getCharacterInfo] [endpoint.get.single.character] with [id:"+id+"]");
            //responseEntity = restTemplateBuilder.build().getForEntity(env.getProperty("endpoint.get.single.character")+id, String.class);
            rootModelResponseEntity = restTemplateBuilder.build().getForEntity(env.getProperty("endpoint.get.single.character")+id, RootModel.class);
            LOGGER.info("[CharacterRepository.getCharacterInfo] [endpoint.get.single.character] with [id:"+id+"][RESULTADO|"+rootModelResponseEntity.getBody()+"]");
            return rootModelResponseEntity;
        } catch (HttpStatusCodeException ex){
            LOGGER.error("[CharacterRepository.getCharacterInfo] [endpoint.get.single.character] with [id:"+id+"][RESULTADO|ERROR]["+ex.getMessage()+"]");
            throw new RepositoryException(ex.getMessage(),ex.getStatusCode(),ex);
        } catch (Exception e ){
            LOGGER.error("[CharacterRepository.getCharacterInfo] [endpoint.get.single.character] with [id:"+id+"][RESULTADO|ERROR]["+e.getMessage()+"]");
            throw new RepositoryException("[ERROR SERVICIO|endpoint.get.single.character]",HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }
}
