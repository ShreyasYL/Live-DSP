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

package uk.co.modularaudio.mads.base.scaleandoffset.ui;

import javax.swing.JComponent;

import uk.co.modularaudio.mads.base.scaleandoffset.mu.ScaleAndOffsetMadDefinition;
import uk.co.modularaudio.mads.base.scaleandoffset.mu.ScaleAndOffsetMadInstance;
import uk.co.modularaudio.util.audio.gui.mad.IMadUiControlInstance;
import uk.co.modularaudio.util.audio.mad.ioqueue.ThreadSpecificTemporaryEventStorage;
import uk.co.modularaudio.util.audio.mad.timing.MadTimingParameters;
import uk.co.modularaudio.util.audio.mvc.displayslider.models.SAOOffsetSliderModel;
import uk.co.modularaudio.util.mvc.displayslider.SliderDisplayController;
import uk.co.modularaudio.util.mvc.displayslider.SliderDisplayModel;
import uk.co.modularaudio.util.mvc.displayslider.SliderDisplayModel.ValueChangeListener;
import uk.co.modularaudio.util.swing.lwtc.LWTCControlConstants;
import uk.co.modularaudio.util.swing.mvc.lwtcsliderdisplay.LWTCSliderDisplayView;
import uk.co.modularaudio.util.swing.mvc.lwtcsliderdisplay.LWTCSliderDisplayView.DisplayOrientation;
import uk.co.modularaudio.util.swing.mvc.lwtcsliderdisplay.LWTCSliderDisplayView.SatelliteOrientation;

public class ScaleAndOffsetOffsetUiJComponent
	implements IMadUiControlInstance<ScaleAndOffsetMadDefinition, ScaleAndOffsetMadInstance, ScaleAndOffsetMadUiInstance>
{
//	private static Log log = LogFactory.getLog( ScaleAndOffsetScaleUiJComponent.class.getName() );

	private final SliderDisplayModel model;
	private final LWTCSliderDisplayView view;

	public ScaleAndOffsetOffsetUiJComponent( final ScaleAndOffsetMadDefinition definition,
			final ScaleAndOffsetMadInstance instance,
			final ScaleAndOffsetMadUiInstance uiInstance,
			final int controlIndex )
	{
		model = new SAOOffsetSliderModel();
		final SliderDisplayController controller = new SliderDisplayController( model );
		view = new LWTCSliderDisplayView( model,
				controller,
				SatelliteOrientation.LEFT,
				DisplayOrientation.HORIZONTAL,
				SatelliteOrientation.RIGHT,
				LWTCControlConstants.SLIDER_VIEW_COLORS,
				"Offset:",
				false,
				true );

		model.addChangeListener( new ValueChangeListener()
		{

			@Override
			public void receiveValueChange( final Object source, final float newValue )
			{
				uiInstance.sendOffsetChange( newValue );
			}
		} );
	}

	@Override
	public JComponent getControl()
	{
		return view;
	}

	@Override
	public void doDisplayProcessing( final ThreadSpecificTemporaryEventStorage tempEventStorage,
			final MadTimingParameters timingParameters,
			final long currentGuiTime)
	{
	}

	@Override
	public void destroy()
	{
	}

	@Override
	public String getControlValue()
	{
		return Float.toString(model.getValue());
	}

	@Override
	public void receiveControlValue( final String valueStr )
	{
		model.setValue( this, Float.parseFloat( valueStr ) );
	}

	@Override
	public boolean needsDisplayProcessing()
	{
		return false;
	}
}
