package controller;

import java.util.HashMap;
import java.util.List;
import model.AnalysisString;
import view.ConsoleForm;

public class AnalysisController {
    private final AnalysisString model;
    private final ConsoleForm view;

    public AnalysisController() {
        this.model = new AnalysisString();
        this.view = new ConsoleForm();
    }

    public void execute() {
        // Function 1: Display Gui And Input Data
        String input = view.inputString();

        // Function 2: Perform function & display result
        HashMap<String, List<Integer>> numberMap = model.getNumber(input);
        HashMap<String, StringBuilder> charMap = model.getCharacter(input);

        view.displayResult(numberMap, charMap);
    }
}
