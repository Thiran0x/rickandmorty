package com.desafio.rickandmorty.rickandmorty.repository.impl;

import com.desafio.rickandmorty.rickandmorty.exception.RepositoryException;
import com.desafio.rickandmorty.rickandmorty.model.OriginModel;
import com.desafio.rickandmorty.rickandmorty.repository.LocationRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;

/**
 * Created by Matias Arce on 29-04-2022.
 */
@Repository
public class LocationRepositoryImpl implements LocationRepository {
    private static final Log LOGGER = LogFactory.getLog(LocationRepositoryImpl.class);
    private static RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public LocationRepositoryImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder=restTemplateBuilder;
    }

    public ResponseEntity<OriginModel> getLocationInfo(String url) throws RepositoryException {
        try{
            //ResponseEntity<String> responseEntity;
            ResponseEntity<OriginModel> originModelResponseEntity;
            LOGGER.info("Consulting repository [LocationRepository.getLocationInfo] with [ENDPOINT:"+url+"]");
            //responseEntity = restTemplateBuilder.build().getForEntity(url, String.class);
            originModelResponseEntity = restTemplateBuilder.build().getForEntity(url, OriginModel.class);
            LOGGER.info("[LocationRepository.getLocationInfo] with [ENDPOINT:"+url+"][RESULTADO|"+originModelResponseEntity.getBody()+"]");
            return originModelResponseEntity;
        } catch (HttpStatusCodeException ex){
            LOGGER.error("[LocationRepository.getLocationInfo] with [ENDPOINT:"+url+"][RESULTADO|ERROR]["+ex.getMessage()+"]");
            throw new RepositoryException(ex.getMessage(),ex.getStatusCode(),ex);
        } catch (Exception e ){
            LOGGER.info("[LocationRepository.getLocationInfo] with [ENDPOINT:"+url+"][RESULTADO|ERROR]["+e.getMessage()+"]");
            throw new RepositoryException("[ERROR SERVICIO|"+url+"]", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }
}
