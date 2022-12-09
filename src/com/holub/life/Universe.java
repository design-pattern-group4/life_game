package com.holub.life;

import com.holub.io.Files;
import com.holub.keyboard.*;
import com.holub.ui.MenuSite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * The Universe is a mediator that sits between the Swing
 * event model and the Life classes. It is also a singleton,
 * accessed via Universe.instance(). It handles all
 * Swing events and translates them into requests to the
 * outermost Neighborhood. It also creates the Composite
 * Neighborhood.
 *
 * @include /etc/license.txt
 */

public class Universe extends JPanel
{	private 		final Cell  	outermostCell;
	private static	final Universe 	theInstance = new Universe();

	/** The default height and width of a Neighborhood in cells.
	 *  If it's too big, you'll run too slowly because
	 *  you have to update the entire block as a unit, so there's more
	 *  to do. If it's too small, you have too many blocks to check.
	 *  I've found that 8 is a good compromise.
	 */

	// Universe로 갔음 초기 화하는 부분
	// gride 사이즈 결정하는 곳
	// -> 적당한 gride size가 8이라는 것을 발견 했다고함. 너무 작으면 누를 블럭이 많아지나봐
	//private static final int  DEFAULT_GRID_SIZE = 8;
	// cell size 결정하는 곳
	//private static final int  DEFAULT_CELL_SIZE = 8;

	// The constructor is private so that the universe can be created
	// only by an outer-class method [Neighborhood.createUniverse()]
	// private static final 로 초기값 주면... 계속 메모리에 남아 있으니깐 지웠음.
	GridCellsize gcsize  = GridCellsize.getInstance();

	// grid size변경 Function
	//cell이 grid보다 크면 안됨. 따라서, cell size는 처음 8 고정으로 유지하고 mapsize를 변경하는 걸로
	private void changeMap(int gridsize){
		outermostCell.clear();
		gcsize.changeGridSize(gridsize);

		outermostCell.changeMap(gcsize.getGridSize());
		repaint();

	}



//	private static int pointerX = 0;
//	private static int pointerY = 0;
	private static Point before, cur;
	private static boolean isFirst = true;
	private static List<KeyBoardBehavior> keyBoardStrategies = Arrays.asList(new MoveUpBehavior(), new MoveLeftBehavior(), new MoveDownBehavior(), new MoveRightBehavior(), new SelectBehavior());




