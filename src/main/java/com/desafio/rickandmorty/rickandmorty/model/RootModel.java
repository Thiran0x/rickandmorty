package com.desafio.rickandmorty.rickandmorty.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Matias Arce on 29-04-2022.
 */
public class RootModel {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private int episode_count;
    private OriginModel origin;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ArrayList<String> episode;



    public RootModel() {
        this.origin=new OriginModel();
    }

    public RootModel(int id, String name, String status, String species, String type, int episode_count, OriginModel origin, ArrayList<String> episode) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.episode_count = episode_count;
        this.origin = origin;
        this.episode = episode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    public OriginModel getOrigin() {
        return origin;
    }

    public void setOrigin(OriginModel origin) {
        this.origin = origin;
    }

    public ArrayList<String> getEpisode() {
        return episode;
    }

    public void setEpisode(ArrayList<String> episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "RootModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", episode_count=" + episode_count +
                ", origin=" + origin +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
