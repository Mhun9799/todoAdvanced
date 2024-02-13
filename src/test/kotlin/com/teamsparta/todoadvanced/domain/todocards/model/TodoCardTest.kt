package com.teamsparta.todoadvanced.domain.todocards.model

import com.teamsparta.todoadvanced.domain.comments.model.Comment
import com.teamsparta.todoadvanced.domain.users.model.User
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class TodoCardTest : BehaviorSpec({
    Given("information of todo card") {
        val id = null
        val title = "title"
        val content = "content"
        val username = "testUser" // User 객체를 생성하기 위한 username
        val password = "testPassword" // User 객체를 생성하기 위한 password
        val user = User(username = username, password = password) // User 객체 생성
        val comments = mutableListOf<Comment>()

        When("execute TodoCard constructor") {
            val todoCard = TodoCard(
                id = id,
                title = title,
                content = content,
                user = user,
                comments = comments
            )

            Then("the properties should be set correctly") {
                todoCard.title shouldBe title
                todoCard.content shouldBe content
                todoCard.user shouldBe user
                todoCard.comments shouldBe comments
            }
        }

        And("execute complete method") {
            val todoCard = TodoCard(
                id = id,
                title = title,
                content = content,
                user = user,
                comments = comments
            )
            todoCard.complete()

            Then("isCompleted should be true") {
                todoCard.isCompleted shouldBe true
            }
        }
    }
})
