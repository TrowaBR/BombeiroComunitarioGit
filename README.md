# BombeiroComunitarioGit

### Passo a passo no NetBeans:

1. Crie um novo projeto com o nome **BombeiroComunitarioGit**

   * Projeto: `Aplicação Web`

   * Frameworks: `Java Server Faces` com `Primefaces` e `Hibernate`

1. Clique-direito no projeto > Controle de Versão > Inicializar Repositório Git

1. Clique-direito no projeto > Git > Adicionar

1. Clique-direito no projeto > Git > Remoto > Puxar

   * Marcar `Especificar a Localização do Repositório Git`

   * Nome Remoto: `origin`

   * Persistir Remoto: `marcado`

   * URL do Repositório: `https://github.com/TrowaBR/BombeiroComunitarioGit.git`

   * Usuário/Senha: `Seu login/senha no Github`

   * Pressionar **Próximo**

   * Selecionar: `master -> origin/master`

   * Pressionar **Finalizar**

1. Clique-direito no projeto > Git > Reverter modificações

Repita o passo 4 para atualizar os fontes.

Será necessário existir uma conexão Postgre local comum banco `bancoBombeiro` conforme configurado em sala.

### Para enviar suas alterações:

1. Clique-direito no projeto > Git > Adicionar

1. Clique-direito no projeto > Git > Fazer Commit

   * Preencher `Mensagem para Commit` (ex: "Incluída classe Agendamento" ou "Corrigida apresentação da lista de permissões").

   * Pressionar **Fazer Commit**

1. Clique-direito no projeto > Git > Remoto > Enviar

   * Marcar `Selecionar a Localização do Repositório Git`

   * Pressionar **Próximo**

   * Selecionar: `master -> origin/master`

   * Pressionar **Próximo**

   * Pressionar **Finalizar**
