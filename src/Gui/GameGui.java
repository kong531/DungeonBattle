//Owner: Kong Lee
//File to display Gui with button functions

package Gui;

//Import specific libraries
//import java.awt.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Assets.Enemy;
import Assets.Player;

public class GameGui extends JFrame implements ActionListener {

    // Label for the game's title
    private JLabel title = new JLabel("Dungeon Battle");

    // Fonts used in the game
    private Font titleFont = new Font("", Font.BOLD, 64);
    private Font textFont = new Font("", Font.PLAIN, 15);

    // Buttons used in the start menu
    private JButton startBtn = new JButton("Start");
    private JButton returnBtn = new JButton("Return");
    private JButton quitBtn = new JButton("Quit");
    private JButton readyBtn = new JButton("Ready!");

    // Button used in combat
    private JButton option1 = new JButton("Stab");
    private JButton option2 = new JButton("Punch");
    private JButton option3 = new JButton("Kick");
    private JButton option4 = new JButton("Guard");

    // Dimensions for the buttons
    private Dimension btnSize = new Dimension(100, 50);

    // Text areas for the player to see character, enemy, info, and output
    public JTextArea output = new JTextArea(10, 10);
    public JTextArea playerInfo = new JTextArea();
    public JTextArea enemyInfo = new JTextArea();
    public JTextArea info = new JTextArea();

    // Scrollpane for the output; try using scrollbar
    private JScrollPane scroll = new JScrollPane(output);

    // Frames for each window
    private JFrame menuFrame = new JFrame("Menu");
    private JFrame startFrame = new JFrame("Start");
    private JFrame gameFrame = new JFrame("Game");

    // Panels for the menu and game's layout
    private JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel botPanel = new JPanel();
    private JPanel menuPanel = new JPanel(new GridLayout(2, 1));
    private JPanel combatPanel = new JPanel(new GridLayout(2, 2));
    private JPanel textPanel = new JPanel(new GridLayout(1, 1));
    private JPanel prepPanel = new JPanel(new GridLayout(2, 1));
    private JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    // Gets the player and enemy's values from Player.java and Enemy.java files
    private Player player = new Player();
    private Enemy enemy = new Enemy();

    // Random number generator
    private Random rand = new Random();

    // Initial variables for damage
    public int damage;
    public int taken;
    public int block;

    // Stats for the player character
    public int playerHealth;
    public int playerDamage;
    public String playerWeapon;
    public String playerClass;

    // Stats for the enemy character
    int enemyHealth = enemy.health;
    int enemyDamage = enemy.damage;
    String enemyWeapon = enemy.weapon;
    String enemyClass = enemy.enemyClass;

    public void reset() {
        // Values to change the characters' stats
        damage = 0;
        taken = 0;
        block = 0;

        // Stats for the player character
        playerHealth = player.health;
        playerDamage = player.damage;
        playerWeapon = player.weapon;
        playerClass = player.playerClass;

        // Stats for the enemy character
        enemyHealth = enemy.health;
        enemyDamage = enemy.damage;
        enemyWeapon = enemy.weapon;
        enemyClass = enemy.enemyClass;
    }

    public void setFrameSize(JFrame frame) {
        // Method to create fullscreen
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        frame.add(title);
        frame.setVisible(true);
        frame.setResizable(false);
        device.setFullScreenWindow(frame);
    }

    public GameGui(String game) {
        super(game);
        // Sets the size of the window
        setSize(1000, 700);

        // Method to make fullscreen based on device size; doesnt fill the entire
        // but it can using the maximum window button

        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // setSize(screenSize.width, screenSize.height);

        // Makes the window fullscreen; works but can't exit with the x button
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        // setUndecorated(true);
        // setVisible(true);

        // Sets the fullscreen for each frame
        // setFrameSize(menuFrame);
        // setFrameSize(startFrame);
        // setFrameSize(gameFrame);

        // Sets the overall layout of the window
        setLayout(new GridLayout(2, 1));

        // Sets an operation to close the game when pressing the exit button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets scroll values
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Sets the visibility of the game's assets
        // menuFrame.setVisible(true);

        // Creates the planes
        // createTopPanel();
        // createMenuPanel();
        // createNewPanel();
        // createBotPanel();
        // createTextPanel();
        // createPrepPanel();
        // createPlayerInfo();
        // createEnemyInfo();
        // createInfoPanel();
        // createExitPanel();

        // Create the menu frame
        // createMenuFrame();

        // Create the start frame

        // Create the combat frame

        // Adds the panels to the client
        // addPanelsToFrame();

        // Adds other settings and action listeners
        additionalSettings();
        addActionListeners();
    }

