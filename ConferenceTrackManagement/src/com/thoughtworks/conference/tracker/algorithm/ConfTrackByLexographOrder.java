package com.thoughtworks.conference.tracker.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.thoughtworks.conference.tracker.constants.ConfTrackerConstants;
import com.thoughtworks.conference.tracker.dto.Session;
import com.thoughtworks.conference.tracker.helper.TimeSlotsDTO;

public class ConfTrackByLexographOrder implements ConfTrackAlgoIntf {

	@Override
	public List<String> prepareConferenceTrack(List<Session> sessions, List<TimeSlotsDTO> availableTimeSlots) {
		List<String> finalConfTrack = new ArrayList<>();
		Collections.sort(sessions, new ConfTrackByLexographOrderComparator());
		addSessionsToTrack(sessions, availableTimeSlots, finalConfTrack);
		return finalConfTrack;
	}
	
	private void addSessionsToTrack(List<Session> sessions, List<TimeSlotsDTO> availableTimeSlots, List<String> finalConfTrack) {
		int index = 0;
		int presentSlotStartTime=0;
		
		for (TimeSlotsDTO presentTimeSlot : availableTimeSlots) {
			presentSlotStartTime = presentTimeSlot.getStartTimeMinutes();

			for ( ; index < sessions.size(); index++) {
				Session currentSession = sessions.get(index);
				if ((presentSlotStartTime + currentSession.getSessionDuration()) <= presentTimeSlot
						.getEndTimeMinutes()) {
					finalConfTrack.add(presentTimeSlot.resolveTimeFromMins(presentSlotStartTime).concat(" ")
							.concat(currentSession.getSessionName()));
					presentSlotStartTime += currentSession.getSessionDuration();
				} else {
					break;
				}
			}
			
			if(index== sessions.size()) {
				break;
			}
		}
	
	finalConfTrack.add(resolveTimeFromMins(presentSlotStartTime).concat(" ").concat(ConfTrackerConstants.NETWORKING_EVENT));
	}
}
