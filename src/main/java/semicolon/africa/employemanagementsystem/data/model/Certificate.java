package semicolon.africa.employemanagementsystem.data.model;

public enum Certificate {
    BSC("Bachelor_Degree"),
    PD("Postgraduate_Diploma"),
    MSC("Master_Degree"),
    PHD("Doctorate_Degree");

    private final String type;

    Certificate(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
