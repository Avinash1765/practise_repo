package com.thoughtworks.conference.tracker.algorithm;

import java.util.Collections;
import java.util.List;

import com.thoughtworks.conference.tracker.dto.Session;
import com.thoughtworks.conference.tracker.helper.TimeSlotsDTO;

public class ConfTrackByShortestTimeFirst implements ConfTrackAlgoIntf{

	@Override
	public List<String> prepareConferenceTrack(List<Session> sessions, List<TimeSlotsDTO> availableTimeSlots) {
		
		/*can add logic further*/
		
		return Collections.emptyList();
	}

}
