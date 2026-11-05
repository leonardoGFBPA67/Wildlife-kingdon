# Wildlife Kingdon - Especificação do Projeto Android

## 1. Visão geral

### Nome do aplicativo
Wildlife Kingdon

### Descrição
Wildlife Kingdon é um jogo mobile Android do tipo idle/tycoon, com foco em construção, evolução de habitats, gerenciamento de biomas, coleta de animais e progresso visual. O jogador começa em um terreno quase vazio e, ao longo do tempo, transforma esse espaço em um mundo natural cada vez maior, vivo, bonito e funcional.

A proposta combina elementos de:
- geração automática de recursos;
- evolução de estruturas;
- expansão de biomas;
- coleção de animais;
- progresso visual constante;
- missão e conquista;
- integração com clima real via API pública.

### Objetivo
Criar uma experiência relaxante e progressiva em que o jogador sinta que o mundo cresce de forma visível ao longo do tempo, sem depender de reflexos rápidos nem de mecânicas competitivas.

O objetivo principal é permitir que o usuário:
- construa habitats;
- gere moedas automaticamente;
- desbloqueie novos animais;
- evolua o cenário;
- complete missões;
- avance entre biomas;
- acompanhe sua coleção e evolução.

### Problema que resolve
O projeto resolve a necessidade de criar um jogo simples, visualmente agradável e funcional em poucas aulas, sem exigir uma arquitetura complexa. A ideia central é oferecer uma experiência de progresso constante em um ambiente acessível e minimalista, adequada ao contexto acadêmico.

### Público-alvo
- alunos de programação e desenvolvimento mobile;
- jogadores que gostam de jogos relaxantes e progressivos;
- usuários que apreciam gerenciamento simples e sensação de criação visual.

### Diferenciais da ideia
- evolução perceptível do mapa;
- comparação entre biomas com identidade visual própria;
- coleção e raridade de animais;
- produção automática com sistema offline;
- sistema de clima em tempo real como complemento;
- proposta de jogo com mecânicas simples, mas com potencial de expansão.

---

## 2. Conceito do aplicativo

Wildlife Kingdon será um jogo de gerenciamento e evolução visual. A experiência começa em uma floresta simples, quase vazia, onde o jogador possui alguns recursos iniciais e um habitat básico. A partir disso, ele passa a desenvolver o ambiente, melhorar estruturas e aumentar a produção de moedas.

A progressão será registrada por vários elementos ao mesmo tempo:
- produção de moedas;
- nível dos habitats;
- quantidade de animais descobertos;
- evolução da aparência do mapa;
- desbloqueio de novos biomas;
- conclusão de missões.

A sensação principal será de um mundo vivo que cresce. À medida que o jogo avança, árvores, plantas, lagoas, pedras, animais e construções passam a aparecer no cenário. Isso cria uma recompensa visual muito forte e reforça a ideia de evolução.

O jogador não precisará tomar decisões muito complexas. O sistema será simples de entender e acessível para um protótipo de disciplina. O foco fica em:
- coletar recursos;
- melhorar habitats;
- aumentar a produção;
- encontrar novos animais;
- evoluir o cenário;
- avançar para novos biomas.

A proposta também inclui um sistema de clima real usando a API Open-Meteo. Mesmo que a conexão falhe, o jogo continua funcionando normalmente, usando um clima padrão. Isso torna o app mais interessante e útil como demonstração de integração com API externa.

---

## 3. Funcionalidades

### 3.1 Funcionalidades principais

1. Sistema de moedas e cristais
   - Moedas geradas por habitats.
   - Cristais obtidos por missões, conquistas e eventos especiais.
   - Recursos usados para evoluir o mundo e desbloquear melhorias.

2. Habitats e produção automática
   - Cada habitat possui nível, produção, custo e aparência.
   - Produção automática em intervalos regulares.
   - O jogador pode comprar melhorias para aumentar a geração de recursos.

3. Biomas progressivos
   - Floresta como início.
   - Ilha Tropical e Região Polar como desbloqueios posteriores.
   - Cada bioma pode ter habitats, animais e elementos visuais exclusivos.

4. Animais e coleção
   - Cada animal pertence a um bioma.
   - Animais podem ser comuns, incomuns, raros, épicos ou lendários.
   - A coleção mostra o progresso do jogador e o status de descoberta.

