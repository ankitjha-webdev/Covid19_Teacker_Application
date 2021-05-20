package com.example.covid19;

public class Constants {public static final String STATE_NAME = "stateName";
    public static final String STATE_CONFIRMED = "stateConfirmed";
    public static final String STATE_CONFIRMED_NEW = "stateConfirmedNew";
    public static final String STATE_ACTIVE = "stateActive";
    public static final String STATE_DEATH = "stateDeath";
    public static final String STATE_DEATH_NEW = "stateDeathNew";
    public static final String STATE_RECOVERED = "stateRecovered";
    public static final String STATE_RECOVERED_NEW = "stateRecoveredNew";
    public static final String STATE_LAST_UPDATE = "stateLastUpdate";

    //District Data Keys
    public static final String DISTRICT_NAME = "districtName";
    public static final String DISTRICT_CONFIRMED = "districtConfirmed";
    public static final String DISTRICT_CONFIRMED_NEW = "districtConfirmedNew";
    public static final String DISTRICT_ACTIVE = "districtActive";
    public static final String DISTRICT_DEATH = "districtDeath";
    public static final String DISTRICT_DEATH_NEW = "districtDeathNew";
    public static final String DISTRICT_RECOVERED = "districtRecovered";
    public static final String DISTRICT_RECOVERED_NEW = "districtRecoveredNew";

    //Country Data Keys
    public static final String COUNTRY_NAME = "country";
    public static final String COUNTRY_CONFIRMED = "cases";
    public static final String COUNTRY_ACTIVE = "active";
    public static final String COUNTRY_DECEASED = "deaths";
    public static final String COUNTRY_NEW_CONFIRMED = "todayCases";
    public static final String COUNTRY_TESTS = "tests";
    public static final String COUNTRY_NEW_DECEASED = "todayDeaths";
    public static final String COUNTRY_FLAGURL = "flag";
    public static final String COUNTRY_RECOVERED = "recovered";

    public static class CountryWiseModel {
        private String country;
        private String confirmed;
        private String newConfirmed;
        private String active;
        private String deceased;
        private String newDeceased;
        private String recovered;
        private String tests;
        private String flag;
    
        public CountryWiseModel(String country, String confirmed, String newConfirmed, String active, String deceased, String newDeceased,
                                String recovered, String tests, String flag) {
            this.country = country;
            this.confirmed = confirmed;
            this.newConfirmed = newConfirmed;
            this.active = active;
            this.deceased = deceased;
            this.newDeceased = newDeceased;
            this.recovered = recovered;
            this.tests = tests;
            this.flag = flag;
        }
    
        public String getCountry() {
            return country;
        }
    
        public String getConfirmed() {
            return confirmed;
        }
    
        public String getNewConfirmed() {
            return newConfirmed;
        }
    
        public String getActive() {
            return active;
        }
    
        public String getDeceased() {
            return deceased;
        }
    
        public String getNewDeceased() {
            return newDeceased;
        }
    
        public String getRecovered() {
            return recovered;
        }
    
        public String getTests() {
            return tests;
        }
    
        public String getFlag() {
            return flag;
        }
    }
}
