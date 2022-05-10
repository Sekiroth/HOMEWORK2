package aviasales.dao;

import java.time.LocalDate;

public class FlightFilter {
    private final String departureAirport;
    private final String arrivalAirport;
    private final LocalDate scheduledDeparture;
    private final LocalDate scheduledArrival;

    private FlightFilter(String departureAirport, String arrivalAirport,
                         LocalDate scheduledDeparture, LocalDate scheduledArrival) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalDate getScheduledDeparture() {
        return scheduledDeparture;
    }

    public LocalDate getScheduledArrival() {
        return scheduledArrival;
    }

    public static class Builder{
        private String departureAirport;
        private String arrivalAirport;
        private LocalDate scheduledDeparture;
        private LocalDate scheduledArrival;

        private Builder() {
        }

        public Builder setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder setArrivalAirport(String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
            return this;
        }

        public Builder setScheduledDeparture(LocalDate scheduledDeparture) {
            this.scheduledDeparture = scheduledDeparture;
            return this;
        }

        public Builder setScheduledArrival(LocalDate scheduledArrival) {
            this.scheduledArrival = scheduledArrival;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public FlightFilter build(){
            return new FlightFilter(departureAirport,
                    arrivalAirport,
                    scheduledDeparture,
                    scheduledArrival);
        }
    }
}

