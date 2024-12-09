package org.example;

public class Etudiant {
    private String nom;
    private int age;

    public Etudiant(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }

}
