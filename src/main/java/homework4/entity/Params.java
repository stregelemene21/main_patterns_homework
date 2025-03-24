package homework4.entity;

public class Params {

    public record Location(int x, int y) {
        @Override
        public boolean equals(Object obj) {
            var location = (Location) obj;
            return location.x == this.x && location.y == this.y;
        }
    }

    public record Velocity(int x, int y) {
    }

    public record Angle(int angleDegrees) {
    }

    // количество топлива в процентах
    public record FuelCount(int percent) {
        public FuelCount {
            if (percent < 0 || percent > 100) {
                throw new IllegalArgumentException("Incorrect fuel count!");
            }
        }
    }

    // расход топлива на 1 у.е. пути
    public record FuelEfficiency(int percentOnDistanceUnit) {
    }

    // путь, который преодолеет объект за единицу времени
    public record Distance(int length) {
    }
}