5. Missões e recompensas
   - Missões oferecem progresso e recompensas em moedas e cristais.
   - A interface mostra objetivo, progresso e botão de coleta.

6. Evolução visual do mapa
   - O cenário modifica de acordo com os níveis atingidos.
   - Novas árvores, plantas, lagos e elementos decorativos aparecem com evolução.

7. Salvamento local
   - O jogo salva progresso em armazenamento local.
   - O estado do jogador, habitats, animais e missões é mantido entre sessões.

8. Produção offline
   - O app calcula o tempo em que o usuário ficou fora do jogo.
   - O jogador recebe moedas acumuladas após retornar.
   - Existe um limite de produção offline para evitar valores absurdos.

9. Eventos simples no mapa
   - Balões, estrelas cadentes e animais visitantes aparecem ocasionalmente.
   - Toque nesses eventos pode conceder moedas ou cristais.

10. Clima real
   - Consulta a API Open-Meteo.
   - Em caso de falha, o jogo mantém seu funcionamento sem quebrar.

### 3.2 Funcionalidades complementares

- Personagem visual do jogador.
- Indicador de produção total por minuto.
- Nível geral do jogador.
- Conquistas com recompensas.
- Configurações de som e cidade para clima.
- Menu inferior com navegação entre telas.
- Tela de progresso da coleção.
- Feedback visual ao melhorar habitats.
- Sistema de evolução de animais por duplicatas.
- Evolução de raridade e bônus extras opcionais.

### 3.3 Possíveis funcionalidades futuras

- Deserto, Oceano, Montanhas e área futurista.
- Sistema de prestígio/reinício com bônus permanentes.
- Eventos sazonais.
- Melhorias por produções específicas por tipo de habitat.
- Sistema de animação mais avançado para animais e personagem.
- Loja de skins e decorações.
- Missões diárias e eventos temporários.
- Sincronização em nuvem.

---

## 4. Telas

### 4.1 Tela Mundo
**Objetivo:** mostrar o principal cenário do jogo.

**Componentes:**
- TextView para moedas, cristais e produção;
- ImageView para fundo do bioma;
- Botões/Views para habitats;
- event container para efeitos e elementos interativos;
- BottomNavigationView ou barra inferior de navegação.

**Informações exibidas:**
- nome do bioma;
- moedas;
- cristais;
- nível do jogador;
- produção total.

**Campos:**
- nenhuma entrada de texto obrigatória.

**Botões:**
- habitat;
- melhorar habitat;
- coletar produção;
- eventos interativos.

**Ações:**
- tocar no habitat para analisar ou ativar produção;
- melhorar estrutura;
- interagir com eventos aleatórios.

**Comportamentos:**
- exibir visualmente o cenário evoluído;
- atualizar produção em tempo real;
- reagir ao toque.

**Navegação:**
- mundo → animais → missões → melhorias → configurações.

### 4.2 Tela Animais
**Objetivo:** exibir a coleção de espécies descobertas e bloqueadas.

**Componentes:**
- RecyclerView;
- CardView;
- ImageView;
- TextView;
- ProgressBar opcional.

**Informações exibidas:**
- nome do animal;
- bioma;
- raridade;
- quantidade obtida;
- bônus;
- status de descoberta.

**Campos:**
- não há formulário principal.

**Botões:**
- filtrar por bioma;
- detalhes do animal.

**Ações:**
- visualizar coleção;
- abrir detalhes.

**Comportamentos:**
- animais desbloqueados ficam visíveis;
- animais não descobertos aparecem escuros ou com ícone de bloqueio.

**Navegação:**
- retorna para mundo ou segue para detalhes.

### 4.3 Tela Missões
**Objetivo:** apresentar objetivos do jogador.

**Componentes:**
- RecyclerView;
- CardView;
- Button;
- ProgressBar;
- TextView.

**Informações exibidas:**
- título;
- descrição;
- progresso atual;
- recompensa;
- status.

**Botões:**
- coletar recompensa;
- acompanhar progresso.

**Ações:**
- completar missão;
- receber recompensa.

**Comportamentos:**
- missão bloqueada ou concluída altera a aparência do item;
- recompensa só pode ser coletada quando concluída.

**Navegação:**
- volta para tela principal.

