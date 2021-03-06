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

package uk.co.modularaudio.service.gui.plugs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import uk.co.modularaudio.util.audio.gui.mad.MadUiChannelInstance;

public class GuiNoteChannelPlug extends GuiChannelPlug
{
	private static final long serialVersionUID = 8525746091614600992L;

	public GuiNoteChannelPlug(final MadUiChannelInstance sacd)
	{
		super(sacd);
	}

	@Override
	public void paint( final Graphics g )
	{
		if( DRAWN_PLUGS )
		{
			if( plugImage == null )
			{
				final int width = getWidth();
				final int height = getHeight();
				final String uniqueId = "note_" + width + "_" + height;
				plugImage = plugImageCache.fetchOrCreatePlugImage( uniqueId, width, height, this );
			}
			g.drawImage( plugImage, 0, 0, null );
		}
	}

	@Override
	public BufferedImage createPlugImage( final int width, final int height )
	{
		final BufferedImage newImage = new BufferedImage( getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB );
		final Graphics2D g2d = newImage.createGraphics();
		g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
		g2d.setColor( PLUG_INSIDE_COLOR );
		final int halfDiameter = PLUG_DIAMETER / 2;
		final int quarterDiameter = halfDiameter / 2;
		g2d.fillRect( quarterDiameter, quarterDiameter, halfDiameter, halfDiameter );
		g2d.setColor( PLUG_OUTLINE_COLOR );
		g2d.drawRect( quarterDiameter, quarterDiameter, halfDiameter, halfDiameter );

		return newImage;
	}

}
