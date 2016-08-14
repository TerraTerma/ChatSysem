package me.JustMaffie.TerraTerma.TTChatSystem.Mechs;

import java.util.ArrayList;
import java.util.List;

import TTCore.Mech.DataHandlers.PlayerData;
import TTCore.Mech.DataHandlers.SavableData;
import TTCore.Savers.Saver;
import me.JustMaffie.TerraTerma.TTChatSystem.Report;

public class ReportsData implements PlayerData, SavableData {

	List<Report> reports = new ArrayList<Report>();
	List<String> list = new ArrayList<>();
	
	
	@Override
	public void save(Saver saver) {
		reports.stream().forEach(r -> list.add(r.toString()));
		saver.set(list);
	}
	

	@Override
	public boolean load(Saver saver) {
		list.stream().forEach(r -> reports.add(Report.fromString(r)));
		return true;
	}
	
	public List<Report> getList(){
		return reports;
	}

}