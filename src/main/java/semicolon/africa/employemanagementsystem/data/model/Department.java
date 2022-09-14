package semicolon.africa.employemanagementsystem.data.model;

public enum Department {
    FINANCE("Finance"),
    ACCOUNT("Account"),
    RESEARCH_AND_DEVELOPMENT("Research_and_Dev"),
    PURCHASING("Purchasing"),
    MARKETING("Marketing"),
    HUMAN_RESOURCE_MANAGEMENT("HRM"),
    PRODUCTION("Production");

    private final String type;

    Department(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }

}