    public void buttonSetUp(JPanel panel, JButton button) {
        panel.add(button);
        button.setPreferredSize(btnSize);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
    }

    public void createMenuFrame() {
        // Add the topPanel to menuFrame
        menuFrame.add(topPanel);

        // Sets the background color of topPanel
        topPanel.setBackground(Color.black);

        // Add the title to topPanel
        topPanel.add(title);

        // Set the font of title
        title.setFont(titleFont);
        // Sets the foreground color of the title
        title.setForeground(Color.black);
    }

    // Function to set up the top panel
    private void createTopPanel() {
        // Sets the background color of topPanel part of the menu
        topPanel.setBackground(Color.green);

        // Adds title
        topPanel.add(title);

        // Sets the font of title
        title.setFont(titleFont);

        // Sets the foreground color for the title
        title.setForeground(Color.white);

        // Adds textPanel to topPanel
        topPanel.add(textPanel);

        // Sets the visibility of textPanel
        textPanel.setVisible(false);

        // Adds infoPanel to topPanel
        topPanel.add(infoPanel);

        // Sets the visibility of infoPanel
        infoPanel.setVisible(false);
    }

    // Function to set up the bottom panel
    private void createBotPanel() {
        // Sets the background color of botPanel part of the menu
        botPanel.setBackground(Color.black);

        // Adds menuPanel to botPanel
        botPanel.add(menuPanel);

        // Adds newPanel to botPanel
        botPanel.add(combatPanel);

        // Adds prepPanel to botPanel
        botPanel.add(prepPanel);

        // Adds exitPanel to botPanel
        botPanel.add(exitPanel);

        // Sets the visibility of newPanel
        combatPanel.setVisible(false);

        // Sets the visibility of prepPanel
        prepPanel.setVisible(false);

        // Sets the visibility of exitPanel
        exitPanel.setVisible(false);
    }

    // Function to set up the prep panel
    private void createPrepPanel() {
        // Sets the background color of prepPanel
        prepPanel.setBackground(Color.black);

        // Sets up the readyBtn for prepPanel
        buttonSetUp(prepPanel, readyBtn);

        // Sets the visibility of newPanel
        combatPanel.setVisible(false);
    }

    // Function to set up the menu panel
    private void createMenuPanel() {
        // Sets tghe background color of menuPanel
        // menuPanel.setBackground(Color.black);

        // Sets the bounds of menuPanel
        menuPanel.setBounds(500, 550, 300, 100);

        // Sets up the startBtn for menuPanel
        buttonSetUp(menuPanel, startBtn);

        // Sets up the quitBtn for menuPanel
        buttonSetUp(menuPanel, quitBtn);
    }

    // Function to set up the new panel
    private void createNewPanel() {
        // Sets the bounds of newPanel
        combatPanel.setBounds(0, 0, 500, 100);

        // Sets up option1 for combatPanel
        buttonSetUp(combatPanel, option1);

        // Sets up option2 for combatPanel
        buttonSetUp(combatPanel, option2);

        // Sets up option3 for combatPanel
        buttonSetUp(combatPanel, option3);

        // Sets up option4 for combatPanel
        buttonSetUp(combatPanel, option4);
    }

    // Function to set up the text panel
    private void createTextPanel() {
        // Adds playerInfo to textPanel
        textPanel.add(playerInfo);

        // Sets the preffered size of playerInfo
        playerInfo.setPreferredSize(new Dimension(320, 200));

        // Sets the foreground color of playerInfo
        playerInfo.setForeground(Color.white);

        // Adds the scrollbar for textPanel
        textPanel.add(scroll, BorderLayout.EAST);

        // Adds enemyInfo to textPanel
        textPanel.add(enemyInfo);

        // Sets the preffered size of enemyInfo
        enemyInfo.setPreferredSize(new Dimension(320, 200));

        // Sets the foreground color of enemyinfo
        enemyInfo.setForeground(Color.white);
    }

    // Function to set up the player's info
    private void createPlayerInfo() {
        // Sets the background color of playerInfo
        playerInfo.setBackground(Color.white);

        // Sets the foreground color of playerInfo
        playerInfo.setForeground(Color.black);

        // Adds the override string from Player.java to playerInfo
        playerInfo.append(player.toString());
    }

    // Function to set up the enemy's info
    private void createEnemyInfo() {
        // Sets the background color of enemyInfo
        enemyInfo.setBackground(Color.white);

        // Sets the foreground color of enemyInfo
        enemyInfo.setForeground(Color.black);

        // Adds the override string from Player.java to enemyInfo
        enemyInfo.append(enemy.toString());
    }

