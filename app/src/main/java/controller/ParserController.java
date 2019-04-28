package controller;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Consts;
import view.ParserActivity;

/**
 * Controller for Parser schedule from Tutu.ru
 *
 * @author Mark Kolpakov
 * @date 27.04.2019
 */
public class ParserController {
    private static final ParserController controller = new ParserController();
    private static WeakReference<ParserActivity> mActivityWeakReference;

    private ParserController() {
    }

    public static ParserController getInstance() {
        return controller;
    }

    public void downloadSchedule(@NonNull final ParserActivity activity, String from, String to) {
        mActivityWeakReference = new WeakReference<>(activity);
        new LoadScheduleTask().execute(from, to);
    }

    /**
     * Async loader connecting to Tutu.ru and to load html file from site
     */
    private static class LoadScheduleTask extends AsyncTask<String, String, List<List<String>>> {
        List<List<String>> scheduleList = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            if (scheduleList.size() != 0)
                scheduleList.clear();
        }

        @Override
        protected List<List<String>> doInBackground(String... strings) {
            //the list contain two list of departure and arrival trains

            String from = strings[0];
            String to = strings[1];
            String[] departure;
            String[] arrival;

            Document document;
            try {
                document = Jsoup.connect(String.format(Consts.URL_REQUEST, from, to)).get();

                departure = document.getElementsByClass(Consts.STANDART_PLUS).text().split(" ");
                arrival = document.getElementsByClass(Consts.TIME_ARRIVAL).text().split(" ");

                //TODO не добавлять в список ушедшие поезда
                scheduleList.add(Arrays.asList(departure));
                scheduleList.add(Arrays.asList(arrival));

            } catch (IOException ex) {
                Log.d("TAG", ex.getLocalizedMessage());
            }

            return scheduleList;
        }

        @Override
        protected void onPostExecute(List<List<String>> s) {
            mActivityWeakReference.get().setTextView(s.get(0), s.get(1));
        }
    }
}
