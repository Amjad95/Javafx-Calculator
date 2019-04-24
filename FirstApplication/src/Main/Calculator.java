package Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Calculator extends Application {

    //The Graphical elements in the SceneWelcome
    //Button for launching the SceneMain
    private Button btnStart = null;

    //CheckBoxes for theme selection
    private CheckBox cbDark = null;
    private CheckBox cbLight = null;

    //Label for  Select theme
    private Label lblSelectTheme = null;


    //The Graphical elements in the SceneMain
    //The Screen TextFields
    private TextField tfScreenPrimary = null;
    private TextField tfScreenSecondary = null;

    //Digits' Buttons
    private Button btnZero = null;
    private Button btnOne = null;
    private Button btnTwo = null;
    private Button btnThree = null;
    private Button btnFour = null;
    private Button btnFive = null;
    private Button btnSix = null;
    private Button btnSeven = null;
    private Button btnEight = null;
    private Button btnNine = null;

    //Operations' Buttons
    private Button btnAdd = null;
    private Button btnSubtract = null;
    private Button btnMultiply = null;
    private Button btnDivide = null;
    private Button btnEqual = null;
    private Button btnDecimalPoint = null;
    private Button btnModulus = null;
    private Button btnToPower2 = null;
    private Button btnToPower3 = null;
    private Button btnSquareRoot = null;
    private Button btnCubeRoot = null;
    private Button btnPi = null;
    private Button btnEulerNumber = null;
    private Button btnOneOverX = null;
    private Button btnDecimalToBinary = null;
    private Button btnChangeSign = null;
    private Button btnSin = null;
    private Button btnCos = null;
    private Button btnTan = null;
    private Button btnLogBase10 = null;
    private Button btnXToPower = null;
    private Button btnLn = null;

    //Clearing the Screen Buttons
    private Button btnOneStepClear = null;
    private Button btnClear = null;

    //For more Operations
    private Button btnInvert = null;

    //Variables for the values from the Text Fields
    private String stTextFromPrimaryScreen = "";
    private String stTextFromSecondaryScreen = "";
    private String stResult = "";

    private char operationSignHolder;

    //Doubles for Converting the Operands
    private double dFirstOperand = 0.0;
    private double dSecondOperand = 0.0;

    //Constants Values for the Design of the Graphical Elements
    private final double btnPrefWidth = 100.0;
    private final double btnPrefHeight = 100.0;

    //Constant Numbers
    private final double pi = Math.PI;
    private final double eulerNumber = Math.exp(1.0);

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage myStage) {

        //Setting the Title of the Stage
        myStage.setTitle("Calculator");

        //Creating the rootNodeMain
        GridPane rootNodeMain = new GridPane();
        rootNodeMain.setAlignment(Pos.TOP_LEFT);
        rootNodeMain.setPadding(new Insets(10));
        rootNodeMain.setHgap(0);
        rootNodeMain.setVgap(0);

        //Creating the SceneMain
        Scene mySceneMain = new Scene(rootNodeMain, rootNodeMain.getMinWidth(), rootNodeMain.getMinHeight());

        //Creating the rootNodeWelcome
        GridPane rootNodeWelcome = new GridPane();
        rootNodeWelcome.setAlignment(Pos.CENTER);
        rootNodeWelcome.setPadding(new Insets(10));
        rootNodeWelcome.setVgap(20);
        rootNodeWelcome.setHgap(40);

        //Creating the SceneWelcome
        Scene mySceneWelcome = new Scene(rootNodeWelcome, rootNodeWelcome.getMinWidth(), rootNodeWelcome.getMinHeight());
        mySceneWelcome.getStylesheets().add(getClass().getResource("Welcome.css").toString());

        //Icon image for the application
        Image icon = new Image("file:/Users/amjadalissaalkhalaf/IdeaProjects//FirstApplication/src/Main/icon1.jpg");
        myStage.getIcons().add(icon);

        //Setting the background image for the Welcome Scene
        Image image = new Image("file:/Users/amjadalissaalkhalaf/IdeaProjects//FirstApplication/src/Main/abstract-background.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(600, 400, false, false, true, false);
        BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(bgImage);
        rootNodeWelcome.setBackground(background);

        //Graphical elements in mySceneWelcome
        //Initializing the CheckBoxes
        //Check box Dark Theme
        cbDark = new CheckBox("Dark");
        rootNodeWelcome.add(cbDark, 1, 4);
        cbDark.setAlignment(Pos.CENTER_LEFT);

        // Handle action events for the check box.
        cbDark.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if (cbDark.isSelected()) {
                    mySceneMain.getStylesheets().add(getClass().getResource("ViperDark.css").toString());
                }
                cbLight.setSelected(false);
            }
        });

        //Check box Light Theme
        cbLight = new CheckBox("Light");
        rootNodeWelcome.add(cbLight, 3, 4);
        cbLight.setAlignment(Pos.CENTER_RIGHT);

        // Handle action events for the check box.
        cbLight.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if (cbLight.isSelected()) {
                    mySceneMain.getStylesheets().add(getClass().getResource("ViperLight.css").toString());
                }
                cbDark.setSelected(false);
            }
        });


        //Button Start
        btnStart = new Button("Start");
        btnStart.setPrefSize(100, 20);
        btnStart.setAlignment(Pos.BASELINE_CENTER);
        rootNodeWelcome.add(btnStart, 2, 9);

        // Handle action events for the Start Button.
        btnStart.setOnAction(ae -> {
            if (cbDark.isSelected() || cbLight.isSelected()) {
                myStage.setScene(mySceneMain);
            }
        });

        //Theme selection Label
        lblSelectTheme = new Label("Please Choose Your Favourite Theme");
        rootNodeWelcome.add(lblSelectTheme, 1, 1, 4, 1);
        lblSelectTheme.setAlignment(Pos.CENTER);

        //Graphical elements in mySceneMain
        //Initializing the TextField1
        tfScreenPrimary = new TextField();
        tfScreenPrimary.setPromptText("0");
        tfScreenPrimary.setPrefSize(650.0, 60.0);
        rootNodeMain.add(tfScreenPrimary, 0, 1, 7, 1);

        //Initializing the TextField2
        tfScreenSecondary = new TextField();
        tfScreenSecondary.setPrefSize(650.0, 60.0);
        rootNodeMain.add(tfScreenSecondary, 0, 0, 7, 1);
        tfScreenSecondary.getStyleClass().add("text-field_Secondary");
        tfScreenSecondary.setEditable(false);

        //Getting the Values of The Screens
        stTextFromPrimaryScreen = tfScreenPrimary.getText();
        stTextFromSecondaryScreen = tfScreenSecondary.getText();

        //Initializing the Digit Buttons
        //#0
        btnZero = new Button("0");
        btnZero.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnZero, 3, 6);

        //Event handler
        btnZero.setOnAction(ae -> {
            addDigit('0');
        });

        //#1
        btnOne = new Button("1");
        btnOne.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnOne, 2, 5);

        //Event handler
        btnOne.setOnAction(ae -> {
            addDigit('1');
        });

        //#2
        btnTwo = new Button("2");
        btnTwo.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnTwo, 3, 5);

        //Event handler
        btnTwo.setOnAction(ae -> {
            addDigit('2');
        });

        //#3
        btnThree = new Button("3");
        btnThree.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnThree, 4, 5);

        //Event handler
        btnThree.setOnAction(ae -> {
            addDigit('3');
        });

        //#4
        btnFour = new Button("4");
        btnFour.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnFour, 2, 4);

        //Event handler
        btnFour.setOnAction(ae -> {
            addDigit('4');
        });

        //#5
        btnFive = new Button("5");
        btnFive.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnFive, 3, 4);

        //Event handler
        btnFive.setOnAction(ae -> {
            addDigit('5');
        });

        //#6
        btnSix = new Button("6");
        btnSix.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnSix, 4, 4);

        //Event handler
        btnSix.setOnAction(ae -> {
            addDigit('6');
        });

        //#7
        btnSeven = new Button("7");
        btnSeven.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnSeven, 2, 3);

        //Event handler
        btnSeven.setOnAction(ae -> {
            addDigit('7');
        });

        //#8
        btnEight = new Button("8");
        btnEight.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnEight, 3, 3);

        //Event handler
        btnEight.setOnAction(ae -> {
            addDigit('8');
        });

        //#9
        btnNine = new Button("9");
        btnNine.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnNine, 4, 3);

        //Event handler
        btnNine.setOnAction(ae -> {
            addDigit('9');
        });

        //Initializing the Basic Operations Buttons
        //+
        btnAdd = new Button("+");
        btnAdd.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnAdd, 5, 5);
        btnAdd.getStyleClass().add("button-function");

        //Event handler
        btnAdd.setOnAction(ae -> {

            generalSetting('+');
        });

        //-
        btnSubtract = new Button("-");
        btnSubtract.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnSubtract, 6, 5);
        btnSubtract.getStyleClass().add("button-function");

        //Event handler
        btnSubtract.setOnAction(ae -> {

            generalSetting('-');
        });

        //×
        btnMultiply = new Button("×");
        btnMultiply.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnMultiply, 5, 4);
        btnMultiply.getStyleClass().add("button-function");

        //Event handler
        btnMultiply.setOnAction(ae -> {

            generalSetting('×');
        });

        //÷
        btnDivide = new Button("÷");
        btnDivide.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnDivide, 6, 4);
        btnDivide.getStyleClass().add("button-function");

        //Event handler
        btnDivide.setOnAction(ae -> {

            generalSetting('÷');
        });

        //.
        btnDecimalPoint = new Button(".");
        btnDecimalPoint.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnDecimalPoint, 4, 6);
        btnDecimalPoint.getStyleClass().add("button-function");

        //Event handler
        btnDecimalPoint.setOnAction(ae -> {
            stTextFromPrimaryScreen += ".";
            tfScreenPrimary.setText(stTextFromPrimaryScreen);
        });

        //=
        btnEqual = new Button("=");
        btnEqual.setPrefSize(2 * btnPrefHeight, btnPrefHeight);
        rootNodeMain.add(btnEqual, 5, 6, 2, 1);
        btnEqual.getStyleClass().add("button-orange");

        //Event handler
        btnEqual.setOnAction(ae -> {
            /*
            Upon clicking the equal button; the method decimalPointCheck is called,
            then the text from the primary screen is added to the content of the secondary screen,
            then the second operand is parsed,
            then the result is computed and is assigned the stResult,
            and finally the result is displayed in the primary screen.
             */
            stTextFromPrimaryScreen = decimalPointCheck(stTextFromPrimaryScreen);
            stTextFromSecondaryScreen += stTextFromPrimaryScreen;
            tfScreenSecondary.setText(stTextFromSecondaryScreen);

            dSecondOperand = getOperand(stTextFromPrimaryScreen);

            stResult = getResult(operationSignHolder);

            stTextFromPrimaryScreen = stResult;
            tfScreenPrimary.setText(stTextFromPrimaryScreen);
        });

        //←
        btnOneStepClear = new Button("←");
        btnOneStepClear.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnOneStepClear, 5, 2);
        btnOneStepClear.getStyleClass().add("button-function");

        //Event handler
        btnOneStepClear.setOnAction(ae -> {
            if (stTextFromPrimaryScreen.length() < 1) {
                stTextFromPrimaryScreen = "";
            } else {
                stTextFromPrimaryScreen = stTextFromPrimaryScreen.substring(0, stTextFromPrimaryScreen.length() - 1);
                tfScreenPrimary.setText(stTextFromPrimaryScreen);
            }
        });

        //C
        btnClear = new Button("C");
        btnClear.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnClear, 6, 2);
        btnClear.getStyleClass().add("button-function");

        //Event handler
        btnClear.setOnAction(ae -> {
            stTextFromPrimaryScreen = "";
            stTextFromSecondaryScreen = "";
            tfScreenPrimary.setText(stTextFromPrimaryScreen);
            tfScreenSecondary.setText(stTextFromSecondaryScreen);
        });

        //%
        btnModulus = new Button("⁒");
        btnModulus.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnModulus, 6, 3);
        btnModulus.getStyleClass().add("button-function");

        //Event handler
        btnModulus.setOnAction(ae -> {

            generalSetting('⁒');
        });

        //X²
        btnToPower2 = new Button("X²");
        btnToPower2.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnToPower2, 4, 2);
        btnToPower2.getStyleClass().add("button-function");

        //Event handler
        btnToPower2.setOnAction(ae -> {
            operationSignHolder = '2';
            dSecondOperand = 2;
            power();
        });

        //X³
        btnToPower3 = new Button("X³");
        btnToPower3.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnToPower3, 3, 2);
        btnToPower3.getStyleClass().add("button-function");

        //Event handler
        btnToPower3.setOnAction(ae -> {
            operationSignHolder = '3';
            dSecondOperand = 3;
            power();
        });


        //√
        btnSquareRoot = new Button("√");
        btnSquareRoot.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnSquareRoot, 1, 2);
        btnSquareRoot.getStyleClass().add("button-function");

        //Event handler
        btnSquareRoot.setOnAction(ae -> {
            operationSignHolder = '√';
            power();
        });

        //∛
        btnCubeRoot = new Button("∛");
        btnCubeRoot.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnCubeRoot, 0, 2);
        btnCubeRoot.getStyleClass().add("button-function");

        //Event handler
        btnCubeRoot.setOnAction(ae -> {
            operationSignHolder = '∛';
            power();
        });

        //π
        btnPi = new Button("π");
        btnPi.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnPi, 1, 4);
        btnPi.getStyleClass().add("button-function");

        //Event handler
        btnPi.setOnAction(ae -> {
            stTextFromPrimaryScreen = "" + pi;
            tfScreenPrimary.setText(stTextFromPrimaryScreen);
        });

        //e
        btnEulerNumber = new Button("e");
        btnEulerNumber.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnEulerNumber, 1, 5);
        btnEulerNumber.getStyleClass().add("button-function");

        //Event handler
        btnEulerNumber.setOnAction(ae -> {
            stTextFromPrimaryScreen = "" + eulerNumber;
            tfScreenPrimary.setText(stTextFromPrimaryScreen);
        });

        //1/x
        btnOneOverX = new Button("1/x");
        btnOneOverX.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnOneOverX, 5, 3);
        btnOneOverX.getStyleClass().add("button-function");

        //Event handler
        btnOneOverX.setOnAction(ae -> {
            operationSignHolder = 'i';
            power();
        });

        //D→B
        btnDecimalToBinary = new Button("D→B");
        btnDecimalToBinary.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnDecimalToBinary, 1, 3);
        btnDecimalToBinary.getStyleClass().add("button-function");

        //Event handler
        btnDecimalToBinary.setOnAction(ae -> {
            operationSignHolder = 'b';
            power();
        });

        //±
        btnChangeSign = new Button("±");
        btnChangeSign.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnChangeSign, 2, 6);
        btnChangeSign.getStyleClass().add("button-function");

        //Event handler
        btnChangeSign.setOnAction(ae -> {
            if (stTextFromPrimaryScreen.charAt(0) >= '0' &&
                    stTextFromPrimaryScreen.charAt(0) <= '9') {
                stTextFromPrimaryScreen = '-' + stTextFromPrimaryScreen;
            } else {
                stTextFromPrimaryScreen = stTextFromPrimaryScreen.substring(1);
            }
            tfScreenPrimary.setText(stTextFromPrimaryScreen);
        });

        //sin
        btnSin = new Button("sin");
        btnSin.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnSin, 0, 3);
        btnSin.getStyleClass().add("button-function");

        //Event handler
        btnSin.setOnAction(ae -> {
            operationSignHolder = 's';
            power();
        });

        //cos
        btnCos = new Button("cos");
        btnCos.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnCos, 0, 4);
        btnCos.getStyleClass().add("button-function");

        //Event handler
        btnCos.setOnAction(ae -> {
            operationSignHolder = 'c';
            power();
        });

        //tan
        btnTan = new Button("tan");
        btnTan.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnTan, 0, 5);
        btnTan.getStyleClass().add("button-function");

        //Event handler
        btnTan.setOnAction(ae -> {
            operationSignHolder = 't';
            power();
        });

        //log
        btnLogBase10 = new Button("log");
        btnLogBase10.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnLogBase10, 1, 6);
        btnLogBase10.getStyleClass().add("button-function");

        //Event handler
        btnLogBase10.setOnAction(ae -> {
            operationSignHolder = 'l';
            power();
        });


        //ln
        btnLn = new Button("ln");
        btnLn.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnLn, 0, 6);
        btnLn.getStyleClass().add("button-function");

        //Event handler
        btnLn.setOnAction(ae -> {
            operationSignHolder = 'n';
            power();
        });

        //x^y
        btnXToPower = new Button("x^y");
        btnXToPower.setMinSize(btnPrefWidth, btnPrefHeight);
        rootNodeMain.add(btnXToPower, 2, 2);
        btnXToPower.getStyleClass().add("button-function");

        //Event handler
        btnXToPower.setOnAction(ae -> {
            generalSetting('^');
        });

        myStage.setScene(mySceneWelcome);
        myStage.setResizable(false);
        myStage.show();
    }

    //Settings for the power operations
    private void power() {

        stTextFromPrimaryScreen = decimalPointCheck(stTextFromPrimaryScreen);
        tfScreenSecondary.setText(stTextFromPrimaryScreen);

        dFirstOperand = getOperand(stTextFromPrimaryScreen);

        stResult = getResult(operationSignHolder);
        stTextFromPrimaryScreen = stResult;

        tfScreenPrimary.setText(stTextFromPrimaryScreen);
    }

    //Adding the digits through pressing the buttons on the screen
    private void addDigit(char c) {
        stTextFromPrimaryScreen = stTextFromPrimaryScreen + c;
        tfScreenPrimary.setText(stTextFromPrimaryScreen);
    }

    //Settings when the basic operations buttons are pressed
    private void generalSetting(char s) {

        //Modifying the text from the primary screen if needed
        stTextFromPrimaryScreen = decimalPointCheck(stTextFromPrimaryScreen);

        /*
        Moving the text from the primary screen to the secondary screen,
         with the sign of the operation
        */
        stTextFromSecondaryScreen = stTextFromPrimaryScreen + " " + s + " ";
        tfScreenSecondary.setText(stTextFromSecondaryScreen);

        /*
        Getting the first operand and assigning the operationSignHolder
        which holds the sign of the operation for computing the results
           */
        dFirstOperand = getOperand(stTextFromPrimaryScreen);
        operationSignHolder = s;

        /*
        ReSetting the primary screen
         */
        stTextFromPrimaryScreen = "";
        tfScreenPrimary.setText(stTextFromPrimaryScreen);
    }

    //Parsing the operand
    private double getOperand(String st) {

        double operand;

        try {
            if (st.charAt(0) == '-') {
                st = st.substring(1);
                operand = -1 * Double.parseDouble(st);
            } else {
                operand = Double.parseDouble(st);
            }
        } catch (NumberFormatException e) {
            operand = 0.0;
        }

        return operand;
    }

    //Computing the results for basic operations + - * / .
    private String getResult(char ch) {

        switch (ch) {
            case '+': {
                return stResult = "" + (dFirstOperand + dSecondOperand);
            }
            case '-': {
                return stResult = "" + (dFirstOperand - dSecondOperand);
            }
            case '×': {
                return stResult = "" + (dFirstOperand * dSecondOperand);
            }
            case '÷': {
                return stResult = "" + (dFirstOperand / dSecondOperand);
            }
            case '2':
            case '3':
            case '^': {
                return stResult = "" + Math.pow(dFirstOperand, dSecondOperand);
            }
            case '⁒': {
                if (dSecondOperand == 100.0) {
                    return stResult = "" + (dFirstOperand / dSecondOperand);
                }
                return stResult = "" + (dFirstOperand % dSecondOperand);
            }
            case '√': {
                return stResult = "" + Math.sqrt(dFirstOperand);
            }
            case '∛': {
                return stResult = "" + Math.cbrt(dFirstOperand);
            }
            case 'i': {
                return stResult = "" + (1 / dFirstOperand);
            }
            case 'b': {
                return stResult = binaryToDecimal(dFirstOperand);
            }
            case 'l': {
                return stResult = "" + Math.log10(dFirstOperand);
            }
            case 'n': {
                return stResult = "" + Math.log(dFirstOperand);
            }
            case 's': {
                return stResult = "" + Math.sin(dFirstOperand);
            }
            case 'c': {
                return stResult = "" + Math.cos(dFirstOperand);
            }
            case 't': {
                return stResult = "" + Math.tan(dFirstOperand);
            }

            default:
                return stResult = "";
        }

    }

    /* For adding Zero after the decimal point,
        if no digit is specified
    */
    private String decimalPointCheck(String st) {

        if (st.charAt(st.length() - 1) == '.') {
            stTextFromPrimaryScreen += '0';
        }
        if (!st.contains(".")) {
            stTextFromPrimaryScreen += ".0";
        }
        if (st.charAt(0) == '.') {
            stTextFromPrimaryScreen = '0' + stTextFromPrimaryScreen;
        }
        return stTextFromPrimaryScreen;
    }

    //Getting the binary representation of a double
    private String binaryToDecimal(double d) {

        String result = "";

        int i = (int) d;

        while (i > 0) {
            if ((i % 2) == 0) {
                result = '0' + result;
            } else {
                result = '1' + result;
            }
            i /= 2;
        }
        return result;
    }
}

