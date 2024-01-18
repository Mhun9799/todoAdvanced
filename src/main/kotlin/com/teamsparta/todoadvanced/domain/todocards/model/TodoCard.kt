package com.teamsparta.todoadvanced.domain.todocards.model

import com.teamsparta.todoadvanced.domain.comments.model.Comment
import jakarta.persistence.*


@Entity
@Table(name = "todo_card")
class TodoCard(
    @Column(name = "title", nullable = false)
    var title: String,
    @Column(name = "content", nullable = false)
    var content: String,
    @OneToMany(
        mappedBy = "todoCard",
        fetch = FetchType.LAZY
    )
    var comments: MutableList<Comment> = mutableListOf(),
    @Column(name = "author_name", nullable = false)
    var authorName: String, // User로 교체예정

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "is_completed")
    private var _isCompleted: Boolean = false

    val isCompleted: Boolean
        get() = _isCompleted

    fun complete() {
        _isCompleted = true
    }
}