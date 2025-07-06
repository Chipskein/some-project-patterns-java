package com.test.negocio;


public class Date {

    private int day = 1;

    private int month = 1;

    private int year = 1900;

    private final int MIN_YEAR = 1900;
    
    private final int MIN_MONTH = 1;
    
    private final int MIN_DAY = 1;
    
    private final int MAX_DAY = 31;
    
    private final int MAX_MONTH = 12;

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private int getMaxDayForMonth(int month, int year) {
        switch (month) {
            case 2:
                return this.isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return MAX_DAY;
        }
    }

    public Date(int day, int month, int year) {
        
        if(month < MIN_MONTH || month > MAX_MONTH)  throw new IllegalArgumentException("Month must be between 1 and 12.");

        if (day >= MIN_YEAR && year >= MIN_DAY && year <= MAX_DAY) {
            System.out.println("Assuming day is " + year + " and year is " + day + ".");
            int tmp=year;
            year = day;
            day = tmp;
        } else if(day >= MIN_YEAR){
            throw new IllegalArgumentException("Invalid date format. If the first parameter is the year, it must be greater than or equal to 1900.");
        }

        int maxDayMonth = getMaxDayForMonth(month, year);

        if (year < MIN_YEAR) throw new IllegalArgumentException("Year must be greater than or equal to 1900.");

        if (day < MIN_DAY || day > maxDayMonth) throw new IllegalArgumentException("Day must be between 1 and "+ maxDayMonth+ ".");

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date() {
        this(1, 1, 1900);
    }
    
    public int getDay() {
        return day;
    }
    
    public int getMonth() {
        return month;
    }
    
    public int getYear() {
        return year;
    }
    
    public Date yesterday() {
        if (day > MIN_DAY) return new Date(day - 1, month, year);
        else if (month > MIN_MONTH) {
            int prevMonthMaxDay = getMaxDayForMonth(month - 1, year);
            return new Date(prevMonthMaxDay, month - 1, year);
        } else {
            if(year - 1 < MIN_YEAR) throw new IllegalArgumentException("Cannot go back before year 1900.");
            return new Date(31, MAX_MONTH, year - 1);
        }
    }

    public Date tomorrow() {
        if (day < getMaxDayForMonth(month, year)) return new Date(day + 1, month, year);
        else if (month < MAX_MONTH) return new Date(1, month + 1, year);
        else {
            return new Date(1, MIN_MONTH, year + 1);
        }
    }

    public Date plusDays(int days) {
        if (days < 0) throw new IllegalArgumentException("Days must be non-negative.");
        
        Date result = this;
        for (int i = 0; i < days; i++) {
            result = result.tomorrow();
        }
        return result;
    }

    public Date minusDays(int days) {
        if (days < 0) throw new IllegalArgumentException("Days must be non-negative.");
        
        Date result = this;
        for (int i = 0; i < days; i++) {
            result = result.yesterday();
        }
        return result;
    }

    public boolean after(Date other) {
        if (this.year > other.year) return true;
        if (this.year < other.year) return false;
        if (this.month > other.month) return true;
        if (this.month < other.month) return false;
        return this.day > other.day;
    }

    public boolean before(Date other) {
        return !this.after(other) && !this.equals(other);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Date)) return false;
        Date other = (Date) obj;
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    
}
