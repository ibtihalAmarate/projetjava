package org.example;


import java.util.ArrayList;
import java.util.List;

public class GestionEtudiants {

    private List<Etudiant> etudiants;

    public GestionEtudiants() {
        etudiants = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public Etudiant getEtudiantParNom(String nom) {
        return etudiants.stream()
                .filter(etudiant -> etudiant.getNom().equals(nom))
                .findFirst()
                .orElse(null);
    }
}
