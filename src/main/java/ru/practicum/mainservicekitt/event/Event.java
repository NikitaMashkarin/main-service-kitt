package ru.practicum.mainservicekitt.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, length = 2000)
    private String annotation;

    @Column(name = "category_id", nullable = false)
    private Long category;

    @Column(nullable = false, length = 7000)
    private String description;

    @Column(nullable = false, name = "event_date")
    private LocalDateTime eventDate;

    @Column(name = "location_id", nullable = false)
    private Long location;

    @Column(nullable = false)
    private boolean paid = false;

    @Column(name = "participant_limit", nullable = false)
    private int participantLimit = 0;

    @Column(name = "request_moderation", nullable = false)
    private boolean requestModeration = true;

    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "published_on")
    private LocalDateTime publishedOn;

    @Column(name = "initiator_id", nullable = false)
    private Long initiator;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventState state;

    @Column(nullable = false, columnDefinition = "bigint default 0")
    private Long views = 0L;
}
