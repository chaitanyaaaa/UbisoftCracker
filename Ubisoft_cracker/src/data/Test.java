package data;

import java.util.ArrayList;
import java.util.List;
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
//        actions  = ((line.split("bounty from")[1]).split("] ")[0]).replaceAll(" ", "")+"]";
//        victim   = ((line.split("bounty from")[1]).split("] ")[1]).split("Victim: ")[1];
//        //victim   = line.matches("\\[(.*?)\\]");
//        timeStamp = line.split("@")[1].split("]")[0];
        
        Pattern pat = Pattern.compile("\\[(.*?)\\]");
        Matcher match = pat.matcher(line);
        List<String> ls = new  ArrayList<String>();
        while(match.find()) {    	
            ls.add(match.group(1));
        }
        actions = "[" + ls.get(1) + "]";
        victim  = ls.get(2);
        if(victim.contains(":"))
        {
        	victim = (victim.split(":")[1]).replaceAll(" ", "");
        }
        timeStamp = (ls.get(3)).replaceAll("@", "");
        

        
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
