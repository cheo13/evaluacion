package com.example.evaluacion.model

import jakarta.validation.constraints.NotBlank
import javax.persistence.*

@Entity
    @Table(name = "assistan")
    class Assistan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var ida: Long? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name = "nameassistant", nullable = false)
    var nameassistant: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name = "roleassistant", nullable = false)
    var roleassistant: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name = "ageassistant", nullable = false)
    var ageassistant: Int? = null
    @NotBlank(message="Campo obligatorio") //validate
    @Column(name = "confassistant", nullable = false)
    var confassistant: Long? = null

    //@ManyToOne
    //@JoinColumn(name = "confassistant", referencedColumnName = "idc")
    //var conference: Conference? = null
}