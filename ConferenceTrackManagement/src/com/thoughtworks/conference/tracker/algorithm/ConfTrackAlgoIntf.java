package com.thoughtworks.conference.tracker.algorithm;

import java.util.List;

import com.thoughtworks.conference.tracker.dto.Session;
import com.thoughtworks.conference.tracker.helper.TimeSlotsDTO;

public interface ConfTrackAlgoIntf {
	
	public List<String> prepareConferenceTrack(List<Session> sessions, List<TimeSlotsDTO> availableTimeSlots);
	
}