### 4.4 Tela Melhorias
**Objetivo:** gerenciar habitats e níveis de progresso.

**Componentes:**
- RecyclerView;
- CardView;
- Button;
- TextView;
- ImageView.

**Informações exibidas:**
- nome do habitat;
- nível atual;
- produção atual;
- próximo nível;
- custo;
- botão para melhorar.

**Campos:**
- sem entrada textual.

**Botões:**
- Melhorar;
- Visualizar detalhes.

**Ações:**
- evoluir habitat;
- verificar custo.

**Comportamentos:**
- custo cresce conforme o nível;
- produção aumenta ao melhorar;
- nova visualização aparece no mapa.

**Navegação:**
- volta para mundo.

### 4.5 Tela Configurações
**Objetivo:** ajustar preferências do aplicativo.

**Componentes:**
- Switch;
- Spinner;
- Button;
- TextView;
- AlertDialog.

**Informações exibidas:**
- música;
- efeitos sonoros;
- cidade para clima;
- informações do app;
- créditos;
- reset de progresso.

**Campos:**
- cidade;
- opções de som;

**Botões:**
- salvar;
- reiniciar progresso;
- limpar dados.

**Ações:**
- ativar/desativar som;
- alterar cidade para clima;
- confirmar reset.

**Comportamentos:**
- salvar configurações localmente;
- confirmar ações destrutivas.

**Navegação:**
- retorna ao menu principal.

### 4.6 Tela de carregamento inicial
**Objetivo:** iniciar e preparar os dados do jogo.

**Componentes:**
- ProgressBar;
- ImageView;
- TextView.

**Ações:**
- inicializar banco de dados;
- carregar progresso;
- verificar se é primeira execução.

### 4.7 Diálogo offline / coleta
**Objetivo:** mostrar os recursos acumulados enquanto o app estava fechado.

**Componentes:**
- TextView;
- Button;
- ImageView opcional.

**Informações exibidas:**
- tempo fora do jogo;
- valor estimado acumulado;
- botão para coletar.

---

## 5. Experiência do usuário

Ao abrir o aplicativo, o usuário entra em uma tela de carregamento. O sistema verifica se há progresso salvo e, em seguida, carrega os dados do jogador.

Na tela principal, o jogador vê o bioma em destaque, com recursos na parte superior e uma área de jogo ocupando a maior parte da tela. O cenário é um espaço natural que cresce conforme a progressão.

O usuário compreende rapidamente a dinâmica do jogo:
1. O habitat produz moedas automaticamente.
2. O jogador melhora as estruturas.
3. O mapa aparece mais rico e com mais elementos.
4. Novos animais e missões são liberados.
5. O jogador avança para novos biomas com novas mecânicas.

O fluxo é pensado para ser relaxante. O usuário não precisa raciocinar muito para continuar. O jogo ensina visualmente a lógica por meio de progressão observável. Isso cria uma sensação de recompensa continua.

A coleta de recursos offline reforça a ideia de retorno ao jogo. Quando o usuário abre a aplicação, recebe um resumo do que aconteceu enquanto estava fora e pode coletar o valor acumulado imediatamente.

---

## 6. Fluxo de navegação

```text
Tela Inicial / Splash
    │
    ├── Mundo
    │     ├── Melhorias
    │     ├── Animais
    │     ├── Missões
    │     └── Configurações
    │
    ├── Animais
    │     └── Detalhes do animal
    │
    ├── Missões
    │     └── Coleta de recompensa
    │
    ├── Melhorias
    │     └── Habitat selecionado
    │
    └── Configurações
          ├── Som
          ├── Cidade
          └── Reset de progresso
```

O fluxo principal é centrado na Tela Mundo, que funciona como o centro do jogo. As demais telas complementam a experiência e permitem controle do progresso.

---

## 7. Interface

### Interface geral
A aplicação usará uma estrutura visual simples, com:
- fundo colorido e natural para os biomas;
- botões maiores e fáceis de tocar;
- textos legíveis;
- área principal de jogo grande;
- elementos visuais suaves e não sobrecarregados.

