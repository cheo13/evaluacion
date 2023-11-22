package com.example.evaluacion.model

import jakarta.validation.constraints.NotBlank
import javax.persistence.*

@Entity
    @Table(name = "conference")
    class Conference {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var idc: Long? = null
    @NotBlank(message="Campo obligatorio") //validate
    //@Column(name = "titconference", nullable = false)
    var titconference: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    //@Column(name = "desconference", nullable = false)
    var desconference: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    //@Column(name = "citconference", nullable = false)
    var citconference: String? = null
    @NotBlank(message="Campo obligatorio") //validate
    //@Column(name = "totassconference", nullable = false)
    var totassconference: String? = null

}