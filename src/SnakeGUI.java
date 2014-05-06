import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class SnakeGUI {
	private JFrame frame;
	public static void main(String[] args) {
		new SnakeGUI();
	}
	private SnakeGUI(){
		makeFrame();
	
	}
	/**
     * Start function: Starts the game.
     */
    private void startGame()
    {
    	int go = 0;
    	//JOptionPane.showMessageDialog(frame, "hej");
    	while(go==0){
    	String[] options = new String[] {"Easy", "Medium", "Hard"};
        int response = JOptionPane.showOptionDialog(frame, "Choose difficulty", "Difficulty",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]);
  
        if(response == 0){
        	//easy
        	JOptionPane.showMessageDialog(frame, "You choosed easy");
        	//play(easy/0); - ta en parameter som best�memer starthastighet
        }
        	//medium
        else if (response == 1){
        	JOptionPane.showMessageDialog(frame, "You choosed medium");
        		
        	}
        	//hard
        else if (response == 2){
        	JOptionPane.showMessageDialog(frame, "You choosed hard");
        	
        }
        	//if exit
        else{
        	JOptionPane.showMessageDialog(frame, "error/exit game", "error", JOptionPane.ERROR_MESSAGE);
        	}
        go = JOptionPane.showOptionDialog(frame, "Play again?", "Play",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, null, null);
        }
    }
    
	/**
     * Start function: Starts the game.
     */
    private void infoGame()
    {
    	JOptionPane.showMessageDialog(frame, "S� h�r spelar du");
    	JOptionPane.showMessageDialog(frame, "Styr ormen och �t �pplen");
    	//frame.pack();
    }
    
	/**
     * Highscore function: Give information about highscore.
     */
    private void highScore()
    {
    	JOptionPane.showMessageDialog(frame, "Inga highscore �n");
    	//frame.pack();
    }    
    
    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }
    
    // ---- swing stuff to build the frame and all its components ----
    
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("Snake");
        makeMenuBar(frame);
       
        
        //Container contentPane = frame.getContentPane();
        //add buttons
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(12, 12, 12, 12)); //add space from the walls

        JLabel fileNameLabel = new JLabel("~~~~~~Snake~~~~~~");
        contentPane.add(fileNameLabel, BorderLayout.NORTH);
     
        JPanel buttons = new JPanel(); //f�r neslade knappar
        //buttons.setBorder(new EmptyBorder(12, 12, 12, 12));
        buttons.setLayout(new GridLayout(0, 1));
        
        //start
        JButton startButton = new JButton("Play Game");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { startGame(); }
        });
        buttons.add(startButton);
        
        //info about the game
        JButton infoButton = new JButton("Instructions");
        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { infoGame(); }
        });
        buttons.add(infoButton);
        
        //button for highscore
        JButton highScoreButton = new JButton("High Score");
        highScoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { highScore(); }
        });
        buttons.add(highScoreButton);
        
        //short info about the game and the creators
        JButton aboutButton = new JButton("About");
        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(frame, "Johans och Christofers Snake-spel"); }
        });
        buttons.add(aboutButton);
        
        //quit game
        JButton quitButton = new JButton("Quit Game");
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { quit(); }
        });
        buttons.add(quitButton);
        
        
        //button in the center
        contentPane.add(buttons, BorderLayout.CENTER); //WEST an alternative
        
        
        //status label
        JLabel statusLabel = new JLabel("version 1.0");
        contentPane.add(statusLabel, BorderLayout.SOUTH);
        
        
        
        // building is done - arrange the components and show        
        frame.pack();
        frame.setVisible(true);
        
        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }    
    
    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();


        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File manu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
        
        JMenuItem GameItem = new JMenuItem("New Game");
            GameItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, SHORTCUT_MASK));
            GameItem.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { startGame(); }
                           });
        fileMenu.add(GameItem);

        JMenuItem quitItem = new JMenuItem("Quit");
            quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            quitItem.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { quit(); }
                           });
        fileMenu.add(quitItem);

    }
}

