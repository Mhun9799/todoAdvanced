package com.teamsparta.todoadvanced.domain.todocards.repository

import com.querydsl.core.BooleanBuilder
import com.teamsparta.todoadvanced.QueryDslSupport
import com.teamsparta.todoadvanced.domain.comments.model.QComment
import com.teamsparta.todoadvanced.domain.todocards.model.QTodoCard
import com.teamsparta.todoadvanced.domain.todocards.model.TodoCard
import com.teamsparta.todoadvanced.domain.users.model.QUser
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class TodoCardRepositoryImpl: CustomTodoCardRepository, QueryDslSupport() {
    private val todoCard = QTodoCard.todoCard
    private val reply = QComment.comment
    private val user = QUser.user

    override fun findAllByOrderByCreatedAtDesc(): List<TodoCard> {
        return queryFactory.selectFrom(todoCard)
            .leftJoin(todoCard.comments, reply)
            .fetchJoin()
            .leftJoin(todoCard.user, user)
            .fetchJoin()
            .orderBy(todoCard.createdAt.desc())
            .fetch()
    }

    override fun findAllByOrderByCreatedAtAsc(): List<TodoCard> {
        return queryFactory.selectFrom(todoCard)
            .leftJoin(todoCard.comments, reply)
            .fetchJoin()
            .leftJoin(todoCard.user, user)
            .fetchJoin()
            .orderBy(todoCard.createdAt.asc())
            .fetch()
    }

    override fun findAllByAuthorId(authorId: Long): List<TodoCard> {
        return queryFactory.selectFrom(todoCard)
            .leftJoin(todoCard.comments, reply)
            .fetchJoin()
            .leftJoin(todoCard.user, user)
            .fetchJoin()
            .where(todoCard.user.id.eq(authorId))
            .fetch()
    }

    override fun findByPageableAndStatus(pageable: Pageable, title: String?): Page<TodoCard> {
        val whereClause = BooleanBuilder()

        title?.let { whereClause.and(todoCard.title.eq(title)) }


        val totalCount = queryFactory.select(todoCard.count()).from(todoCard).where(whereClause).fetchOne() ?: 0L


        val query = queryFactory.selectFrom(todoCard)
            .where(whereClause)
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())


        if (pageable.sort.isSorted) {

            when(pageable.sort.first()?.property) {
                "id" -> query.orderBy(todoCard.id.asc())
                "title" -> query.orderBy(todoCard.title.asc())
                else -> query.orderBy(todoCard.id.asc())
            }
        } else {
            query.orderBy(todoCard.id.asc())
        }


        val contents = query.fetch()


        return PageImpl(contents, pageable, totalCount)
    }
}