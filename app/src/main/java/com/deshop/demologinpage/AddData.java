package com.deshop.demologinpage;

public class AddData {

    private String full_Nmae;
    private String father_Nmae;
    private String mother_Nmae;
    private String nid_Number;
    private String address_loc;

    public AddData(){
        //empty constructor

    }

    public AddData(String full_Nmae, String father_Nmae, String mother_Nmae, String nid_Number, String address_loc) {
        this.full_Nmae = full_Nmae;
        this.father_Nmae = father_Nmae;
        this.mother_Nmae = mother_Nmae;
        this.nid_Number = nid_Number;
        this.address_loc = address_loc;
    }

    public String getFull_Nmae() {
        return full_Nmae;
    }

    public void setFull_Nmae(String full_Nmae) {
        this.full_Nmae = full_Nmae;
    }

    public String getFather_Nmae() {
        return father_Nmae;
    }

    public void setFather_Nmae(String father_Nmae) {
        this.father_Nmae = father_Nmae;
    }

    public String getMother_Nmae() {
        return mother_Nmae;
    }

    public void setMother_Nmae(String mother_Nmae) {
        this.mother_Nmae = mother_Nmae;
    }

    public String getNid_Number() {
        return nid_Number;
    }

    public void setNid_Number(String nid_Number) {
        this.nid_Number = nid_Number;
    }

    public String getAddress_loc() {
        return address_loc;
    }

    public void setAddress_loc(String address_loc) {
        this.address_loc = address_loc;
    }
}
