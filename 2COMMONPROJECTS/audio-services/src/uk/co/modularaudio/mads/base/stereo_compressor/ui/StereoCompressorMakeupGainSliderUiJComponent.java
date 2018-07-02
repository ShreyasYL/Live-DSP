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

package uk.co.modularaudio.mads.base.stereo_compressor.ui;

import javax.swing.JComponent;

import uk.co.modularaudio.mads.base.stereo_compressor.mu.StereoCompressorMadDefinition;
import uk.co.modularaudio.mads.base.stereo_compressor.mu.StereoCompressorMadInstance;
import uk.co.modularaudio.util.audio.gui.mad.IMadUiControlInstance;
import uk.co.modularaudio.util.audio.mad.ioqueue.ThreadSpecificTemporaryEventStorage;
import uk.co.modularaudio.util.audio.mad.timing.MadTimingParameters;
import uk.co.modularaudio.util.audio.mvc.displayslider.models.CompressionOutputGainSliderModel;
import uk.co.modularaudio.util.mvc.displayslider.SliderDisplayController;
import uk.co.modularaudio.util.mvc.displayslider.SliderDisplayModel;
import uk.co.modularaudio.util.mvc.displayslider.SliderDisplayModel.ValueChangeListener;
import uk.co.modularaudio.util.swing.lwtc.LWTCControlConstants;
import uk.co.modularaudio.util.swing.mvc.lwtcsliderdisplay.LWTCSliderDisplayView;
import uk.co.modularaudio.util.swing.mvc.lwtcsliderdisplay.LWTCSliderDisplayView.DisplayOrientation;
import uk.co.modularaudio.util.swing.mvc.lwtcsliderdisplay.LWTCSliderDisplayView.SatelliteOrientation;

public class StereoCompressorMakeupGainSliderUiJComponent
	implements IMadUiControlInstance<StereoCompressorMadDefinition, StereoCompressorMadInstance, StereoCompressorMadUiInstance>
{
//	private static Log log = LogFactory.getLog( StereoCompressorMakeupGainSliderUiJComponent.class.getName() );

	private final SliderDisplayModel model;
	private final LWTCSliderDisplayView view;

	public StereoCompressorMakeupGainSliderUiJComponent( final StereoCompressorMadDefinition definition,
			final StereoCompressorMadInstance instance,
			final StereoCompressorMadUiInstance uiInstance,
			final int controlIndex )
	{
		model = new CompressionOutputGainSliderModel();
		final SliderDisplayController controller = new SliderDisplayController( model );
		view = new LWTCSliderDisplayView( model,
				controller,
				SatelliteOrientation.ABOVE,
				DisplayOrientation.VERTICAL,
				SatelliteOrientation.BELOW,
				LWTCControlConstants.SLIDER_VIEW_COLORS,
				"Out Gain:",
				false,
				true );

		model.addChangeListener( new ValueChangeListener()
		{

			@Override
			public void receiveValueChange( final Object source, final float newValue )
			{
				uiInstance.sendGain( newValue );
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
		// log.debug("Received display tick");
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
