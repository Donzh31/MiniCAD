import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * Description: the mainFrame class of MiniCAD
 * Extends: JFrame
 * @author Ziheng Duan
 */
public class myMainFrame extends JFrame{
	private static final long serialVersionUID = 3659345350703127276L;
	private myActionListener myActionListener;
	private myItemController myItemController;
	private myCanvas canvas;
	private myToolBar toolBar;
	private myMenuBar menuBar;
	
	public myMainFrame(myActionListener actListener, myItemController tarController){
		//initialize variables and panels
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolKit.getScreenSize();
		myItemController = tarController;
		myActionListener =  actListener;
		canvas = new myCanvas(myActionListener, myItemController);	
		toolBar = new myToolBar(myActionListener);
		menuBar = new myMenuBar(myActionListener);
	
		//initialize layout MainFrame 
		this.setTitle("MiniCAD");
		this.setMinimumSize(new Dimension(500, 500));
		this.setSize((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(5,5));
		this.setJMenuBar(menuBar);
		this.add(toolBar,BorderLayout.PAGE_START);
		this.add(canvas, BorderLayout.CENTER);	
		this.addKeyListener(actListener);
		this.setFocusable(true);
		this.setVisible(true);
	}
	
	public void repaintCanvas() {
		canvas.repaint();
	}
	
	public void requestCanvas()
	{
		canvas.requestFocus();
	}
	
	public Graphics2D getCanvasGraphics2d() {
		return (Graphics2D)canvas.getGraphics();
	} 
}

/**
 * Description: the menuBar class of MiniCAD
 * Extends: JMenuBar
 * @author Ziheng Duan
 */
class myMenuBar extends JMenuBar
{
	private static final long serialVersionUID = -6087080564688256949L;
	private JMenu fileMenu, operationMenu, helpMenu;
	private JMenuItem openFile, saveFile, aboutInfo, helpInfo;
	private JMenuItem createLine, createRect, createCircle, createText, scaleItem, moveItem;
	private myActionListener myActionListener;
	
	public myMenuBar(myActionListener actionListener) {
		// TODO Auto-generated constructor stub
		myActionListener = actionListener;
		
		fileMenu = new JMenu("File");
		operationMenu = new JMenu("Operation");
		helpMenu = new JMenu("Help");
		
		openFile = new JMenuItem("Open");
		openFile.setActionCommand("BTOPEN");
		openFile.addActionListener(myActionListener);
		fileMenu.add(openFile);
		
		saveFile = new JMenuItem("Save");
		saveFile.setActionCommand("BTSAVE");
		saveFile.addActionListener(myActionListener);
		fileMenu.add(saveFile);
		
		createLine = new JMenuItem("Create Line");
		createLine.setActionCommand("TYPE_LINE");
		createLine.addActionListener(myActionListener);
		operationMenu.add(createLine);
		
		createRect = new JMenuItem( "Create Rectangle");
		createRect.setActionCommand("TYPE_RECT");
		createRect.addActionListener(myActionListener);
		operationMenu.add(createRect);
		
		createCircle = new JMenuItem( "Create Circle");
		createCircle.setActionCommand("TYPE_ELLIPSE");
		createCircle.addActionListener(myActionListener);
		operationMenu.add(createCircle);
		
		createText = new JMenuItem( "Create Text");
		createText.setActionCommand("TYPE_TEXTE");
		createText.addActionListener(myActionListener);
		operationMenu.add(createText);
		
		operationMenu.addSeparator();
		
		scaleItem = new JMenuItem( "Scale item");
		scaleItem.setActionCommand("COMMAND_CHANGE_SIZE");
		scaleItem.addActionListener(myActionListener);
		operationMenu.add(scaleItem);
		
		moveItem = new JMenuItem("Move item");
		moveItem.setActionCommand("COMMAND_MOVE");
		moveItem.addActionListener(myActionListener);
		operationMenu.add(moveItem);
	
		aboutInfo = new JMenuItem("About");
		aboutInfo.setActionCommand("MENU_ABOUT");
		aboutInfo.addActionListener(myActionListener);
		helpMenu.add(aboutInfo);
		
		helpInfo = new JMenuItem("Help");
		helpInfo.setActionCommand("MENU_HELP");
		helpInfo.addActionListener(myActionListener);
		helpMenu.add(helpInfo);
		
		this.add(fileMenu);
		this.add(operationMenu);
		this.add(helpMenu);
		this.setPreferredSize(new Dimension(500, 32));
	}
}

/**
 * Description: the JToolBar class of MiniCAD
 * Extends: JToolBar
 * @author Ziheng Duan
 */
class myToolBar extends JToolBar
{
	private static final long serialVersionUID = 3743739626041084438L;
	private ImageIcon icLine, icRect, icCircle, icText, icOpen, icSave, icChose, icScale, icMove, icColor;
	private JButton  btSave, btOpen, btLine, btRect, btCircle, btText, btChose, btChangeSize, btMove, btColor;
	private myActionListener myActionListener;
	
