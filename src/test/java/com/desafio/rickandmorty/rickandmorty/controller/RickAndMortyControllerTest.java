package com.desafio.rickandmorty.rickandmorty.controller;

import com.desafio.rickandmorty.rickandmorty.model.RootModel;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Matias Arce on 01-05-2022.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RickAndMortyControllerTest {

    private static final Gson g = new Gson();

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getFullCharacterInfo() throws MalformedURLException {
        String responseString="{\"id\":1,\"name\":\"Rick Sanchez\",\"status\":\"Alive\",\"species\":\"Human\",\"type\":\"\",\"episode_count\":51,\"origin\":{\"name\":\"Earth (C-137)\",\"url\":\"https://rickandmortyapi.com/api/location/1\",\"dimension\":\"Dimension C-137\",\"residents\":[\"https://rickandmortyapi.com/api/character/38\",\"https://rickandmortyapi.com/api/character/45\",\"https://rickandmortyapi.com/api/character/71\",\"https://rickandmortyapi.com/api/character/82\",\"https://rickandmortyapi.com/api/character/83\",\"https://rickandmortyapi.com/api/character/92\",\"https://rickandmortyapi.com/api/character/112\",\"https://rickandmortyapi.com/api/character/114\",\"https://rickandmortyapi.com/api/character/116\",\"https://rickandmortyapi.com/api/character/117\",\"https://rickandmortyapi.com/api/character/120\",\"https://rickandmortyapi.com/api/character/127\",\"https://rickandmortyapi.com/api/character/155\",\"https://rickandmortyapi.com/api/character/169\",\"https://rickandmortyapi.com/api/character/175\",\"https://rickandmortyapi.com/api/character/179\",\"https://rickandmortyapi.com/api/character/186\",\"https://rickandmortyapi.com/api/character/201\",\"https://rickandmortyapi.com/api/character/216\",\"https://rickandmortyapi.com/api/character/239\",\"https://rickandmortyapi.com/api/character/271\",\"https://rickandmortyapi.com/api/character/302\",\"https://rickandmortyapi.com/api/character/303\",\"https://rickandmortyapi.com/api/character/338\",\"https://rickandmortyapi.com/api/character/343\",\"https://rickandmortyapi.com/api/character/356\",\"https://rickandmortyapi.com/api/character/394\"]}}";
        RootModel rootModel= g.fromJson(responseString,RootModel.class);
        ResponseEntity<RootModel> expectedResponse= new ResponseEntity<RootModel>(rootModel, HttpStatus.OK);

        ResponseEntity<RootModel> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/api/character/1").toString(), RootModel.class);
        assertEquals(expectedResponse.getBody(), response.getBody());
    }

}