package com.date;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatepickerActivity extends Activity implements OnClickListener{
	private TextView mDateDisplay;
    private Button mPickDate;
    private int mYear ;
    private int mMonth ;
    private int mDay;

    static final int DATE_DIALOG_ID = 1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        mPickDate = (Button) findViewById(R.id.pickDate);
        
        mPickDate.setOnClickListener(this);
        
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date (this method is below)
        updateDisplay();

    }
	private void updateDisplay() {
		// TODO Auto-generated method stub
		 mDateDisplay.setText(
		            new StringBuilder()
		                    // Month is 0 based so add 1
		                    .append(mMonth+1).append("-")
		                    .append(mDay).append("-")
		                    .append(mYear).append(" "));

		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		showDialog(DATE_DIALOG_ID);
		
	}
	 private DatePickerDialog.OnDateSetListener mDateSetListener =
	            new DatePickerDialog.OnDateSetListener() {

	                public void onDateSet(DatePicker view, int year, 
	                                      int monthOfYear, int dayOfMonth) {
	                    mYear = year;
	                    mMonth = monthOfYear;
	                    mDay = dayOfMonth;
	                    updateDisplay();
	                }
	            };
	            
	            @Override
	            protected Dialog onCreateDialog(int id) {
	                switch (id) {
	                case DATE_DIALOG_ID:
	                    return new DatePickerDialog(this,
	                                mDateSetListener,
	                                mYear, mMonth, mDay);
	                }
	                return null;
	            }
}