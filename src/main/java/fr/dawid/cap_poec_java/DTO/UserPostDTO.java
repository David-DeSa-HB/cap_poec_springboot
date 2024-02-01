package fr.dawid.cap_poec_java.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserPostDTO {

    @Size(message = "Tu peux faire mieux que 4 lettres quand même...", min = 5)
    @NotBlank(message = "Si tu met pas de pseudo, on va avoir du mal à t'identifier...")
    private String nickname;

    @Email(message = "Respectes toi, met au moins une @ et un .fr")
    @NotBlank(message = "Pas de email, pas de chocolat...")
    private String email;

    @NotBlank(message = "ALors là, super sécurisé comme password...")
    @Size(message = "Fais comme tout le monde, balance au moins 8 charactères", min = 8)
    private String password;

    @NotNull(message = "Indique ta date de naissance, c'est pour nos BDD")
    @PastOrPresent(message = "Non. Tu n'es pas né dans le futur.")
    private LocalDate birthAt;
}
