package com.james.codebinary.appcato.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.james.codebinary.appcato.R;

import butterknife.BindView;

/**
 * Created by James on 23/06/16.
 */
public class FragmentoCalendario extends Fragment {

    @BindView(R.id.calendarView)
    CalendarView calendarView;

    @BindView(R.id.txtCalendar)
    TextView dateDisplay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_calendario, container, false);

        dateDisplay.setText("Date: ");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                dateDisplay.setText("Date: " + dayOfMonth + " / " + month + " / " + year);

                Toast.makeText(getActivity().getApplicationContext(),"Selected Date:\n" + "Day = " + dayOfMonth + "\n" + "Month = " + month + "\n" + "Year = " + year, Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
