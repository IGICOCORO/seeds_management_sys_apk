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
}