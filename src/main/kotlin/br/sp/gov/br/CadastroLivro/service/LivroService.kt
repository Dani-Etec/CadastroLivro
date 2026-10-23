package br.sp.gov.br.CadastroLivro.service

import br.sp.gov.br.CadastroLivro.entity.Livro
import br.sp.gov.br.CadastroLivro.repository.LivroRepository
import org.springframework.stereotype.Service

@Service
class LivroService (val repository: LivroRepository) {
    fun cadastrar(livro: Livro): Livro {
        return repository.save(livro)
    }
    fun listar(): List<Livro>{
        return repository.findAll()
    }
    fun buscar(id : Long): Livro?{
        return repository.findById(id).orElse(null)
    }
    fun excluir(id: Long): Boolean {
        if (repository.existsById(id)){
            return false
        }
        repository.existsById(id)
        return true
    }
    fun atualizar(id: Long, livro: Livro): Livro? {
        var livroExistente = repository.findById(id).orElse(null) ?: return null
        livroExistente.titulo = livro.titulo
        livroExistente.autor = livro.autor
        livroExistente.ano = livro.ano
        return repository.save(livroExistente)
    }
}