package com.teamsparta.todoadvanced.domain.posts.model

import jakarta.persistence.*


@Entity
class TodoCard(
    @Column
    val title: String,
    @Column
    val content: String,
    //val comments: List<Comment> = emptyList(),
    @Column
    val authorName: String, // User로 교체예정

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