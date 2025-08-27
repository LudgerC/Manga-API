package be.ehb.mangaapi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
public class Klant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Email moet geldig zijn")
    @NotBlank(message = "Email is verplicht")
    private String email;

    @NotBlank(message = "Tier is verplicht")
    @Pattern(regexp = "casual|fan|collector", message = "Tier moet 'casual', 'fan' of 'collector' zijn")
    private String tier;

    @NotBlank(message = "Adres is verplicht")
    private String adres;

    @ManyToMany
    @JoinTable(
            name = "friends",
            joinColumns = @JoinColumn(name = "klant_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<Klant> friends;

    // --- Constructors ---
    public Klant() {}

    public Klant(Long id, String email, String tier, String adres, List<Klant> friends) {
        this.id = id;
        this.email = email;
        this.tier = tier;
        this.adres = adres;
        this.friends = friends;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public List<Klant> getFriends() {
        return friends;
    }

    public void setFriends(List<Klant> friends) {
        this.friends = friends;
    }
}
