package Data;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)


public class Table implements Comparable<Table> {

    @XmlElement(name = "number")
    private String number;

    @XmlElement(name = "number_of_seats")
    private int number_of_seats;

    @XmlElement(name = "smoking")
    private String smoking;

    @XmlTransient
    private Boolean reserved;


    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }


    @Override
    public int compareTo(Table table) {
            return this.getNumber_of_seats() - table.getNumber_of_seats()  ;
    }
}


