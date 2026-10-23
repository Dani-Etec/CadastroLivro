package br.sp.gov.br.CadastroLivro.repository

import br.sp.gov.br.CadastroLivro.entity.Livro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository: JpaRepository<Livro, Long> {
}