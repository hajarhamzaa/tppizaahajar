package com.example.tppizza.service;

import com.example.tppizza.classes.Produit;
import com.example.tppizza.dao.IDao;
import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<Produit> {
    private List<Produit> produits = new ArrayList<>();

    @Override
    public boolean create(Produit o) {
        return produits.add(o);
    }

    @Override
    public boolean delete(Produit o) {
        return produits.remove(o);
    }

    @Override
    public boolean update(Produit o) {
        int index = produits.indexOf(o);
        if (index != -1) {
            produits.set(index, o);
            return true;
        }
        return false;
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Produit findById(int id) {
        return null;
    }
}
