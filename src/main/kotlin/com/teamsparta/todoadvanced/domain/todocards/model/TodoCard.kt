package com.teamsparta.todoadvanced.domain.todocards.model

import com.teamsparta.todoadvanced.domain.comments.model.Comment
import com.teamsparta.todoadvanced.domain.users.model.User
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.time.ZonedDateTime


@Entity
@Table(name = "todo_card")
@EntityListeners(AuditingEntityListener::class)
class TodoCard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "title", nullable = false)
    var title: String,
    @Column(name = "content", nullable = false)
    var content: String,
    @CreatedDate
    @Column(name = "created_at")
    var createdDate: LocalDateTime? = null,
    @OneToMany(
        mappedBy = "todoCard",
        fetch = FetchType.LAZY
    )
    var comments: MutableList<Comment> = mutableListOf(),
    @ManyToOne
    @JoinColumn(name = "author_name", nullable = false)
    var user: User,

    @CreatedDate
    @Column(updatable = false)
    val createdAt: ZonedDateTime = ZonedDateTime.now()

) {


    @Column(name = "is_completed")
    private var _isCompleted: Boolean = false

    val isCompleted: Boolean
        get() = _isCompleted

    fun complete() {
        _isCompleted = true
    }
}