package com.justai.jaicf.template.scenario

import com.justai.jaicf.channel.jaicp.reactions.switchToOperator
import com.justai.jaicf.model.scenario.Scenario
import com.justai.jaicf.reactions.jaicp.jaicpAsync

object MainScenario : Scenario() {

    init {
        state("Start") {
            globalActivators {
                regex("/start")
            }
            action {
                reactions.say("Начнём!")
            }
        }

        state("Hello") {
            activators {
                intent("Hello")
            }

            action {
                reactions.say("Привет!")
            }
        }

        state("Operator") {
            activators {
                regex("оператор")
                regex("operator")
            }
            action {
                reactions.jaicpAsync?.switchToOperator("Человек хочет задать вопрос")
            }
        }


        fallback {
            reactions.say("Мне пока нечего сказать...")
        }
    }
}