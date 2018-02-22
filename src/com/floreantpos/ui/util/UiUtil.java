/**
 * ************************************************************************
 * * The contents of this file are subject to the MRPL 1.2
 * * (the  "License"),  being   the  Mozilla   Public  License
 * * Version 1.1  with a permitted attribution clause; you may not  use this
 * * file except in compliance with the License. You  may  obtain  a copy of
 * * the License at http://www.floreantpos.org/license.html
 * * Software distributed under the License  is  distributed  on  an "AS IS"
 * * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * * License for the specific  language  governing  rights  and  limitations
 * * under the License.
 * * The Original Code is FLOREANT POS.
 * * The Initial Developer of the Original Code is OROCUBE LLC
 * * All portions are Copyright (C) 2015 OROCUBE LLC
 * * All Rights Reserved.
 * ************************************************************************
 */
package com.floreantpos.ui.util;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Locale;
import java.time.ZoneId;

import org.jdesktop.swingx.JXDatePicker;

public class UiUtil {
	public static JXDatePicker getCurrentMonthStart() {
		Locale locale = Locale.getDefault();
		
		Calendar c = Calendar.getInstance(locale);
		c.set(Calendar.DAY_OF_MONTH, 1);
		JXDatePicker datePicker = new JXDatePicker(c.getTime(), locale);
		
		return datePicker;
	}
        
        public static DateTimePicker getDefualtStartDateTime() {		
		DateTimePicker datePicker = new DateTimePicker();               		
                Calendar cal=Calendar.getInstance();
                cal.set(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth().getValue()-1, LocalDateTime.now().getDayOfMonth(), 8, 0);
                LocalDateTime dt= LocalDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());
                datePicker.setDateTimePermissive(dt);
		return datePicker;
	}
        
        public static DateTimePicker getDefualtEndDateTime() {		
		DateTimePicker datePicker = new DateTimePicker();  
               
                Calendar cal=Calendar.getInstance();
                cal.set(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth().getValue()-1, LocalDateTime.now().getDayOfMonth()+1, 4, 0);
                LocalDateTime dt= LocalDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());
                
                datePicker.setDateTimePermissive(dt);
		return datePicker;
	}


	public static JXDatePicker getCurrentMonthEnd() {
		Locale locale = Locale.getDefault();
		
		Calendar c = Calendar.getInstance(locale);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		JXDatePicker datePicker = new JXDatePicker(c.getTime(), locale);
		
		return datePicker;
	}
	
	public static JXDatePicker getDeafultDate() {

		JXDatePicker datePicker = new JXDatePicker();
		
		return datePicker;
	}
	
}
