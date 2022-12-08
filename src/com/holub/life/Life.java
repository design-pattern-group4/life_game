package com.holub.life;

import com.holub.ui.MenuSite;
import com.holub.ui.MenuVisitor;

import javax.swing.*;
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
		super("채조보's The Game of Life. ");

		//1. 메인프레임을 만들어 메뉴사이트를 설치하고
		// Must establish the MenuSite very early in case
		// a subcomponent puts menus on it.
		MenuSite.establish( this );		//{=life.java.establish}


		setDefaultCloseOperation	( EXIT_ON_CLOSE 		);
		/*
		contentPane : 일반적인 컴포넌트들을 가질 수 있는 패널
		- 프레임 객체의 getContentPane()메소드를 이용해서 얻을 수 있다.
		 */

		//2. 게임보드(Universe)를 만들어 프레임에 설치한다.
		//컨텐츠 영역에 부착되는 구성요소들을 "BoarderLayout"으로 배치하겠다.
		getContentPane().setLayout	( new BorderLayout()	);
		getContentPane().add( Universe.instance(), BorderLayout.CENTER); //{=life.java.install}

		MenuVisitor visitor = new MenuVisitor();



		pack();
		setVisible( true );
	}
}
