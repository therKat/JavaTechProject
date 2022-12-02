package main;

import javax.swing.UIManager;

import view.QLSVView;

public class main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLSVView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}