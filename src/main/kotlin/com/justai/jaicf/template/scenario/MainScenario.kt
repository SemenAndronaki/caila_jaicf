package com.justai.jaicf.template.scenario

import com.justai.jaicf.model.scenario.Scenario
import com.justai.jaicf.activator.caila.caila

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

        state("Bye") {
            activators {
                intent("Bye")
            }

            action {
                reactions.say("Скоро увидимся!")
            }
        }
        
        state("Delivery") {
            activators {
                intent("Delivery")
            }

            action {
                reactions.say(activator.caila?.topIntent?.answer.toString())
            }
        }

        fallback {
            reactions.say("Мне пока нечего сказать...")
        }
    }
}