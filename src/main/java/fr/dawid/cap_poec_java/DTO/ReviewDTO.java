package fr.dawid.cap_poec_java.DTO;

import fr.dawid.cap_poec_java.entity.Game;
import fr.dawid.cap_poec_java.entity.Gamer;
import fr.dawid.cap_poec_java.entity.Moderator;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewDTO {

    @DecimalMin(
            value = "0",
            message = "Veuillez indiquer une note entre 0 et 20.")
    @DecimalMax(
            value = "20",
            message = "Veuillez indiquer une note entre 0 et 20."
    )
    @NotNull(message = "Veuillez indiquer une note entre 0 et 20.")
    private Float rating;

    @NotBlank(message = "Laissez un commentaire.")
    private String description;

}
