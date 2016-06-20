package model;


public class Adress {

    private String country;
    private String city;
    private String adress;
    private String street;
    private Long houseNumber;
    private String houseSuffix;
    private Long postCode;

    private Integer idUser;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Long houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseSuffix() {
        return houseSuffix;
    }

    public void setHouseSuffix(String houseSuffix) {
        this.houseSuffix = houseSuffix;
    }

    public Long getPostCode() {
        return postCode;
    }

    public void setPostCode(Long postCode) {
        this.postCode = postCode;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void getInfo(){
        System.out.printf("City " + city + " adress " + adress +"\n");
    }

}
