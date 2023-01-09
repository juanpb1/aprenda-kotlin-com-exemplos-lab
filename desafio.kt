interface PrintNivelUsario{
    fun printNivel() : String 
}

enum class Nivel : PrintNivelUsario { 
    BASICO{
        override fun printNivel() = "Básico"
    }
    , INTERMEDIARIO{
         override fun printNivel() = "Intermediário"
    }, AVANCADO{
         override fun printNivel() = "Avançado"
    } 
}

data class Usuario(val nome: String, val id: Int){
    constructor() : this("", 0)
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60){
    constructor() : this("", 0)
}

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        
        inscritos.add(usuario)
      
    }
}

fun printUsuarios(formacao: Formacao){
    print("= ALUNO(S): ")
    for(inscrito in formacao.inscritos){
        print("${inscrito.nome} | ")
    }
    println("")
    println("= FORMACAO: ${formacao.nome}")
    println("= NÍVEL: ${Nivel.BASICO.printNivel()}")
    println("= CONTEÚDOS: ")
    for(conteudo in formacao.conteudos){
        println("Nome: ${conteudo.nome} | Duração(h): ${conteudo.duracao}")
    }
}

fun main() {
    
    val aluno0 = Usuario("Pedro", 1)
    val aluno1 = Usuario("Marcos", 2)
    
    val conteudoEducacional0 = ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin", 30)
    val conteudoEducacional1 = ConteudoEducacional("Estruturas de Controle de Fluxo e Coleções em Kotlin", 60)
    val conteudos = mutableListOf<ConteudoEducacional>()
    conteudos.add(conteudoEducacional0)
    conteudos.add(conteudoEducacional1)
    
    val nomeFormacao = "Kotlin Experiencen"
    val formacao0 = Formacao(nomeFormacao, conteudos)
    
    formacao0.matricular(aluno0)
    formacao0.matricular(aluno1)
    
    printUsuarios(formacao0)
    println()
        
  }
    
    
    
    
