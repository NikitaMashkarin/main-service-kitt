package ru.practicum.mainservicekitt.comments;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false, length = 512)
    private String text;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    private Long authorId;

    private Long eventId;
}