### Componentes Android recomendados
- TextView: para moedas, cristais, produção, nomes de habitats e animais.
- ImageView: para fundo do mapa, imagens de animais, itens e produção visual.
- Button: para melhorar, coletar recompensa e confirmar ações.
- RecyclerView: para listas de habitats, animais e missões.
- CardView: para itens organizados e visualmente agradáveis.
- BottomNavigationView: para navegação entre telas principais.
- Toolbar: para títulos de tela e ações rápidas.
- ScrollView: para telas com muito conteúdo.
- Dialog / AlertDialog: para confirmar reset, exibir coleta offline e avisos.
- Spinner: para seleção da cidade usada pelo clima.
- Switch: para controle de som e efeitos.
- ProgressBar: para progresso de missão, carregamento e processos.

### Diretrizes visuais
- usar paleta com verdes, azuis e tons terrestres;
- manter contraste adequado;
- usar ícones simples para a navegação;
- priorizar legibilidade em telas pequenas;
- evitar excesso de texto em uma mesma tela.

---

## 8. Modelo de dados

O app precisará armazenar dados de jogador, habitats, animais, missões, conquistas e configurações. Para aplicação acadêmica, o modelo deve ser simples e funcional.

### 8.1 Entidade: Player

| Campo | Tipo | Obrigatório | Descrição |
| ----- | ---- | ----------- | --------- |
| id | int | Sim | Identificação do jogador |
| name | String | Sim | Nome do jogador |
| coins | long | Sim | Quantidade de moedas |
| crystals | int | Sim | Quantidade de cristais |
| level | int | Sim | Nível do jogador |
| totalProduction | long | Sim | Produção total por minuto |
| currentBiome | String | Sim | Bioma atual |
| lastSessionTimestamp | long | Sim | Data/hora da última sessão |
| unlockedBiomes | String | Sim | Biomas desbloqueados |

### 8.2 Entidade: Habitat

| Campo | Tipo | Obrigatório | Descrição |
| ----- | ---- | ----------- | --------- |
| id | int | Sim | Identificação do habitat |
| biome | String | Sim | Nome do bioma |
| name | String | Sim | Nome do habitat |
| level | int | Sim | Nível atual |
| baseProduction | long | Sim | Produção base |
| cost | long | Sim | Custo para melhorar |
| visualStage | int | Sim | Fase visual atual |
| unlocked | boolean | Sim | Se o habitat está disponível |

### 8.3 Entidade: Animal

| Campo | Tipo | Obrigatório | Descrição |
| ----- | ---- | ----------- | --------- |
| id | int | Sim | Identificação do animal |
| name | String | Sim | Nome do animal |
| biome | String | Sim | Bioma a que pertence |
| rarity | String | Sim | Comum, incomum, raro etc. |
| level | int | Sim | Nível da espécie |
| discovered | boolean | Sim | Se foi encontrado |
| quantity | int | Sim | Quantidade obtida |
| bonus | long | Sim | Bônus gerado |

### 8.4 Entidade: Mission

| Campo | Tipo | Obrigatório | Descrição |
| ----- | ---- | ----------- | --------- |
| id | int | Sim | Identificação da missão |
| title | String | Sim | Título |
| description | String | Sim | Descrição |
| progressCurrent | int | Sim | Progresso atual |
| progressTarget | int | Sim | Meta |
| rewardCoins | long | Sim | Recompensa em moedas |
| rewardCrystals | int | Sim | Recompensa em cristais |
| completed | boolean | Sim | Missão concluída |
| claimed | boolean | Sim | Recompensa coletada |

### 8.5 Entidade: Achievement

| Campo | Tipo | Obrigatório | Descrição |
| ----- | ---- | ----------- | --------- |
| id | int | Sim | Identificação |
| title | String | Sim | Nome da conquista |
| description | String | Sim | Descrição |
| unlocked | boolean | Sim | Se foi conquistada |
| rewardCoins | long | Sim | Recompensa |
| rewardCrystals | int | Sim | Recompensa em cristais |

### 8.6 Entidade: Settings

| Campo | Tipo | Obrigatório | Descrição |
| ----- | ---- | ----------- | --------- |
| musicEnabled | boolean | Sim | Som ativado |
| soundEnabled | boolean | Sim | Efeitos sonoros |
| selectedCity | String | Sim | Cidade usada para clima |
| theme | String | Sim | Tema visual |

### Relacionamentos
- Player possui vários habitats.
- Player possui vários animais.
- Player possui várias missões.
- Player possui várias conquistas.
- Habitat pertence a um bioma.
- Animal pertence a um bioma.

