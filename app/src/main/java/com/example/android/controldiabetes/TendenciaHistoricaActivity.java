package com.example.android.controldiabetes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.PieChart;
import org.achartengine.chart.XYChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class TendenciaHistoricaActivity extends AppCompatActivity {

    /** Colors to be used for the pie slices. */
    private static int[] COLORS = new int[] {R.color.BLACK, Color.BLUE, Color.RED, Color.WHITE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendencia_historica);

        XYSeries series = new XYSeries("Lima Temperatura horaria");

        int hour = 0;
        for (HourForecast hf : nextHourForecast) {
            series.add(hour++, hf.weather.temperature.getTemp());
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}
