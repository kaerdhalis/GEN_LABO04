package ch.heigvd.gen2019;

public enum Color {


        BLUE,
        RED,
        YELLOW,
        NO_COLOR {
            @Override
            public String toString() {
                return "no color";
            }
        };

        public String toString() {
            return super.name().toLowerCase();
        }

}
