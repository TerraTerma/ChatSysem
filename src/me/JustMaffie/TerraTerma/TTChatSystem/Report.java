package me.JustMaffie.TerraTerma.TTChatSystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

import TTCore.Entity.Living.Human.Player.TTAccount;
import TTCore.Entity.Living.Human.Player.TTPlayer;

public class Report {

	String ID;
	TTAccount reporter;
	Boolean closed;
	String reason;
	LocalTime timeOfReport;
	LocalDate dateOfReport;
	
	public Report(String ID, TTAccount reporter, Boolean closed, String reason, LocalTime timeOfReport, LocalDate dateOfReport){
		this.ID = ID;
		this.reporter = reporter;
		this.closed = closed;
		this.reason = reason;
		this.timeOfReport = timeOfReport;
		this.dateOfReport = dateOfReport;
	}
	
	public Report(TTPlayer reporter, String reason){
		this.reporter = reporter;
		this.reason = reason;
		this.closed = false;
		this.timeOfReport = LocalTime.now();
		this.dateOfReport = LocalDate.now();
	}
	
	public String getId(){
		return ID;
	}
	
	public TTAccount getReporter(){
		return reporter;
	}
	
	public Boolean getClosed(){
		return closed;
	}
	
	public String getReason(){
		return reason;
	}
	
	public LocalTime getTime(){
		return timeOfReport;
	}
	
	public LocalDate getDate(){
		return dateOfReport;
	}
	
	@Override
	public String toString(){
		return
				ID  + "," + 
				reporter.getPlayer().getUniqueId().toString() + "," + 
				closed + "," + 
				reason + "," + 
				timeOfReport.getHour() + ":" + timeOfReport.getMinute() + "," + 
				dateOfReport.getMonth() + "/" + dateOfReport.getDayOfMonth() + "/" + dateOfReport.getYear();
	}
	
	public static Optional<Report> fromString(String reportString){
		String[] args = reportString.split(",");
		if(args.length == 6){
			String id = args[0];
			UUID uuid = UUID.fromString(args[1]);
			boolean closed = Boolean.parseBoolean(args[2]);
			String reason = args[3];

			String[] timeS = args[4].split(":");
			LocalTime time = LocalTime.of(Integer.parseInt(timeS[0]), Integer.parseInt(timeS[1]));

			String[] dateS = args[5].split("/");
			int month = Integer.parseInt(dateS[0]);
			int day = Integer.parseInt(dateS[1]);
			int year = Integer.parseInt(dateS[2]);
			LocalDate date = LocalDate.of(year, month, day);
			return Optional.of(new Report(id, TTAccount.getAccount(uuid).get(), closed, reason, time, date));
		}
		return Optional.empty();
	}
	
	
}
