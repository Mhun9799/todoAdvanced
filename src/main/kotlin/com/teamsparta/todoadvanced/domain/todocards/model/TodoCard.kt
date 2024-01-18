package com.teamsparta.todoadvanced.domain.todocards.model

import jakarta.persistence.*


@Entity
class TodoCard(
    @Column
    var title: String,
    @Column
    var content: String,
    //val comments: List<Comment> = emptyList(),
    @Column
    var authorName: String, // User로 교체예정

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "is_completed")
    private var _isCompleted: Boolean = false

    val isCompleted: Boolean
        get() = _isCompleted

    fun complete(){
        _isCompleted = true
    }
}