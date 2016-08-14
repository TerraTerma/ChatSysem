package me.JustMaffie.TerraTerma.TTChatSystem.Mechs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import TTCore.Mech.DataHandlers.PlayerData;
import TTCore.Mech.DataHandlers.SavableData;
import TTCore.Savers.Saver;
import me.JustMaffie.TerraTerma.TTChatSystem.Report;

public class ReportsData implements PlayerData, SavableData {

	List<Report> reports = new ArrayList<Report>();

	@Override
	public void save(Saver saver) {
		List<String> list = new ArrayList<>();
		reports.stream().forEach(r -> list.add(r.toString()));
		saver.set(list, "Reports");
	}

	@Override
	public boolean load(Saver saver) {
		//gets the reports to the player as String
		List<String> list = saver.getList(String.class, "Reports");
		//checks that the list was actually received
		if(list != null){
			//converts the String list to Report list
			list.stream().forEach(r -> {
				Optional<Report> opReport = Report.fromString(r);
				if(opReport.isPresent()){
					reports.add(opReport.get());
				}
			});

		}
		return true;
	}

	public List<Report> getList() {
		return reports;
	}

}