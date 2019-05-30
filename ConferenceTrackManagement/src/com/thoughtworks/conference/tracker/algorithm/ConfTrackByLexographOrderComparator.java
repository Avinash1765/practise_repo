package com.thoughtworks.conference.tracker.algorithm;

import java.util.Comparator;

import com.thoughtworks.conference.tracker.dto.Session;

public class ConfTrackByLexographOrderComparator implements Comparator<Session>{

	@Override
	public int compare(Session obj1, Session obj2) {
		
		return obj1.getSessionName().compareTo(obj2.getSessionName());
		
	}

}
