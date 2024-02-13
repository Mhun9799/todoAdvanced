package com.teamsparta.todoadvanced.domain.todocards.repository

import com.teamsparta.todoadvanced.QueryDslSupport
import com.teamsparta.todoadvanced.domain.todocards.model.QTodoCard
import com.teamsparta.todoadvanced.domain.todocards.model.TodoCard
import com.teamsparta.todoadvanced.domain.todocards.model.TodoSearchParam
import org.springframework.stereotype.Repository

@Repository
class TodoRepositoryQuery : QueryDslSupport(){

    private val todo = QTodoCard.todoCard

    fun search(param: TodoSearchParam): List<TodoCard>{
        return queryFactory
            .select(todo)
            .from(todo)
            .where(
                todo.title.contains(param.keywords)
            ).fetch()
    }
}