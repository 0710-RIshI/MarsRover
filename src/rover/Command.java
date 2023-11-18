package rover;

import java.util.List;

public class Command {

    private List<Character> commands;

    Command(List<Character> commands){
        this.commands = commands;
    }

    List<Character> getCommands(){
        return this.commands;
    }
    
    public boolean validateCommands(){
    	for(Character command : this.commands) {
    		if(command != 'N' && command != 'S' || command !='E' || command != 'W') {
    			return false;
    		}
    	}
    	return true;
    }
    
}
