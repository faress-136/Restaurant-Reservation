 package Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

    @XmlRootElement(name = "reservedTable")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class ReservedTables {

        @XmlElement(name = "number")
        private String number;

        @XmlElement(name = "reserved")
        private String reserved;

        @XmlElement(name = "name")
        private String name;

        @XmlElement(name = "paid")
        private double paid;

        @XmlElement(name = "time")
        private String time;


        @XmlElement(name ="Grilled")
        private int grilled;
        @XmlElement(name = "Soup")
        private int soup ;
        @XmlElement(name = "beef")
        private int beef  ;
        @XmlElement(name = "fries")
        private int fries ;
        @XmlElement(name = "salade")
        private int salade;
        @XmlElement(name = "molten")
        private int  molten;
        @XmlElement(name = "apple")
        private int  apple;

        public int getGrilled() {
            return grilled;
        }

        public void setGrilled(int grilled) {
            this.grilled = grilled;
        }

        public int getSoup() {
            return soup;
        }

        public void setSoup(int soup) {
            this.soup = soup;
        }

        public int getBeef() {
            return beef;
        }

        public void setBeef(int beef) {
            this.beef = beef;
        }

        public int getFries() {
            return fries;
        }

        public void setFries(int fries) {
            this.fries = fries;
        }

        public int getSalade() {
            return salade;
        }

        public void setSalade(int salade) {
            this.salade = salade;
        }

        public int getMolten() {
            return molten;
        }

        public void setMolten(int molten) {
            this.molten = molten;
        }

        public int getApple() {
            return apple;
        }

        public void setApple(int apple) {
            this.apple = apple;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getReserved() {
            return reserved;
        }

        public void setReserved(String reserved) {
            this.reserved = reserved;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPaid() {
            return paid;
        }

        public void setPaid(double paid) {
            this.paid = paid;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