---

## 9. Armazenamento

### Estratégia recomendada
Para a primeira versão, a melhor escolha é combinar:
- Room para persistência estruturada;
- SharedPreferences para configurações simples;
- arquivos locais apenas quando necessário.

### Por que Room?
Room é a alternativa mais adequada para um projeto com dados organizados em tabelas e entidades relacionadas. Ele ajuda a manter o código mais limpo e evita manipulação manual de SQLite.

### Vantagens da solução escolhida
- organização por entidades;
- manutenção mais simples;
- suporte ao uso de LiveData/Room DAO;
- boa adaptação para um projeto acadêmico;
- facilita evoluções futuras.

### Exemplos de uso
- salvar estado do player;
- salvar habitats e níveis;
- salvar animais encontrados;
- salvar missões e conquistas;
- guardar configurações gerais.

### Armazenamento online
A consulta da API Open-Meteo deve ser feita em tempo real quando houver internet. Se ela falhar, o app usa dados padrão e segue funcionando sem quebrar.

---

## 10. Regras de negócio

1. O jogador começa com uma pequena área de floresta e recursos iniciais.
2. Cada habitat produz moedas automaticamente em intervalos definidos.
3. Melhorar um habitat aumenta sua produção e altera a aparência do cenário.
4. O jogador só pode melhorar um habitat se possuir moedas suficientes.
5. Alguns animais só aparecem após desbloquear o habitat ou o bioma correspondente.
6. Animais descobertos entram na coleção.
7. A produção total do bioma é a soma de todas as produções dos habitats.
8. A primeira versão terá 3 biomas: Floresta, Ilha Tropical e Região Polar.
9. O desbloqueio de biomas depende de requisitos como nível, missões concluidas ou animais descobertos.
10. Missões são concluídas automaticamente conforme o progresso do jogador.
11. Recompensas podem ser coletadas apenas quando a missão está concluída.
12. A produção offline terá limite máximo definido pelo jogo.
13. Se a API falhar, o app usa valores padrão do clima.
14. O progresso deve ser persistido localmente.
15. O reset de progresso deve exigir confirmação para evitar perda acidental.

---

## 11. Validações

| Campo/Ação | Regra | Mensagem |
| ---------- | ----- | -------- |
| Melhorar habitat | O jogador deve ter moedas suficientes | "Você não possui moedas suficientes." |
| Missão | Só pode coletar recompensa se estiver concluída | "Complete a missão antes de coletar a recompensa." |
| Animal desbloqueado | Não pode duplicar desbloqueio indevidamente | "Animal já encontrado." |
| Cidade do clima | Deve ser válida e não vazia | "Selecione uma cidade válida." |
| Reset de progresso | Deve exigir confirmação | "Deseja realmente reiniciar o progresso?" |
| Produção offline | Não pode ultrapassar limite máximo | "Sua produção offline foi limitada." |
| Nome do jogador | Não pode ficar vazio | "Digite um nome válido." |
| Banco de dados | Deve iniciar sem dados corrompidos | "Não foi possível carregar o progresso." |

---

## 12. Tratamento de erros

O aplicativo deve reagir com mensagens amigáveis e sem quebrar a execução.

### Cenários previstos
- falha na API de clima;
- falta de conexão com internet;
- banco de dados vazio;
- progresso corrompido;
- falta de moedas para melhoria;
- nome inválido;
- erro ao salvar dados.

### Estratégia
- usar try/catch em operações críticas;
- exibir Toast ou Dialog com mensagem clara;
- manter o app funcionando com valores padrão;
- não bloquear toda a navegação por um erro local;
- validar entradas antes de persistir dados;
- registrar falhas em log local para debug.

---

## 13. Recursos visuais

### 13.1 Recursos principais
- ícones de moedas, cristais, habitats e animais;
- fundo de biomas com temas naturais;
- elementos visuais para floresta, ilha tropical e região polar;
- ilustrações para pessoas e animais;
- imagens para eventos aleatórios.

### 13.2 Fontes e estilos
- usar fontes legíveis e de tamanho acessível;
- padronizar títulos e textos de botões;
- priorizar contraste e simplicidade.

