package com.teamsparta.todoadvanced.domain.comments.model

import com.teamsparta.todoadvanced.domain.todocards.model.TodoCard
import jakarta.persistence.*

@Entity
@Table(name = "comment")
class Comment(
    @Column(name = "content", nullable = false)
    var content: String,

    @Column(name = "author_name", nullable = false)
    val authorName: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    var todoCard: TodoCard

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null


       /* fun changeContent(content: String) {
            this.content = content
        }

        fun checkAuthentication(authorName: String, password: String) {
            if (authorName != this.authorName) {
                throw Exception("wrong user")
            }
            if (password != this.password) {
                throw Exception("wrong password")
            }
        }*/


}


