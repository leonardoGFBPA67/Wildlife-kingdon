Wildlife Kingdon - Android (Java)

Descrição
---------
Projeto educativo: jogo idle/tycoon onde o jogador desenvolve habitats, coleciona animais e vê evolução visual.

Como rodar (requisições)
-------------------------
Pré-requisitos:
- Android Studio com SDK compatível (compileSdk 37)
- Java 11
- Emulador Android ou dispositivo conectado (USB debug)

Passos:
1. Abrir o projeto em Android Studio
2. Aguarde o Gradle sincronizar
3. Build: Run > Build APK(s) ou execute no terminal: ./gradlew assembleDebug
4. Para instalar em dispositivo/emulador: ./gradlew installDebug

Observações:
- Dependências: Room, Lifecycle, RecyclerView, Material
- Assets placeholders foram adicionados em res/drawable
- DB Room é utilizado; operações são realizadas em background (Executor)
- Para testes rápidos, use um emulador API 31+ e execute installDebug

Estrutura relevante
-------------------
- app/src/main/java/com/example/wildlifekingdon
  - MainActivity.java
  - MundoFragment.java
  - ColecaoFragment.java
  - MelhoriasFragment.java
  - MissoesFragment.java
  - ConfigFragment.java
  - data: GameRepository, AppDatabase, DAOs
  - adapters: AnimalAdapter, HabitatAdapter, MissionAdapter
  - EventManager, OfflineDialogFragment

Próximos passos recomendados
---------------------------
- Melhorar UI/UX com imagens reais e animações
- Ajustar balanceamento (custos/prod)
- Adicionar testes unitários e instrumented tests

Créditos: Projeto gerado com suporte do GitHub Copilot e assistente.