package cs105Project.userInterface.panels;

import cs105Project.userInterface.PanelComponents;

import javax.swing.*;
import java.awt.*;

import static cs105Project.userInterface.PanelComponents.*;

public final class ExactCubes {

    public static void setComponents(final Container pane) {
        // Init all the JPanels necessary for this program.
        JPanel titleHolder = new JPanel();
        JPanel barHolder = new JPanel();
        titleHolder.setLayout(new BoxLayout(titleHolder, BoxLayout.PAGE_AXIS));
        JPanel inputHolderL = new JPanel();
        inputHolderL.setLayout(new BoxLayout(inputHolderL, BoxLayout.PAGE_AXIS));
        JPanel inputHolderR = new JPanel();
        inputHolderR.setLayout(new BoxLayout(inputHolderR, BoxLayout.PAGE_AXIS));
        JPanel inputHolderBoth = new JPanel();
        JPanel buttonLayout = new JPanel();
        JPanel buttonHolder = new JPanel(new CardLayout());
        JPanel buttonAndBarHolder = new JPanel(new BorderLayout());
        JPanel interactionHolder = new JPanel(new BorderLayout());
        JPanel scrollHolder = new JPanel(new GridLayout());

        setBackgrounds(buttonHolder, interactionHolder, scrollHolder, buttonLayout, inputHolderL, inputHolderR, inputHolderBoth, titleHolder, barHolder);

        JTextArea outputField = PanelComponents.getJTextArea(15,30);
        JProgressBar progressBar = PanelComponents.getProgressBar();
        JTextField inputFieldL = PanelComponents.getJTextField("1", 10);
        JTextField inputFieldR = PanelComponents.getJTextField("500", 10);


        titleHolder.add(getJLabel("Exact Cubes Calculator", titleFont));
        titleHolder.add(getJLabel("Searches for exact cubes of numbers,", descriptionFont));
        titleHolder.add(getJLabel("in the range provided below:", descriptionFont));
        titleHolder.add(Box.createVerticalStrut(5));
        titleHolder.add(getJSeparator());

        inputHolderL.add(getJLabel("From:", descriptionFont));
        inputHolderL.add(inputFieldL);

        inputHolderR.add(getJLabel("To:", descriptionFont));
        inputHolderR.add(inputFieldR);

        inputHolderBoth.add(inputHolderL);
        inputHolderBoth.add(Box.createHorizontalStrut(50));
        inputHolderBoth.add(inputHolderR);

        buttonLayout.add(PanelComponents.getButton("Run", ButtonType.EXACTCUBES, progressBar, outputField, inputFieldL, inputFieldR));
        buttonLayout.add(PanelComponents.getButton("Back", ButtonType.BACK));
        buttonHolder.add(buttonLayout);

        barHolder.add(progressBar);

        buttonAndBarHolder.add(buttonHolder, BorderLayout.NORTH);
        buttonAndBarHolder.add(barHolder, BorderLayout.SOUTH);

        interactionHolder.add(titleHolder, BorderLayout.PAGE_START);
        interactionHolder.add(inputHolderBoth, BorderLayout.CENTER);
        interactionHolder.add(buttonAndBarHolder, BorderLayout.SOUTH);

        // Create a scroll pane as holder for the output
        JScrollPane scroll = new JScrollPane(
                outputField,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scroll.setBackground(discordGray);
        scrollHolder.add(scroll);

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                interactionHolder, scrollHolder
        );
        splitPane.setEnabled(false);
        splitPane.setDividerSize(1);

        pane.add(
                splitPane,
                BorderLayout.CENTER
        );
    }
}
