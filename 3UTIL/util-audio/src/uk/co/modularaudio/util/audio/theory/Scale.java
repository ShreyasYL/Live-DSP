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

package uk.co.modularaudio.util.audio.theory;

import java.util.HashMap;
import java.util.Map;

public enum Scale
{
	MAJOR,
	MINOR;

	public final static Map<Scale,String> SCALE_TO_STR_MAP = new HashMap<Scale,String>();
	public final static Map<String,Scale> STR_TO_SCALE_MAP = new HashMap<String,Scale>();

	static
	{
		SCALE_TO_STR_MAP.put( MAJOR, "MAJOR" );
		SCALE_TO_STR_MAP.put( MINOR, "MINOR" );

		STR_TO_SCALE_MAP.put( "MAJOR", MAJOR );
		STR_TO_SCALE_MAP.put( "MINOR", MINOR );
	};
}