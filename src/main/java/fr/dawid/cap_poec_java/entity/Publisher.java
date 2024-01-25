package fr.dawid.cap_poec_java.entity;

import fr.dawid.cap_poec_java.entity.interfaces.NomenclatureInterface;
import fr.dawid.cap_poec_java.entity.interfaces.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Publisher  implements
        SluggerInterface,
        NomenclatureInterface
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String slug;

    @OneToMany(mappedBy = "publisher")
    private List<Game> games = new ArrayList<>();

    @Override
    public String getField() {
        return name;
    }
}