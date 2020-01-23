package ad.example.performance.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ad.example.performance.data.OneMb;

@RestController
@RequestMapping("/simulate")
public class SimulatorController {

	private static final int MAX_TIME = 10000;
	private static final int MIN_TIME = 0;
	// private static byte[] APP_BYTES = null;
	private static int NO_OF_MEM_INC_REQUEST = 0;
	private static Map<Integer, OneMb> APP_BYTES = new HashMap<Integer, OneMb>();


	@GetMapping(value = {"/delay", "/delay/{timeinms}"} )
	public String getDelayedResponse(@PathVariable(name = "timeinms", required = false) Integer timeInMs) {
		if (timeInMs==null)
			timeInMs=0;
		return delayResponse(timeInMs);
	}

	@GetMapping(value = "/randomdelay")
	public String getDelayedResponse() {
		int timeInMs = new Random().nextInt((MAX_TIME - MIN_TIME) + 1) + MIN_TIME;
		return delayResponse(timeInMs);
	}

	private String delayResponse(long delayTimeInMs) {
		try {
			Thread.sleep(delayTimeInMs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Delayed by " + delayTimeInMs + " ms";
	}

//	private String incrementMemory() {
//		synchronized (this) {
//			//NO_OF_MEM_INC_REQUEST++;
//			NO_OF_MEM_INC_REQUEST=NO_OF_MEM_INC_REQUEST+5;
//		}
//		int memory_request = NO_OF_MEM_INC_REQUEST * 1000 * 1000;
//		APP_BYTES = null;
//		APP_BYTES = new byte[memory_request];
//		// increase 1 MB of memory.
//		return "Memory used in " + (memory_request/1000/1000) + " MB";
//	}

//	private String incrementMemory(int noOfBlocksMB) {
//		if (noOfBlocksMB<=0)
//			noOfBlocksMB=2;
//		synchronized (this) {
//			NO_OF_MEM_INC_REQUEST=noOfBlocksMB-1;
//		}
//		return incrementMemory();
//	}

	private String incrementMemory(int noOfBlocksMB) {
		synchronized (this) {
			for (int i = 0; i < noOfBlocksMB; i++) {
				NO_OF_MEM_INC_REQUEST++;

				if (!APP_BYTES.containsKey(NO_OF_MEM_INC_REQUEST)) {
					APP_BYTES.put(NO_OF_MEM_INC_REQUEST, new OneMb());
				}
			}
		}
		return "Memory used in " + NO_OF_MEM_INC_REQUEST + " MB";
	}

	@GetMapping(value = {"/memory", "/memory/{noofmb}"} )
	public String incrementMemoryHigh(@PathVariable(name = "noofmb", required = false) Integer noOfBlocksMB) {
		if (noOfBlocksMB==null)
			noOfBlocksMB = 1;
		return incrementMemory(noOfBlocksMB);
	}

//	@GetMapping(value = "/memory")
//	public String incrementMemoryOneMB() {
//		return incrementMemory();
//	}
//	
//	@GetMapping(value = "/memory/{noofmb}")
//	public String incrementMemoryHigh(@PathVariable("noofmb") int noOfBlocksMB) {
//		return incrementMemory(noOfBlocksMB);
//	}

	@GetMapping(value = "/error")
	public String error() {
		try {
			generateError();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "OK with error";
	}

	private void generateError() throws Exception {
		try {
			int i = 10 / 0;
		} catch (Exception e) {
			throw new Exception("Custom exception", e);
		}
	}

}
