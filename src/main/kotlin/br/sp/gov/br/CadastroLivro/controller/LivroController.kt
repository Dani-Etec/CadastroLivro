package br.sp.gov.br.CadastroLivro.controller

import br.sp.gov.br.CadastroLivro.entity.Livro
import br.sp.gov.br.CadastroLivro.service.LivroService
import br.sp.gov.br.CadastroLivro.repository.LivroRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/livros")
class LivroController(val service: LivroService){

    @PostMapping
    fun cadastrar(@RequestBody livro: Livro): ResponseEntity<Livro> {
        return ResponseEntity.ok(service.cadastrar(livro))
    }

    @GetMapping
    fun listar(): ResponseEntity<List<Livro>> {
        return ResponseEntity.ok(service.listar())
    }

    @PutMapping("/{id}")
    fun atualizar(
        @PathVariable("id") id : Long,
        @RequestBody livro: Livro
    ): ResponseEntity<Livro> {
        val atualizado = service.atualizar(id,livro) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(atualizado)
    }

    @DeleteMapping("/{id}")
    fun excluir(@PathVariable("id") id : Long): ResponseEntity<Void> {
        val excluir = service.excluir(id)
        if (!excluir) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.noContent().build()
    }
}