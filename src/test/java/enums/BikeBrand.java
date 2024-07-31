package enums;

public enum BikeBrand {
    BMC("BMC"),
    CANNONDALE("Cannondale"),
    CERVELO("Cervélo"),
    CUBE("Cube"),
    FELT("Felt"),
    FONDREIST("Fondreist"),
    FUJI("Fuji"),
    GARY_FISHER("Gary Fisher"),
    GIANT("Giant"),
    MERIDA("Merida"),
    NORCO("Norco"),
    ORBEA("Orbea"),
    QUINTANA_ROO("Quintana Roo"),
    SPECIALIZED("Specialized"),
    TREK("Trek");

    private final String name;

    BikeBrand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static BikeBrand fromString(String brand) {
        for (BikeBrand brands : BikeBrand.values()) {
            if (brands.getName().equals(brand)) {
                return brands;
            }
        }
        return null;
    }
}

