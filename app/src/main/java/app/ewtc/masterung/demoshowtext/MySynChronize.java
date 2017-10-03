package app.ewtc.masterung.demoshowtext;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by masterung on 3/10/2017 AD.
 */

public class MySynChronize extends AsyncTask<String, Void, String>{

    private Context context;

    public MySynChronize(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("3octV2", "e doIn ==> " + e.toString());
            return null;
        }



    }
}
