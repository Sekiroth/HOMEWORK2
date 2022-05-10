package aviasales.dao;

import java.time.LocalDate;

public class Flight {
    private final String flightId;
    private final String flightMo;
    private final LocalDate scheduledDeparture;
    private final LocalDate scheduledArrival;
    private final String departureAirport;
    private final String arrivalAirport;
    private final String status;
    private final String aircraftCode;
    private final LocalDate actualDeparture;
    private final LocalDate actualArrival;

    public Flight(String flightId, String flightMo, LocalDate scheduledDeparture,
                  LocalDate scheduledArrival, String departureAirport, String arrivalAirport,
                  String status, String aircraftCode, LocalDate actualDeparture,
                  LocalDate actualArrival) {
        this.flightId = flightId;
        this.flightMo = flightMo;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.status = status;
        this.aircraftCode = aircraftCode;
        this.actualDeparture = actualDeparture;
        this.actualArrival = actualArrival;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getFlightMo() {
        return flightMo;
    }

    public LocalDate getScheduledDeparture() {
        return scheduledDeparture;
    }

    public LocalDate getScheduledArrival() {
        return scheduledArrival;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getStatus() {
        return status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public LocalDate getActualDeparture() {
        return actualDeparture;
    }

    public LocalDate getActualArrival() {
        return actualArrival;
    }

    public static class Builder {
        private String flightId;
        private String flightMo;
        private LocalDate scheduledDeparture;
        private LocalDate scheduledArrival;
        private String departureAirport;
        private String arrivalAirport;
        private String status;
        private String aircraftCode;
        private LocalDate actualDeparture;
        private LocalDate actualArrival;

        public Builder setFlightId(String flightId) {
            this.flightId = flightId;
            return this;
        }

        private Builder() {
        }

        public Builder setFlightMo(String flightMo) {
            this.flightMo = flightMo;
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

        public Builder setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder setArrivalAirport(String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setAircraftCode(String aircraftCode) {
            this.aircraftCode = aircraftCode;
            return this;
        }

        public Builder setActualDeparture(LocalDate actualDeparture) {
            this.actualDeparture = actualDeparture;
            return this;
        }

        public Builder setActualArrival(LocalDate actualArrival) {
            this.actualArrival = actualArrival;
            return this;
        }

        public static Builder create() {
            return new Builder();
        }

        public Flight build() {
            return new Flight(flightId, flightMo, scheduledDeparture,
            scheduledArrival, departureAirport, arrivalAirport,
            status, aircraftCode, actualDeparture, actualArrival);
        }
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId='" + flightId + '\'' +
                ", flightMo='" + flightMo + '\'' +
                ", scheduledDeparture=" + scheduledDeparture +
                ", scheduledArrival=" + scheduledArrival +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", status='" + status + '\'' +
                ", aircraftCode='" + aircraftCode + '\'' +
                ", actualDeparture=" + actualDeparture +
                ", actualArrival=" + actualArrival +
                '}';
    }
}
