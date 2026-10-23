package br.sp.gov.br.CadastroLivro.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_livro")
data class Livro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?,
    @Column(unique = true)
    var titulo: String,
    var autor : String,
    var ano : Int
)
