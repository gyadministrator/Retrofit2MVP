package presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;

import model.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.ILoginService;
import view.ILoginView;

public class LoginPresenter {

    private ILoginView loginView;

    private Context mContext;

    private static final String TAG = "LoginPresenter";

    private User u;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 1) {
                if (u.getCode() == 100) {
                    Toast.makeText(mContext, "登录成功" + u.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    public LoginPresenter(Context mContext, ILoginView loginView) {
        this.mContext = mContext;
        this.loginView = loginView;
    }

    public void login(String user, String password) {
        if (user.equals("") || password.equals("")) {
            Toast.makeText(mContext, "请填写登录信息", Toast.LENGTH_SHORT).show();
        } else {
            loginView.showDialog();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://123.207.93.53/MusicWebServer/user/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ILoginService url = retrofit.create(ILoginService.class);

            Call<User> call = url.getLogin(user, password);


            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    assert response.body() != null;
                    u = response.body();
                    mHandler.sendEmptyMessage(1);
                    loginView.dismissDialog();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    loginView.dismissDialog();
                    loginView.error("哎呀,请求发生了错误了");
                }
            });
        }
    }
}