### 13.3 Alternativas sem custo
- usar ícones do Material Design;
- criar fundos em gradientes e formas vetoriais simples;
- usar imagens públicas em domínio livre;
- criar ilustrações básicas em XML ou vetor;
- usar elementos de natureza estilizados em formas geométricas.

---

## 14. Estrutura do projeto Android

```text
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/wildlifekingdon/
│   │   │       ├── MainActivity.java
│   │   │       ├── MundoFragment.java
│   │   │       ├── ColecaoFragment.java
│   │   │       ├── MelhoriasFragment.java
│   │   │       ├── MissoesFragment.java
│   │   │       ├── ConfigFragment.java
│   │   │       ├── GameRepository.java
│   │   │       ├── GameViewModel.java
│   │   │       ├── AppDatabase.java
│   │   │       ├── Player.java
│   │   │       ├── Habitat.java
│   │   │       ├── Animal.java
│   │   │       ├── Mission.java
│   │   │       ├── Achievement.java
│   │   │       ├── EventManager.java
│   │   │       └── WeatherService.java
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── fragment_mundo.xml
│   │   │   │   ├── fragment_colecao.xml
│   │   │   │   ├── fragment_missoes.xml
│   │   │   │   ├── fragment_melhorias.xml
│   │   │   │   ├── fragment_config.xml
│   │   │   │   └── dialog_offline.xml
│   │   │   ├── drawable/
│   │   │   ├── mipmap/
│   │   │   ├── menu/
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   ├── colors.xml
│   │   │   │   └── themes.xml
│   │   │   └── xml/
│   │   │       └── network_security_config.xml
│   │   └── AndroidManifest.xml
│   └── androidTest/
│   └── test/
├── build.gradle
├── settings.gradle
├── gradle.properties
└── proguard-rules.pro
```

### Principais componentes
- MainActivity: responsável pela navegação e ciclo principal.
- MundoFragment: exibe o mapa e a lógica de produção.
- MelhoriasFragment: lista habitats e opções de upgrade.
- ColecaoFragment: exibe animais encontrados.
- MissoesFragment: lista objetivos do jogador.
- ConfigFragment: controla opções e preferências.
- GameRepository: centraliza acesso a dados e regras do jogo.
- AppDatabase: configuração do Room.
- EventManager: controla eventos interativos no mapa.
- WeatherService: consulta clima real.

---

## 15. Arquitetura

Para um projeto acadêmico, a melhor abordagem é uma arquitetura simples, com separação clara entre dados e interface.

### Estrutura sugerida
- UI: Activities e Fragments.
- ViewModel: expõe dados da UI e observa mudanças.
- Repository: centraliza regras e acesso aos dados.
- Room: persistência local.
- API externa: Open-Meteo para clima.

### Responsabilidades
- MainActivity: controla a navegação principal.
- MundoFragment: atualiza dados do mapa e interações do usuário.
- GameViewModel: conecta a UI com o repository.
- GameRepository: processa atualização de moedas, habitats, missão e coleta offline.
- AppDatabase: mantém as entidades e DAOs.

### Por que essa arquitetura?
Ela é simples, funcional e adequada para aprender desenvolvimento Android com Java. Não exige complexidade extra como Clean Architecture, DDD ou multiplas camadas de abstração. O foco principal está em aprender organização, navegação, persistência e lógica de jogo.

---

## 16. Plano de desenvolvimento em 4 aulas

### Aula 1 — Estrutura e interface
**Objetivo:** construir a base do app.

**Deve ser desenvolvido:**
- criação do projeto em Android Studio;
- configuração do Gradle e dependências;
- criação das Activities e Fragments;
- layout da tela principal;
- navegação inferior;
- tela do mundo com elementos básicos;
- recursos iniciais de moedas e produção.

**Resultado esperado:**
- app abrindo com tela inicial e navegação básica.

### Aula 2 — Funcionalidades
**Objetivo:** implementar a lógica do jogo.

**Deve ser desenvolvido:**
- habitat e produção automática;
- melhorias de habitat;
- sistema de moedas e cristais;
- eventos simples;
- coleta e atualização de dados;
- progressão visual do mapa.

**Resultado esperado:**
- jogador consegue evoluir o mundo e gerar recursos.

### Aula 3 — Dados e recursos
**Objetivo:** persistir e complementar o jogo.

