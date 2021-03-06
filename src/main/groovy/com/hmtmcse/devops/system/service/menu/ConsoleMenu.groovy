package com.hmtmcse.devops.system.service.menu

import com.hmtmcse.devops.system.DevOpsTool
import com.hmtmcse.shellutil.common.ShellUtilException
import com.hmtmcse.shellutil.console.menu.CommandAction
import com.hmtmcse.shellutil.console.menu.CommandProcessor
import com.hmtmcse.shellutil.console.menu.OptionDefinition
import com.hmtmcse.shellutil.console.menu.OptionValues
import com.hmtmcse.shellutil.print.ConsolePrinter

class ConsoleMenu {

    public static OptionDefinition bismillah(){
        OptionDefinition optionDefinition = new OptionDefinition(new CommandAction() {
            @Override
            public void process(OptionValues optionValues) throws ShellUtilException {
                DevOpsTool devOpsTool = new DevOpsTool()
                devOpsTool.executeTask(optionValues.valueAsString("descriptor"), optionValues.valueAsString("variable"));
                devOpsTool.showReport()
            }
        });
        optionDefinition.setCommandDescription("Start DevOps Tool");
        optionDefinition.addOption("descriptor", "d").required();
        optionDefinition.required().setDescription("Please specify the descriptor YAML file location.");

        optionDefinition.addOption("variable", "v")
        optionDefinition.setDescription("Please specify the variable YAML file location.");

        return optionDefinition;
    }

    public static OptionDefinition showAllTaskDescription(){
        OptionDefinition optionDefinition = new OptionDefinition(new CommandAction() {
            @Override
            public void process(OptionValues optionValues) throws ShellUtilException {
                DevOpsTool devOpsTool = new DevOpsTool()
                devOpsTool.showSample();
            }
        });
        optionDefinition.setCommandDescription("Show Task Description Sample");
        optionDefinition.addOption("command", "c");
        optionDefinition.setDescription("Specify command name for that command sample.")
        return optionDefinition;
    }


   public static void bismillah(String[] args){
       CommandProcessor commandProcessor = new CommandProcessor();
       commandProcessor.addCommand("bismillah", bismillah());
       commandProcessor.addCommand("show", showAllTaskDescription());
       try {
           commandProcessor.processCommands(args);
       } catch (ShellUtilException e) {
           ConsolePrinter.errorPrint(e.getMessage());
           commandProcessor.printMenu();
       }
   }

}
