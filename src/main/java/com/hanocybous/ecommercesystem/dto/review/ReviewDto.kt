package com.hanocybous.ecommercesystem.dto.review

import java.time.LocalDateTime

data class ReviewDto(
    val id: Long,
    val title: String,
    val rating: Int,
    val productId: Long,
    val userId: Long,
    val comment: String,
    val reviewDate: LocalDateTime
) {

    init {
        require(title.isNotBlank()) { "Title must not be blank" }
        require(title.length <= 100) { "Title must not be longer than 100 characters" }
        require(rating in 1..5) { "Rating must be between 1 and 5" }
        require(comment.isNotBlank()) { "Comment must not be blank" }
        require(comment.length <= 1000) { "Comment must not be longer than 1000 characters" }
    }

    override fun toString(): String {
        return "ReviewDto(id=$id, " +
                "title='$title', " +
                "rating=$rating, " +
                "productId=$productId, " +
                "userId=$userId, " +
                "comment='$comment', " +
                "reviewDate=$reviewDate)"
    }
}
