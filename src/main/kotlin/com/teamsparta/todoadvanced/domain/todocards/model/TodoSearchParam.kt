package com.teamsparta.todoadvanced.domain.todocards.model

data class TodoSearchParam(
    val keywords : String
){
    companion object{
        fun toParam(title: String):TodoSearchParam{
            return TodoSearchParam(title)
        }
    }
}
