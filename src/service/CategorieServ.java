package service;

import entity.Categorie;
import persistance.PersCategorie;

import java.util.List;

public class CategorieServ {
    PersCategorie persCategorie = new PersCategorie();

    public void addCategorie(Categorie c) {
        if (c != null) {
            // Check if category with same name already exists
            if (persCategorie.getCategorie(c.getNom()) != null) {
                System.out.println("Category with this name already exists!");
                return;
            }
            persCategorie.add(c);
            System.out.println("Category added successfully!");
        }
    }

    public boolean removeCategorie(String nom) {
        Categorie categorie = persCategorie.getCategorie(nom);
        if (categorie != null) {
            persCategorie.remove(categorie);
            System.out.println("Category removed successfully!");
            return true;
        } else {
            System.out.println("Category not found!");
            return false;
        }
    }

    public Categorie viewCategorie(String nom) {
        Categorie categorie = persCategorie.getCategorie(nom);
        if (categorie != null) {
            System.out.println("Category Details:");
            System.out.println("Name: " + categorie.getNom());
            System.out.println("Price: " + categorie.getPrix());
            return categorie;
        } else {
            System.out.println("Category not found!");
            return null;
        }
    }

    public void listAllCategories() {
        System.out.println("--- ALL CATEGORIES ---");
        List<Categorie> categories = persCategorie.getAllCategories();
        if (categories.isEmpty()) {
            System.out.println("No categories found!");
            return;
        }
        for(Categorie categorie : categories) {
            viewCategorie(categorie.getNom());
        }
    }

    public boolean modifyCategorie(String nom, Categorie updatedCategorie) {
        Categorie existingCategorie = persCategorie.getCategorie(nom);
        if (existingCategorie != null) {
            // If name is changed, check if new name already exists
            if (!nom.equals(updatedCategorie.getNom()) &&
                    persCategorie.getCategorie(updatedCategorie.getNom()) != null) {
                System.out.println("Category with new name already exists!");
                return false;
            }
            persCategorie.update(nom, updatedCategorie);
            System.out.println("Category modified successfully!");
            return true;
        }
        System.out.println("Category not found!");
        return false;
    }
}