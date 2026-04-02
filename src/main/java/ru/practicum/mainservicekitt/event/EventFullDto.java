package ru.practicum.mainservicekitt.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.mainservicekitt.category.CategoryDto;
import ru.practicum.mainservicekitt.location.LocationDto;
import ru.practicum.mainservicekitt.user.UserShortDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventFullDto {

    private Long id;
    private String title;
    private String annotation;
    private CategoryDto category;
    private String description;
    private String eventDate;
    private LocationDto location;
    private boolean paid;
    private int participantLimit;
    private boolean requestModeration;
    private long confirmedRequests;
    private String createdOn;
    private String publishedOn;
    private UserShortDto initiator;
    private String state;
    private long views;
}
