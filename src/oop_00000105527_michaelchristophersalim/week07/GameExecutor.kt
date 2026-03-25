package oop_00000105527_michaelchristophersalim.week07

fun processEvent(event: BattleState) {
    when (event) {

        is BattleState.MonsterEncounter -> {
            println("Monster muncul: ${event.monsterName}! Siap bertarung!")
        }

        is BattleState.LootDropped -> {
            val (name, _, rarity) = event.item  // destructuring
            println("Loot didapat: $name dengan rarity $rarity")
        }

        is BattleState.GameOver -> {
            println("Game Over! Alasan: ${event.reason}")
        }

        BattleState.SafeZone -> {
            println("Kamu berada di Safe Zone. Aman sejenak.")
        }
    }
}