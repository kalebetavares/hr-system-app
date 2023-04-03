package br.com.hrsystem.userapi.domain;

import br.com.hrsystem.userapi.resources.dto.UserDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_USER")
public class User {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private Double hourlyPrice;

    public User (UserDto userDto){
        this.name = userDto.getName();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
        this.hourlyPrice = userDto.getHourlyPrice();
    }
}