	private Universe()
	{	// Create the nested Cells that comprise the "universe." A bug
		// in the current implementation causes the program to fail
		// miserably if the overall size of the grid is too big to fit
		// on the screen.


		// => negiborhood gridsize가 여기서 정해짐. 즉, gridsize를 계속 바꾸면 negiborhood에 있는 값도 계속 바뀜
		// 즉, 다른 클래스간 데이터 공유가 쉬워야함. 여러 클래스에서 접근하여 사용하기 때문에, 많은 인스턴스가 만들어지면 좋지가 않음. 한개만 존재하는게 좋음.(?) -> singleton
		outermostCell = new Neighborhood
						(
							new Neighborhood
							(
								new Resident()
							)
						);
		cur = new Point(0, 0);
		final Dimension PREFERRED_SIZE =
						new Dimension
						(  outermostCell.widthInCells() * gcsize.getCellSize(),
						   outermostCell.widthInCells() * gcsize.getCellSize()
						);

		addComponentListener
		(	new ComponentAdapter()
			{	public void componentResized(ComponentEvent e)
				{
					// Make sure that the cells fit evenly into the
					// total grid size so that each cell will be the
					// same size. For example, in a 64x64 grid, the
					// total size must be an even multiple of 63.

					Rectangle bounds = getBounds();
					bounds.height /= outermostCell.widthInCells();
					bounds.height *= outermostCell.widthInCells();
					bounds.width  =  bounds.height;
					setBounds( bounds );
				}
			}
		);

		// 화면 색 설정하는 부분
		setBackground	( Color.white	 );
		// 레이아웃 크기 설정??????
		setPreferredSize( PREFERRED_SIZE );
		setMaximumSize	( PREFERRED_SIZE );
		setMinimumSize	( PREFERRED_SIZE );
		setOpaque		( true			 );

		addMouseListener					//{=Universe.mouse}
		(	new MouseAdapter()
			{	public void mousePressed(MouseEvent e)
				{	Rectangle bounds = getBounds();
					bounds.x = 0;
					bounds.y = 0;
					System.out.println(e.getPoint().x + " " + e.getPoint().y + " pressed");
					outermostCell.userClicked(e.getPoint(),bounds);
					repaint();
				}
			}
		);

		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("---" + e.getKeyChar() + "---");

				Rectangle bounds = getBounds();
				bounds.x = 0;
				bounds.y = 0;
				//int pixelsPerCell = (bounds.width / gcsize.getGridSize()) / gcsize.getGridSize() ;
				gcsize.calculatePixelsPercell(bounds.width);
				System.out.println(gcsize.getPixelsPerCell());
				before = new Point(cur.x, cur.y);

				KeyBoardBehavior keyStrategy = getKeyBoardStrategy(e.getKeyChar());
				if(keyStrategy != null){
					keyStrategy.action(outermostCell, cur, before, bounds, gcsize.getPixelsPerCell(), isFirst);
				}

				isFirst = false;
				repaint();
			}
		});


		MenuSite.addLine( this, "Grid", "Clear",
			new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{	outermostCell.clear(); // -> 따라 들어가보니깐, outermostCell 은 Cell이고 이거 구현하는게 Neighborhood 거기서 그리드 전체 clear하고 있음
					repaint();
				}
			}
		);

		MenuSite.addLine			// {=Universe.load.setup}
		(	this, "Grid", "Load",
			new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{	doLoad();
				}
			}
		);

		MenuSite.addLine
		(	this, "Grid", "Store",
			new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{	doStore();
				}
			}
		);

		MenuSite.addLine
		(	this, "Grid", "Exit",
			new ActionListener()
			{	public void actionPerformed(ActionEvent e)
		        {	System.exit(0);
		        }
			}
		);




		MenuSite.addLine
				(	this, "MapSize", "2X2",
						new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
						{
							isFirst = true;
							changeMap(2);
						}
						}
				);

		MenuSite.addLine
				(	this, "MapSize", "4X4",
						new ActionListener()
						{	public void actionPerformed(ActionEvent e)
						{
							isFirst = true;
							changeMap(4);
						}
						}
				);

		MenuSite.addLine
				(	this, "MapSize", "8X8",
						new ActionListener()
						{	public void actionPerformed(ActionEvent e)
						{
							isFirst = true;
							changeMap(8);
						}
						}
				);













		MenuSite.addLine( this, "Example", "Test",
				new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						System.out.println("메뉴의 동작");
					}
				}
		);





		Clock.instance().addClockListener //{=Universe.clock.subscribe}
		(	new Clock.Listener()
			{	public void tick()
				{	if( outermostCell.figureNextState
						   ( Cell.DUMMY,Cell.DUMMY,Cell.DUMMY,Cell.DUMMY,
							 Cell.DUMMY,Cell.DUMMY,Cell.DUMMY,Cell.DUMMY
						   )
					  )
					{	if( outermostCell.transition() )
							refreshNow();
					}
				}
			}
		);
	}

	public static KeyBoardBehavior getKeyBoardStrategy(char pressedKey) {
		return keyBoardStrategies.stream()
				.filter(strategy -> strategy.isPressed(pressedKey))
				.findAny()
				.orElseThrow(()-> new IllegalArgumentException("정의되지 않은 입력"));
	}

	/** Singleton Accessor. The Universe object itself is manufactured
	 *  in Neighborhood.createUniverse()
	 */

	public static Universe instance()
	{	return theInstance;
	}

	private void doLoad()
	{	try
		{
			FileInputStream in = new FileInputStream(Files.userSelected(".",".life","Life File","Load"));


			Clock.instance().stop();		// stop the game and
			outermostCell.clear();			// clear the board.

			Storable memento = outermostCell.createMemento();
			memento.load( in );
			outermostCell.transfer( memento, new Point(0,0), Cell.LOAD );

			in.close();
		}
		catch( IOException theException )
		{	JOptionPane.showMessageDialog( null, "Read Failed!",
					"The Game of Life", JOptionPane.ERROR_MESSAGE);
		}
		repaint();
	}

	private void doStore()
	{	try
		{
			FileOutputStream out = new FileOutputStream(
					Files.userSelected(".",".life","Life File","Write"));

			Clock.instance().stop();		// stop the game

			Storable memento = outermostCell.createMemento();
			outermostCell.transfer( memento, new Point(0,0), Cell.STORE );
			memento.flush(out);

			out.close();
		}
		catch( IOException theException )
		{	JOptionPane.showMessageDialog( null, "Write Failed!",
					"The Game of Life", JOptionPane.ERROR_MESSAGE);
		}
	}

	/** Override paint to ask the outermost Neighborhood
	 *  (and any subcells) to draw themselves recursively.
	 *  All knowledge of screen size is also encapsulated.
	 *  (The size is passed into the outermost <code>Cell</code>.)
	 */

	public void paint(Graphics g)
	{
		Rectangle panelBounds = getBounds();
		Rectangle clipBounds  = g.getClipBounds();

		// The panel bounds is relative to the upper-left
		// corner of the screen. Pretend that it's at (0,0)
		panelBounds.x = 0;
		panelBounds.y = 0;
		outermostCell.redraw(g, panelBounds, true);		//{=Universe.redraw1}
	}

	/** Force a screen refresh by queing a request on
	 *  the Swing event queue. This is an example of the
	 *  Active Object pattern (not covered by the Gang of Four).
	 *  This method is called on every clock tick. Note that
	 *  the redraw() method on a given <code>Cell</code>
	 *  does nothing if the <code>Cell</code> doesn't
	 *  have to be refreshed.
	 */

	private void refreshNow()
	{	SwingUtilities.invokeLater
		(	new Runnable()
			{	public void run()
				{	Graphics g = getGraphics();
					if( g == null )		// Universe not displayable
						return;
					try
					{
						Rectangle panelBounds = getBounds();
						panelBounds.x = 0;
						panelBounds.y = 0;
						outermostCell.redraw(g, panelBounds, false); //{=Universe.redraw2}
					}
					finally
					{	g.dispose();
					}
				}
			}
		);
	}

	public Cell getOutermostCell() {
		return outermostCell;
	}

	public static Point getBefore() {
		return before;
	}

	public static Point getCur() {
		return cur;
	}

	public static boolean getIsFirst() {
		return isFirst;
	}

	public static List<KeyBoardBehavior> getKeyBoardStrategies() {
		return keyBoardStrategies;
	}
//
//	public static int getDefaultGridSize(){
//		return DEFAULT_GRID_SIZE;
//	}
//
//	public static int getDefaultCellSize(){
//		return DEFAULT_CELL_SIZE;
//	}
}
