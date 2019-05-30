package com.thoughtworks.conference.tracker.context;

import java.util.List;

import com.thoughtworks.conference.tracker.algorithm.ConfTrackAlgoIntf;
import com.thoughtworks.conference.tracker.dto.Session;
import com.thoughtworks.conference.tracker.helper.TimeSlotsDTO;

public class ConfTrackerContext{
	
	private ConfTrackAlgoIntf confTrackAlgo;
	
	public ConfTrackerContext(ConfTrackAlgoIntf confTrackerAlgo) {
		confTrackAlgo = confTrackerAlgo;
	}

	
	public List<String> prepareTrack(List<Session> sessions, List<TimeSlotsDTO> availableTimeSlots) {
		return confTrackAlgo.prepareConferenceTrack(sessions, availableTimeSlots);
	}
	
}
