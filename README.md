# ArcadeGame
Projeto realizado para a disciplina de Programação Orientada a Objetos.
Alunos:
- Anlee Feng Chang - n° USP 12563690
- Cássio Perpétuo da Cunha - n° USP
- Diego Soares da Paz - n° USP 8936415
  
# 1. Requirements
- Criar a interface gráfica do usuário (GUI), que deve incluir opções para iniciar um novo jogo, continuar um jogo salvo e sair.
- Os jogadores controlam uma nave espacial usando o teclado, podendo mover para a esquerda, direita e disparar projéteis.
- Alienígenas aparecem em formações e se movem em direção à nave do jogador, soltando bombas ocasionalmente.
- Detectar colisões entre projéteis e alienígenas, destruindo os alienígenas no impacto.
- Os jogadores devem trabalhar juntos para derrotar os alienígenas, compartilhando a tela do jogo e usando teclas diferentes.
- Implementar níveis com dificuldade crescente, incluindo alienígenas mais rápidos e/ou padrões de ataque mais complexos.
- Implementar uma lista dos melhores jogadores e suas pontuações.
- Implementar um tratamento robusto de erros usando os mecanismos de tratamento de exceções do Java.

# 2. Descrição do projeto

  O projeto Space Invaders foi implementado usando Java e Swing para a interface gráfica. Ele é composto por várias classes que se comunicam entre si para proporcionar a funcionalidade desejada.
- SpaceInvaders2.java: Contém a classe principal que inicializa o JFrame e adiciona o painel do jogo.
- SpaceInvaders.java: É o painel principal do jogo, responsável por gerenciar a lógica do jogo, incluindo a atualização dos estados do jogador, alienígenas e projéteis.
- Player.java: Gerencia o jogador, incluindo movimentos e colisões.
- Bullet.java: Representa os projéteis, tanto do jogador quanto dos alienígenas.
- Alien.java: Gerencia o comportamento dos alienígenas, incluindo movimentos e colisões.
- Difficulty.java: Enumeração que define diferentes níveis de dificuldade e a lógica para aumentar a dificuldade.

  2.1. Fluxo do Jogo
- Tela de Início: O jogo começa na tela de início, onde o jogador pode pressionar ENTER para começar.
- Jogo Rodando: Durante o jogo, o jogador pode se mover para a esquerda e direita usando as setas do teclado e atirar com a barra de espaço.
- Colisões: O jogo verifica colisões entre projéteis e alienígenas ou o jogador. Se o jogador é atingido, perde uma vida.
- Fim de Jogo: Quando as vidas do jogador chegam a zero ou um alienígena atinge a parte inferior da tela, o jogo termina e a tela de game over é exibida.

# 3. Comentários sobre o código

3.1. Códigos
3.1.1. SpaceInvaders2.java
- Classe principal que contém o método main.
- Inicializa o JFrame e adiciona o painel do jogo (SpaceInvaders).

3.1.2. SpaceInvaders.java
- Extende JPanel e implementa Runnable e KeyListener.
- Gerencia a lógica do jogo, incluindo o loop principal.
- Contém instâncias das classes Player, Alien, Bullet, e Difficulty.
- Utiliza a enumeração GameState para controlar o estado do jogo (START, RUNNING, GAME_OVER).
- Responsável por inicializar os alienígenas e monitorar colisões.

3.1.3. Player.java
- Gerencia o jogador, incluindo movimentos e desenho na tela.
- Possui métodos update, draw, keyPressed e keyReleased para atualizar a posição e ações do jogador.
- Implementa colisões usando a classe Rectangle.

3.1.4. Alien.java
- Representa os alienígenas no jogo.
- Contém métodos update e draw para mover e desenhar os alienígenas na tela.
- Controla a direção de movimento e a mudança de direção quando alcança as bordas da tela.
- Implementa colisões usando a classe Rectangle.

