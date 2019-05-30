package com.thoughtworks.conference.tracker.client;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.thoughtworks.conference.tracker.algorithm.ConfTrackByLexographOrder;
import com.thoughtworks.conference.tracker.constants.ConfTrackerConstants;
import com.thoughtworks.conference.tracker.context.ConfTrackerContext;
import com.thoughtworks.conference.tracker.dto.Session;
import com.thoughtworks.conference.tracker.exception.ConfTrackerException;
import com.thoughtworks.conference.tracker.helper.ConfTrackErrorMessages;
import com.thoughtworks.conference.tracker.helper.TimeSlotsDTO;

public class ConfTrackClient {
	private List<TimeSlotsDTO> slots=new ArrayList<>();
	
	public ConfTrackClient() {
		slots.add(new TimeSlotsDTO(540, 720));
		slots.add(new TimeSlotsDTO(780, 1020));
	}

	public static void main(String[] args) {
		
	try {
		ConfTrackClient clientObj=new ConfTrackClient();
		Consumer<String> displayTrack= System.out::println;
		ConfTrackerContext context=new ConfTrackerContext(new ConfTrackByLexographOrder());
		String inputString=clientObj.readInput();
		List<Session> sessionList=clientObj.populateSessionList(inputString);
		context.prepareTrack(sessionList, clientObj.slots).stream().forEach(displayTrack);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private List<Session> populateSessionList(String inputString) {
		
		String[] arr=inputString.split("\n");
		Set<String> sessionSet=new HashSet<>(Arrays.asList(arr));
		sessionSet.remove("\n");
		sessionSet=formatSessionNames(sessionSet);
		return populateSessionListHelper(sessionSet);
		
	}

	private Set<String> formatSessionNames(Set<String> sessionSet) {
		Function<String, String> function = (String str) ->  str.replaceAll("\\r", "");
		
		for(String str : sessionSet) {
			if(str.trim().isEmpty()) {
				throw new ConfTrackerException(ConfTrackErrorMessages.INVALID_TALK_NAME);
			}
		}
		return sessionSet.stream().map(function).collect(Collectors.toSet());
	}

	private List<Session> populateSessionListHelper(Set<String> sessionSet) {
		List<Session> sessionList=new ArrayList<>();

		for(String sessionInfo : sessionSet) {
			boolean digitPresent=ifSessionContainsTime(sessionInfo);
			if(digitPresent) {
				int spaceLastIndex=sessionInfo.lastIndexOf(' ');
				sessionList.add(new Session(sessionInfo, Integer.parseInt(sessionInfo.substring(spaceLastIndex + 1).split(ConfTrackerConstants.TIME_UNIT)[0])));
			}else {
				sessionList.add(new Session(sessionInfo, ConfTrackerConstants.DEFAULT_CONF_DURATION));
			}
		}
		return sessionList;
	}

	private boolean ifSessionContainsTime(String sessionInfo) {
		
		for(char ch : sessionInfo.toCharArray()) {
			if(Character.isDigit(ch))
				return true;
		}
		return false;
	}

	private String readInput() {
		StringBuilder str=new StringBuilder();
		
		try(FileInputStream fis= new FileInputStream(ConfTrackerConstants.FILE_NAME)){
			int chAscii;
			while((chAscii=fis.read()) != -1) {
				str.append((char)chAscii);
			}
		}catch(Exception e) {
			throw new ConfTrackerException(e.getMessage());
		}
		if(str.length()==0)
			throw new ConfTrackerException("File empty..");
		return new String(str);
	}

}
