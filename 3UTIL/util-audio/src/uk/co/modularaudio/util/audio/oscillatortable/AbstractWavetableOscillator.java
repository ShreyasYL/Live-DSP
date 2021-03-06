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

package uk.co.modularaudio.util.audio.oscillatortable;

public abstract class AbstractWavetableOscillator implements Oscillator
{
	protected double currentPosition = 0.0;
	protected WaveTableValueFetcher valueFetcher;
	protected PulseWidthMapper pulseWidthMapper;

	public AbstractWavetableOscillator( final WaveTableValueFetcher valueFetcher, final PulseWidthMapper pulseWidthMapper )
	{
		this.valueFetcher = valueFetcher;
		this.pulseWidthMapper = pulseWidthMapper;
	}

	@Override
	public void resetPhase( final float newPhase )
	{
		currentPosition = (newPhase < 0.0f ? 0.0f : (newPhase > 1.0f ? 1.0f : newPhase ) );
	}

}
