package com.example.tp4.service;

import com.example.tp4.beans.Star;
import com.example.tp4.dao.IDao;

import java.util.ArrayList;
import java.util.List;

public class StarService implements IDao<Star> {
    private List<Star> stars;
    private static StarService instance;
    private StarService() {
        this.stars = new ArrayList<>();
    }
    public static StarService getInstance() {
        if(instance == null)
            instance = new StarService();
        return instance;
    }

    @Override
    public boolean create(Star o) {
        return stars.add(o);
    }

    @Override
    public boolean update(Star o) {
        for(Star star:stars){
            if(star.getId()==o.getId())
                star.setStar(o.getStar());
        }
        return true;
    }

    @Override
    public boolean delete(Star o) {
        return stars.remove(o);
    }

    @Override
    public Star findById(int id) {
       for(Star star:stars){
           if(star.getId()==id)
               return  star;
       }
       return null;
    }

    @Override
    public List<Star> findAll() {
        return stars;
    }
}
