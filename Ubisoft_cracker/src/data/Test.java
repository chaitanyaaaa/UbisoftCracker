package data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String details;
		String player_id;
		String points;
		String actions;
		String victim;
		String timeStamp;
		
        String line = "[Scoring]: 2 Dev 158744780 got 10.0 bounty from [Actor - Kill Assist] [Victim: Actor2_(Actor_Replica_Player_2)] [@519382]";
        String[] l = line.split(" ");
        
        player_id = line.substring(line.indexOf("]:")+1, line.indexOf("got"));
        points   = (line.split("got")[1]).split(" ")[1];
        actions  = ((line.split("bounty from")[1]).split("] ")[0]).replaceAll(" ", "")+"]";
        victim   = ((line.split("bounty from")[1]).split("] ")[1]).split("Victim: ")[1];
        timeStamp = line.split("@")[1].split("]")[0];
        
        details = "Player-ID = "+player_id + "\n" +
                "Points = " + points + "\n" +
                "Action = " + actions + "\n" +
                "Victim = " + victim + "\n" +
                "Timestamp = " + timeStamp + "\n" +
                "**************************************************";
        
        System.out.println(details);
        		
        		
        for(String s : l)
        {
        	if(s == "got")
        	{
        		
        	}
        }
       
	}

}
