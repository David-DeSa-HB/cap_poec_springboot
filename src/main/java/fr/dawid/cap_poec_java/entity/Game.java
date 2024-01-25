package fr.dawid.cap_poec_java.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate publishedAt;

    private String image;

    @ManyToOne
    private BusinessModel businessModel;

    @ManyToMany
    @JoinTable(
            name = "game_platform",
            joinColumns = @JoinColumn(name = "game_id"), // Nom de la colonne de la table courante
            inverseJoinColumns = @JoinColumn(name = "platform_id") // Nom de la colonne de l'entité en relation
    )
    private List<Platform> platforms = new ArrayList<>();

    @ManyToOne
    private Publisher publisher;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Classification classification;

    @OneToMany(mappedBy = "game")
    private List<Review> reviews = new ArrayList<>();

    @OneToOne
    private Moderator moderator;

}