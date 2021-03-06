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

package uk.co.modularaudio.util.audio.dsp;

public final class MidSideProcessor
{
	private MidSideProcessor()
	{
	}

	public final static void lrToMs(
			final float[] left, final float[] right,
			final float[] mid, final float[] side,
			final int frameOffset, final int length )
	{
		final int lastIndex = frameOffset + length;
		for( int i = frameOffset ; i < lastIndex ; i++ )
		{
			mid[ i ] = 0.5f * (left[i] + right[i]);
			side[ i ] = 0.5f * (left[i] - right[i]);
		}
	}

	public final static void msToLr(
			final float[] mid, final float[] side,
			final float[] left, final float[] right,
			final int frameOffset, final int length )
	{
		final int lastIndex = frameOffset + length;
		for( int i = frameOffset ; i < lastIndex ; i++ )
		{
			left[ i ] = mid[ i ] + side[ i ];
			right[ i ] = mid[ i ] - side[ i ];
		}
	}
}
