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

import uk.co.modularaudio.mads.base.BaseComponentsCreationContext;
import uk.co.modularaudio.service.madclassification.MadClassificationService;
import uk.co.modularaudio.util.audio.mad.MadChannelDirection;
import uk.co.modularaudio.util.audio.mad.MadChannelPosition;
import uk.co.modularaudio.util.audio.mad.MadChannelType;
import uk.co.modularaudio.util.audio.mad.MadClassification;
import uk.co.modularaudio.util.audio.mad.MadClassification.ReleaseState;
import uk.co.modularaudio.util.audio.mad.helper.AbstractNonConfigurableMadDefinition;
import uk.co.modularaudio.util.exception.DatastoreException;
import uk.co.modularaudio.util.exception.RecordNotFoundException;

public class CrossFaderMadDefinition extends AbstractNonConfigurableMadDefinition<CrossFaderMadDefinition, CrossFaderMadInstance>
{
	// Indexes into the channels
	public final static int CONSUMER_CHAN1_LEFT = 0;
	public final static int CONSUMER_CHAN1_RIGHT = 1;
	public final static int CONSUMER_CHAN2_LEFT = 2;
	public final static int CONSUMER_CHAN2_RIGHT = 3;
	public final static int PRODUCER_OUT_LEFT = 4;
	public final static int PRODUCER_OUT_RIGHT = 5;
	public final static int NUM_CHANNELS = 6;

	public static final String DEFINITION_ID = "cross_fader";

	private final static String USER_VISIBLE_NAME = "Cross Fader";

	private final static String CLASS_GROUP = MadClassificationService.SOUND_ROUTING_GROUP_ID;
	private final static String CLASS_NAME = "Cross Fader";
	private final static String CLASS_DESC = "A simple cross fader";

	// These must match the channel indexes given above
	private final static String[] CHAN_NAMES = new String[] { "Input Channel 1 Left",
		"Input Channel 1 Right",
		"Input Channel 2 Left",
		"Input Channel 2 Right",
		"Output Wave Left",
		"Output Wave Right" };

	private final static MadChannelType[] CHAN_TYPES = new MadChannelType[] { MadChannelType.AUDIO,
		MadChannelType.AUDIO,
		MadChannelType.AUDIO,
		MadChannelType.AUDIO,
		MadChannelType.AUDIO,
		MadChannelType.AUDIO };

	private final static MadChannelDirection[] CHAN_DIRS = new MadChannelDirection[] { MadChannelDirection.CONSUMER,
		MadChannelDirection.CONSUMER,
		MadChannelDirection.CONSUMER,
		MadChannelDirection.CONSUMER,
		MadChannelDirection.PRODUCER,
		MadChannelDirection.PRODUCER };

	private final static MadChannelPosition[] CHAN_POSI = new MadChannelPosition[] { MadChannelPosition.STEREO_LEFT,
		MadChannelPosition.STEREO_RIGHT,
		MadChannelPosition.STEREO_LEFT,
		MadChannelPosition.STEREO_RIGHT,
		MadChannelPosition.STEREO_LEFT,
		MadChannelPosition.STEREO_RIGHT };

	public CrossFaderMadDefinition( final BaseComponentsCreationContext creationContext,
			final MadClassificationService classService ) throws RecordNotFoundException, DatastoreException
	{
		super( DEFINITION_ID, USER_VISIBLE_NAME,
				new MadClassification( classService.findGroupById( CLASS_GROUP ),
						DEFINITION_ID,
						CLASS_NAME,
						CLASS_DESC,
						ReleaseState.RELEASED ),
				new CrossFaderIOQueueBridge(),
				NUM_CHANNELS,
				CHAN_NAMES,
				CHAN_TYPES,
				CHAN_DIRS,
				CHAN_POSI );

	}
}
