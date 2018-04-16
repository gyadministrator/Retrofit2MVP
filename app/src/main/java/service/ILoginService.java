package service;

import model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ILoginService {

    @GET("login")
    Call<User> getLogin(@Query("username") String username, @Query("password") String password);
}
