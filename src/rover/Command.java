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
    
}
