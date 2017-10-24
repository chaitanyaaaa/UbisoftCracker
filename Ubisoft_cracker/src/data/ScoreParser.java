package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScoreParser {
	
	static BufferedReader ac_log;
	static BufferedWriter ac_writer;
	static BufferedWriter details_writer;
	
	
	public static void score_line_finder(String file_path,String out_file,String details_path)
	{
		
		try 
		{
			ac_log = new BufferedReader (new FileReader(file_path));
			ac_writer = new BufferedWriter(new FileWriter(out_file));
			details_writer = new BufferedWriter(new FileWriter(details_path));
			String line;	
		
			while((line = ac_log.readLine()) != null )
			{
		         if(line.startsWith("[Scoring]:"))
		         {
		        	 // solution-1 scoring lines
		        	 ac_writer.write(line+"\n");
		        	 
		        	 //solution-2 details page
		        	 if(line.contains("bounty from") && line.contains("got"))
		        	 {
		        	   System.out.println(line);
		        	   details_writer.write(detail_finder(line));
		        	 }
		         }
			}
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try {
				ac_log.close();
				ac_writer.close();
				details_writer.close();
			}
			catch(IOException ex)
			{
				
			}
		}
		
	}
	
	public static String detail_finder(String line)
	{
		//String line = "[Scoring]: Bot-16 got 2.0 bounty from [Actor - Kill] [Victim: Actor200_(Actor_Local_Minion_200)] [@152133]\r\n";
		String details = "";
		String player_id;
		String points;
		String actions;
		String victim;
		String timeStamp;

        player_id = line.substring(line.indexOf("]:")+1, line.indexOf("got"));
        points   = (line.split("got")[1]).split(" ")[1];
//        actions  = ((line.split("bounty from")[1]).split("] ")[0]).replaceAll(" ", "")+"]";
//        victim   = ((line.split("bounty from")[1]).split("] ")[1]).split("Victim: ")[1];
//        timeStamp = line.split("@")[1].split("]")[0];
//        
        
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
                  "**************************************************" + "\n";
		//System.out.println(details);
		return details;
	}
	
	
	public static void main(String[] args)
	{
		String file_path = System.getProperty("user.dir")+"\\src\\data\\Player1_Assassins.txt";
		String out_path = System.getProperty("user.dir")+"\\src\\data\\output.txt";
		String details = System.getProperty("user.dir")+"\\src\\data\\details.txt";
		score_line_finder(file_path,out_path,details);
		 
	}

}
