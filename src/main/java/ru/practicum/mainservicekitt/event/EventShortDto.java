package ru.practicum.mainservicekitt.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.mainservicekitt.category.CategoryDto;
import ru.practicum.mainservicekitt.user.UserShortDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventShortDto {
    private Long id;
    private String title;
    private String annotation;
    private CategoryDto category;
    private String eventDate;
    private long confirmedRequests;
    private UserShortDto initiator;
    private boolean paid;
    private long views;
    private int participantLimit;
}