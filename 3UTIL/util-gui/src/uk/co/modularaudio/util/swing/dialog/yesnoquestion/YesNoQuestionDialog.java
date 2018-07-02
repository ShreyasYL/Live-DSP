/**
 *
 * Copyright (C) 2015 - Daniel Hams, Modular Audio Limited
 *                      daniel.hams@gmail.com
 *
 * Mad is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Mad is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Mad.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package uk.co.modularaudio.util.swing.dialog.yesnoquestion;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JDialog;

public class YesNoQuestionDialog extends JDialog
{
	private static final long serialVersionUID = -2754047150668644731L;

//	private static Log log = LogFactory.getLog( YesNoQuestionDialog.class.getName() );

	private final YesNoQuestionPanel yesNoQuestionPanel;

	public YesNoQuestionDialog()
	{
		yesNoQuestionPanel = new YesNoQuestionPanel( this );
		this.setModal( true );

		this.setMinimumSize( new Dimension( 300, 150 ) );

		this.add( yesNoQuestionPanel );
		this.pack();
	}

	public void setValues( final Component parentComponent,
			final String message,
			final String title,
			final int messageType,
			final String[] options,
			final String defaultChoice,
			final YesNoQuestionDialogCallback callback )
	{
		this.setTitle( title );
		yesNoQuestionPanel.setValues( message, messageType, options, defaultChoice, callback );
		this.pack();

		this.setLocationRelativeTo( parentComponent );
	}

	public void go()
	{
		setVisible( true );
	}

}
