package bi.infinity.seeds_management_system.Model;

public class Stock {
    public String nom, image, details,owner,prix,qtt;

    public Stock(String nom, String image, String details, String owner, String prix, String qtt) {
        this.nom = nom;
        this.image = image;
        this.details = details;
        this.owner = owner;
        this.prix = prix;
        this.qtt = qtt;
    }

    public Stock(String nom, String image, String details, String owner) {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
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

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getQtt() {
        return qtt;
    }

    public void setQtt(String qtt) {
        this.qtt = qtt;
    }

}
