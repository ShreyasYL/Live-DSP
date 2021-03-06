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

package uk.co.modularaudio.service.gui.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import uk.co.modularaudio.service.userpreferences.mvc.comboitems.AudioSystemMidiDeviceComboItem;
import uk.co.modularaudio.service.userpreferences.mvc.controllers.InputMidiDeviceComboMVCController;
import uk.co.modularaudio.service.userpreferences.mvc.models.AudioSystemMidiDeviceMVCModel;
import uk.co.modularaudio.util.swing.mvc.combo.ComboView;
import uk.co.modularaudio.util.swing.mvc.combo.ComboViewListCellRenderer;

public class UserPreferencesInputMidiDeviceMVCView extends ComboView<AudioSystemMidiDeviceComboItem>
{
	private static final long serialVersionUID = 4761930364824619693L;

	protected static Log log = LogFactory.getLog( UserPreferencesInputMidiDeviceMVCView.class.getName() );

	public UserPreferencesInputMidiDeviceMVCView( final AudioSystemMidiDeviceMVCModel cm,
			final InputMidiDeviceComboMVCController cc,
			final ComboViewListCellRenderer<AudioSystemMidiDeviceComboItem> cr)
	{
		super(cm, cc, cr);
	}

}
