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

package uk.co.modularaudio.mads.base.crossfader.mu;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.co.modularaudio.util.audio.mad.ioqueue.IOQueueEvent;
import uk.co.modularaudio.util.audio.mad.ioqueue.MadLocklessQueueBridge;
import uk.co.modularaudio.util.audio.mad.ioqueue.ThreadSpecificTemporaryEventStorage;

public class CrossFaderIOQueueBridge extends MadLocklessQueueBridge<CrossFaderMadInstance>
{
	private static Log log = LogFactory.getLog( CrossFaderIOQueueBridge.class.getName() );

	public static final int COMMAND_AMPA_AMPB = 0;

	public CrossFaderIOQueueBridge()
	{
	}

	@Override
	public void receiveQueuedEventsToInstance( final CrossFaderMadInstance instance,
			final ThreadSpecificTemporaryEventStorage tses,
			final long periodTimestamp,
			final IOQueueEvent queueEntry )
	{
		switch( queueEntry.command )
		{
			case COMMAND_AMPA_AMPB:
			{
				final long value = queueEntry.value;
				final int lower32Bits = (int)((value ) & 0xFFFFFFFF);
				final int upper32Bits = (int)((value >> 32 ) & 0xFFFFFFFF);
				final float ampA = Float.intBitsToFloat( lower32Bits );
				final float ampB = Float.intBitsToFloat( upper32Bits );
				instance.setDesiredAmps( ampA, ampB );
				break;
			}
			default:
			{
				final String msg = "Unknown command passed on incoming queue: " + queueEntry.command;
				log.error( msg );
			}
		}
	}
}
