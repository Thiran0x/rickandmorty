package com.desafio.rickandmorty.rickandmorty.model;

import java.util.ArrayList;

/**
 * Created by Matias Arce on 29-04-2022.
 */
public class OriginModel {

    private String name;
    private String url;
    private String dimension;
    private ArrayList<String> residents;

    public OriginModel() {
    }

    public OriginModel(String name, String url, String dimension, ArrayList<String> residents) {
        this.name = name;
        this.url = url;
        this.dimension = dimension;
        this.residents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public ArrayList<String> getResidents() {
        return residents;
    }

    public void setResidents(ArrayList<String> residents) {
        this.residents = residents;
    }

    @Override
    public String toString() {
        return "OriginModel{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", dimension='" + dimension + '\'' +
                ", residents=" + residents +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
