package fr.dawid.cap_poec_java.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private LocalDateTime createdAt;

    private Float rating;

    private LocalDateTime moderatedAt;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Game game;

    @OneToOne
    private Moderator moderator;

    @ManyToOne
    private Gamer gamer;

}