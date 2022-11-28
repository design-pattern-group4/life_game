package com.holub.life;

import com.holub.ui.*;

import javax.swing.*;

import com.holub.ui.MenuSite;
import com.holub.ui.MenuVisitor;
import java.awt.*;

/*******************************************************************
 * An implemenation of Conway's Game of Life.
 *
 * @include /etc/license.txt
 */

public final class Life extends JFrame
{	
	private static JComponent universe;

	public static void main( String[] arguments )
	{	new Life();
	}

	private Life()
	{
		super("채조보양's The Game of Life. ");


		// Must establish the MenuSite very early in case
		// a subcomponent puts menus on it.
		MenuSite.establish( this );		//{=life.java.establish}

		setDefaultCloseOperation	( EXIT_ON_CLOSE 		);
		getContentPane().setLayout	( new BorderLayout()	);
		getContentPane().add( Universe.instance(), BorderLayout.CENTER); //{=life.java.install}

		MenuVisitor visitor = new MenuVisitor();



		pack();
		setVisible( true );
	}
}
