# ArcadeGame
Projeto realizado para a disciplina de Programação Orientada a Objetos.
Alunos:
- Anlee Feng Chang - n° USP 12563690
- Cássio Perpétuo da Cunha - n° USP 8538501
- Diego Soares da Paz - n° USP 8936415
  
# 1. Requerimentos
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
- Jogo Rodando: Durante o jogo, os jogadores pode se mover para a esquerda e direita usando as setas do teclado e as teclas "A" e "D", e atirar com a barra de espaço.
- Colisões: O jogo verifica colisões entre projéteis e alienígenas ou com os jogadores. Se um jogador é atingido, perde uma vida.
- Fim de Jogo: Quando as vidas de um dos jogadores chega a zero ou um alienígena atinge a parte inferior da tela, o jogo termina e a tela de game over é exibida.

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
- SpaceInvaders chama o método update, que atualiza a posição dos jogadores, alienígenas e projéteis.
- Verifica colisões entre projéteis e jogadores ou alienígenas.
- Remove projéteis fora da tela e verifica condições de game over.

3.2.4. Desenho na Tela:
- SpaceInvaders chama o método paintComponent para desenhar os jogadores, alienígenas e projéteis na tela.
- Diferentes estados do jogo (START, RUNNING, GAME_OVER) exibem diferentes informações na tela.

3.2.5. Controle do Jogador:
- SpaceInvaders implementa KeyListener para detectar entrada do teclado.
- Movimentos e ações do jogador são processados e atualizados através dos métodos keyPressed e keyReleased de Player.

3.2.6. Aumento de Dificuldade:
- Quando todos os alienígenas são eliminados, SpaceInvaders chama increaseDifficulty da enumeração Difficulty e reinicializa os alienígenas com maior dificuldade.

# 4. Plano de testes

- Testar os movimentos dos jogadores para a esquerda e direita.
- Testar o disparo de projéteis pelos jogadores.
- Testar a colisão de projéteis dos jogadores com os alienígenas.
- Testar a colisão de projéteis dos alienígenas com os jogadores.
- Verificar se o jogo reinicia corretamente após o game over.
- Verificar se a dificuldade aumenta conforme os alienígenas são eliminados.
 
# 5.Resultados dos teste

- Movimento dos jogadores funcionando corretamente.
- Disparo de projéteis pelos jogadores funcionando conforme esperado.
- Colisões entre projéteis dos jogadores e alienígenas detectadas corretamente.
- Colisões entre projéteis dos alienígenas e os jogadores funcionando corretamente.
- Jogo reinicia corretamente após o game over.
- A dificuldade aumenta corretamente conforme o nível vai aumentando.

# 6. Como rodar 
  Para executar o jogo é necessário baixar uma IDE que suporte Java. Caso já tenha instalado em seu dispositivo, pule a instução de intalação. 
Nota: caso não consiga rodar no jogo na IDE que já tem intalada, aconselhamos seguir as instruções a seguir para instalar a plataforma que utilizamos.

6.1. Instale o NetBeans
- Através do link https://netbeans.apache.org/front/main/download/nb22/ instale o NetBeans para o seu sistema operacional. As instruções estão todas nesse link, mas reforçamos que 
a instalação do Apache NetBeans 22 requerer JDK 17 ou superior e suportam oficialmente a execução em JDK 17, 21 e 22, portanto é necessário baixá-lo pelo site da Oracle: https://www.oracle.com/java/technologies/downloads/.

6.2. Abrir o projeto
- Agora, no GitHub, faça o download em .zip do projeto, para isso clique no botão verde "Code" e em seguida em "Download ZIP". Nos seu Explorador de Arquivos extraia o .zip.
- Após tudo instalado, abra o projeto no NetBeans, no canto direito superior em "Files" terá a opção "Open project", abra a pasta baixada anteriormente no GitHub.


# 7. Problemas

- Dificuldade inicial com a implementação de colisões. 
- Garantir que o aumento de dificuldade fosse perceptível mas não impossível.


# 8. Comentários

- O projeto foi uma excelente oportunidade para aplicar conhecimentos de Java e programação orientada a objetos.
- Utilizar Swing para a interface gráfica facilitou a criação de uma experiência de jogo visualmente atraente.
