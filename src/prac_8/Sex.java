package prac_8;
public enum Sex{
    m("male","��"),f("female","Ů");
    private final String sex;
    private final String sexDesc;
    Sex(String sex,String sexDesc){
        this.sex = sex;
        this.sexDesc = sexDesc;
    }
    public String getSex() {
        return sex;
    }
    public String getSexDesc() {
        return sexDesc;
    }
}