3.1.5. Bullet.java
- Representa os projéteis no jogo, tanto do jogador quanto dos alienígenas.
- Contém métodos update e draw para mover e desenhar os projéteis.
- Diferencia entre projéteis de jogadores e alienígenas com base no construtor usado.
- Implementa colisões usando a classe Rectangle.

3.1.6. Difficulty.java
- Enumeração que define diferentes níveis de dificuldade (EASY, MEDIUM, HARD).
- Cada nível de dificuldade possui uma velocidade de alienígenas e um número de alienígenas que podem atirar.
- Contém um método increaseDifficulty que aumenta a dificuldade do jogo.
- Interações Entre as Classes
- SpaceInvaders2 inicializa e exibe o JFrame contendo o painel de jogo (SpaceInvaders).
- SpaceInvaders contém e gerencia instâncias de Player, Alien, Bullet e Difficulty.
- O Player se move e dispara projéteis (Bullet), que são gerenciados pela classe SpaceInvaders.
- Os Alien se movem e podem disparar projéteis (Bullet), também gerenciados por SpaceInvaders.
- A enumeração Difficulty é usada para ajustar a velocidade e comportamento dos alienígenas.

3.1. Fluxo do Jogo
3.2.1. Inicialização
- O jogo começa com a criação do JFrame em SpaceInvaders2.
- SpaceInvaders é adicionado ao JFrame, onde os componentes do jogo (jogador, alienígenas, projéteis) são inicializados.

3.2.2. Loop do Jogo:
- SpaceInvaders inicia o loop do jogo quando start é chamado.
- O método run de SpaceInvaders mantém o loop ativo, chamando update e repaint continuamente.


3.2.3. Atualização do Jogo:
- SpaceInvaders chama o método update, que atualiza a posição do jogador, alienígenas e projéteis.
- Verifica colisões entre projéteis e jogadores ou alienígenas.
- Remove projéteis fora da tela e verifica condições de game over.


3.2.4. Desenho na Tela:
- SpaceInvaders chama o método paintComponent para desenhar o jogador, alienígenas e projéteis na tela.
- Diferentes estados do jogo (START, RUNNING, GAME_OVER) exibem diferentes informações na tela.


3.2.5. Controle do Jogador:
- SpaceInvaders implementa KeyListener para detectar entrada do teclado.
- Movimentos e ações do jogador são processados e atualizados através dos métodos keyPressed e keyReleased de Player.


3.2.6. Aumento de Dificuldade:
- Quando todos os alienígenas são eliminados, SpaceInvaders chama increaseDifficulty da enumeração Difficulty e reinicializa os alienígenas com maior dificuldade.


# 4. Plano de testes

- Testar o movimento do jogador para a esquerda e direita.
- Testar o disparo de projéteis pelo jogador.
- Testar a colisão de projéteis do jogador com os alienígenas.
- Testar a colisão de projéteis dos alienígenas com o jogador.
- Verificar se o jogo reinicia corretamente após o game over.
- Verificar se a dificuldade aumenta conforme os alienígenas são eliminados.
 
# 5.Resultados dos teste

- Movimento do jogador funcionando corretamente.
- Disparo de projéteis pelo jogador funcionando conforme esperado.
- Colisões entre projéteis do jogador e alienígenas detectadas corretamente.
- Colisões entre projéteis dos alienígenas e o jogador funcionando corretamente.
- Jogo reinicia corretamente após o game over.
- A dificuldade aumenta corretamente conforme os alienígenas são eliminados.

# 6. Build Procedures: 
A step-by-step guide to run your code. You should start telling how to install whatever software you need, then how to download/build your program, and finally how to set up the environment to run it. Imagine that someone installing will just follow these commands (nothing more).

# 7. Problems

- Dificuldade inicial com a implementação de colisões. 
- Garantir que o aumento de dificuldade fosse perceptível mas não impossível.

# 8. Comments

- O projeto foi uma excelente oportunidade para aplicar conhecimentos de Java e programação orientada a objetos.
- Utilizar Swing para a interface gráfica facilitou a criação de uma experiência de jogo visualmente atraente.
