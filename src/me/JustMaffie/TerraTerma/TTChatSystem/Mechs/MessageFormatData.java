package me.JustMaffie.TerraTerma.TTChatSystem.Mechs;

import TTCore.Mech.DataHandlers.PlayerData;
import TTCore.Mech.DataHandlers.SavableData;
import TTCore.Savers.Saver;

public class MessageFormatData implements PlayerData, SavableData {

	String CHAT_FORMAT = "Default Format.";
	String STAFF_CHAT_FORMAT = "Added soon";
	private static MessageFormatData mfd;
  
  public String getChatFormat(){
		return CHAT_FORMAT;
  }
		  
	public void setChatFormat(String format){
		CHAT_FORMAT = format;
  }
	
  public String getStaffChatFormat(){
		return STAFF_CHAT_FORMAT;
  }
			  
  public void setStaffChatFormat(String format){
		STAFF_CHAT_FORMAT = format;
  }
  
	@Override
	public void save(Saver saver){
  		saver.set(STAFF_CHAT_FORMAT, "Format.Staff");
  		saver.set(CHAT_FORMAT, "Format.Chat");
  	}

	@Override
	public boolean load(Saver saver){
		String format = saver.get(String.class, "Format.Chat");
		String format2 = saver.get(String.class, "Format.Staff");
		if (format != null){
			CHAT_FORMAT = format;
      STAFF_CHAT_FORMAT = format2;
			return true;
		}
		return true;
	}
	public static MessageFormatData getThaClass(){
		return mfd;
	}

}