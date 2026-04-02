package ru.practicum.mainservicekitt.request;

import lombok.NoArgsConstructor;
import org.apache.catalina.connector.Request;

import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class RequestMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static RequestDto toRequestDto(Request request) {
        if (request == null) {
            return null;
        }
        return RequestDto.builder()
                .id(request.getId())
                .event(request.getEvent().getId())
                .requester(request.getRequester().getId())
                .status(request.getStatus().toString())
                .created(request.getCreated().format(FORMATTER))
                .build();
    }
}
