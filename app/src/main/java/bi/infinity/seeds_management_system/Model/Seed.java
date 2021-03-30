package bi.infinity.seeds_management_system.Model;

import android.content.Context;

import bi.infinity.seeds_management_system.Fragments.HomeFragment;

public class Seed {
    public String nom, image, details,owner,qtt;
    public Integer prix;

    public Seed(String nom, String image, String details, String owner) {
        this.nom = nom;
        this.image = image;
        this.details = details;
        this.owner = owner;
        this.prix = prix;
        this.qtt = qtt;
    }

    @Override
    public String toString() {
        return "Seed{" +
                "nom='" + nom + '\'' +
                ", image='" + image + '\'' +
                ", details='" + details + '\'' +
                ", owner='" + owner + '\'' +
                ", qtt='" + qtt + '\'' +
                ", prix=" + prix +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage(Context fragment) {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getQtt() {
        return qtt;
    }

    public void setQtt(String qtt) {
        this.qtt = qtt;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
}
