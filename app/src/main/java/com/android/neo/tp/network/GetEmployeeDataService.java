package com.android.neo.tp.network;

import com.android.neo.tp.model.EmployeList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetEmployeeDataService {
    @GET("retrofit-demo.php")
    Call<EmployeList> getEmployeeData(@Query("company_no") int companyNo);
}
