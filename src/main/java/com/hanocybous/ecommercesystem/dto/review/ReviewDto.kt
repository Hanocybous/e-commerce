package com.hanocybous.ecommercesystem.dto.review;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

public record ReviewDto(
        Long id,
        String title,
        Integer rating,
        Long productId,
        Long userId,
        String comment,
        LocalDateTime reviewDate) {

    public ReviewDto {
        Objects.requireNonNull(id);
        Objects.requireNonNull(title);
        Objects.requireNonNull(rating);
        Objects.requireNonNull(productId);
        Objects.requireNonNull(userId);
        Objects.requireNonNull(comment);
        Objects.requireNonNull(reviewDate);

        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title must not be blank");
        }
        if (comment.isBlank()) {
            throw new IllegalArgumentException("Comment must not be blank");
        }
        if (title.length() > 100) {
            throw new IllegalArgumentException("Title must not be longer than 100 characters");
        }
        if (comment.length() > 1000) {
            throw new IllegalArgumentException("Comment must not be longer than 1000 characters");
        }

    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "ReviewDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", productId=" + productId +
                ", userId=" + userId +
                ", comment='" + comment + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }

}
