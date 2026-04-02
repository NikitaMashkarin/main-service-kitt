package ru.practicum.mainservicekitt.request;

import java.util.List;

public interface RequestService {

    RequestDto createParticipationRequest(Long userId, Long eventId);

    RequestDto cancelParticipationRequest(Long userId, Long requestId);

    List<RequestDto> getParticipationRequests(Long userId);

    List<RequestDto> getParticipationRequestsForUserEvent(Long userId, Long eventId);

    EventRequestStatusUpdateResultDto changeParticipationRequestsStatus(Long userId, Long eventId,
                                                                        EventRequestStatusUpdateRequestDto eventRequestStatusUpdateRequest);
}