**Deve ser desenvolvido:**
- Room e modelos de dados;
- salvamento local;
- produção offline;
- missões com recompensa;
- animais e coleção;
- API de clima com fallback.

**Resultado esperado:**
- o jogo funciona mesmo após fechar o app.

### Aula 4 — Finalização
**Objetivo:** apresentação e refinamento.

**Deve ser desenvolvido:**
- ajustes de interface;
- testes manuais;
- correções de bugs;
- melhor organização visual;
- documentação e checklist final;
- preparação para apresentação.

**Resultado esperado:**
- protótipo funcional e apresentável.

---

## 17. Prompts para o GitHub Copilot

### Prompt 1 — Configuração inicial
**Objetivo:** criar a base do projeto Android.

**Arquivos envolvidos:**
- build.gradle
- settings.gradle
- AndroidManifest.xml
- activity_main.xml

**Implementação esperada:**
- criar projeto com Java, Material Design e navegação inferior.

**Regras:**
- usar Java e XML;
- manter estrutura simples;
- configurar projeto para Android Studio.

**Comportamento esperado:**
- app abre com uma tela principal e BottomNavigationView.

### Prompt 2 — Tela Mundo
**Objetivo:** criar a tela principal do jogo.

**Arquivos envolvidos:**
- MundoFragment.java
- fragment_mundo.xml

**Implementação esperada:**
- fundo do mapa, área de jogo, painel de recursos e botões de habitat.

**Regras:**
- interface visualmente clara;
- manter layout responsivo.

**Comportamento esperado:**
- o usuário vê o bioma e elementos interativos.

### Prompt 3 — Sistema de recursos
**Objetivo:** criar lógica de moedas e produção.

**Arquivos envolvidos:**
- GameRepository.java
- GameViewModel.java
- Player.java

**Implementação esperada:**
- gerar moedas por intervalo;
- calcular produção total;
- atualizar dados em tempo real.

**Regras:**
- não usar lógica complexa;
- manter valores simples e fáceis de testar.

**Comportamento esperado:**
- moedas aumentam automaticamente sem ação manual.

### Prompt 4 — Melhorias de habitat
**Objetivo:** permitir evolução dos habitats.

**Arquivos envolvidos:**
- MelhoriasFragment.java
- Habitat.java
- fragment_melhorias.xml

**Implementação esperada:**
- exibir cada habitat com nível e custo;
- aplicar upgrade ao clicar no botão.

**Regras:**
- verificar saldo antes de melhorar;
- atualizar produção e visual.

**Comportamento esperado:**
- o habitat melhora e aumenta a geração de moedas.

### Prompt 5 — Coleção de animais
**Objetivo:** implementar a tela de coleção.

**Arquivos envolvidos:**
- ColecaoFragment.java
- Animal.java
- fragment_colecao.xml

**Implementação esperada:**
- listar animais com raridade e status.
- mostrar animais bloqueados e descobertos.

**Regras:**
- usar RecyclerView;
- manter layout sem excesso de detalhes.

**Comportamento esperado:**
- a coleção mostra progresso corretamente.

### Prompt 6 — Missões
**Objetivo:** criar o sistema de objetivos.

**Arquivos envolvidos:**
- MissoesFragment.java
- Mission.java
- fragment_missoes.xml

**Implementação esperada:**
- criar missões com progresso e recompensa;
- permitir coleta do prêmio.

**Regras:**
- missão só é coletável quando concluída;
- progresso deve ser visível.

**Comportamento esperado:**
- a lista de missões atualiza conforme o usuário progride.

### Prompt 7 — Persistência
**Objetivo:** salvar progresso localmente.

**Arquivos envolvidos:**
- AppDatabase.java
- PlayerDao.java
- HabitatDao.java
- AnimalDao.java
- MissionDao.java

**Implementação esperada:**
- criar entidades e DAOs no Room;
- salvar e recuperar progresso.

**Regras:**
- usar Room para dados estruturados;
- manter a lógica simples.

**Comportamento esperado:**
- ao fechar e abrir o app, o estado é preservado.

### Prompt 8 — Produção offline
**Objetivo:** implementar coleta de recursos após ausência.

**Arquivos envolvidos:**
- GameRepository.java
- dialog_offline.xml
- OfflineDialogFragment.java

