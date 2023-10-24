package com.example.bookstoredemo.model.entity;



import com.example.bookstoredemo.model.ERole;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "role_name")
    @Enumerated(value = EnumType.STRING)
    ERole roleName;
}
