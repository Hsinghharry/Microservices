package com.lcwd.user.service.entities;


import jakarta.persistence.*;
import lombok.*;





@Getter
@Setter
@Builder
@Entity
@Table(name = "micro_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "EMAIL_ID")
    private String emailid;
    @Column(name = "ABOUT")
    private String about;

}
