public class DateTest {
    public static void main(String[] args){
        MyDate date1 = new MyDate(11,11,1918);
        MyDate date2 = new MyDate();
        date2.day = 11;
        date2.month = 11;
        date2.year = 1918;
        MyDate date3 = new MyDate();
        date3.setDate(4,21,1968);
        String str1 = date1.toString();
        String str2 = date2.toString();
        String str3 = date3.toString();
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}

class MyDate{

    int month, day, year;

    MyDate(){}

    MyDate(int month, int day, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    void setDate(int month, int day, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString(){
        return "MyDate { day = " + day + ", month = " + month + ", year = " + year + " }";
    }

}
