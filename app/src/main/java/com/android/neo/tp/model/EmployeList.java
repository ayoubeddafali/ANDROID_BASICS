package com.android.neo.tp.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EmployeList {
        @SerializedName("employeeList")
        private ArrayList<Employe> employeeList;

        public ArrayList<Employe> getEmployeeArrayList() {
            return employeeList;
        }

        public void setEmployeeArrayList(ArrayList<Employe> employeeArrayList) {
            this.employeeList = employeeArrayList;
        }

}
