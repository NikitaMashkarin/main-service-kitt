package ru.practicum.mainservicekitt.event;

import lombok.NoArgsConstructor;
import ru.practicum.mainservicekitt.request.Request;
import ru.practicum.mainservicekitt.request.RequestStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static ru.practicum.mainservicekitt.category.CategoryMapper.toCategoryDto;
import static ru.practicum.mainservicekitt.location.LocationMapper.toLocation;
import static ru.practicum.mainservicekitt.location.LocationMapper.toLocationDto;
import static ru.practicum.mainservicekitt.user.UserMapper.toUserShortDto;

@NoArgsConstructor
public class EventMapper {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static Event toEvent(NewEventDto newEventDto) {
        return Event.builder()
                .title(newEventDto.getTitle())
                .annotation(newEventDto.getAnnotation())
                .description(newEventDto.getDescription())
                .eventDate(LocalDateTime.parse(newEventDto.getEventDate(), formatter))
                .location(toLocation(newEventDto.getLocation()))
                .paid(newEventDto.isPaid())
                .participantLimit(newEventDto.getParticipantLimit())
                .requestModeration(newEventDto.isRequestModeration())
                .build();
    }

    public static EventFullDto toEventFullDto(Event event) {
        return EventFullDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .annotation(event.getAnnotation())
                .category(toCategoryDto(event.getCategory()))
                .description(event.getDescription())
                .eventDate(event.getEventDate().format(formatter))
                .location(toLocationDto(event.getLocation()))
                .paid(event.isPaid())
                .participantLimit(event.getParticipantLimit())
                .requestModeration(event.isRequestModeration())
                .confirmedRequests(countConfirmedRequests(event.getRequests()))
                .createdOn(event.getCreatedOn().format(formatter))
                .publishedOn(event.getPublishedOn() != null ? event.getPublishedOn().format(formatter) : null)
                .initiator(toUserShortDto(event.getInitiator()))
                .state(event.getState().toString())
                .views(event.getViews())
                .build();
    }

    public static EventShortDto toEventShortDto(Event event) {
        return EventShortDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .annotation(event.getAnnotation())
                .category(toCategoryDto(event.getCategory()))
                .eventDate(event.getEventDate().format(formatter))
                .confirmedRequests(countConfirmedRequests(event.getRequests()))
                .initiator(toUserShortDto(event.getInitiator()))
                .paid(event.isPaid())
                .views(event.getViews())
                .build();
    }

    public static long countConfirmedRequests(List<Request> requests) {
        return requests != null
                ? requests.stream().filter(r -> r.getStatus() == RequestStatus.CONFIRMED).count()
                : 0;
    }
}
