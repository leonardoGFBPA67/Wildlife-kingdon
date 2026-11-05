CHANGELOG & INSTRUÇÕES DE APRESENTAÇÃO

Versão atual: 0.1 (versão acadêmica)

APK
---
app-debug.apk: app/build/outputs/apk/debug/app-debug.apk

Como instalar (local)
---------------------
1. Conecte um dispositivo Android com depuração USB ativada, ou inicie um emulador.
2. No terminal do projeto execute:
   ./gradlew installDebug
   ou em Windows PowerShell:
   .\gradlew.bat installDebug
3. Abra o app "Wildlife Kingdon" no dispositivo.

Teste rápido (fluxo de apresentação)
-----------------------------------
1. Ao abrir, se houver tempo ausente, aparece o diálogo "Enquanto você estava fora..." com produção acumulada. Pressione COLETAR.
2. Tela Mundo: exibe moedas, cristais e produção/min. Observe o cenário com camadas.
3. Abra Melhorias: pressione MELHORAR em um habitat para aumentar o nível (se tiver moedas).
4. Abra Coleção: veja animais (silhuetas para não descobertos).
5. Abra Missões: veja tarefas e colete recompensas quando completar.
6. Eventos aleatórios (balão/estrela/visitante) aparecem — toque para coletar bônus.

Arquivos principais
-------------------
- MainActivity.java: host da navegação e startup (offline dialog)
- MundoFragment.java: cenário, indicadores, coletor
- ColecaoFragment.java, MelhoriasFragment.java, MissoesFragment.java, ConfigFragment.java
- AppDatabase.java, DAO, Entities (Room)
- GameRepository.java: camada de dados (background)
- GameViewModel.java: LiveData e observers
- EventManager.java: eventos aleatórios

Modelo visual (mockup)
----------------------
Mundo (Tela principal)

+-------------------------------------------------------------+
| Toolbar: Wildlife Kingdon     🪙  1200   💎  5   +850/min      |
+-------------------------------------------------------------+
|                                                       🌲     |
|    [bg layer: trees]                                     🐇   |
|    [bg layer: decorations]                                 |
|                                                         ☁️  |
|                                                         🎈  |
+-------------------------------------------------------------+
| BottomNav: Mundo | Animais | Missões | Melhorias | Config   |
+-------------------------------------------------------------+

Melhorias (lista)

+------------------------+
| Lago — Nível 1         |
| Produção: 1 / 3s       |
| Custo: 100    [MELHORAR] |
+------------------------+
| Bosque — Nível 1       |
| ...                    |
+------------------------+

Coleção (RecyclerView)

[ Card ] Coelho — Comum • Nível 1
[ Card ] Esquilo — ? • Nível 1
[ Card ] Cervo — Silhueta (não descoberto)

Missões

- Melhore o Lago para nível 5 — Recompensa: 500 coins
- Descubra 3 animais — Recompensa: 200 coins + 10 crystals

Observações finais
------------------
- Strings foram movidas para res/values/strings.xml para facilitar traduções.
- Assets placeholders foram adicionados. Para melhor apresentação, substitua por ilustrações do projeto (Kenney, OpenGameArt, etc.).
- Para publicação, ajustar assinatura e otimizar imagens (WebP) se desejar.

Precisa que eu execute ./gradlew installDebug agora? Se sim, conecte o emulador/dispositivo e diga "instalar agora". Caso contrário, prossigo com otimização de imagens e conversão para WebP.