**Implementação esperada:**
- calcular tempo fora do app;
- mostrar valor acumulado;
- permitir coleta com limite máximo.

**Regras:**
- manter cálculo simples e seguro.

**Comportamento esperado:**
- quando o jogador retorna, recebe um resumo do progresso offline.

### Prompt 9 — Clima externo
**Objetivo:** integrar Open-Meteo.

**Arquivos envolvidos:**
- WeatherService.java
- ConfigFragment.java
- AndroidManifest.xml

**Implementação esperada:**
- consultar clima da cidade selecionada;
- aplicar efeitos visuais e bônus de produção.

**Regras:**
- se falhar, usar clima padrão;
- não bloquear o jogo.

**Comportamento esperado:**
- app continua funcionando sem internet.

### Prompt 10 — Finalização e polish
**Objetivo:** preparar apresentação final.

**Arquivos envolvidos:**
- todos os layouts e classes principais.

**Implementação esperada:**
- corrigir detalhes visuais e de navegação;
- ajustar textos e recursos;
- validar telas principais.

**Regras:**
- foco em funcionalidade e apresentação;
- não adicionar arquitetura desnecessária.

**Comportamento esperado:**
- app está funcional, estável e pronto para demonstração.

---

## 18. Testes

### Testes de telas
- abrir app e verificar splash/carregamento;
- verificar tela mundo;
- verificar tela animais;
- verificar tela missões;
- verificar tela melhorias;
- verificar tela configurações.

### Testes de botões
- botão de melhorar habitat;
- botão de coletar recompensa;
- botão de coletar produção offline;
- botão de reset de progresso;
- botão de navegação inferior.

### Testes de campos
- cidade selecionada;
- opções de som;
- nome do jogador (se existir);
- campos de diálogo.

### Testes de regras
- impedir melhoria sem saldo;
- impedir coleta de recompensa antes da conclusão;
- limitar produção offline;
- validar progresso de missão.

### Testes de dados
- salvar progresso após melhoria;
- recuperar dados ao reiniciar app;
- verificar animais descobertos e raridade;
- verificar que os habitats persistem por nível.

### Testes de situações inválidas
- sem internet;
- API indisponível;
- banco vazio;
- dados corrompidos;
- reset sem confirmação.

### Testes de navegação
- navegação entre telas;
- retorno ao mundo após ação;
- fluxo de missões e estratégias de upgrade;
- manutenção do estado ao alternar telas.

---

## 19. Checklist final

- [ ] Projeto criado no Android Studio.
- [ ] App compila sem erros.
- [ ] Tela principal funciona.
- [ ] Navegação entre telas funciona.
- [ ] Produção automática está ativa.
- [ ] Melhorias de habitat funcionam.
- [ ] Sistema de moedas e cristais funciona.
- [ ] Coleção de animais está visível.
- [ ] Missões e recompensas funcionam.
- [ ] Exportação e salvamento locais funcionam.
- [ ] Produção offline está funcionando.
- [ ] API do clima falha sem quebrar o app.
- [ ] Configurações persistem corretamente.
- [ ] Interface está visualmente aceitável.
- [ ] App está pronto para apresentação.

---

## 20. Possíveis melhorias

- adicionar mais biomas e habitats;
- expandir o sistema de animais raros;
- criar animações de personagem e animais;
- implementar sistema de eventos temporários;
- melhorar a identidade visual de cada bioma;
- evoluir a coleção com filtros e detalhes;
- criar sistema de prestígio e reinício;
- incluir missões diárias;
- adicionar loja de decorações;
- integrar efeitos sonoros e música real.

---

## Conclusão

Wildlife Kingdon é uma proposta forte para um projeto acadêmico em Android por combinar mecânicas simples, apresentação visual agradável e progressão clara. A ideia original foi preservada, com uma expansão inteligente para tornar o jogo mais completo e interessante enquanto mantém o escopo viável para quatro aulas.

Com arquitetura simples, uso de Java + XML, Room para armazenamento local, navegação por telas e integração com API externa, o aluno terá um projeto funcional, apresentável e com potencial de evolução ao longo do curso.

A proposta está adequada para ser implementada com apoio de GitHub Copilot, sem exigir uma solução excessivamente complexa, mas com capacidade de demonstrar conhecimento em programação Android, persistência, interface e lógica de jogos idle.