    // Function to set up the info panel
    private void createInfoPanel() {
        // Adds info to infoPanel
        infoPanel.add(info);
        infoPanel.setBackground(Color.white);

        // Sets the preffered size of info
        info.setPreferredSize(new Dimension(900, 200));

        // Appends the following text to info
        info.append("Welcome adventurer! There's a dungeon full of valuable treasures, don't come back empty handed! "
                +
                "Be warned, the wicked \ncreatures that lurks within will try to stop any trespassers. "
                +
                "Remember, you are an adventurer, if those monsters give you trouble, \nshow em who's boss.\n\n"
                + "Instructions:\r\n"
                +
                "You have four sets of actions, each having their own effects that help you combat the various creatures that dares to stop you.");

        // Sets the font of info
        info.setFont(textFont);

        // Sets the background color of info
        info.setBackground(Color.white);
    }

    // Function to set up the exit panel
    private void createExitPanel() {
        // Sets up the returnBtn for exitPanel
        buttonSetUp(exitPanel, returnBtn);
    }

    // Function to add the panels to the window
    private void addPanelsToFrame() {
        // Adds topPanel to the frame
        add(topPanel, BorderLayout.NORTH);

        // Adds botPanel to the frame
        add(botPanel, BorderLayout.CENTER);
    }

    // Function to set up the action listeners
    private void addActionListeners() {
        // Sets the action listener to startBtn
        startBtn.addActionListener(this);

        // Sets the action listener to quitBtn
        quitBtn.addActionListener(this);

        // Sets the action listener to readyBtn
        readyBtn.addActionListener(this);

        // Sets the action listener to returnBtn
        returnBtn.addActionListener(this);

        // Sets the action listener to option1
        option1.addActionListener(this);

        // Sets the action listener to option2
        option2.addActionListener(this);

        // Sets the action listener to option3
        option3.addActionListener(this);

        // Sets the action listener to option4
        option4.addActionListener(this);
    }

    // Function to set up additional settings
    private void additionalSettings() {
        // Sets editable of output
        output.setEditable(false);

        // Sets the background color of output
        output.setBackground(Color.white);

        // Sets editable of info
        info.setEditable(false);

        // Sets the background color of info
        info.setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Sets the action command of a button depending on which ones is pressed
        String callingBtn = e.getActionCommand();

        // Several cases of the type of button pressed for the menu

        // When the start button is pressed
        if (callingBtn.equals("Start")) {
            // Sets the visibility of menuPanel
            menuPanel.setVisible(false);

            // Sets the visibility of prepPanel
            prepPanel.setVisible(true);

            // Sets the visibility of newPanel
            combatPanel.setVisible(false);

            // Sets the visibility of title
            title.setVisible(false);

            // Sets the visibility of infoPanel
            infoPanel.setVisible(true);
        }

        // When the quit button is pressed
        else if (callingBtn.equals("Quit")) {
            // Releases all assets; closes everything
            dispose();
        }

        // When the ready button is pressed
        else if (callingBtn.equals("Ready!")) {
            // Sets the output text
            output.setText("");

            // Sets the visibility of menuPanel
            menuPanel.setVisible(false);

            // Sets the visibility of prepPanel
            prepPanel.setVisible(false);

            // Sets the visibility of newPanel
            combatPanel.setVisible(true);

            // Sets the visibility of title
            title.setVisible(false);

            // Sets the visibility of infoPanel
            infoPanel.setVisible(false);

            // Sets the visibility of textPanel
            textPanel.setVisible(true);
        }

        // When the return button is pressed
        else if (callingBtn.equals("Return")) {
            // Sets the visibility of exitPanel
            exitPanel.setVisible(false);

            // Sets the visibility of textPanel
            textPanel.setVisible(false);

            // Sets the visibility of menuPanel
            menuPanel.setVisible(true);

            // Sets the visibility of title
            title.setVisible(true);

            // Resets the player
            player = new Player();

            // Resets the playerInfo text
            playerInfo.setText("");

            // Appends player.toString() to playerInfo
            playerInfo.append(player.toString());

            // Resets the enemy
            enemy = new Enemy();

            // Resets the enemyInfo text
            enemyInfo.setText("");

            // Appends enemy.toString() to enemyInfo
            enemyInfo.append(enemy.toString());

            reset();
        }

        // Several cases of the type of button pressed for combat

        // When the stab button is pressed
        else if (callingBtn.equals("Stab")) {

        }

        // When the punch button is pressed
        else if (callingBtn.equals("Punch")) {

        }

        // When the kick button is pressed
        else if (callingBtn.equals("Kick")) {

        }

        // When the guard button is pressed
        else if (callingBtn.equals("Guard")) {

        }
    }
}