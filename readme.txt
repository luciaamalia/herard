# Herard – Gestão de Hábitos & Rotinas Inteligentes. </h1>

##
Permite que usuários cadastrem hábitos, metas e rotinas.
Exemplo: “Treinar 3x por semana”, “Ler 20 páginas por dia”.
##


## Estamos na versão 1.0

A herard-ms é uma API de habit tracker onde o usuário se cadastra, cria hábitos com uma meta de dias (ex: 30 dias de leitura), registra diariamente se cumpriu ou não o hábito e, quando completa a meta definida, ganha um troféu ligado àquele hábito.
A API expõe endpoints para: gerenciar usuários, CRUD de hábitos, registrar check-ins diários, consultar o progresso (quantos dias feitos x meta) e registrar/consultar troféus conquistados.

Regras de negócio principais

Um User pode ter vários Habit.

Cada Habit tem uma meta targetDays > 0 e pertence a apenas um User.

Cada dia que o usuário marca o hábito como feito gera um HabitLog (máx. 1 log por dia por hábito).

A quantidade de HabitLog.completed = true de um hábito é usada para comparar com targetDays.

Ao atingir a meta (diasConcluidos >= targetDays) é criado um Trophy para aquele usuário e hábito (um troféu por meta/hábito).


+-----------------------------+
|           User              |
+-----------------------------+
| - id: UUID                  |
| - name: String              |
| - email: String             |
| - createdAt: LocalDateTime  |
+-----------------------------+
| +getHabits()                |
+-----------------------------+
             1
             |
             | *
+-----------------------------+
|           Habit             |
+-----------------------------+
| - id: UUID                  |
| - user: User                |
| - name: String              |
| - description: String       |
| - targetDays: int           |  // meta (ex: 30 dias)
| - createdAt: LocalDateTime  |
| - active: boolean           |
+-----------------------------+
| +addLog(date)               |
| +getProgress(): int         |  // dias concluídos
+-----------------------------+
             1
             |
             | *
+-----------------------------+
|          HabitLog           |
+-----------------------------+
| - id: UUID                  |
| - habit: Habit              |
| - date: LocalDate           |
| - completed: boolean        |
+-----------------------------+
| // regra: 1 log por dia     |
+-----------------------------+

User 1 ----- * Trophy
Habit 0..1 - * Trophy

+-----------------------------+
|           Trophy            |
+-----------------------------+
| - id: UUID                  |
| - user: User                |
| - habit: Habit              |
| - name: String              | // ex: "30 dias de leitura"
| - earnedAt: LocalDateTime   |
+-----------------------------+