	public myToolBar(myActionListener actListener)
	{
		myActionListener = actListener;
		icChose = new ImageIcon(new ImageIcon("icon/chose.png").getImage().getScaledInstance(25, 25, Image.SCALE_FAST)); 
		icOpen = new ImageIcon(new ImageIcon("icon/open.png").getImage().getScaledInstance(25, 25, Image.SCALE_FAST)); 
		icSave = new ImageIcon(new ImageIcon("icon/save.png").getImage().getScaledInstance(25, 25, Image.SCALE_FAST)); 
		icScale =new ImageIcon(new ImageIcon("icon/scale.png").getImage().getScaledInstance(25, 25, Image.SCALE_FAST)); 
		icMove = new ImageIcon(new ImageIcon("icon/move.png").getImage().getScaledInstance(25, 25, Image.SCALE_FAST)); 
		icColor = new ImageIcon(new ImageIcon("icon/color.png").getImage().getScaledInstance(25, 25, Image.SCALE_FAST)); 
		icLine = new  ImageIcon(new ImageIcon("icon/line.png").getImage().getScaledInstance(25, 25, Image.SCALE_FAST));
		icRect = new ImageIcon(new ImageIcon("icon/rect.png").getImage().getScaledInstance(25, 25, Image.SCALE_FAST)); 
		icCircle = new ImageIcon(new ImageIcon("icon/circle.png").getImage().getScaledInstance(25, 25, Image.SCALE_FAST)); 
	    icText = new ImageIcon(new ImageIcon("icon/text.png").getImage().getScaledInstance(25, 25, Image.SCALE_FAST)); 
		
	    btChose = new JButton(icChose);
	    btChose.setActionCommand("BTCHOSE");
	    btChose.addActionListener(myActionListener);
	    
		btOpen = new JButton(icOpen);
		btOpen.setActionCommand("BTOPEN");
		btOpen.addActionListener(myActionListener);
		
		btSave = new JButton(icSave);
		btSave.setActionCommand("BTSAVE");
		btSave.addActionListener(myActionListener);
		
		btLine = new JButton(icLine);
		btLine.setActionCommand("TYPE_LINE");
		btLine.addActionListener(myActionListener);
		
		btRect = new JButton(icRect);
		btRect.setActionCommand("TYPE_RECT");
		btRect.addActionListener(myActionListener);
		
		btCircle = new JButton(icCircle);
		btCircle.setActionCommand("TYPE_ELLIPSE");
		btCircle.addActionListener(myActionListener);
		
		btText = new JButton(icText);
		btText.setActionCommand("TYPE_TEXT");
		btText.addActionListener(myActionListener);
		
		btChangeSize = new JButton(icScale);
		btChangeSize.setActionCommand("COMMAND_CHANGE_SIZE");
		btChangeSize.addActionListener(myActionListener);
		
		btMove = new JButton(icMove);
		btMove.setActionCommand("COMMAND_MOVE");
		btMove.addActionListener(myActionListener);
		
		btColor = new JButton(icColor);
		btColor.setActionCommand("COMMAND_COLOR");
		btColor.addActionListener(myActionListener);
		
		this.add(btOpen);
		this.add(btSave);
		this.add(btChose);
		this.add(btLine);
		this.add(btRect);
		this.add(btCircle);
		this.add(btText);
		this.add(btChangeSize);
		this.add(btMove);
		this.add(btColor);
		this.setAlignmentX(0); 
	}
}

/**
 * Description: the canvas for painting
 * Extends: JPanel 
 * @author Ziheng Duan
 */
class myCanvas extends JPanel
{
	private static final long serialVersionUID = -2355712177102116341L;
	private myActionListener myActionListener;
	private myItemController myItemController;
	
	public myCanvas(myActionListener actListener, myItemController tarController)
	{
		this.myActionListener = actListener;
		this.myItemController = tarController;
		this.setBackground(Color.WHITE);
		this.addMouseListener(myActionListener);
		this.addMouseMotionListener(myActionListener);
		this.addKeyListener(myActionListener);
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.myItemController.paintAll(g);
	}
}










